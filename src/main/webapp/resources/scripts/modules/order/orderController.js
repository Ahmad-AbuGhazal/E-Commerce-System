rapp.controller('orderCtrl', ['$scope','orderService','$q','$location', function($scope,orderService,$q,$location) {
    $scope.orders=[];
    orderService.getorders(1).then(function (res) {
          $scope.orders=res.data;
   });
}]);