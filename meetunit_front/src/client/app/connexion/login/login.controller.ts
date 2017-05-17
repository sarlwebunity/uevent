namespace app.users {
    'use strict';
    import IPromise = angular.IPromise;

    export class UsersController {

        libelle:string;
        /* @ngInject */
        constructor() {
        }

    }

    angular
        .module('app.users')
        .controller('UsersController', UsersController);
}
