app.service("brandService", function ($http) {

    this.findPage = function (pageNum, pageSize) {
        return $http.get("../brand/findPage.do?page=" + pageNum + "&rows=" + pageSize)
    };


    //新增
    this.save = function (entity) {
        return $http.post("../brand/add.do", entity);
    };
    //更新
    this.update = function (entity) {
        return $http.post("../brand/update.do", entity);
    };


    //根据主键查询
    this.findOne = function (id) {
        return $http.get("../brand/findOne.do?id=" + id);
    };

    this.delete = function (selectionList) {
        return $http.get("../brand/delete.do?ids=" + selectionList)
    };


    this.search = function (pageNum, pageSize, searchEntity) {
        return $http.post("../brand/search.do?page=" + pageNum + "&rows=" + pageSize, searchEntity);
    };


});