namespace app.connexion {
    'use strict';

    angular
        .module('app.connexion')
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
                state: 'home.connexion',
                config: {
                    url: 'connexion',
                    abstract: true,
                    templateUrl: 'app/connexion/connexion.html',
                    controller: 'ConnexionController',
                    controllerAs: 'vm',
                    settings: {},
                    resolve: {
                    }
                }
            }
        ];
    }
}
