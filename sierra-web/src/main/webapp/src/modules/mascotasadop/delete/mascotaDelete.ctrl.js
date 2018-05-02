(function (ng) {
    var mod = ng.module("mascotaadopModule");
    mod.constant("mascotaaContext", "api/mascotaAdoptadas");
    mod.controller('mascotaDeleteCtrl', ['$scope', '$http', 'mascotaaContext', '$state',

        function ($scope, $http, mascotaaContext, $state) {
           
           
            var idMascota = $state.params.mascotaId;
            
                 $http.get(mascotaaContext).then(function (response) { 
                 $scope.mascotasRecords = response.data;
                 $scope.currentMascota = $filter('filter')($scope.mascotasRecords, {id: $state.params.mascotaId}, true)[0];  
                });
                
             
            $scope.deleteMascota = function () {
                $http.delete(mascotaaContext + '/' + idMascota, {}).then(function (response) {
                    $state.go('mascotasList', {idMascota: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
