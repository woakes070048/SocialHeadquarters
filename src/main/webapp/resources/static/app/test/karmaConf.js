module.exports = function(config) {
  config.set({

  basePath: '.././',

        files : [
            {pattern: 'node_modules/angular/angular.js', included: true},
            {pattern: 'node_modules/angular-route/angular-route.js', included: true},
            {pattern: 'node_modules/angular-mocks/angular-mocks.js', included: true},
            {pattern: 'node_modules/requirejs-domready/domReady.js', included: true},
            {pattern: 'node_modules/angular-easyfb/build/angular-easyfb.js',included: true},
            {pattern: 'node_modules/angular-bootstrap/ui-bootstrap.js',included: true},
            {pattern:  'node_modules/angular-resource/angular-resource.js',included: true},
            {pattern: 'test/unit/*.js', included: true},
            {pattern: '*.js', included: true},

            // needs to be last http://karma-runner.github.io/0.12/plus/requirejs.html
            'test-main.js'
        ],

   autoWatch: true,

   frameworks: ['jasmine', 'requirejs'],

   browsers:  ['Chrome'],

   plugins:   [
                'karma-chrome-launcher',
                'karma-firefox-launcher',
                'karma-jasmine',
                'karma-junit-reporter',
                 'karma-requirejs',
               ],

   reporters: ['junit'],

   junitReporter: {
                 outputFile: 'report_unit.xml',
                 outputDir: 'test/reports'
                  }
  });
};