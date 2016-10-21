rapp.controller('regCtrl', ['$scope','$q','regService', function($scope,$q,regService) {
    $scope.regData = {};
    $scope.regData.credDetails={};
    $scope.regData.userDetails={};
    $scope.regData.userDetails.customer={};
    $scope.regData.cardDetails={};
    
    $scope.regSuccess = false;
    $scope.showRegResult = false;
    
    $scope.register = function(formNum) {
    	if(formNum=="1") {
    		angular.element('#tab1 a').trigger('click');
    	} else if(formNum =="2") {
    		angular.element('#tab2 a').trigger('click');
    		$scope.form2Class="active";
    	} else if(formNum=="3") {
    		angular.element('#tab3 a').trigger('click');
    	} else if(formNum=="4") {
	        var promise = regService.registerUser($scope.regData.userDetails.userType, $scope.regData.credDetails, $scope.regData.userDetails, $scope.regData.cardDetails);
	        promise.then(function(data) {
	        	if(data.response == 'Y') {
	        		$scope.regSuccess=true;
	        		$scope.showRegResult = true;
	        	} else {
	        		$scope.regSuccess=false;
		        	$scope.showRegResult = true;
	        	}
	        }, function(error) {
	        	$scope.regSuccess=false;
	        	$scope.showRegResult = true;
	        });
    	}
    };
}]);

rapp.directive('checkWith',[function() {
	return {
		require: 'ngModel',
		scope: {
			firstVal : "=checkWith"
		},
		link: function(scope, elem, attrs, ngModel) {
			ngModel.$validators.compareTo=function(val) {
				return val == scope.firstVal;
			};
			
			scope.$watch("firstVal", function() {
				ngModel.$validate();
			});
		}
	}
}]);