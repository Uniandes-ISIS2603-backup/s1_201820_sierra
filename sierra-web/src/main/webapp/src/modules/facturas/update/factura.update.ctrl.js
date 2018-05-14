(function (ng) {
    var mod = ng.module("facturaModule");
    mod.constant("facturaContext", "api/facturas");
    mod.controller('facturaUpdateCtrl', ['$scope', '$http', 'facturaContext', '$state', '$rootScope',  
        function ($scope, $http ,facturaContext ,$state ,$rootScope) {
            $rootScope.edit = true;
            $scope.data = {};
            $scope.selectedItems = [];
            $scope.availableItems = [];
            var facturaId = $state.params.facturaId;
            $http.get(facturaContext + '/' + facturaId).then(function (response) {
                var auxiliar = response.data;
                $scope.data.idCliente = auxiliar.idCliente;
                $scope.data.nombreCliente = auxiliar.nombreCliente;
                $scope.data.valor = auxiliar.valor;
            });
            $scope.updateFactura = function () {
                $http.put(facturaContext + "/" + facturaId, $scope.data).then(function (response) {
    
                    $state.go('facturasList', {facturaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);


