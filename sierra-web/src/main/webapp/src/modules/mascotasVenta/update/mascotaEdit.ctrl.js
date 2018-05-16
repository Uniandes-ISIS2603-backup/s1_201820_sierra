(function (ng) {
    var mod = ng.module("mascotaVentaModule");
    mod.constant("mascotaVentaContext", "api/mascotasVenta");
    mod.controller('mascotaVentaEditCtrl', ['$scope', '$http', 'mascotaVentaContext', '$state', '$rootScope', '$filter',

      function ($scope, $http, mascotaVentaContext, $state, $rootScope, $filter) {
            $rootScope.edit = true;
            
             $http.get(mascotaVentaContext).then(function (response) { 
                    $scope.mascotasRecords = response.data;
                    $scope.currentMascota = $filter('filter')($scope.mascotasRecords, {id: $state.params.mascotaId}, true)[0];
                 
                });


            var idMascota = $state.params.mascotaId;
       
            
            //Consulto el autor a editar.
            $http.get(mascotaVentaContext + '/' + idMascota).then(function (response) {
                var mascota = response.data;
             
                    $scope.nombreMascota = mascota.nombre;
                     $scope.edadMascota = mascota.edad;
                    $scope.colorMascota = mascota.color; 
                     $scope.tamanoMascota = mascota.tamano;
                     $scope.imagenMascota = mascota.imagen;
                      $scope.adquiridoMascota = mascota.adquirido;
                      $scope.esterilMascota = mascota.esteril;
               
                    
                
            });
     
              $scope.createMascota = function () {   
                $http.put(mascotaVentaContext + "/" + idMascota, {
                    nombre: $scope.nombreMascota,
                    imagen: $scope.imagenMascota,
                    tamano:  $scope.tamanoMascota,
                    color: $scope.colorMascota ,
                    edad:    $scope.edadMascota ,
                    esteril: $scope.esterilMascota,
                    adquirido: $scope.adquiridoMascota 
                    
                }).then(function (response) {
                    $state.go('mascotasVentaList', {idMascota: response.data.id}, {reload: true});
                });
            };
   
        }]);
}
)(window.angular);