namespace blocks.param {
    'use strict';

    export interface IParam {
        urlDisconnect: string;
        urlChangePassword: string;
        urlHome: string;
    }

    export interface IParamService {
        getParam:() => ng.IPromise<IParam>;
    }

    export class ParamService implements IParamService {

        /* @ngInject */
        constructor(private $resource:any, private $cacheFactory:any) {

        }

        private cache:any = this.$cacheFactory.get('$http');
        private API_PARAM:string = 'api/public/params';

        private invalidateCache:(api?:string) => void = (api?) => {
            let apiSuffix = api ? api : '';
            this.cache.remove(this.API_PARAM + apiSuffix);
        };

        private _getParam:(force:boolean, api?:string) => ng.IPromise<any> = (force, api?) => {
            if (force) {
                this.invalidateCache(api);
            }
            let apiSuffix = api ? api : '';
            return this.$resource(this.API_PARAM + apiSuffix,
                {},
                {
                    get: {
                        method: 'GET',
                        isArray: false,
                        cache: true
                    }
                }).get().$promise;
        };

        public getParam:() => ng.IPromise<IParam> = () => this._getParam(false);
    }

    angular
        .module('blocks.param')
        .service('ParamService', ParamService);
}
