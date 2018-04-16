(function (ng) {
    var mod = ng.module("calificacionModule");
    mod.constant("calificacionContext", "api/calificaciones");
    mod.controller('calificacionCtrl', ['$scope', '$http', 'calificacionContext',

        function ($scope, $http, calificacionContext) {
            //Controlador
            //reviews comienza vacio
            $scope.reviews = {};
            //llena reviews con los datos del response
            $http.get('data/calificaciones.json').then(function (response) {
                $scope.reviews = response.data;
            });
            


        }
    ]);

})(window.angular);

