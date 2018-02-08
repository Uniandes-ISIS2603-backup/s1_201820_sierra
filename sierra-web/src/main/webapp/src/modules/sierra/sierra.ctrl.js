(function (ng) {

    var mod = ng.module("sierraModule");

    mod.controller("sierraCtrl", ['$scope', '$state', '$stateParams', '$http', 'sierraContext', function ($scope, $state, $stateParams, $http, context) {

            // inicialmente el listado de entidades de sierra está vacio
            $scope.records = {};
            // carga las entidades de sierra
            $http.get(context).then(function (response) {
                $scope.records = response.data;
            });

            // el controlador recibió un sierraId ??
            // revisa los parámetros (ver el :sierraId en la definición de la ruta)
            if ($stateParams.sierraId !== null && $stateParams.sierraId !== undefined) {

                // toma el id del parámetro
                id = $stateParams.sierraId;
                // obtiene el dato del recurso REST
                $http.get(context + "/" + id)
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentRecord
                            $scope.currentRecord = response.data;
                        });

                // el controlador no recibió un sierraId
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
                                $state.go('sierraList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    // ejecuta PUT en el recurso REST
                    return $http.put(context + "/" + currentRecord.id, currentRecord)
                            .then(function () {
                                // $http.put es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('sierraList');
                            });
                }
                ;
            };

            this.deleteRecord = function (id) {
                $http.delete(context + "/" + id);
                $state.reload('sierraList');

            };

// Código continua con las funciones de despliegue de errores


        }]);
})(window.angular);

