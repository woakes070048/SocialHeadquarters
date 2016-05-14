require.config({
    baseUrl: "",

    // alias libraries paths.  Must set 'angular'
    paths: {
        'angular': 'node_modules/angular/angular.min',
        'angular-route': 'node_modules/angular-route/angular-route.min',
        'angular-resource': 'node_modules/angular-resource/angular-resource.min',
        'angular-easyfb': 'node_modules/angular-easyfb/angular-easyfb.min.js',
        'angular-bootstrap': 'node_modules/angular-bootstrap/ui-bootstrap.js'
    },

    // Add angular modules that does not support AMD out of the box, put it in a shim
    shim: {
        'angular-route': ['angular']
        'angular-resource': ['angular']
        'angular-easyfb': ['angular']
        'angular-bootstrap': ['angular']
    },

    // kick start application
    deps: ['app']
});