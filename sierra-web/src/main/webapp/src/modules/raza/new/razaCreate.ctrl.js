(function (ng) {
    var mod = ng.module("razaModule");
    mod.constant("razasContext", "api/razas",'especiesContext','api/especies');
    mod.controller('razacreateCtrl', ['$scope', '$http', 'razasContext', '$state', '$rootScope','especiesContext',
               
        function ($scope, $http, razasContext, $state, $rootScope,especiesContext) {
            $rootScope.edit = false;
            
             $http.get(especiesContext).then(function (response) {
                $scope.especiesRecords = response.data;
            });

            $scope.createRaza = function () {
               
                $http.get(especiesContext).then(function (response) { 
                    $scope.especiesRecords = response.data;
                    $scope.currentEspecie = $filter('filter')($scope.especiesRecords, {id: $scope.data.especieId}, true)[0];
                });
                $http.post(razasContext,$scope.data).then(function (response) {
                    $state.go('razasList', {razaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);