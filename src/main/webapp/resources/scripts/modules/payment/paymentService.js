rapp.service('paymentService', ['$http', '$q', function ($http, $q) {

    this.getPayments = function (customerId) {
        var deferred = $q.defer();
        // call http service to get all payments
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
      // call http to add payment
    this.addPayment = function addPayment(customerId, paymentCard) {

        console.log(customerId);

        var deferred = $q.defer();
        $http({
            method: 'POST',
            url: '/estore/customers/' + customerId + '/payments',
            data: paymentCard

        }).then(function (res) {
            deferred.resolve(res);
        }, function (error) {
         deferred.reject(error);
        });
        return deferred.promise;
    };

    this.detetePayment=function deletePayment(paymentId){
   var deferred = $q.defer();
        // call http service to get all payments
        $http({
            method: 'PUT',
            url: '/estore/customers/' + customerId + '/payments'+'/'+paymentId
        }).then(function (res) {
            deferred.resolve(res);
        }, function (error) {
            deferred.reject(error);
        });
        return deferred.promise;
    
    };
}]);