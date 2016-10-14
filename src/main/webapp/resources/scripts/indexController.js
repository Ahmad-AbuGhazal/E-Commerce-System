app.controller('indexCtrl',['$scope','$location','searchService', function($scope, $location, searchService) {
    $scope.searchQuery='';
    
    $scope.categoryName='Electronics';
    
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
        searchService.search($scope.searchQuery, $scope.categoryName);
        
        //route to search list page
    }
    
    $scope.login = function() {
    	$location.path("/login");
    }
}]);
