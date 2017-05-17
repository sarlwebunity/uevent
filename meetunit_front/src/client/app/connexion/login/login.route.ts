namespace app.users {
    'use strict';

    angular
        .module('app.users')
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
                state: 'home.users',
                config: {
                    url: 'users',
                    abstract: true,
                    templateUrl: 'app/users/users.html',
                    controller: 'UsersController',
                    controllerAs: 'vm',
                    settings: {},
                    resolve: {
                    }
                }
            }
        ];
    }
}
