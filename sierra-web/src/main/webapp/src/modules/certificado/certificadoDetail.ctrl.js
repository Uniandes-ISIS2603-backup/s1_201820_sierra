(function (ng) {
    var mod = ng.module("certificadoModule");
    mod.constant("certificadoContext", "api/razas");
    mod.controller('certificadoDetailCtrl', ['$scope', '$http', 'certificadoContext', '$state', '$filter',
        function ($scope, $http, certificadoContext, $state, $filter) {
            if (($state.params.certificadoId !== undefined) && ($state.params.certificadoId !== null)) {
                $http.get(certificadoContext).then(function (response) { 
                    $scope.certificadoRecords = response.data;
                    $scope.currentCertificado = $filter('filter')($scope.certicadoRecords, {id: $state.params.certificadoId}, true)[0];
                 
                });
            }
            
        }               
    ]);
}
)(window.angular);