/**
 * Created by blosa on 21/09/2016.
 */
module app.users.profile {

    'use strict';
    import IPromise = angular.IPromise;

    // Interface du controller
    export interface IProfileService {

        getUser(id: number);
    }

    class ProfileService implements IProfileService {

        user: Utilisateur;

        /* @ngInject */
        constructor(private $resource) {
        }

        getUser(id: number) {
            let self = this;
            return this.$resource('api/user/:id', {
                id: id,
            }).get().$promise.then(function (ut) {
                self.user = ut;
                return ut;
            });
        }
    }

    angular
        .module('app.users.profile')
        .service('ProfileService', ProfileService);
}
