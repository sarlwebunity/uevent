namespace app.layout {
    'use strict';
    import IPromise = angular.IPromise;

    export class ShellController {

        /* @ngInject */
        constructor() {
        }
        /*static $inject:Array<string> = ['userConnected', 'SpinnerService'];

        constructor(userConnected:blocks.auth.User, private SpinnerService:ISpinnerService) {
            this.user = userConnected;
            this.onInit();
        }

        user:blocks.auth.User;
        param:{spinner:IPromise<any>} = {spinner: undefined};

        private onInit = () => {
            this.SpinnerService.subscribeToPromiseUpdates(this);
        };

        public onPromiseUpdated = (promise:IPromise<any>) => {
            this.param.spinner = promise;
        };*/
    }

    angular
        .module('app.layout')
        .controller('ShellController', ShellController);
}
