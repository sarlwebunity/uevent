namespace app.evenements.createSortie {
    'use strict';

    angular
        .module('app.evenements.createSortie')
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
                state: 'home.evenements.createSortie',
                config: {
                    url: 'Create',
                    abstract: false,
                    templateUrl: 'app/evenements/createSortie/createSortie.html',
                    controller: 'CreateSortieController',
                    controllerAs: 'vm',
                    settings: {},
                    resolve: {
                    }
                }
            }
        ];
    }
}
