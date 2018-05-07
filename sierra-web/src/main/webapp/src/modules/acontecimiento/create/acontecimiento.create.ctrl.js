(function (ng) {
    var mod = ng.module("acontecimientoModule");
    mod.constant("acontecimientoContext", "api/acontecimiento");
    mod.controller('acontecimientoCreateCtrl', ['$scope', '$http', 'acontecimientoContext', '$state', '$rootScope',
        
        function ($scope, $http, acontecimientoContext, $state, $rootScope) {
            $rootScope.edit = true;
            $scope.data = {};
            $scope.createAcontecimiento = function () {
                $http.post(acontecimientoContext, $scope.data).then(function (response) {
                    $state.go('acontecimientoList', {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

