(function (ng){
    var mod = ng.module('acontecimientoModule');
    mod.constant("acontecimientoContext", "api/acontecimientos");
    mod.controller('acontecimientoDeleteCtrl', ['$scope','$http','acontecimientoContext','$state',
         function ($scope, $http, acontecimientoContext, $state){
             $scope.deleteAcontecimiento = function(){
                 $http.delete(acontecimientoContext+'/'+$state.params.acontecimientoId).then(function(response){
                      $state.go('acontecimientoList', {acontecimientoId: response.data.id}, {reload: true});
                 });
             };
         }
    ]);
    
}
)(window.angular);