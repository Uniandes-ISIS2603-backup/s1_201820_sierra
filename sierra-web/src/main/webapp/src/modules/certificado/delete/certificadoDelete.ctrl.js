(function (ng) {
    var mod = ng.module("certificadoModule");
    mod.constant("certificadosContext", "api/certificados");
    mod.controller('certificadoDeleteCtrl', ['$scope', '$http', 'certificadosContext', '$state',

        function ($scope, $http, certificadosContext, $state) {
           
           
            var idCertificado = $state.params.certificadoId;
            
                 $http.get(certificadosContext).then(function (response) { 
                 $scope.certificadoRecords = response.data;
                 $scope.currentCertificado = $filter('filter')($scope.certificadoRecords, {id: $state.params.certificadoId}, true)[0];  
                });
                
             
            $scope.deleteCertificado = function () {
                $http.delete(certificadosContext + '/' + idCertificado, {}).then(function (response) {
                    $state.go('certificadosList', {idCertificado: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
