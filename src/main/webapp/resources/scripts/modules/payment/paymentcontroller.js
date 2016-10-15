rapp.controller('paymentCtrl', ['$scope', '$q', '$location','$http','paymentService', function ($scope, $q, $location,$http,paymentService) {
$scope.payments=[];
// get payments
paymentService.getPayments(1)
.then(function (res) {
          $scope.payments=res.data;
   });
}]);