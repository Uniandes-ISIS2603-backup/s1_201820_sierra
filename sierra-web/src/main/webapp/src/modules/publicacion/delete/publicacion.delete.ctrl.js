(function (ng){
    var mod = ng.module('publicacionModule');
    mod.constant("publicacionContext", "api/publicaciones");
    mod.controller('publicacionDeleteCtrl', ['$scope','$http','publicacionContext','$state',
         function ($scope, $http, publicacionContext, $state){
             $scope.deletePublicacion = function(){
                 $http.delete(publicacionContext+'/'+$state.params.publicacionId).then(function(response){
                      $state.go('publicacionList', {publicacionId: response.data.id}, {reload: true});
                 });
             };
         }
    ]);
    
}
)(window.angular);
