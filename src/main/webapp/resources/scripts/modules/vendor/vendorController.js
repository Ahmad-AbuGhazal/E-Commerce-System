rapp.controller('vendorCtrl', ['$scope', '$q', '$location','$http','vendorService', function ($scope, $q, $location,$http,vendorService) {

// get vendor profile


$scope.vendor={};
$scope.proucts=[];
$scope.profilePageIndicator=true;

vendorService.getVendor(1)
.then(function (res) {
          $scope.vendor=res.data;
   });


$scope.getProducts=function getProducts(){
   vendorService.getProducts(vendor_sn).then(function (res) {
          $scope.products=res.data;
   });

};
}]);

