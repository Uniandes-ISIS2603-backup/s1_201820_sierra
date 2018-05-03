(function (ng){
    var mod = ng.module('clienteModule');
    mod.constant("clienteContext", "api/clientes");
    mod.controller('deleteClienteCtrl', ['$scope','$http','clienteContext','$state',
         function ($scope, $http, clienteContext, $state){
             var clienteId = $state.params.clienteId;
             $scope.deleteCliente = function(){
                 $http.delete(clienteContext+'/'+clienteId).then(function(response){
                      $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
                 });
             };
         }
    ]);
    
}
)(window.angular);


