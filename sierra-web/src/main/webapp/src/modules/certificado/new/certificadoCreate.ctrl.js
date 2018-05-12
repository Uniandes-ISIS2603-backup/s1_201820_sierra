(function (ng) {
    var mod = ng.module("certificadoModule");
    mod.constant("certificadosContext", "api/certificados");
    mod.controller('certificadocreateCtrl', ['$scope', '$http', 'certificadosContext', '$state', '$rootScope',
        
        function ($scope, $http, certificadosContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            $scope.createCertificado = function () {
                $http.post(certificadosContext, $scope.data).then(function (response) {
                    $state.go('certificadosList', {certificadoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);