rapp.service('paymentService',['$http','$q','$location', function($http, $q) {
this.payments=[];
this.getPayments=function getPayments(customerId){

// call http service to get all orders
$http.get({
    method:'GET',
    url:'/customers/'+customerId+'payments'
}).then(function (res) {
   this.payments=res.data;
      });
  return this.payments;
  };
}]);