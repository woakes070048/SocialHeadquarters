
app.service('ManageBrandService', ['$http', '$q', function($http, $q){
    return {

            fetchFacebookAccount: function(brandId){
                                return $http.get('http://localhost:8080/brand/'+brandId+'/facebookaccount/')
                                        .then(
                                                function(response){
                                                    return response.data;
                                                },
                                                function(errResponse){
                                                    console.error('Error while updating brand');
                                                    return $q.reject(errResponse);
                                                }
                                        );
                        },
            createFacebookAccount: function(facebookAccount){
                    return $http.post('http://localhost:8080/brand/facebookaccount/', facebookAccount)
                            .then(
                                    function(response){
                                        return response.data;
                                    },
                                    function(errResponse){
                                        console.error('Error while creating facebookAccount');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            updateFacebookAccount: function(facebookAccount, id){
                    return $http.put('http://localhost:8080/brand/facebookaccount/'+id, facebookAccount)
                            .then(
                                    function(response){
                                        return response.data;
                                    },
                                    function(errResponse){
                                        console.error('Error while updating facebookAccount');
                                        return $q.reject(errResponse);
                                    }
                            );
             },
             fetchFacebookAccountProfile: function(facebookAccount, id){
                    return $http.put('http://localhost:8080/brand/facebookaccount/'+id+'/profile/')
                            .then(
                                     function(response){
                                           return response.data;
                                      },
                                      function(errResponse){
                                          console.error('Error while fetching facebookAccount profile');
                                          return $q.reject(errResponse);
                                       }
                              );
             }
      };
}]);