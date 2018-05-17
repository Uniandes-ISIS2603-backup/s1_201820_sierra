(function (ng) {
    var mod = ng.module("calificacionModule");
    mod.constant("calificacionContext", "api/calificaciones");
    mod.controller('calificacionCreateCtrl', ['$scope', '$http', 'calificacionContext', '$state', '$rootScope',
        /**
         * @ngdoc controller
         * @name editorials.controller:editorialNewCtrl
         * @description
         * Definición del controlador auxiliar para crear Editoriales. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} editorialContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Editoriales en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function ($scope, $http, calificacionContext, $state, $rootScope) {
            $rootScope.edit = true;

            $scope.createCalificacion = function () {
                $http.post(calificacionContext, $scope.data).then(function (response) {
                    $state.go('calificacionist', {calificacionId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);