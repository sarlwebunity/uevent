namespace app.evenements.sorties {
    'use strict';

    angular
        .module('app.evenements.sorties')
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
                state: 'home.evenements.sorties',
                config: {
                    url: '',
                    abstract: false,
                    templateUrl: 'app/evenements/sorties/sorties.html',
                    controller: 'SortiesController',
                    controllerAs: 'vm',
                    settings: {},
                    resolve: {
                    }
                }
            }
        ];
    }
}
