(function (ng) {
    var mod = ng.module("razaModule");
    mod.constant("razasContext", "api/razas");
    mod.controller('razacreateCtrl', ['$scope', '$http', 'razasContext', '$state', '$rootScope',
               
        function ($scope, $http, razasContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.createRaza = function () {
                $http.post(razasContext,$scope.data).then(function (response) {
                    $state.go('razasList', {razaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);