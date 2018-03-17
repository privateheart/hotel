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