app.controller('MainController',  ['$scope', function($scope) {
    $scope.headingTitle = "Welcome!";
}]);

app.controller('UsersAdministrationController',  ['$scope',function($scope) {
    $scope.headingTitle = "Users Administration";
}]);

app.controller('ContactController',  ['$scope',function($scope) {
    $scope.headingTitle = "Contact Info";
}]);