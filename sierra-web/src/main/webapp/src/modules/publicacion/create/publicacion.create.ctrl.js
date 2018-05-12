(function (ng) {
    var mod = ng.module("publicacionModule");
    mod.constant("publicacionContext", "api/publicaciones");
    mod.controller('publicacionCreateCtrl', ['$scope', '$http', 'publicacionContext', '$state', '$rootScope',
        
        function ($scope, $http, publicacionContext, $state, $rootScope) {
            $rootScope.edit = true;
            $scope.createPublicacion = function () {
                $http.post(publicacionContext, $scope.data).then(function (response) {
                    $state.go('publicacionList', {publicacionId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
