(function (ng) {
    var mod = ng.module("especieModule");
    mod.constant("especiesContext", "api/especies");
    mod.constant("especiesContext", "api/especies");
    mod.controller('especieeditCtrl', ['$scope', '$http', 'especiesContext', '$state', '$rootScope', '$filter',

      function ($scope, $http, especiesContext, $state, $rootScope, $filter) {
            $rootScope.edit = true;
            
             $http.get(especiesContext).then(function (response) { 
                    $scope.especieRecords = response.data;
                    $scope.currentEspecie = $filter('filter')($scope.especieRecords, {id: $state.params.especieId}, true)[0];
                 
                });


            var idEspecie = $state.params.especieId;
       
            
            //Consulto el autor a editar.
            $http.get(especiesContext + '/' + idEspecie).then(function (response) {
                var especie = response.data;
             
                    $scope.nombreEspecie = especie.nombre;
                   
                    $scope.ClasificacionEspecie = especie.clasificacion; 
                
               
                    $scope.CaracteristicasEspecie = especie.caracteristicas;
          
                     $scope.ImagenEspecie = especie.imagen;
                
            });
     
              $scope.createEspecie = function () {   
                $http.put(especiesContext + "/" + idEspecie, {
                    nombre: $scope.nombreEspecie,
                    clasificacion: $scope.ClasificacionEspecie,
                    caracteristicas: $scope.CaracteristicasEspecie,
                    imagen: $scope.ImagenEspecie
                }).then(function (response) {
                    $state.go('especiessList', {idEspecie: response.data.id}, {reload: true});
                });
            };
   
        }]);
}
)(window.angular);