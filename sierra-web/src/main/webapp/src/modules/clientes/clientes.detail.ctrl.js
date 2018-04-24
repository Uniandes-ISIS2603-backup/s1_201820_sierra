(function (ng) {
    var mod = ng.module("clienteModule");
    mod.constant("clienteContext", "api/clientes");
    mod.controller('clienteDetailCtrl', ['$scope', '$http', 'clienteContext', '$state',
        
        function ($scope, $http, clienteContext, $state) {
            
            
                $http.get(clienteContext + '/' + $state.params.clienteId).then(function (response) {
                    
                    $scope.clienteCurrent = response.data;
                });
            
        }
    ]);
}
)(window.angular);


