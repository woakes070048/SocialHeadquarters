define(['./module'], function (module) {
    'use strict';

    module.factory('sharedProperties', function() {
    var viewedBrand = {id:null,name:'',description:''};
    var brandList = [];
    var brandFacebookAccount;

    return {
        setBrandList: function(value) {
            brandList = value;
        },
        getBrandList: function() {
                    return brandList;
        },
        setViewedBrand: function(value) {
            viewedBrand = value;
        },
        getViewedBrand: function() {
                   return viewedBrand;
        },
        setBrandFacebookAccount: function(value) {
            brandFacebookAccount = value;
         },
        getBrandFacebookAccount: function() {
            return brandFacebookAccount;
         }
    }
});
});