(function (ng) {
    var mod = ng.module("mascotaVentaModule");
    mod.constant("mascotaVentaContext", "api/mascotasVenta");
    mod.controller('mascotaVentaCreateCtrl', ['$scope', '$http', 'mascotaVentaContext', '$state', '$rootScope',
        
        function ($scope, $http, mascotaVentaContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            $scope.createMascota = function () {
                $http.post(mascotaVentaContext, $scope.data).then(function (response) {
                    $state.go('mascotasVentaList', {mascotaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);