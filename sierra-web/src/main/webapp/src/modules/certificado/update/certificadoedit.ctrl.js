(function (ng) {
    var mod = ng.module("certificadoModule");
    mod.constant("certificadosContext", "api/certificados");
    mod.controller('certificadoeditCtrl', ['$scope', '$http', 'certificadosContext', '$state', '$rootScope', '$filter',

      function ($scope, $http, certificadosContext, $state, $rootScope, $filter) {
            $rootScope.edit = true;
            
             $http.get(certificadosContext).then(function (response) { 
                    $scope.certificadoRecords = response.data;
                    $scope.currentCertificado = $filter('filter')($scope.certificadoRecords, {id: $state.params.certificadoId}, true)[0];
                 
                });


            var idCertificado = $state.params.certificadoId;
       
            
            //Consulto el certificado a editar.
            $http.get(certificadosContext + '/' + idCertificado).then(function (response) {
                var certificado = response.data;
             
                    $scope.fechaCertificado = certificado.fecha;
                   
                    $scope.DescripcionCertificado = certificado.descripcion; 
                
              
                     $scope.ImagenCertificado = certificado.imagen;
                     
                     
                
            });
     
              $scope.createCertificado = function () {   
                $http.put(certificadosContext + "/" + idCertificado, {
                    fecha: $scope.fechaCertificado,
                    descripcion: $scope.DescripcionCertificado,
                    imagen: $scope.ImagenCertificado,
                   
                }).then(function (response) {
                    $state.go('certificadosList', {idCertificado: response.data.id}, {reload: true});
                });
            };
   
        }]);
}
)(window.angular);