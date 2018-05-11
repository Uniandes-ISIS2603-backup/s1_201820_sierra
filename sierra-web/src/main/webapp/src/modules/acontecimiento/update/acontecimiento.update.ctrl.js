(function (ng) {
    var mod = ng.module("acontecimientoModule");
    mod.constant("acontecimientoContext", "api/acontecimientos");
    mod.controller('acontecimientoUpdateCtrl', ['$scope', '$http', 'acontecimientoContext', '$state', '$rootScope',
        
        function ($scope, $http ,acontecimientoContext ,$state ,$rootScope) {
            $rootScope.edit = true;
            $scope.data = {};
            $scope.selectedItems = [];
            $scope.availableItems = [];
            var acontecimientoId = $state.params.acontecimientoId;
            $http.get(acontecimientoContext + '/' + acontecimientoId).then(function (response) {
                var auxiliar = response.data;
                $scope.data.nombre = auxiliar.nombre;
                $scope.data.fecha = auxiliar.fecha;
                $scope.data.tipo = auxiliar.tipo;
                $scope.data.importancia = auxiliar.importancia;
                $scope.data.descripcion = auxiliar.descripcion;
                $scope.data.fotoURL = auxiliar.fotoURL; 
            });
            $scope.updateAcontecimiento = function () {
                $http.put(acontecimientoContext + "/" + acontecimientoId, $scope.data).then(function (response) {
                    
                    $state.go('acontecimientoList', {acontecimientoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);


