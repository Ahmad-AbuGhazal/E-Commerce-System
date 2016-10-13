rapp.controller('productsCtrl', ['$scope', '$location', 'searchService', function ($scope, $location, searchService) {
    $scope.mo = function () {
        console.log($location.path().split("/")[2]);
    }
}]);