define('routeConfig', ['./app'], function (app) {
    'use strict';
    return angular.module('app')
        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider
                            .when('/',{
                                    templateUrl: 'resources/static/app/home/home.html',
                                    controller: 'HomeController'
                            })
                            .when('/users',{
                                    templateUrl: 'resources/static/app/users/users.html',
                                    controller: 'UserController'
                            })
                            .when('/brands',{
                                   templateUrl: 'resources/static/app/brands/user_brands.html',
                                   controller: 'BrandController'
                             })
                            .when('/brand', {
                                    templateUrl: 'resources/static/app/manageBrand/manage_brand.html',
                                    controller: 'BrandController'
                             })
                            .when('/contactus',{
                                    templateUrl: 'resources/static/app/contact/contactus.html',
                                    controller: 'ContactController'
                             })
                            .otherwise({
                                    redirectTo: '/'
                            });
        }]);
});