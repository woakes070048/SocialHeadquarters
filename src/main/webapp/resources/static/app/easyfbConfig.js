define('easyfbConfig', ['./app'], function (app) {
    'use strict';
    return angular.module('app')
        .config(['ezfbProvider', function (ezfbProvider){
            ezfbProvider.setInitParams({
                                    appId: '1042323119170013',
                                    version: 'v2.6'
            });
        }]);
});