'use strict';

if(window.__karma__) {
    var allTestFiles = [];
    var TEST_REGEXP = /spec\.js$/;

    var pathToModule = function(path) {
        return path.replace(/^\/base\/app\//, '').replace(/\.js$/, '');
    };

    Object.keys(window.__karma__.files).forEach(function(file) {
        if (TEST_REGEXP.test(file)) {
            allTestFiles.push(pathToModule(file));
        }
    });
}


require.config({
    paths: {
         'angular': 'node_modules/angular/angular.min',
         'angular-route': 'node_modules/angular-route/angular-route.min',
         'angular-resource': 'node_modules/angular-resource/angular-resource.min',
         'angular-easyfb': 'node_modules/angular-easyfb/build/angular-easyfb.min',
         'angular-bootstrap': 'node_modules/angular-bootstrap/ui-bootstrap',
         'ngDialog': 'ngDialog',
         'domReady': 'node_modules/requirejs-domready/domReady'
    },
    shim: {
        'angular': {'exports': 'angular'},
        'angularRoute': ['angular'],
        'angularMocks': {
            deps: ['angular'],
            'exports': 'angular.mock'
        }
    },
    priority: [
        "angular"
    ],
    deps: window.__karma__ ? allTestFiles : [],
    callback: window.__karma__ ? window.__karma__.start : null,
    baseUrl: window.__karma__ ? 'resources/static/app' : '/'
});

require([
              'require',
              'angular',
              'app',
              'routeConfig',
              'easyfbConfig',
              'ngDialogConfig'
    ], function (angular, app) {
        require(['domReady!'], function (document) {
            angular.bootstrap(document, ['app']);
        });
    }
);