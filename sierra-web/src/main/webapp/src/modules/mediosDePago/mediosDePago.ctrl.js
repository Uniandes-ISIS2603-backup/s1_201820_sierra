(function (ng) {
    var mod = ng.module("mediosDePagoModule");
     mod.constant("mediosDePagoContext", "api/mediosDePago");
    mod.controller('mediosDePagoCtrl', ['$scope', '$http', 'mediosDePagoContext', '$state',
        function ($scope, $http, mediosDePagoContext, $state) {
            
           $http.get(mediosDePagoContext).then(function(response){
               $scope.mediosDePagoRecords = response.data;
           
        });
        }]);
}
)(window.angular);


