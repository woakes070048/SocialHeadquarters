define(['./module'], function (module) {
    'use strict';

    module.controller('AboutController',  ['$scope',function($scope) {
    $scope.headingTitle = "About Social Headquarters";
    $scope.pageClass = 'page-contact';

}]);
});