define([
    'require',
    'angular',
    'app',
    'routeConfig',
    'easyfbConfig',
    'ngDialogConfig'
], function (require, ng) {
    'use strict';

    /*
     * place operations that need to initialize prior to app start here
     * using the `run` function on the top-level module
     */

    require(['domReady!'], function (document) {
        ng.bootstrap(document, ['app']);
    });
});