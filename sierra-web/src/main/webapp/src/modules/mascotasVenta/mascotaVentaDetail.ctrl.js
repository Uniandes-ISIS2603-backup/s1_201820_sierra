(function (ng) {
    var mod = ng.module("mascotaVentaModule");
    mod.constant("mascotaVentaContext", "api/mascotasVenta");
    mod.controller('mascotaVentaDetailCtrl', ['$scope', '$http', 'mascotaVentaContext', '$state', '$filter',
        function ($scope, $http, mascotaVentaContext, $state, $filter) {
            //console.log("mascotaVentaDetail" + $state.params);
            if (($state.params.mascotaId !== undefined) && ($state.params.mascotaId !== null)) {
                $http.get(mascotaVentaContext).then(function (response) { 
                    $scope.mascotasRecords = response.data;
                    $scope.currentMascota = $filter('filter')($scope.mascotasRecords, {id: $state.params.mascotaId}, true)[0];
                   
                });
            }
            
        }               
    ]);
}
)(window.angular);