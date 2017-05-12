namespace app.evenements {
    'use strict';
    import IPromise = angular.IPromise;

    export class EvenementsController {

        libelle:string;
        /* @ngInject */
        constructor() {
        }

    }

    angular
        .module('app.evenements')
        .controller('EvenementsController', EvenementsController);
}
