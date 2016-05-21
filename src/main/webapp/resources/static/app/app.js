define([ 'angular',
 'angular-route',
 'angular-bootstrap',
 'angular-resource',
 'angular-animate',
 'ngDialog',
 'angular-easyfb',
 './brands/index',
 './contact/index',
 './home/index',
 './manageBrand/index',
 './users/index'
], function (angular) {
    'use strict';

    var app = angular.module('app', [
            'ngRoute',
            'ezfb',
            'ngDialog',
            'ngResource',
            'ngAnimate',
            'ui.bootstrap',
            'app.brands',
            'app.contact',
            'app.home',
            'app.manageBrand',
            'app.users'
            ]);

    return app;
});
