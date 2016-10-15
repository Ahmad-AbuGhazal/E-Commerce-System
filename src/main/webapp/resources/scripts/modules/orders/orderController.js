rapp.controller('orderCtrl', ['$scope','orderService','$q','$location', function($scope,$q,orderService,$location) {
    $scope.order = {
    "status":'',
    "orderDate":'',
    "id":''
    };

    $scope.getorders = function getorders(customerId) {
       $scope.orders= orderService.getorders(customerId);
    };
}]);