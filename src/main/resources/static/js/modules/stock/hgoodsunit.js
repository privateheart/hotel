$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'hgoodsunit/list',
        datatype: "json",
        colModel: [
            {label: 'goodsUnitId', name: 'goodsUnitId', index: 'goods_unit_id', width: 50, key: true},
            {label: '物品', name: 'goodsId', index: 'goods_id', width: 80, formatter: goodsNameFormatter},
            {label: '单位', name: 'unit', index: 'unit', width: 80},
            {label: '换算率', name: 'conversionRate', index: 'conversion_rate', width: 80},
            {label: '该单位下的价格', name: 'unitPrice', index: 'unit_price', width: 80},
            {label: '是否原子单位', name: 'isAtomic', index: 'is_atomic', width: 80, formatter: dicFormatter},
            {label: '', name: 'createTime', index: 'create_time', width: 80},
            {label: '', name: 'modifyTime', index: 'modify_time', width: 80},
            {label: '', name: 'creator', index: 'creator', width: 80, formatter: userNameFormatter},
            {label: '', name: 'modifier', index: 'modifier', width: 80, formatter: userNameFormatter},
            {label: '是否有效', name: 'isValid', index: 'is_valid', width: 80, formatter: dicFormatter}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        hGoodsUnit: {},
        hGoodsVos: [],
        sysUsers: []
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.hGoodsUnit = {};
        },
        update: function (event) {
            var goodsUnitId = getSelectedRow();
            if (goodsUnitId == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(goodsUnitId)
        },
        saveOrUpdate: function (event) {
            var url = vm.hGoodsUnit.goodsUnitId == null ? "hgoodsunit/save" : "hgoodsunit/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.hGoodsUnit),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var goodsUnitIds = getSelectedRows();
            if (goodsUnitIds == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "hgoodsunit/delete",
                    contentType: "application/json",
                    data: JSON.stringify(goodsUnitIds),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function (goodsUnitId) {
            $.get(baseURL + "hgoodsunit/info/" + goodsUnitId, function (r) {
                vm.hGoodsUnit = r.hGoodsUnit;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                page: page
            }).trigger("reloadGrid");
        }
    },
    created: function () {
        getAllUsers();
        getAllHGoods();
    }
});