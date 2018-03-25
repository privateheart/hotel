/**
 * 获取字典类型
 */
function hdicTypes() {
    $.post(baseURL + "hdictype/queryAll", {}, function (r) {
        if (r.code == 0) {
            var hdicTypeList = [];
            for (var i = 0; i < r.hDicTypes.length; i++) {
                hdicTypeList[i] = {id: r.hDicTypes[i].dicTypeId, text: r.hDicTypes[i].categoryName};
            }
            vm.hdicTypes = hdicTypeList;
        } else {
            alert(r.msg);
        }
    })
}

/**
 * 获取所有管理员
 */
function getAllUsers() {
    $.post(baseURL + "sys/user/queryAllSysUser", {}, function (r) {
        if (r.code == 0) {
            var userList = [];
            for (var i = 0; i < r.users.length; i++) {
                userList[i] = {id: r.users[i].userId, text: r.users[i].username};
            }
            vm.sysUsers = userList;
        } else {
            alert(r.msg);
        }
    })
}

/**
 * 获取所有的 物品
 */
function getAllHGoods() {
    $.post(baseURL + "hgoods/queryAllHGoodsVos", {}, function (r) {
        if (r.code == 0) {
            var hGoodsVos = [];
            for (var i = 0; i < r.hGoodsVos.length; i++) {
                hGoodsVos[i] = {id: r.hGoodsVos[i].goodsId, text: r.hGoodsVos[i].goodsName};
            }
            vm.hGoodsVos = hGoodsVos;
        } else {
            alert(r.msg);
        }
    })
}

/**
 * 获取所有的 厅房
 */
function getAllHRooms() {
    $.post(baseURL + "hroom/queryALlRooms", {}, function (r) {
        if (r.code == 0) {
            var hRoomVos = [];
            for (var i = 0; i < r.hRoomVos.length; i++) {
                hRoomVos[i] = {id: r.hRoomVos[i].roomId, text: r.hRoomVos[i].roomName};
            }
            vm.hRoomVos = hRoomVos;
        } else {
            alert(r.msg);
        }
    })
}
/**
 * 获取 物品的所有单位
 */
function getGoodsUnit(goodsId) {
    $.post(baseURL + "hgoodsunit/queryGoodsUnits", {goodsId:goodsId}, function (r) {
        if (r.code == 0) {
            var units = [];
            for (var i = 0; i < r.units.length; i++) {
                units[i] = {id: r.units[i].goodsUnitId, text: r.units[i].unit,conversionRate:r.units[i].conversionRate};
            }
            vm.units = units;
        } else {
            alert(r.msg);
        }
    })
}

function dicFormatter(cellValue, options, rowObject) {
    var dicName = '';
    for (var i = 0; i < allDic.length; i++) {
        if (allDic[i].dicId == cellValue) {
            dicName = allDic[i].dicName;
            break;
        }
    }
    return dicName;
}

function userNameFormatter(cellValue, options, rowObject) {
    var userName = '';
    for (var i = 0; i < vm.sysUsers.length; i++) {
        if (vm.sysUsers[i].id == cellValue) {
            userName = vm.sysUsers[i].text;
            break;
        }
    }
    return userName;
}

function goodsNameFormatter(cellValue, options, rowObject) {
    var goodsName = '';
    for (var i = 0; i < vm.hGoodsVos.length; i++) {
        if (vm.hGoodsVos[i].id == cellValue) {
            goodsName = vm.hGoodsVos[i].text;
            break;
        }
    }
    return goodsName;
}