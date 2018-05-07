(function (ng) {
    var mod = ng.module("clienteModule");
    mod.constant("clienteContext", "api/clientes");
    mod.controller('clienteUpdateCtrl', ['$scope', '$http', 'clienteContext', '$state', '$rootScope',
        
        function ($scope, $http, clienteContext, $state, $rootScope) {
            $rootScope.edit = true;

            $scope.data = {};

            $scope.selectedItems = [];

            $scope.availableItems = [];

            var clienteId = $state.params.clienteId;

            $http.get(clienteContext + '/' + clienteId).then(function (response) {
                var cliente = response.data;
                $scope.data.nombre = cliente.nombre;
                $scope.data.apellido = cliente.apellido;
                $scope.data.cedula = cliente.cedula;
                $scope.data.telefono = cliente.telefono;
                $scope.data.correo = cliente.correo;
                $scope.data.contrasenia = cliente.contrasenia;
            });
                 
            $scope.createCliente = function () {
                $http.put(clienteContext + "/" + clienteId, $scope.data).then(function (response) {
                    
                    $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);


