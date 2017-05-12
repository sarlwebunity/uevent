namespace app.widgets.topbar {

    export class TopBar implements ng.IComponentOptions {

        public bindings:{ [binding:string]:string} = {
            active: '@',
        };
        public controller:Function = TopBarCtrl;
        public controllerAs:string = 'vm';
        public templateUrl:string = 'app/widgets/top-bar/top.bar.html';
    }

    angular
        .module('app.widgets.topbar')
        .component('topBar', new TopBar());
}
