(function (ng) {
    var mod = ng.module("razaModule");
    mod.constant("razasContext", "api/razas",'especieContext','api/especies');
    mod.controller('razacreateCtrl', ['$scope', '$http', 'razasContext','especieContext', '$state', '$rootScope',
               
        function ($scope, $http, razasContext,especieContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            $http.get(especieContext).then(function (response) {
                $scope.especiesRecords = response.data;
            });
            
            $scope.createRaza = function () {
                $http.post(razasContext,$scope.data).then(function (response) {
                    $state.go('razasList', {razaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);