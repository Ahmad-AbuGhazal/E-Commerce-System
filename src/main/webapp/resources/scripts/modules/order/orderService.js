rapp.service('orderService',['$http','$q', function($http, $q) {
this.orders=[];
this.getorders=function getorders(customerId){

// call http service to get all orders
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: '/estore/customers/' + customerId + '/orders'
        }).then(function (res) {
            deferred.resolve(res);
        }, function (error) {
            deferred.reject(error);
        });
        return deferred.promise;
    };
}]);
 