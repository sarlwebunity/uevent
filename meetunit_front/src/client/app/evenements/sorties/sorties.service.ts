namespace app.evenements.sorties {
    'use strict';
    import IPromise = angular.IPromise;
    import Sortie = app.evenements.Sortie;

    // Interface du controller
    export interface ISortiesService {

        getSorties();
    }

    export class SortiesService implements ISortiesService{

        sorties: Array<Sortie> = [];

        /* @ngInject */
        constructor(private $resource: any) {
        }

        getSorties() {
            let self = this;
            return this.$resource('api/sortie').query().$promise.then(function (sorts) {
                self.initSorties(sorts);
                self.sorties = sorts;
                return sorts;
            });
        }

        initSorties(sorties: Array<Sortie>){
            //On parcours chaque sortie
            var listeSorties = [];
            return sorties.forEach(initDate());

            function initDate() {
                return function (sort) {
                    sort.date = moment(sort.dateDebut);
                }
            }
        }

    }
    angular
        .module('app.evenements.sorties')
        .service('SortiesService', SortiesService);
}
