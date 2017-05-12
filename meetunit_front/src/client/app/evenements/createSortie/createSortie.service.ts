/**
 * Created by blosa on 21/09/2016.
 */
module app.evenements.createSortie {

    'use strict';
    import IPromise = angular.IPromise;

    // Interface du controller
    export interface ICreateSortieService {

    }

    class CreateSortieService implements ICreateSortieService {

        /* @ngInject */
        constructor(private $resource) {
        }

    }

    angular
        .module('app.evenements.createSortie')
        .service('CreateSortieService', CreateSortieService);
}
