(function (ng) {

    var mod = ng.module("SierraModule");

    mod.controller("SierraCtrl", ['$scope', '$state', '$stateParams', '$http', 'SierraContext', function ($scope, $state, $stateParams, $http, context) {

            // inicialmente el listado de entidades de Sierra está vacio
            $scope.records = {};
            // carga las entidades de Sierra
            $http.get(context).then(function (response) {
                $scope.records = response.data;
            });

            // el controlador recibió un SierraId ??
            // revisa los parámetros (ver el :SierraId en la definición de la ruta)
            if ($stateParams.SierraId !== null && $stateParams.SierraId !== undefined) {

                // toma el id del parámetro
                id = $stateParams.SierraId;
                // obtiene el dato del recurso REST
                $http.get(context + "/" + id)
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentRecord
                            $scope.currentRecord = response.data;
                        });

                // el controlador no recibió un SierraId
            } else {
                // el registro actual debe estar vacio
                $scope.currentRecord = {
                    id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                    name: '' /*Tipo String*/,
                };

                $scope.alerts = [];
            }


            this.saveRecord = function (id) {
                currentRecord = $scope.currentRecord;

                // si el id es null, es un registro nuevo, entonces lo crea
                if (id == null) {

                    // ejecuta POST en el recurso REST
                    return $http.post(context, currentRecord)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('SierraList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    // ejecuta PUT en el recurso REST
                    return $http.put(context + "/" + currentRecord.id, currentRecord)
                            .then(function () {
                                // $http.put es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('SierraList');
                            });
                }
                ;
            };

            this.deleteRecord = function (id) {
                $http.delete(context + "/" + id);
                $state.reload('SierraList');

            };

// Código continua con las funciones de despliegue de errores


        }]);
})(window.angular);

