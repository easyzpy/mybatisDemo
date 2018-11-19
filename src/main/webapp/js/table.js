$.fn.bootstrapTable.defaults = {
    detailFormatter: function (index, row, element) {
        console.log(index)
        console.log(row)
        console.log(element)
    }
}
$('#table').bootstrapTable({
    url: basePath + "/emp/list",
    columns: [{
        field: 'empId',
        title: 'empId'
    }, {
        field: 'lastName',
        title: 'lastName'
    }, {
        field: 'email',
        title: 'email'
    }, {
        field: 'gender',
        title: 'gender'
    }, {
        field: 'empType',
        title: 'empType',
        formatter: emptypeFormat(value, row, index)
    }, {
        field: 'employeeType',
        title: 'employeeType',
        formatter: emptypeFormat(value, row, index)

    }, {
        field: 'createTime',
        title: 'createTime'
    }, {
        field: 'updateTime',
        title: 'updateTime'
    }]

});
function emptypeFormat(value, row, index) {
        switch (value){
        case "VIP":
            return "会员"
        case "Tourist":
            return "游客"
        default:return null;
    }
}