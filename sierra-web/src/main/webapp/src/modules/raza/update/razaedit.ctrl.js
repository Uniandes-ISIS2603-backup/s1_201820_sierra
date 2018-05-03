(function (ng) {
    var mod = ng.module("razaModule");
    mod.constant("razasContext", "api/razas");
    mod.controller('razaeditCtrl', ['$scope', '$http', 'razasContext', '$state', '$rootScope', '$filter',

      function ($scope, $http, razasContext, $state, $rootScope, $filter) {
            $rootScope.edit = true;
            
             $http.get(razasContext).then(function (response) { 
                    $scope.razaRecords = response.data;
                    $scope.currentRaza = $filter('filter')($scope.razaRecords, {id: $state.params.razaId}, true)[0];
                 
                });


            var idRaza = $state.params.razaId;
       
            
            //Consulto la raza a editar.
            $http.get(razasContext + '/' + idRaza).then(function (response) {
                var raza = response.data;
             
                    $scope.nombreRaza = raza.nombre;
                   
                    $scope.CuidadosRaza = raza.cuidados; 
                
              
                     $scope.DestacableRaza = raza.destacable;
                     
                      $scope.CaracteristicasRaza= raza.caracteristicas;
          
                
            });
     
              $scope.createRaza = function () {   
                $http.put(razasContext + "/" + idRaza, {
                    nombre: $scope.nombreRaza,
                    cuidados: $scope.CuidadosRaza,
                    descatacable: $scope.DestacableRaza,
                    caracteristicas: $scope.CaracteristicasRaza
                }).then(function (response) {
                    $state.go('razasList', {idRaza: response.data.id}, {reload: true});
                });
            };
   
        }]);
}
)(window.angular);