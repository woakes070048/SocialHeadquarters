define(['./module'], function (module) {
    'use strict';

    module.controller('ContactController',  ['$scope',function($scope) {
    $scope.headingTitle = "Contact Info";
    $scope.pageClass = 'page-contact';

}]);
});