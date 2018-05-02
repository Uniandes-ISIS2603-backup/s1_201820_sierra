(function (ng) {
    var mod = ng.module("certificadoModule");
    mod.constant("certificadoContext", "api/certificados");
    mod.controller('certificadocreateCtrl', ['$scope', '$http', 'certificadoContext', '$state', '$rootScope',
        
        function ($scope, $http, certificadoContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            $scope.createCertificado = function () {
                $http.post(certificadoContext, $scope.data).then(function (response) {
                    $state.go('certificadosList', {certificadoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);