
app.controller('ManageBrandController', ['$scope','$routeParams','ngDialog' , 'BrandService' ,'ManageBrandService','sharedProperties', function($scope, $routeParams, ngDialog ,BrandService,ManageBrandService, sharedProperties) {
          var self = this;
          self.facebookAccount = {id:null,appId:'',secretKey:'',brandId:null};
          $scope.viewedBrand = sharedProperties.getViewedBrand();

         $scope.$watch(function () { return sharedProperties.getBrandFacebookAccount(); },
                    function (value) {
                        $scope.facebook = value;
                    }
                );

         self.createFacebookAccount = function(facebookAccount){
              facebookAccount.brandId = $scope.viewedBrand.id;
              ManageBrandService.createFacebookAccount(facebookAccount)
                      .then(
                              function(errResponse){
                                   console.error('Error while creating FacebookAccount.');
                              }
                  );
          };

         self.updateFacebookAccount = function(facebookAccount, id){
              ManageBrandService.updateFacebookAccount(facebookAccount, id)
                      .then(
                              function(errResponse){
                                   console.error('Error while updating FacebookAccount.');
                              }
                  );
          };

         self.loadProfile = function(facebookId) {
         				 ManageBrandService.fetchFacebookAccountProfile(facebookId)
                                              .then(function success(response) {
         						$scope.profile = response;
         					}, function error(error) {
         						$scope.message = 'Couldn\'t able to fetch profile :(';
         						console.log(error);
         					});
         };

         self.fetchFacebookAccount = function(brandId){
               ManageBrandService.fetchFacebookAccount(brandId)
                   .then(
                                function(fetchedAccount) {
                                     sharedProperties.setBrandFacebookAccount(fetchedAccount);
                                     self.facebookAccount = fetchedAccount;
                                },
                                 function(errResponse){
                                     console.error('Error while fetching Brand Accounts');
                                 }
                        );
           };

          self.fetchFacebookAccount($scope.viewedBrand.id);

          self.submit = function() {
              if(self.facebookAccount.id == null){
                  console.log('Saving New Facebook account', self.facebookAccount);
                  self.createFacebookAccount(self.facebookAccount);

              }else{
                  console.log('Facebook account updated with id ', self.facebookAccount.id);
                  self.updateFacebookAccount(self.facebookAccount, self.facebookAccount.id);
              }
              ngDialog.close();
          };

          self.addEditFacebookAccount = function(){
               ngDialog.open({
                template: 'resources/static/views/modals/modalFacebook.html',
                plain: false,
                controller: 'ManageBrandController'
                });
          }
 }]);