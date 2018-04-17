(function (ng) {
    var mod = ng.module("adquisicionModule");
    mod.constant("adquisicionContext", "api/adquisiciones");
    mod.controller('adquisicionCtrl', ['$scope', '$http', 'adquisicionContext',

        function ($scope, $http, adquisicionContext) {
            //Controlador
            //reviews comienza vacio
            $scope.reviews = {};
            //llena reviews con los datos del response
            $http.get('data/adquisiciones.json').then(function (response) {
                $scope.adquisiciones = response.data;
            });
           
           
        }
    ]);

})(window.angular);

