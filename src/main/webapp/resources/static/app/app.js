var app = angular.module('app', ['ngResource' , 'ngRoute', 'ui.bootstrap', 'ngDialog','ezfb']);
app.config(function($routeProvider, $locationProvider,ezfbProvider){
      ezfbProvider.setInitParams({
        appId: '1042323119170013',
        version: 'v2.6'
      });
    $routeProvider
        .when('/',{
            templateUrl: 'resources/static/app/views/home.html',
            controller: 'MainController'
        })
        .when('/users',{
            templateUrl: 'resources/static/app/views/admin_users.html',
            controller: 'UserController'
        })
         .when('/brands',{
                    templateUrl: 'resources/static/app/views/user_brands.html',
                    controller: 'BrandController'
                })
        .when('/brand', {
                       templateUrl: 'resources/static/app/views/manage_brand.html',
                       controller: 'BrandController'
                })
        .when('/contactus',{
            templateUrl: 'resources/static/app/views/contactus.html',
            controller: 'ContactController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});
app.config(["ngDialogProvider", function (ngDialogProvider) {
    ngDialogProvider.setDefaults({
        className: "ngdialog-theme-default",
        plain: false,
        showClose: true,
        closeByDocument: true,
        closeByEscape: true,
        appendTo: false,
        preCloseCallback: function () {
            console.log("default pre-close callback");
        }
    });
}]);

