(function (ng) {
    var mod = ng.module("clienteModule");
     mod.constant("clienteContext", "api/clientes");
    mod.controller('clienteCtrl', ['$scope', '$http', 'clienteContext', '$state',
        function ($scope, $http, clienteContext, $state) {
            
           $http.get(clienteContext).then(function(response){
               $scope.clienteRecords = response.data;
           
        });
        }]);
}
)(window.angular);


