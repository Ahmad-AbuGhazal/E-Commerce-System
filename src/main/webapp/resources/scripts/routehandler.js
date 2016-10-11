var app = angular.module('estore', ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {
$routeProvider.when('/', {
    templateUrl: 'resources/views/hotdeals.html'
}).when('/search', {
    templateUrl: 'resources/views/hotdeals.html'
}).when('/vendor/register',{
    templateUrl: 'resources/views/vendor-registration.html'
})
    .otherwise({
    templateUrl: 'resources/views/hotdeals.html'
});
}]);