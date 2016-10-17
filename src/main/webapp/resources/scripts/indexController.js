app.controller('indexCtrl',['$scope','$location','$q','$http','searchService','memService', 
                            function($scope, $location,$q,$http, searchService, memService) {
    $scope.searchQuery='';
    
    $scope.categoryName='All';
    
    $scope.catList={'data':[]};
   
    searchService.getCategories()
	.then(function() {
		$scope.catList = memService.getCatList();
	}, function(error){
		console.log(error);
	});
    
    $scope.typeaheadClick=function(searchName) {
    	$location.path('products/'+window.encodeURIComponent(searchName));
    }
    
    $scope.catClick = function(catName) {
    	$scope.categoryName = catName;
    	$scope.searchQuery='';
    }
    
    $scope.callback = function(data) {
    	$scope.searchData = data;
    };
    
    searchService.registerCallback($scope.callback);
    
    $scope.searchData=searchService.getSearchData();
    
    $scope.getItems = function() {
        $scope.searchData = searchService.getSearchData();
    }
    
    $scope.search = function() {
        searchService.search($scope.searchQuery, $scope.categoryName);
    }
    
    
    
    $scope.searchClick = function() {
    	console.log('searchClick');
        searchService.search($scope.searchQuery, $scope.categoryName);
        $location.path('/products/'+$scope.searchQuery);
        //route to search list page
    }
    
    $scope.login = function() {
    	$location.path("/login");
    }
    
    $scope.searchEnter = function(event) {
    	if(event.keyCode==13)
    		$scope.searchClick();
    }
    
}]);
