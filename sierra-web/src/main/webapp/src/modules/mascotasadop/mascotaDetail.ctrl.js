(function (ng) {
    var mod = ng.module("mascotaadopModule");
    mod.constant("mascotaaContext", "api/mascotaAdoptadas");
    mod.controller('mascotaDetailCtrl', ['$scope', '$http', 'mascotaaContext', '$state', '$filter',
        function ($scope, $http, mascotaaContext, $state, $filter) {
            if (($state.params.mascotaId !== undefined) && ($state.params.mascotaId !== null)) {
                $http.get(mascotaaContext).then(function (response) { 
                    $scope.mascotasRecords = response.data;
                    console.log(response.data);
                    $scope.currentMascota = $filter('filter')($scope.mascotasRecords, {id: $state.params.mascotaId}, true)[0];
                 
                });
            }
            
        }               
    ]);
}
)(window.angular);