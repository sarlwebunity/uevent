namespace app.users.profile {
    'use strict';
    import IPromise = angular.IPromise;

    export class ProfileController {

        user: Utilisateur;
        /* @ngInject */
        constructor(private ProfileService: IProfileService, private $stateParams) {
            this.getUser($stateParams.id);
        }

        getUser(id: number){
            let self = this;
            this.ProfileService.getUser(id).then(function (ut){
                //On récupère la sortie
                self.user = ut;
            })
        }
    }

    angular
        .module('app.users.profile')
        .controller('ProfileController', ProfileController);
}
