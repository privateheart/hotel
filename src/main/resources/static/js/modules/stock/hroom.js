$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'hroom/list',
        datatype: "json",
        colModel: [			
			{ label: 'roomId', name: 'roomId', index: 'room_id', width: 50, key: true },
			{ label: '厅名字', name: 'roomName', index: 'room_name', width: 80 }, 			
			{ label: '最大容纳人数', name: 'seatingCapacity', index: 'seating_capacity', width: 80 }, 			
			{ label: '厅管理人', name: 'custodianName', index: 'custodian', width: 80 },
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '更新时间', name: 'modifyTime', index: 'modify_time', width: 80 }, 			
			{ label: '创建人', name: 'creatorName', index: 'creator', width: 80 },
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
		showList: true,
		title: null,
		hRoom: {},
        sysUsers:[]
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.hRoom = {};
		},
		update: function (event) {
			var roomId = getSelectedRow();
			if(roomId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(roomId)
		},
		saveOrUpdate: function (event) {
			var url = vm.hRoom.roomId == null ? "hroom/save" : "hroom/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.hRoom),
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
			var roomIds = getSelectedRows();
			if(roomIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "hroom/delete",
                    contentType: "application/json",
				    data: JSON.stringify(roomIds),
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
		getInfo: function(roomId){
			$.get(baseURL + "hroom/info/"+roomId, function(r){
                vm.hRoom = r.hRoom;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	},
    created:function () {
        getAllUsers();
    }
});