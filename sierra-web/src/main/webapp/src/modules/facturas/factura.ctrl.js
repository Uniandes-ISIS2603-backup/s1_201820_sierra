(function(ng)
{
    var modulo = ng.module("facturaModule");
    modulo.constant("facturaContext", "api/facturas");
    modulo.controller('facturaCtrl', ['$scope', '$http', 'facturaContext',
                      function($scope, $http, acontecimientoContext)
                      {
                     $http.get(acontecimientoContext).then(function (response) {
                       $scope.facturas = response.data;
            });
} 
]);
}
)(window.angular);

