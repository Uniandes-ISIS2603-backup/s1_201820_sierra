(function (ng) {
    var mod = ng.module("razaModule");
    mod.constant("razasContext", "api/razas");
    mod.controller('razaDeleteCtrl', ['$scope', '$http', 'razasContext', '$state',

        function ($scope, $http, razasContext, $state) {
           
           
            var idRaza = $state.params.razaId;
            
                 $http.get(razasContext).then(function (response) { 
                 $scope.razaRecords = response.data;
                 $scope.currentRaza = $filter('filter')($scope.razaRecords, {id: $state.params.razaId}, true)[0];  
                });
                
             
            $scope.deleteRaza = function () {
                $http.delete(razasContext + '/' + idRaza, {}).then(function (response) {
                    $state.go('razasList', {idRaza: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
