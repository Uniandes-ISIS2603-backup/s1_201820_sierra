(function (ng) {
    var mod = ng.module("certificadoModule");
    mod.constant("certificadoContext", "api/certificados");
    mod.controller('certificadoCtrl', ['$scope', '$http', 'certificadoContext', '$state',
        function ($scope, $http, certificadoContext, $state) {
            $http.get("http://localhost:8080/sierra-web/api/certificados").then(function (response) {
                $state.params.certificadoId = null;
                $scope.certificadosRecords = response.data;
            });
            
            if (($state.params.certificadoId !== undefined)&& ($state.params.certificadoId !== null)) {
                $http.get("http://localhost:8080/sierra-web/api/certificados" + '/' + $state.params.certificadoId).then(function (response) {
                    $scope.currentCertificado = response.data;
                    
                });
            }
        }
    ]);
}
)(angular);