(function (ng) {
    var mod = ng.module("clienteModule");
    mod.constant("clienteContext", "api/clientes");
    mod.controller('clienteDetailCtrl', ['$scope', '$http', 'clienteContext', '$state',
        
        function ($scope, $http, clienteContext, $state) {
            if (($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)) {
                
                $http.get(clienteContext + '/' + $state.params.clienteId).then(function (response) {
                    $scope.mediosDePagoRecords = response.data.mediosDePago;
                    $scope.currentCliente = response.data;
                });
            }
        }
    ]);
}
)(window.angular);


