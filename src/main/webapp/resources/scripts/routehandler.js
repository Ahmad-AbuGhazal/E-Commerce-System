var app = angular.module('estore', ['ngRoute', 'rapp', 'ngAnimate', 'ngSanitize', 'ui.bootstrap']);

app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
            templateUrl: 'resources/views/hotdeals.html'
        }).when('/login', {
        	templateUrl: 'resources/views/login.html',
        	controller : 'loginCtrl'
        }).when('/vendor/register', {
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
            templateUrl: 'resources/views/hotdeals.html'
        });
}]);

var rapp = angular.module('rapp', []);