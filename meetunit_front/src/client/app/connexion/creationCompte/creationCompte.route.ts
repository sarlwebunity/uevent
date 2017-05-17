namespace app.connexion.creationCompte {
    'use strict';

    angular
        .module('app.connexion.creationCompte')
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
                state: 'home.connexion.creationCompte',
                config: {
                    url: 'inscription',
                    abstract: false,
                    templateUrl: 'app/connexion/creationCompte/creationCompte.html',
                    controller: 'NewCompteController',
                    controllerAs: 'vm',
                    settings: {},
                    resolve: {
                    }
                }
            }
        ];
    }
}
