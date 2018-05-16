(function (ng) {
    var mod = ng.module("mascotaVentaModule");
    mod.constant("mascotaVentaContext", "api/mascotasVenta");
    mod.controller('mascotaVentaDeleteCtrl', ['$scope', '$http', 'mascotaVentaContext', '$state',

        function ($scope, $http, mascotaVentaContext, $state) {
           
           
            var idMascota = $state.params.mascotaId;
            
                 $http.get(mascotaVentaContext).then(function (response) { 
                 $scope.mascotasRecords = response.data;
                 $scope.currentMascota = $filter('filter')($scope.mascotasRecords, {id: $state.params.mascotaId}, true)[0];  
                });
                
             
            $scope.deleteMascota = function () {
                $http.delete(mascotaVentaContext + '/' + idMascota, {}).then(function (response) {
                    $state.go('mascotasVentaList', {idMascota: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
