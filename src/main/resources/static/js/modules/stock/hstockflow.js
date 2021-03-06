$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'hstockflow/list',
        datatype: "json",
        colModel: [			
			{ label: 'stockFlowId', name: 'stockFlowId', index: 'stock_flow_id', width: 50, key: true },
			{ label: '物品', name: 'goodsId', index: 'goods_id', width: 80,formatter: goodsNameFormatter },
			{ label: '厅号id', name: 'roomId', index: 'room_id', width: 80 }, 			
			{ label: '进出数量', name: 'qty', index: 'qty', width: 80 },
            {label: '进出库存时的单位', name: 'flowUnit', index: 'flowUnit', width: 80},
			{ label: '原子数量', name: 'atomicQty', index: 'atomic_qty', width: 80 },
            {label: '原子单位', name: 'atomicUnit', index: 'atomicUnit', width: 80},
            {label: '操作时间', name: 'createTime', index: 'create_time', width: 80},
            {label: '操作人', name: 'creator', index: 'creator', width: 80, formatter: userNameFormatter},
			{ label: '', name: 'modifyTime', index: 'modify_time', width: 80 }, 			
			{ label: '', name: 'modifier', index: 'modifier', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
        hStockFlow: {
            goodsId: 0
        },
        hGoodsVos:[],
        hRoomVos: [],
        sysUsers: [],
        units: [],
        atomUnit: ""
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.hStockFlow = {};
		},
		update: function (event) {
			var stockFlowId = getSelectedRow();
			if(stockFlowId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(stockFlowId)
		},
		saveOrUpdate: function (event) {
			var url = vm.hStockFlow.stockFlowId == null ? "hstockflow/save" : "hstockflow/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.hStockFlow),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var stockFlowIds = getSelectedRows();
			if(stockFlowIds == null){
				return ;
			}
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "hstockflow/delete",
                    contentType: "application/json",
				    data: JSON.stringify(stockFlowIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(stockFlowId){
			$.get(baseURL + "hstockflow/info/"+stockFlowId, function(r){
                vm.hStockFlow = r.hStockFlow;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
        },
        computeAtomQty: function () {
            for (var i = 0; i < vm.units.length; i++) {
                if (vm.units[i].id == vm.hStockFlow.goodsUnitId) {
                    vm.$set(vm.hStockFlow, 'atomicQty', vm.units[i].conversionRate * vm.hStockFlow.qty);
                    break;
                }
            }
        },
        getUnits: function () {
            getGoodsUnit(vm.hStockFlow.goodsId);
            vm.initQty();
        },
        initQty: function () {
            vm.$set(vm.hStockFlow, 'atomicQty', 0);
            vm.$set(vm.hStockFlow, 'qty', 0);
        }/*,
        changeGoods:function () {
			var goodsId = vm.hStockFlow.goodsId;
			vm.units = getGoodsUnit(goodsId);
        }*/
    },
    watch: {
        'units': function (val, oldVal) {
            for (var i = 0; i < vm.units.length; i++) {
                if (vm.units[i].isAtomic == 1) {
                    vm.atomUnit = vm.units[i].text;
                    break;
                }
            }
        }
	},
	created:function () {
        getAllUsers();
		getAllHGoods();
        getAllHRooms();
    }
});