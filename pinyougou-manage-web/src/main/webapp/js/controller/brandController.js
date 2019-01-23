app.controller("brandController", function ($scope, $controller,$http, brandService) {

    $controller("baseController",{$scope:$scope});



    //--------


    $scope.findPage = function (pageNum, pageSize) {
        $http.get("../brand/findPage.do?page=" + pageNum + "&rows=" + pageSize).success(function (response) {
            $scope.brandList = response.dateList;
            $scope.paginationConf.totalItems = response.total;
        })
    };


    $scope.save = function () {
        var obj;
        if ($scope.entity.id != null) {
            obj = brandService.update($scope.entity)
        } else {
            obj = brandService.save($scope.entity)
        }

        obj.success(function (response) {
            if (response.success) {
                $scope.reloadList();
            } else {
                alert(response.message);
            }
        })
    };


    $scope.findOne = function (id) {
        brandService.findOne(id).success(function (response) {
            $scope.entity = response;
        })
    };



    $scope.delete = function () {
        if ($scope.selectionList.length > 0) {
            if (window.confirm("确定要删除?")) {
                brandService.delete($scope.selectionList).success(function (response) {
                    if (response.success) {
                        $scope.reloadList();
                        $scope.selectionList = [];
                    } else {
                        alert(response.message)
                    }
                })
            }
        } else {
            alert("请选择后再删除...");
            return;
        }
    };

    $scope.searchEntity = {};
    $scope.search = function (pageNum, pageSize) {
        brandService.search(pageNum, pageSize, $scope.searchEntity).success(function (response) {
            $scope.brandList = response.dateList;
            $scope.paginationConf.totalItems = response.total;
        })
    }
});
