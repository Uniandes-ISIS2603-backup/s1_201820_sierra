(function (ng) {
    var mod = ng.module("mediosDePagoModule");
    mod.constant("mediosDePagoContext", "api/mediosDePago");
    mod.controller('mediosDePagoDetailCtrl', ['$scope', '$http', 'mediosDePagoContext', '$state',
        
        function ($scope, $http, mediosDePagoContext, $state) {
            if (($state.params.mediosDePagoId !== undefined) && ($state.params.mediosDePagoId !== null)) {
                
                $http.get(mediosDePagoContext + '/' + $state.params.mediosDePagoId).then(function (response) {
                    
                    $scope.currentMediosDePago = response.data;
                });
            }
        }
    ]);
}
)(window.angular);


