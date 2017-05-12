namespace app.evenements {
    'use strict';
    import IPromise = angular.IPromise;

    export class Logo {

        id:number;
        logo:string;

        /* @ngInject */
        constructor(id:number, logo:string) {
            this.id=id;
            this.logo=logo;
        }

    }
}
