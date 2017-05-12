namespace app.evenements {
    'use strict';

    angular
        .module('app.evenements')
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
                state: 'home.evenements',
                config: {
                    url: 'sorties',
                    abstract: true,
                    templateUrl: 'app/evenements/evenements.html',
                    controller: 'EvenementsController',
                    controllerAs: 'vm',
                    settings: {},
                    resolve: {
                    }
                }
            }
        ];
    }
}
