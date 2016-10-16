rapp.controller('paymentCtrl', ['$scope', '$q', '$location','$http','paymentService', function ($scope, $q, $location,$http,paymentService) {
$scope.payments=[];

$scope.payment={
cardHolder: '',
cardNum:'',
securityCode: '',
expiration: ''
};
// get payments

$scope.month='';
$scope.year='';
  $scope.addPaymentMessage=false;
  $scope.addPaymentMessageError=false;
  $scope.errorPaymentForm='';
  $scope.paymentDeleted='The Payment Sucsessfully deleted';
  $scope.paymentDeletedIndicator=false;
paymentService.getPayments(1)
.then(function (res) {
          $scope.payments=res.data;
   });

var origionPayment = angular.copy($scope.payment);

    $scope.reset = function reset () {
      $scope.payment = angular.copy(origionPayment);
      $scope.paymentForm.$setPristine();
      $scope.addPaymentMessageError=false;
      $scope.addPaymentMessage=false;
    };
      $scope.ccinfo = {type:undefined};
// add payment 
$scope.addPayment=function addPaymentCard(){
$scope.payment.expiration=$scope.year+"-"+$scope.month+"-"+1;
if ($scope.paymentForm.$valid){

paymentService.addPayment(1,$scope.payment).then(function (res) {
         var response=res.data;
          if(response.response=='Y'){
           $scope.addPaymentMessage=true;
           $scope.reset();  
         }
         else{
      $scope.addPaymentMessageError=true;
      $scope.errorPaymentForm=res.data.message;
  
         }
   },function error(error){
      $scope.addPaymentMessageError=true;
      console.log(error.data.message);
      $scope.errorPaymentForm=error.data.message;
   });
}
};


// delete payment 
$scope.detetePayment = function deletePayment(customerId,paymentId){
paymentService.detetePayment(customerId,paymentId).then(function (res) {
         var response=res.data;
          if(response.response=='Y'){
          $scope.paymentDeletedIndicator=true;
          getPaymentsLocal();
         }
         else{
         }
   },function error(error){
   
   });
};

function getPaymentsLocal(){
  paymentService.getPayments(1)
.then(function (res) {
          $scope.payments=res.data;
   });
}
}]);
