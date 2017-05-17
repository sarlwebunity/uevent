namespace app.connexion {
    'use strict';
    import IPromise = angular.IPromise;

    export class ConnexionController {

        libelle:string;
        /* @ngInject */
        constructor() {
        }

    }

    angular
        .module('app.connexion')
        .controller('ConnexionController', ConnexionController);
}
