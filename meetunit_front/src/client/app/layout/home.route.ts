namespace app.layout {
    'use strict';

    angular
        .module('app.layout')
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
                state: 'home',
                config: {
                    url: '/',
                    abstract: true,
                    templateUrl: 'app/layout/shell.html',
                    controller: 'ShellController',
                    controllerAs: 'vm',
                    settings: {},
                    resolve: {
                        /*userConnected: getUser,
                        param: param*/
                    }
                }
            }
        ];
    }

    /* @ngInject */
    function getUser(AuthService:blocks.auth.IAuthService, $log:ng.ILogService, $q:ng.IQService) {
        var deferred = $q.defer();
        AuthService.getUser(false).then((user) => {
            if (!user) {
                deferred.reject({data: 'pas de user'});
            } else {
                deferred.resolve(user);
            }
        }).catch(function (e) {
            deferred.reject(e);
        });
        return deferred.promise;
    }

    /* @ngInject */
    function param(ParamService:blocks.param.IParamService) {
        return ParamService.getParam();
    }
}
