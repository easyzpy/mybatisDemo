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
        field: 'createTime',
        title: 'createTime'
    }, {
        field: 'updateTime',
        title: 'updateTime'
    }]

});
