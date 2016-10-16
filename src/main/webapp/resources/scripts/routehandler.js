var app = angular.module('estore', ['ngRoute', 'rapp', 'ngAnimate', 'ngSanitize', 'ui.bootstrap']);

app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
            templateUrl: 'resources/views/hotdeals.html'
        }).when('/login', {
        	templateUrl: 'resources/views/login.html',
        	controller : 'loginCtrl'
        }).when('/search', {
            templateUrl: 'hotdeals.html'
        }).when('/customer/profile',{
        templateUrl:'resources/views/customer/profile.html'
        })
        .when('/customer/payments',{
        templateUrl:'resources/views/customer/payments.html',
        controller:'paymentCtrl'
        })
        .when('/customer/addPayment',{
        templateUrl:'resources/views/customer/addPayment.html',
        controller:'paymentCtrl'
        })
        .when('/customer/orders',{
        templateUrl:'resources/views/customer/orders.html',
        controller:'orderCtrl'
        }).when('/vendor/dashboard', {
            templateUrl: 'resources/views/vendor/profile.html',
            controller:'vendorCtrl'
        })
        .when('/vendor/register', {
            templateUrl: 'resources/views/vendor-registration.html',
            controller: 'regCtrl'
        }).when('/products/:name', {
            templateUrl: 'resources/views/searchProducts.html',
            controller: 'productsCtrl'
        }).when('/productDetail/:id', {
            templateUrl: 'resources/views/productDetails.html',
            controller: 'productDetailCtrl'
    })
        .otherwise({
            templateUrl: '../views/hotdeals.html'
        });
}]);

var rapp = angular.module('rapp', []);