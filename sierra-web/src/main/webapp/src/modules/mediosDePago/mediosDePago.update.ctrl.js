(function (ng) {
    var mod = ng.module("mediosDePagoModule");
    mod.constant("mediosDePagoContext", "api/mediosDePago");
    mod.controller('mediosDePagoUpdateCtrl', ['$scope', '$http', 'mediosDePagoContext', '$state', '$rootScope',
        
        function ($scope, $http, mediosDePagoContext, $state, $rootScope) {
            $rootScope.edit = true;

            $scope.data = {};

            $scope.selectedItems = [];

            $scope.availableItems = [];

            var mediosDePagoId = $state.params.mediosDePagoId;

            $http.get(mediosDePagoContext + '/' + mediosDePagoId).then(function (response) {
                var medio = response.data;
                $scope.data.tipo = medio.tipo;
                $scope.data.numeroReferencia = medio.numeroReferencia;
            });
                 
            $scope.createMediosDePago = function () {
                $http.put(mediosDePagoContext + "/" + mediosDePagoId, $scope.data).then(function (response) {
                    
                    $state.go('mediosDePagoList', {mediosDePagoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

