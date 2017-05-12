namespace app.evenements.sortie {
    'use strict';
    import IPromise = angular.IPromise;

    export class SortieController {

        sortie: Sortie;
        /* @ngInject */
        constructor(private SortieService: ISortieService, private $stateParams) {
            this.getSortie($stateParams.id);
        }

        getSortie(id: number){

            let self = this;

            this.SortieService.getSortie(id).then(function (sort){
                //On récupère la sortie
                self.sortie = sort;
            })
        }

    }

    angular
        .module('app.evenements.sortie')
        .controller('SortieController', SortieController);
}
