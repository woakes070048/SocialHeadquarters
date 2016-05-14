require.config({
  // Karma serves files under /base, which is the basePath from your config file
  baseUrl: '/base',
     paths: {
          'angular': 'node_modules/angular/angular.min',
          'angular-mocks': 'node_modules/angular-mocks/angular-mocks',
                  'angular-route': 'node_modules/angular-route/angular-route.min',
                  'angular-resource': 'node_modules/angular-resource/angular-resource.min',
                  'angular-easyfb': 'node_modules/angular-easyfb/build/angular-easyfb.min',
                  'angular-bootstrap': 'node_modules/angular-bootstrap/ui-bootstrap',
                  'ngDialog': 'ngDialog',
                  'domReady': 'node_modules/requirejs-domready/domReady'
     },
     shim: {
         'angular': {'exports': 'angular'},
         'angular-mocks': {
             deps: ['angular'],
             'exports': 'angular-mocks'
         },
         'angular-route': ['angular'],
                 'angular-resource': ['angular'],
                 'angular-easyfb': ['angular'],
                 'angular-bootstrap': ['angular'],
     },
     priority: [
         "angular"
     ]
  // we have to kickoff jasmine, as it is asynchronous
});
  require(['angular-mocks'], function() {

    var specFiles = [];
    for (var file in window.__karma__.files) {
      if (window.__karma__.files.hasOwnProperty(file)) {
        if (/\/base\/test\/unit\/.*_test\.js$/.test(file)) {
          specFiles.push(file);
        }
      }
    }

    // second overload to include specFiles and start Karma
    require.config({
      deps: specFiles,
      callback: window.__karma__.start
    });
  });
  require([      'angular',
                  'app',
                'require',
                'angular-mocks',
                              'routeConfig',
                              'easyfbConfig',
                              'ngDialogConfig'
      ], function (angular, app) {
          require(['domReady!'], function (document) {
              angular.bootstrap(document, ['app']);
          });
      }
  );
