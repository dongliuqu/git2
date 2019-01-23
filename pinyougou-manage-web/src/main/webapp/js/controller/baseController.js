app.controller("baseController", function ($scope) {

    $scope.paginationConf = {
        currentPage: 1,//当前页号
        totalItems: 10,//总记录数
        itemsPerPage: 10,//页大小
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();
        }
    };

    // $scope.fi
    $scope.reloadList = function () {
        // ndPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage)

    };


    $scope.selectionList=[];
    $scope.updateSelection = function (event, id) {
        if (event.target.checked) {
            $scope.selectionList.push(id)
        } else {
            $scope.selectionList.splice($scope.selectionList.indexOf(id), 1);
        }
    };

});