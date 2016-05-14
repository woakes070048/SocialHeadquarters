define('ngDialogConfig', ['./app'], function (app) {
    'use strict';
    return angular.module('app')
        .config(["ngDialogProvider", function (ngDialogProvider){
           ngDialogProvider.setDefaults({
                                           className: "ngdialog-theme-default",
                                           plain: false,
                                           showClose: true,
                                           closeByDocument: true,
                                           closeByEscape: true,
                                           appendTo: false,
                                           preCloseCallback: function () {
                                                          console.log("ngDialog module pre-close callback");
                                           }
                          });
        }]);
});