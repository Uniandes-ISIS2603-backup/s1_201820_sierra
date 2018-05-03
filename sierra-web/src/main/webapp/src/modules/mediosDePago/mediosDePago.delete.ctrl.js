(function (ng){
    var mod = ng.module('mediosDePagoModule');
    mod.constant("mediosDePagoContext", "api/mediosDePago");
    mod.controller('deleteMediosDePagoCtrl', ['$scope','$http','mediosDePagoContext','$state',
         function ($scope, $http, mediosDePagoContext, $state){
             var mediosDePagoId = $state.params.mediosDePagoId;
             $scope.deleteMediosDePago = function(){
                 $http.delete(mediosDePagoContext+'/'+$state.params.mediosDePagoId).then(function(response){
                      $state.go('mediosDePagoList', {mediosDePagoId: response.data.id}, {reload: true});
                 });
             };
         }
    ]);
    
}
)(window.angular);