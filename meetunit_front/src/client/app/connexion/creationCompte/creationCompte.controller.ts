namespace app.connexion.creationCompte {
    'use strict';
    import IPromise = angular.IPromise;

    export class NewCompteController {

        newUser:Utilisateur;

        /* @ngInject */
        constructor() {
            
        }

    }

    angular
        .module('app.connexion.creationCompte')
        .controller('NewCompteController', NewCompteController);
}
