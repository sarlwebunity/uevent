namespace app.widgets.formprogressbar {

    interface IFormProgressBarCtrl {
        crumbs:Array<FormProgressBarCrumb>;
        currentIndexCrumb:number; //index of the current crumb
    }

    export interface FormProgressBarCrumb {
        title:string;
    }

    export class FormProgressBarCtrl implements IFormProgressBarCtrl {
        currentIndexCrumb:number;
        crumbs:Array<FormProgressBarCrumb>;

        /* @ngInject */
        constructor() {
        }
    }

    angular
        .module('app.widgets.formprogressbar')
        .controller('FormProgressBarCtrl', FormProgressBarCtrl);
}
