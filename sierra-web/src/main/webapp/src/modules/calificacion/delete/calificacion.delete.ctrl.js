(function (ng) {
    var mod = ng.module("calificacionModule");
    mod.constant("calificacionContext", "api/calificaciones");
    mod.controller('calificacionDeleteCtrl', ['$scope', '$http', 'calificacionContext', '$state',
        /**
         * @ngdoc controller
         * @name editorials.controller:editorialDeleteCtrl
         * @description
         * Definición del controlador auxiliar para eliminar Editoriales. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} editorialContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Editoriales en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function ($scope, $http, calificacionContext, $state) {
            var idCal = $state.params.calId;
            /**
             * @ngdoc function
             * @name deleteCalificacion
             * @methodOf calificaciones.controller:calificacionlDeleteCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para eliminar la calificacion.
             * @param {String} id El ID de la calificacion a eliminar.
             */
            $scope.deleteCalificacion = function () {
                $http.delete(calificacionContext + '/' + idCal, {}).then(function (response) {
                    $state.go('calificacionList', {calId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);