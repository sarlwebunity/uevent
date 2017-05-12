namespace app.users.profile {
    'use strict';

    angular
        .module('app.users.profile')
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
                state: 'home.users.profile',
                config: {
                    url: '/:id',
                    abstract: false,
                    templateUrl: 'app/users/profile/profile.html',
                    controller: 'ProfileController',
                    controllerAs: 'vm',
                    settings: {},
                    resolve: {
                    }
                }
            }
        ];
    }
}
