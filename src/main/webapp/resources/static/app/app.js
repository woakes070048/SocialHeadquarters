define([ 'angular',
 'angular-route',
 'angular-bootstrap',
 'angular-resource',
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
            'ui.bootstrap',
            'app.brands',
            'app.contact',
            'app.home',
            'app.manageBrand',
            'app.users'
            ]);

    return app;
});
