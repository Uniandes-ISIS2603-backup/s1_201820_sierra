(function (ng) {
    var mod = ng.module("comprobanteModule");
    mod.constant("comprobanteContext", "api/comprobantes");
    mod.controller('comprobanteCreateCtrl', ['$scope', '$http', 'ComprobanteContext', '$state', '$rootScope',
        
        function ($scope, $http, acontecimientoContext, $state, $rootScope) {
            $rootScope.edit = true;
            $scope.createAcontecimiento = function () {
                $http.post(acontecimientoContext, $scope.data).then(function (response) {
                    $state.go('comprobantesList', {comprobanteId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

