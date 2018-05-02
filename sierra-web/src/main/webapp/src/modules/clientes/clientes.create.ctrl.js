(function (ng) {
    var mod = ng.module("clienteModule");
    mod.constant("clienteContext", "api/clientes");
    mod.controller('clienteNewCtrl', ['$scope', '$http', 'clienteContext', '$state', '$rootScope',
        
        function ($scope, $http, clienteContext, $state, $rootScope) {
            $rootScope.edit = true;

            $scope.data = {};

            $scope.createCliente = function () {
                $http.post(clienteContext, $scope.data).then(function (response) {
                    $state.go('clientes', {clienteId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);


