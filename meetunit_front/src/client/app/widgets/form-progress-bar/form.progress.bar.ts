namespace app.widgets.formprogressbar {

    export class FormProgressBar implements ng.IComponentOptions {

        public bindings:{ [binding:string]:string} = {
            crumbs: '<',
            currentIndexCrumb: '<'
        };
        public controller:Function = FormProgressBarCtrl;
        public controllerAs:string = 'vm';
        public templateUrl:string = 'app/widgets/form-progress-bar/top.bar.html';
    }

    angular
        .module('app.widgets.formprogressbar')
        .component('formProgressBar', new FormProgressBar());
}
