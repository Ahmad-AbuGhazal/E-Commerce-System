var app = angular.module('estore', ['ngRoute','rapp']);

app.config(['$routeProvider', function ($routeProvider) {
$routeProvider.when('/', {
    templateUrl: 'resources/views/hotdeals.html'
}).when('/search', {
    templateUrl: 'resources/views/hotdeals.html'
}).when('/vendor/register',{
    templateUrl: 'resources/views/vendor-registration.html',
    controller: 'regCtrl'
})
    .otherwise({
    templateUrl: 'resources/views/hotdeals.html'
});
}]);

var rapp = angular.module('rapp',[]);