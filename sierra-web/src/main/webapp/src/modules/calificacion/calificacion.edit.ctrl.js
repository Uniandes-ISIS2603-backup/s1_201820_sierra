(function (ng) {
    var mod = ng.module("calificacionModule");
    mod.constant("calificacionContext", "api/calificaciones");
    mod.controller('calificacionEditCtrl', ['$scope', '$http', 'calificacionContext', '$state', '$rootScope', '$filter',

        function ($scope, $http, calificacionContext, $state, $rootScope, $filter) {
            $rootScope.edit = true;

            $http.get(calificacionContext).then(function (response) {
                $scope.calificacionRecords = response.data;
                $scope.currentCalificacion = $filter('filter')($scope.calificacionRecords, {id: $state.params.calificacionId}, true)[0];

            });


            var idCal = $state.params.calificacionId;
            var cal = undefined;

            $http.get(calificacionContext + '/' + idCal).then(function (response) {
                cal = response.data;
            });

            $scope.updateCalificacion = function () {
                $http.put(calificacionContext + "/" + idCal, {
                    valor: cal.valor,
                    comentarios: cal.comentarios,
                    sugerencia: cal.sugerencia

                }).then(function (response) {
                    $state.go('calificacionList', {reload: true});
                });
            };

        }]);
}
)(window.angular);


