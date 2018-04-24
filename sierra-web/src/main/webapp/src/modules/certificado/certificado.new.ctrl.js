(function (ng) {
    var mod = ng.module("certificadoModule");
    mod.constant("certificadoContext", "api/certificados");
    mod.controller('certificadoNewCtrl', ['$scope', '$http', 'certificadoContext', '$state', '$rootScope',
        function ($scope, $http, certificadoContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createCertificado = function () {
                try
                {
               
             
                $http.post("http://localhost:8080/sierra-web/api/certificados", {
                    Fecha: $scope.certificadoFecha,
                    Descrpcion: $scope.certificadoDescripcion,
                    Imagen: $scope.certificadoImagen,
                    
                }).then(function (response) {
                    $state.go('certificadoList', {certificadoId: response.data.id}, {reload: true});
                });
                
                
                }
                catch(Error)
                {
                    $state.go('certificadoList', {certificadoId: null}, {reload: true});
                }
            };
        }
    ]);
}
)(window.angular);