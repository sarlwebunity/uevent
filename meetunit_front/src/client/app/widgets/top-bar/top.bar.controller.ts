namespace app.widgets.topbar {

    export interface ITopBarCtrl {

    }

    export class TopBarCtrl implements ITopBarCtrl {

        /* @ngInject */
        constructor() {
        }
    }

    angular
        .module('app.widgets.topbar')
        .controller('TopBarCtrl', TopBarCtrl);
}
