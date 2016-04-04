
app.service('BrandService', ['$http', '$q', function($http, $q){
    return {
            fetchAllBrands: function() {
                    return $http.get('http://localhost:8080/brand/')
                            .then(
                                    function(response){
                                        return response.data;
                                    },
                                    function(errResponse){
                                        console.error('Error while fetching brands');
                                        return $q.reject(errResponse);
                                    }
                            );
            },

            createBrand: function(brand){
                    return $http.post('http://localhost:8080/brand/', brand)
                            .then(
                                    function(response){
                                        return response.data;
                                    },
                                    function(errResponse){
                                        console.error('Error while creating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },

            updateBrand: function(brand, id){
                    return $http.put('http://localhost:8080/brand/'+id, brand)
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
            fetchBrandFacebookAccounts: function(id){
                                return $http.get('http://localhost:8080/brand/'+id+'/facebook/')
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

            deleteBrand: function(id){
                    return $http.delete('http://localhost:8080/brand/'+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    },
                                    function(errResponse){
                                        console.error('Error while deleting brand');
                                        return $q.reject(errResponse);
                                    }
                            );
            }

    };

}]);
app.service('sharedProperties', function() {
    var viewedBrand;
    var brandFacebookAccount;
    var brandList = [];

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