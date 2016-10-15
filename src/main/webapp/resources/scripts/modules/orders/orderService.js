rapp.service('orderService',['$http','$q', function($http, $q) {
this.orders=[];
this.getOrders=function getOrders(customerId){

// call http service to get all orders
$http.get({
    method:'GET',
    url:'/customers/'+customerId+'orders'
}).then(function (res) {
   this.orders=res.data;
      });
    return this.getOrders;  
  };
}]);
 