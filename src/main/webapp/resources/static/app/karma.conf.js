// Karma configuration
module.exports = function(config) {
  config.set({

    basePath: '',

    frameworks: ['jasmine', 'requirejs'],

    files: [
            {pattern: 'node_modules/requirejs/require.js', included: false},
            {pattern: 'node_modules/angular/angular.js', included: false},
            {pattern: 'node_modules/angular-mocks/angular-mocks.js', included: false},
            {pattern: 'node_modules/angular-route/angular-route.min.js',included: false},
            {pattern: 'node_modules/angular-resource/angular-resource.min.js',included: false},
            {pattern: 'node_modules/angular-easyfb/build/angular-easyfb.min.js',included: false},
            {pattern: 'node_modules/angular-bootstrap/ui-bootstrap.js',included: false},
            {pattern: 'node_modules/angular-animate/angular-animate.min',included: false},
            {pattern: 'node_modules/requirejs-domready/domReady.js', included: false},
            {pattern: 'test/unit/*.js', included: true },
            {pattern: './**/*.js', included: false },
           'test-main.js'
    ],

    exclude: [
            './main.js',
            'test/karmaConf.js',
            'test/protractorConf.js'
    ],

    preprocessors: {
    },

    reporters: ['progress','junit'],

    junitReporter: {
                 outputFile: 'report_unit.xml',
                 outputDir: 'test/reports'
                  },

    port: 9876,

    colors: true,

    logLevel: config.LOG_DEBUG,

    autoWatch: true,

    browsers: ['Chrome', 'Firefox'],

    singleRun: false,

    concurrency: Infinity
  })
}
