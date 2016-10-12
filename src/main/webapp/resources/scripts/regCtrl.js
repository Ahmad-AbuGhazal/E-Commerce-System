rapp.controller('regCtrl', ['$scope','$q','regService', function($scope,$q,regService) {
    $scope.regData = {};
    $scope.regData.credDetails=regService.getCredDetails;
    $scope.regData.userDetails=regService.getUserDetails;
    $scope.regData.cardDetails=regService.getCardDetails;
    
    
    $scope.register = function() {
        var promise = regService.register($scope.regData.userDetails, $scope.regData.cardDetails);
        promise.then(function(data) {
            console.log(data);
        }, function(error) {
            console.log(error);
        });
    };
}]);