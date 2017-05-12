namespace app.evenements.sortie {
    'use strict';

    angular
        .module('app.evenements.sortie')
        .config(configureStates);

    //configureStates.$inject = ['$stateProvider'];
    /* @ngInject */
    function configureStates($stateProvider:ng.ui.IStateProvider) {
        var states = getStates();
        states.forEach(function (state) {
            $stateProvider.state(state.state, state.config);
        });
    }

    function getStates() {
        return [
            {
                state: 'home.evenements.sortie',
                config: {
                    url: '/:id',
                    abstract: false,
                    templateUrl: 'app/evenements/sortie/sortie.html',
                    controller: 'SortieController',
                    controllerAs: 'vm',
                    settings: {},
                    resolve: {
                    }
                }
            }
        ];
    }
}
