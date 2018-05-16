(function (ng) {
    var mod = ng.module("loginModule");
    mod.controller('logoutCtrl', ['$rootScope', '$state',
        function ($rootScope, $state) {
            if (sessionStorage.getItem("user")) {
                sessionStorage.clear();
            } else {
                $state.go('especiesList', {}, {reload: true});
            }
        }
    ]);
}
)(window.angular);