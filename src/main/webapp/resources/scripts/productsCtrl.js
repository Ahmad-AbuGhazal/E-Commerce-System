rapp.controller('productsCtrl', ['$scope', '$location', 'searchService','memService',
                                 function ($scope, $location, searchService, memService) {
    $scope.productList = memService.getsdata();
    
    $scope.mo = function () {
        console.log($location.path().split("/")[2]);
    }
}]);

rapp.controller('productDetailCtrl',['$scope', '$location', 'searchService','memService',
                                     function($scope, $location, searchService, memService) {
    //$scope.productDetail = searchService.searchOne($location.path().split("/")[2]);
    
    $scope.productDetails = searchService.searchOne($location.path().split("/")[2]);
    
    
    
    getSimilarProdsData();
    
    
    this.reload = function() {
        $scope.productDetails = searchService.searchOne($location.path().split("/")[2]);
    
        getSimilarProdsData();
    }
    
    function getSimilarProdsData() {
    	searchService.searchSimilarProds($location.path().split("/")[2])
    	.then(function() {
    		$scope.similarProducts = memService.getSimilarProdsData();
    	}, function(error){
    		
    	});
    }
    
}]);