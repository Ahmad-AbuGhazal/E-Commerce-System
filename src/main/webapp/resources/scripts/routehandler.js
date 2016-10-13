var app = angular.module('estore', ['ngRoute', 'rapp', 'ngAnimate', 'ngSanitize', 'ui.bootstrap']);

app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
            templateUrl: '../views/hotdeals.html'
        }).when('/search', {
            templateUrl: 'hotdeals.html'
        }).when('/vendor/register', {
            templateUrl: 'vendor-registration.html',
            controller: 'regCtrl'
        }).when('/products/:name', {
            templateUrl: 'searchProducts.html',
            controller: 'productsCtrl'
        })
        .otherwise({
            templateUrl: '../views/hotdeals.html'
        });
}]);

var rapp = angular.module('rapp', []);