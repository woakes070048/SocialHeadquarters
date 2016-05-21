define(['./module'], function (module) {
    'use strict';

    module.controller('HomeController',  ['$scope', function($scope) {
         $scope.headingTitle = "Welcome!";
         $scope.pageClass = 'page-home';

    }]);
});