define([
    'require',
    'angular',
    'app',
    'routeConfig',
    'easyfbConfig',
    'ngDialogConfig'
    ], function (require, ng) {
    'use strict';

    require(['domReady!'], function (document) {
        ng.bootstrap(document, ['app']);
    });
});