rapp.controller('logCtrl', ['$scope','$q', function($scope,$q) {
    $scope.loginData = {
    "username":'',
    "password":''
    };

    $scope.login = function() {
       console.log($scope.loginData);
    };
}]);