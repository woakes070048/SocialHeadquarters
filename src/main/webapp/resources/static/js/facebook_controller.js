
app.controller('FacebookAccountController', ['$scope','$routeParams','ngDialog' , 'BrandService' ,'FacebookAccountService','sharedProperties', function($scope, $routeParams, ngDialog ,BrandService,FacebookAccountService, sharedProperties) {
          var self = this;
          self.facebookAccount={id:null,appId:'',secretKey:'',brandId:null};
          $scope.brandFacebookAccount = sharedProperties.getBrandFacebookAccount();
          $scope.viewedBrand = sharedProperties.getViewedBrand();


         self.createFacebookAccount = function(facebookAccount){
              facebookAccount.brandId = $scope.viewedBrand.id;
              FacebookAccountService.createFacebookAccount(facebookAccount)
                      .then(
                           self.fetchFacebookAccount,
                              function(errResponse){
                                   console.error('Error while creating FacebookAccount.');
                              }
                  );
          };

         self.updateFacebookAccount = function(facebookAccount, id){
              FacebookAccountService.updateFacebookAccount(facebookAccount, id)
                      .then(
                              function(errResponse){
                                   console.error('Error while updating FacebookAccount.');
                              }
                  );
          };

          self.submit = function() {
              if(self.facebookAccount.id===null){
                  console.log('Saving New Facebook account', self.facebookAccount);
                  self.createFacebookAccount(self.facebookAccount);

              }else{
                  console.log('Facebook account updated with id ', self.facebookAccount.id);
                  self.updateFacebookAccount(self.facebookAccount, self.facebookAccount.id);
              }
          };

 }]);