(function (ng) {
    var mod = ng.module("calificacionModule");
    mod.constant("calificacionContext", "api/calificaciones");
    mod.controller('calificacionCreateCtrl', ['$scope', '$http', 'calificacionContext', '$state', '$rootScope',
        
        function ($scope, $http, calificacionContext, $state, $rootScope) {
            $rootScope.edit = true;

            $scope.data = {};

            $scope.createCalificacion = function () {
                $http.post(calificacionContext, $scope.data).then(function (response) {
                    $state.go('calificacinoesList', {reload: true});
                });
            };
            
            $scope.updateCalificacion = function() {
                $http.put(calificacionContext + '/' + $scope.data.id, $scope.data).then(function (response){
                    $state.go('calificacionesList', {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);


