require.config({
    baseUrl: "resources/static/app/",

    // alias libraries paths.  Must set 'angular'
    paths: {
        'angular': 'node_modules/angular/angular.min',
        'angular-route': 'node_modules/angular-route/angular-route.min',
        'angular-resource': 'node_modules/angular-resource/angular-resource.min',
        'angular-easyfb': 'node_modules/angular-easyfb/build/angular-easyfb.min',
        'angular-bootstrap': 'node_modules/angular-bootstrap/ui-bootstrap',
        'angular-animate': 'node_modules/angular-animate/angular-animate.min',
        'ngDialog': 'ngDialog',
        'domReady': 'node_modules/requirejs-domready/domReady'
    },

    shim: {
         'angular': {
                exports: 'angular'
                   },
        'angular-route':    ['angular'],
        'angular-resource': ['angular'],
        'angular-easyfb':   ['angular'],
        'angular-bootstrap':['angular'],
        'angular-animate':  ['angular']
    },

    // kick start application
    deps: ['./appBootstrap']
});