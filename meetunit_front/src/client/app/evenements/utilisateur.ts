namespace app.evenements {
    'use strict';
    import IPromise = angular.IPromise;

    export class Utilisateur {

        id:number;
        pseudo:string;

        /* @ngInject */
        constructor(id:number, pseudo:string) {
            this.id=id;
            this.pseudo=pseudo;
        }

    }
}
