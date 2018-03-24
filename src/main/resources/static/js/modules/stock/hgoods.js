$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'hgoods/list',
        datatype: "json",
        colModel: [			
			{ label: 'goodsId', name: 'goodsId', index: 'goods_id', width: 50, key: true},
			{ label: '物品名称', name: 'goodsName', index: 'goods_name', width: 80 },
            {label: '物品类型', name: 'goodsType', index: 'goods_type', width: 80, formatter: dicFormatter},
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '创建人', name: 'creatorName', index: 'creator', width: 80 },
			{ label: '修改时间', name: 'modifyTime', index: 'modify_time', width: 80 },
			{ label: '修改者', name: 'modifierName', index: 'modifier', width: 80 }
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
        q:{
            goodsName: null,
			goodsType: ""
        },
		showList: true,
		title: null,
        goodsTypes:allDic,
		hGoods: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.hGoods = {};
		},
		update: function (event) {
			var goodsId = getSelectedRow();
			if(goodsId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(goodsId)
		},
		saveOrUpdate: function (event) {
			var url = vm.hGoods.goodsId == null ? "hgoods/save" : "hgoods/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.hGoods),
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
			var goodsIds = getSelectedRows();
			if(goodsIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "hgoods/delete",
                    contentType: "application/json",
				    data: JSON.stringify(goodsIds),
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
		getInfo: function(goodsId){
			$.get(baseURL + "hgoods/info/"+goodsId, function(r){
                vm.hGoods = r.hGoods;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'goodsName': vm.q.goodsName,'goodsType': vm.q.goodsType},
                page:page
            }).trigger("reloadGrid");
		}
	}
});