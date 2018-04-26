(function (ng) {
    var mod = ng.module("mascotaadopModule");
    mod.constant("mascotaaContext", "api/mascotasAdoptadas");
    mod.controller('mascotaeditCtrl', ['$scope', '$http', 'mascotaaContext', '$state', '$rootScope', '$filter',

      function ($scope, $http, mascotaaContext, $state, $rootScope, $filter) {
            $rootScope.edit = true;
            
             $http.get(mascotaaContext).then(function (response) { 
                    $scope.mascotasRecords = response.data;
                    $scope.currentMascota = $filter('filter')($scope.mascotasRecords, {id: $state.params.mascotaId}, true)[0];
                 
                });


            var idMascota = $state.params.mascotaId;
       
            
            //Consulto el autor a editar.
            $http.get(mascotaaContext + '/' + idMascota).then(function (response) {
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
                $http.put(mascotaaContext + "/" + idMascota, {
                    nombre: $scope.nombreMascota,
                    imagen: $scope.imagenMascota,
                    tamano:  $scope.tamanoMascota,
                    color: $scope.colorMascota ,
                    edad:    $scope.edadMascota ,
                    esteril: $scope.esterilMascota,
                    adquirido: $scope.adquiridoMascota 
                    
                }).then(function (response) {
                    $state.go('mascotasList', {idMascota: response.data.id}, {reload: true});
                });
            };
   
        }]);
}
)(window.angular);