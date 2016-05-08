exports.config = {
  specs: [
    'e2e/*.js'
  ],
     capabilities: {
          'browserName': 'chrome'
       },

       baseUrl: 'http://localhost:8080/',

       framework: 'jasmine2',

       jasmineNodeOpts: {
          defaultTimeoutInterval: 30000
       }
};