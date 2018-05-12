(function (ng) {
    var mod = ng.module("especieModule");
    mod.constant("especieContext", "api/especies");
    mod.controller('especieDetailCtrl', ['$scope', '$http', 'especieContext', '$state', '$filter',
        function ($scope, $http, especieContext, $state, $filter) {
            if (($state.params.especieId !== undefined) && ($state.params.especieId !== null)) {
                $http.get(especieContext).then(function (response) { 
                    $scope.especieRecords = response.data;
                    console.log(response.data);
                    $scope.currentEspecie = $filter('filter')($scope.especieRecords, {id: $state.params.especieId}, true)[0];
                 
                });
            }
            
        }               
    ]);
}
)(window.angular);