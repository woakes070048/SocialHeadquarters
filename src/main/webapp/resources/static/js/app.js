var app = angular.module('app', ['ngResource' , 'ngRoute', 'ui.bootstrap']);
app.config(function($routeProvider, $locationProvider){
    $routeProvider
        .when('/',{
            templateUrl: 'resources/static/views/home.html',
            controller: 'MainController'
        })
        .when('/users',{
            templateUrl: 'resources/static/views/admin_users.html',
            controller: 'UserController'
        })
         .when('/brands',{
                    templateUrl: 'resources/static/views/user_brands.html',
                    controller: 'BrandController'
                })
        .when('/brand', {
                       templateUrl: 'resources/static/views/manage_brand.html',
                       controller: 'BrandController'
                })
        .when('/contactus',{
            templateUrl: 'resources/static/views/contactus.html',
            controller: 'ContactController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});