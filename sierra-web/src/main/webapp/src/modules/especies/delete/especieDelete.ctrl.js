(function (ng) {
    var mod = ng.module("especieModule");
    mod.constant("especiesContext", "api/especies");
    mod.controller('especieDeleteCtrl', ['$scope', '$http', 'especiesContext', '$state',

        function ($scope, $http, especiesContext, $state) {
           
           
            var idEspecie = $state.params.especieId;
            
                 $http.get(especiesContext).then(function (response) { 
                 $scope.especieRecords = response.data;
                 $scope.currentEspecie = $filter('filter')($scope.especieRecords, {id: $state.params.especieId}, true)[0];  
                });
                
             
            $scope.deleteEspecie = function () {
                $http.delete(especiesContext + '/' + idEspecie, {}).then(function (response) {
                    $state.go('especiesList', {idEspecie: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
