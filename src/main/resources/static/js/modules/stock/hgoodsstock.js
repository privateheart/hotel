$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'hgoodsstock/list',
        datatype: "json",
        colModel: [
            {label: 'goodsStockId', name: 'goodsStockId', index: 'goods_stock_id', width: 50, key: true},
            {label: '物品', name: 'goodsId', index: 'goods_id', width: 80,formatter: goodsNameFormatter},
            {label: '数量(原子)', name: 'qty', index: 'qty', width: 80},
            {label: '原子单位', name: 'atomicUnit', index: 'atomicUnit', width: 80}
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
        hGoodsStock: {},
        hGoodsVos: []
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.hGoodsStock = {};
        },
        update: function (event) {
            var goodsStockId = getSelectedRow();
            if (goodsStockId == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(goodsStockId)
        },
        saveOrUpdate: function (event) {
            var url = vm.hGoodsStock.goodsStockId == null ? "hgoodsstock/save" : "hgoodsstock/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.hGoodsStock),
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
            var goodsStockIds = getSelectedRows();
            if (goodsStockIds == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "hgoodsstock/delete",
                    contentType: "application/json",
                    data: JSON.stringify(goodsStockIds),
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
        getInfo: function (goodsStockId) {
            $.get(baseURL + "hgoodsstock/info/" + goodsStockId, function (r) {
                vm.hGoodsStock = r.hGoodsStock;
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
    created:function () {
        getAllHGoods();
    }
});