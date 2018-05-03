(function (ng) {
    var mod = ng.module("mediosDePagoModule");
    mod.constant("mediosDePagoContext", "api/mediosDePago");
    mod.controller('mediosDePagoNewCtrl', ['$scope', '$http', 'mediosDePagoContext', '$state', '$rootScope',
        
        function ($scope, $http,mediosDePagoContext, $state, $rootScope) {
            $rootScope.edit = true;

            $scope.createMediosDePago= function () {
                $http.post(mediosDePagoContext, $scope.data).then(function (response) {
                    $state.go('mediosDePagoList', {mediosDePagoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);


