(function (ng) {
    var mod = ng.module("especieModule");
    mod.constant("especiesContext", "api/especies");
     mod.constant('razaContext','api/razas');
    mod.controller('especieeditCtrl', ['$scope', '$http', 'especiesContext', '$state', '$rootScope', '$filter','razaContext',

      function ($scope, $http, especiesContext, $state, $rootScope, $filter,razaContext) {
            $rootScope.edit = true;
            $scope.data = {};

            $scope.selectedItems = [];

            $scope.availableItems = [];


            var idEspecie = $state.params.especieId;
       
            
            //Consulto el autor a editar.
            $http.get(especiesContext + '/' + idEspecie).then(function (response) {
                var especie = response.data;
                    $scope.nombreEspecie = especie.nombre;
                    $scope.id=especie.id;
                    $scope.ClasificacionEspecie = especie.clasificacion; 
                
               
                    $scope.CaracteristicasEspecie = especie.caracteristicas;
          
                     $scope.ImagenEspecie = especie.imagen;
                     $scope.razas=especie.razas;
                     
                     $scope.getRazas(especie.razas);
                     $scope.getMascotas(especie.mascotas);
                
            });
     
            
              $scope.getRazas = function (razas) {

                $http.get(razaContext).then(function (response) {

                    $scope.allRazas = response.data;
                    $scope.razasEspecie = razas;

                    var filteredRazas = $scope.allRazas.filter(function (raza) {
                        return $scope.razasEspecie.filter(function (razaEspecie) {
                            return razaEspecie.id === raza.id;
                        }).length === 0;
                    });

                    var unFilteredRazas = $scope.allRazas.filter(function (raza) {
                        return $scope.razasEspecie.filter(function (razaEspecie) {
                            return razaEspecie.id === raza.id;
                        }).length !== 0;
                    });

                    if ($scope.razasEspecie.length === 0) {

                        $scope.availableItems = $scope.allRazas;

                    } else {

                        $scope.selectedItems = unFilteredRazas;
                        $scope.availableItems = filteredRazas;
                    }
                });
            };
            
            
            
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