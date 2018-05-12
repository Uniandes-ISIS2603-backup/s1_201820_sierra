(function (ng) {
    var mod = ng.module("mascotaadopModule");
    mod.constant("mascotaaContext", "api/mascotas");
    mod.controller('mascotacreateCtrl', ['$scope', '$http', 'mascotaaContext', '$state', '$rootScope',
        
        function ($scope, $http, mascotaaContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            $scope.createMascota = function () {
                $http.post(mascotaaContext, $scope.data).then(function (response) {
                    $state.go('mascotasList', {mascotaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);