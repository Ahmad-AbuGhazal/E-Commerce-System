rapp.service('paymentService', ['$http', '$q', function ($http, $q) {

    this.getPayments = function (customerId) {
        var deferred = $q.defer();
        // call http service to get all orders
        $http({
            method: 'GET',
            url: '/estore/customers/' + customerId + '/payments'
        }).then(function (res) {
            deferred.resolve(res);
        }, function (error) {
            deferred.reject(error);
        });
        return deferred.promise;
    };
}]);