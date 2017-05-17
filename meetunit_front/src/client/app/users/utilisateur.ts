namespace app.users {
    'use strict';
    import IPromise = angular.IPromise;

    export class Utilisateur {

        id:number;
        pseudo:string;

        /* @ngInject */
        constructor(id:number, pseudo:string, name:string, firstname:string, mail:string, pass:string, passV:string) {
            this.id=id;
            this.pseudo=pseudo;
            this.name=name;
            this.firstname=firstname;
            this.mail=mail;
            this.pass=pass;
            this.passV=passV;
        }

    }
}
