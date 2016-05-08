module.exports = function(config) {
  config.set({

  basePath: '../',

  files :     [
               'vendor/angular/angular.js',
               'vendor/angular-route/angular-route.js',
               'vendor/angular-mocks/angular-mocks.js',
               'vendor/angular-resource/angular-resource.js',
               'vendor/angular-easyfb/build/angular-easyfb.js',
               'vendor/angular-bootstrap/ui-bootstrap.js',
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
                 outputFile: 'test/report_unit.xml'
                  }
  });
};