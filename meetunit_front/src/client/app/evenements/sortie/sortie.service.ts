/**
 * Created by blosa on 21/09/2016.
 */
module app.evenements.sortie {

    'use strict';
    import IPromise = angular.IPromise;

    // Interface du controller
    export interface ISortieService {

        getSortie(id: number);
    }

    class SortieService implements ISortieService {

        sortie: Sortie;

        /* @ngInject */
        constructor(private $resource) {
        }

        getSortie(id: number) {
            let self = this;
            return this.$resource('api/sortie/:id', {
                id: id,
            }).get().$promise.then(function (sort) {
                sort.date = moment(sort.dateDebut);
                self.sortie = sort;
                return sort;
            });
        }
    }

    angular
        .module('app.evenements.sortie')
        .service('SortieService', SortieService);
}
