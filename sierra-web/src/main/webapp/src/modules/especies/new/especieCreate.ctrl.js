(function (ng) {
    var mod = ng.module("especieModule");
    mod.constant("especiesContext", "api/especies");
    mod.controller('especiecreateCtrl', ['$scope', '$http', 'especiesContext', '$state', '$rootScope',
        
        function ($scope, $http, especiesContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            $scope.createEspecie = function () {
                $http.post(especiesContext, $scope.data).then(function (response) {
                    $state.go('especiesList', {especieId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);