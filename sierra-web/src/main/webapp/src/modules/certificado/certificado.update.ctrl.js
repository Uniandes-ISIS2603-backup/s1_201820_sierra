(
        function (ng) {
            var mod = ng.module("certificadoModule");
            mod.constant("certificadoContext", "api/certificados");
            mod.controller('certificadoUpdateCtrl', ['$scope', '$http', 'certificadoContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, certificadoContext, $state, $rootScope, $filter) {
                    $rootScope.edit = true;
                    var idCertificado = $state.params.certificadoId;
                    
                    $http.get("http://localhost:8080/sierra-web/api/certificados" + '/' + idCertificado, ).then(function (response) {
                            var certificado = response.data;
                            $scope.certificadoId = certificado.id;
                            $scope.certificadoFecha = certificado.fecha;
                            $scope.certificadoDescripcion = certificado.descripcion;
                            $scope.certificadoImagen = certificado.imagen;
                    });
                    
                    
                    $scope.createMensaje = function () {
                      try{
                            
                        
                        
                        
                        $http.put("http://localhost:8080/sierra-web/api/certificados" + '/' + idCertificado, {
                            Fecha: $scope.certificadoFecha,
                            Descrpcion: $scope.certificadoDescripcion,
                            Imagen: $scope.certificadoImagen,
                        }).then(function (response) {
                            $state.go('certificadoList', {certificadoId: response.data.id}, {reload: true});
                        });
                        
                       
                       
                        
                        }
                        catch(Error){
                        $state.go('certificadoList', {certificadoId: null}, {reload: true});
                        }   
                    };
                }
            ]);
        }
)(window.angular);