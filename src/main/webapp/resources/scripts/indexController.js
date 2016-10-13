app.controller('indexCtrl',['$scope','$location','searchService', function($scope, $location, searchService) {
    $scope.searchQuery='';
    
    $scope.searchData=searchService.search($scope.searchQuery);;
    
    $scope.getItems = function() {
        $scope.searchData = searchService.getSearchData();
    }
    
    $scope.search = function() {
        $scope.searchData = searchService.search($scope.searchQuery);
    }
    
    $scope.searchClick = function() {
        searchService.search($scope.searchQuery);
        
        //route to search list page
    }
}]);
