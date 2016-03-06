app.controller('MainController',  ['$scope', function($scope) {
    $scope.headingTitle = "Welcome!";
}]);

app.controller('GalleryController',  ['$scope',function($scope) {
    $scope.headingTitle = "Photo Gallery Items";
}]);

app.controller('ContactController',  ['$scope',function($scope) {
    $scope.headingTitle = "Contact Info";
}]);