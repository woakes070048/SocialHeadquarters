module.exports = function(config) {
  config.set({

  basePath: '../',

  files :     [
               'node_modules/requirejs/require.js',
               'node_modules/angular/angular.js',
               'node_modules/angular-route/angular-route.js',
               'node_modules/angular-mocks/angular-mocks.js',
               'node_modules/angular-resource/angular-resource.js',
               'node_modules/angular-easyfb/build/angular-easyfb.js',
               'node_modules/angular-bootstrap/ui-bootstrap.js',
               '*.js',
               'test/unit/*.js'
               ],
   autoWatch: true,

   frameworks: ['jasmine'],

   browsers:  ['Chrome'],

   plugins:   [
                'karma-chrome-launcher',
                'karma-firefox-launcher',
                'karma-jasmine',
                'karma-junit-reporter'
               ],

   reporters: ['junit'],

   junitReporter: {
                 outputFile: 'report_unit.xml',
                 outputDir: 'test/reports'
                  }
  });
};