namespace app.evenements.createSortie {
    'use strict';
    import IPromise = angular.IPromise;

    export class CreateSortieController {

        /* @ngInject */
        constructor(private CreateSortieService: ICreateSortieService, private $stateParams) {
        }
    }

    angular
        .module('app.evenements.createSortie')
        .controller('CreateSortieController', CreateSortieController);
}
