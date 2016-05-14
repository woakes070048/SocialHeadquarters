'use strict';

describe('Controller: UserController', function () {
    var $scope;
    var controller;

    beforeEach(function() {
        module("app");

        inject(function(_$rootScope_, $controller) {
            $scope = _$rootScope_.$new();
            controller = $controller("UserController", {$scope: $scope});
         });
    });

    it("Should count zero", function() {
        expect(controller.users.length).toBe(0);
    });
});