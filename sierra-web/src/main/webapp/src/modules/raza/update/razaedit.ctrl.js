(function (ng) {
    var mod = ng.module("razaModule");
    mod.constant("razasContext", "api/razas");
    mod.constant('especieContext','api/especies');
    mod.controller('razaeditCtrl', ['$scope', '$http', 'razasContext','$state', '$rootScope', '$filter','especieContext',

      function ($scope, $http, razasContext, $state, $rootScope, $filter, especieContext) {
            $rootScope.edit = true;
           
             $http.get(razasContext).then(function (response) { 
                    $scope.razaRecords = response.data;
                    $scope.currentRaza = $filter('filter')($scope.razaRecords, {id: $state.params.razaId}, true)[0];
                });
                
             $http.get(especieContext).then(function (response) {
                $scope.especiesRecords = response.data;
   
            });

            var idRaza = $state.params.razaId;
       
            
            //Consulto la raza a editar.
            $http.get(razasContext + '/' + idRaza).then(function (response) {
                var raza = response.data;
             
                    $scope.nombreRaza = raza.nombreRaza;   
                    $scope.CuidadosRaza = raza.cuidados; 
                    $scope.especieR=raza.especie;
                    $scope.DestacableRaza = raza.destacable;  
                    $scope.CaracteristicasRaza= raza.caracteristicas;
          
                
            });
     
              $scope.createRaza = function () {   

                $http.put(razasContext + "/" + idRaza, {
                    nombreRaza: $scope.nombreRaza,
                    cuidados: $scope.CuidadosRaza,
                    destacable: $scope.DestacableRaza,
                    especie:  $scope.especieR,
                    caracteristicas: $scope.CaracteristicasRaza
                }).then(function (response) {
                    $state.go('razasList', {idRaza: response.data.id}, {reload: true});
                });
            };
   
        }]);
}
)(window.angular);