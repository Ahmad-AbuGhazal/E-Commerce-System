rapp.controller('vendorCtrl', ['$scope', '$q', '$location', '$http', 'vendorService', function ($scope, $q, $location, $http, vendorService) {

    // get vendor profile


    $scope.vendor = {};
    $scope.proucts = [];
    $scope.product = {
        productName: '',
        description: '',
        productPrice: '',
        productQuantity: '',
        approve: 'false',
        category: {
            id: ''
        },
        vendor: {
            vendor_sn: 1
        }
    };
    $scope.categoriesList = [];
    $scope.profilePageIndicator = true;
    $scope.addProductPageIndicator = false;

    //get vendor profile
    vendorService.getVendor(1)
        .then(function (res) {
            $scope.vendor = res.data;
        });

    // profile page view
    $scope.profilePageView = function profilePageView() {
        $scope.profilePageIndicator = true;
        $scope.addProductPageIndicator = false;

    }
    //get categories
    vendorService.getCategories()
        .then(function (res) {
            console.log(res.data);
            console.log(res.data.data);
            console.log(res.data.data.data);
            $scope.categoriesList = res.data.data;
        }, function (error) {

        });
    // get products by vendor
    $scope.getProducts = function getProducts() {
        vendorService.getProducts(vendor_sn).then(function (res) {
            $scope.products = res.data;
        });
    };

    // add product page view
    $scope.addProductPageView = function addProductPageView() {
        $scope.profilePageIndicator = false;
        $scope.addProductPageIndicator = true;
    };

    // add product service
    $scope.addProduct = function addProduct() {
        vendorService.addProduct($scope.product).then(function (res) {
        });
    };
}]);

