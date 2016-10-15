rapp.controller('paymentCtrl', ['$scope', 'paymentService', '$q', '$location', function ($scope, $q, paymentService, $location) {
    
    $scope.payments=[];
    $scope.payment =
        {
            "id": '',
            "cardHolder": "",
            "cardNum": "",
            "securityCode": "",
            "expiration": '',
            "maxCredit": '',
            "availableCredit": '',
            "status": ''
        };


    $scope.getPayments = function getPayments(customerId) {
        $scope.payments = paymentService.getPayments(customerId);
    };
}]);