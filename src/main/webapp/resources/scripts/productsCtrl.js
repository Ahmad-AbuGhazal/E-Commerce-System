rapp.controller('productsCtrl', ['$scope', '$location', 'searchService', function ($scope, $location, searchService) {
    $scope.productList = searchService.search($location.path().split("/")[2]);
    
    $scope.mo = function () {
        console.log($location.path().split("/")[2]);
    }
}]);

rapp.controller('productDetailCtrl',['$scope', '$location', 'searchService',function($scope, $location, searchService) {
    //$scope.productDetail = searchService.searchOne($location.path().split("/")[2]);
    
    $scope.productDetails = searchService.searchOne($location.path().split("/")[2]);
    
    $scope.similarProducts = searchService.searchSimilarProds($location.path().split("/")[2]);
    
    
    this.reload = function() {
        $scope.productDetails = searchService.searchOne($location.path().split("/")[2]);
    
        $scope.similarProducts = searchService.searchSimilarProds($location.path().split("/")[2]);
    }
    
}]);