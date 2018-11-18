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
        title: 'empType'
    }, {
        field: 'employeeType',
        title: 'employeeType'
    }, {
        field: 'createTime',
        title: 'createTime'
    }, {
        field: 'updateTime',
        title: 'updateTime'
    }]
});