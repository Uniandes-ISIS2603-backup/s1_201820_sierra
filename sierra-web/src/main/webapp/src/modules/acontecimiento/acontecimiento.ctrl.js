(function(ng)
{
    var modulo = ng.module("acontecimientoModule");
    modulo.constant("acontecimientoContext", "api/acontecimientos");
    modulo.controller('acontecimientoCtrl', ['$scope', '$http', 'sportContext',
                      function($scope, $http, acontecimientoContext)
                      {
                       $scope.acontecimientos = {};
                       $http.get('data/acontecimientos.json').then(function (response) 
                                                                   {
                                                                    $scope.acontecimientos = response.data;   
                                                                   }
                                                                   );
} 
]);
}
)

