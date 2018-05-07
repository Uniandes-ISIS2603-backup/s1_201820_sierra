(function(ng)
{
    var modulo = ng.module("acontecimientoModule");
    modulo.constant("acontecimientoContext", "api/acontecimientos");
    modulo.controller('acontecimientoCtrl', ['$scope', '$http', 'acontecimientoContext',
                      function($scope, $http, acontecimientoContext)
                      {
                     $http.get(acontecimientoContext).then(function (response) {
                       $scope.acontecimientos = response.data;
            });
} 
]);
}
)(window.angular);

