namespace app.core {
    // ((): void => {
    // })();
    // What: Creates an IIFE
    // When: Use when you have no TypeScript components to export
    // Less function wrapping
    'use strict';

    angular
        .module('app.core')
        .run(appRun);

    angular
        .module('app.core')
        .config(configureStates);

    appRun.$inject = ['RouterHelper'];
    function appRun(RouterHelper:blocks.router.IRouterHelper) {
    }

    configureStates.$inject = ['$stateProvider', '$locationProvider', '$urlRouterProvider'];
    /* @ngInject */
    function configureStates($stateProvider:ng.ui.IStateProvider,
                             $locationProvider:ng.ILocationProvider,
                             $urlRouterProvider:ng.ui.IUrlRouterProvider) {
        var otherwise = '/404';
        var states = getStates();
        states.forEach(function (state) {
            $stateProvider.state(state.state, state.config);
        });
        $locationProvider.html5Mode(false);
        $urlRouterProvider.otherwise(otherwise);
    }

    function getStates() {
        return [
            {
                state: 'error',
                config: {
                    url: '/error',
                    templateUrl: 'app/core/error.html',
                    title: 'Erreur'
                }
            },
            {
                state: '404',
                config: {
                    url: '/404',
                    templateUrl: 'app/core/404.html',
                    title: '404'
                }
            }

        ];
    }
}
