/* global toastr:false, moment:false */
declare var moment: any;

namespace app.core {
    'use strict';

    angular
        .module('app.core')
        .constant('toastr', toastr)
        .constant('moment', moment);
}
