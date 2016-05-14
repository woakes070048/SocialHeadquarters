define(['./module'], function (module) {
    'use strict';

    module.service('BrandService', ['$http', '$q', function($http, $q){
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
                                        console.error('Error while creating brand');
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
});