(function (ng)
{
    var mod = ng.module("facturaModule");
    mod.constant("facturaContext", "api/facturas");
    mod.controller('facturaDeleteCtrl', ['$scope', '$http', 'facturaContext', '$state', '$rootScope',
        function ($scope, $http, facturaContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.data = {};
            var facturaId = $state.params.facturaId;
            $scope.deleteFactura = function ()
            {
                $http.delete(facturaContext + "/" + facturaId).then(function (response) {
                    $state.go('facturasList', {reload: true});
                });
            };
        }

    ]);
}
)(window.angular);


