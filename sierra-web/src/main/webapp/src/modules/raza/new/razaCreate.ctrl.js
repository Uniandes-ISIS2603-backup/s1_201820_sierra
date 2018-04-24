(function (ng) {
    var mod = ng.module("razaModule");
    mod.constant("razaContext", "api/razas");
    mod.controller('razacreateCtrl', ['$scope', '$http', 'razaContext', '$state', '$rootScope',
        
        function ($scope, $http, razaContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            $scope.createRaza = function () {
                $http.post(razaContext, $scope.data).then(function (response) {
                    $state.go('razasList', {razaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);