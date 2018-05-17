(function (ng)
{
    var mod = ng.module("facturaModule");
    mod.constant("facturaContext", "api/facturas");
    mod.controller('facturaDeleteCtrl', ['$scope', '$http', 'facturaContext', '$state', 
        function ($scope, $http, facturaContext, $state) {
            
            var facturaId = $state.params.facturaId;
            $scope.deleteFactura = function ()
            {
                $http.delete(facturaContext + "/" + facturaId).then(function (response) {
                    $state.go('facturasList', {facturaId: response.data.id},{reload: true});
                });
            };
        }

    ]);
}
)(window.angular);


