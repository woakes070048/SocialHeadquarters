define(['./module'], function (module) {
    'use strict';

    module.controller('BrandController', ['$scope','$routeParams','ngDialog' , 'BrandService','ManageBrandService','sharedProperties', '$timeout', function($scope, $routeParams, ngDialog ,BrandService,ManageBrandService, sharedProperties, $timeout) {
          var self = this;
          self.brand={id:null,name:'',description:''};
          self.brands = [];
          self.brandId = parseInt( $routeParams.brandId, 10);
          $scope.brandList = sharedProperties.getBrandList();
          $scope.viewedBrand = sharedProperties.getViewedBrand();

          self.fetchAllBrands = function(){
              BrandService.fetchAllBrands()
                  .then(
                               function(fetchedBrands) {
                                    self.brands = fetchedBrands;
                                    sharedProperties.setBrandList(self.brands);

                               },
                                function(errResponse){
                                    console.error('Error while fetching Brands');
                                }
                       );
          };

          self.createBrand = function(brand){
              BrandService.createBrand(brand)
                      .then(
                      self.fetchAllBrands,
                              function(errResponse){
                                   console.error('Error while creating Brand.');
                              }
                  );
          };

         self.updateBrand = function(brand, id){
              BrandService.updateBrand(brand, id)
                      .then(
                              self.fetchAllBrands,
                              function(errResponse){
                                   console.error('Error while updating Brand.');
                              }
                  );
          };

         self.deleteBrand = function(id){
              BrandService.deleteBrand(id)
                      .then(
                              self.fetchAllBrands,
                              function(errResponse){
                                   console.error('Error while deleting Brand.');
                              }
                  );
          };

          self.fetchAllBrands();

          self.submit = function() {
              if(self.brand.id===null){
                  console.log('Saving New Brand', self.brand);
                  self.createBrand(self.brand);
              }else{
                  self.updateBrand(self.brand, self.brand.id);
                  console.log('Brand updated with id ', self.brand.id);
              }
              self.reset();
          };

          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.brands.length; i++){
                  if(self.brands[i].id === id) {
                     self.brand = angular.copy(self.brands[i]);
                     break;
                  }
              }
          };

          self.fetchBrandAccounts = function(brandId){
               ManageBrandService.fetchFacebookAccount(brandId)
                   .then(
                                function(fetchedAccount) {
                                     sharedProperties.setBrandFacebookAccount(fetchedAccount);
                                },
                                 function(errResponse){
                                     console.error('Error while fetching Brand Accounts');
                                 }
                        );
           };

          self.initBrand = function(id){
              for(var i = 0; i <  self.brands.length; i++){
                  if( self.brands[i].id === id) {
                     sharedProperties.setViewedBrand(angular.copy( self.brands[i]));
                     self.fetchBrandAccounts(id);
                     break;
                  }
              }
          }

          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.brand.id === id) {
                 self.reset();
              }
              self.deleteBrand(id);
          };

          self.reset = function(){
              self.brand={id:null,name:'',description:''};
              $scope.myForm.$setPristine();
          };

      }]);
});