(function (ng) {
    var mod = ng.module("razaModule");
    mod.constant("razaContext", "api/razas");
    mod.controller('razaDetailCtrl', ['$scope', '$http', 'razaContext', '$state', '$filter',
        function ($scope, $http, razaContext, $state, $filter) {
            if (($state.params.razaId !== undefined) && ($state.params.razaId !== null)) {
                $http.get(razaContext).then(function (response) { 
                    $scope.razaRecords = response.data;
                    console.log(response.data);
                    $scope.currentRaza = $filter('filter')($scope.razaRecords, {id: $state.params.razaId}, true)[0];
                 
                });
            }
            
        }               
    ]);
}
)(window.angular);