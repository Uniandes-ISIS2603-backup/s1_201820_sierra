
(function (ng)
{
    //Definicion del modulo.
    var modulo = ng.module("facturaModule", ['ui.router']);
    modulo.constant("facturaContext", "api/facturas")
    //Configuracion de los estados.
    modulo.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider)
        {
            //basePath es la variable con la ruta para encontrar los templates, controladores y modulo.
            var basePath = 'src/modules/facturas/';
            //Estado por defecto
            $urlRouterProvider.otherwise("/facturasList");
            //Definicion de los estados
            //Estado iincial
            $stateProvider.state('facturas', {
                url: '/facturas',
                abstrac: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'factura.html',
                        controller: 'facturaCtrl',
                        constrollerAs: 'ctrl'
                    }
                },
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            })
                    // Define el estado lista
                    .state('facturasList', {
                        url: '/facturas/list',
                        views: {
                            'mainView': {
                                templateUrl: basePath + 'list/factura.list.html',
                                controller: 'facturaCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                    })
                    //Estado crear
                    .state('facturaCreate', {
                        url: '/facturas/create',
                        views: {
                            'mainView': {
                                templateUrl: basePath + 'create/factura.create.html',
                                controller: 'facturaCreateCtrl',
                                controllerAs: 'ctrl'
                            }
                        },
                        data: {
                            requireLogin: true,
                            roles: ['admin']
                        }
                    })
                    //Estado actualizar
                    .state('facturaUpdate', {
                        url: '{facturaId:int}/update',
                        param: {
                            facturaId: null
                        },
                        views: {
                            'mainView': {
                                templateUrl: basePath + 'update/factura.update.html',
                                controller: 'facturaUpdateCtrl',
                                controllerAs: 'ctrl'
                            }
                        },
                        data: {
                            requireLogin: true,
                            roles: ['admin']
                        }
                    })
                    .state('facturaDelete', {
                        url: '/{facturaId:int}/delete',
                        parent: 'facturas',
                        param: {
                            facturaId: null
                        },
                        views: {
                            'mainView': {
                                templateUrl: basePath + 'list/factura.list.html',
                                controller: 'facturaDeleteCtrl',
                                controllerAs: 'Ctrl'
                            }
                        },
                        data: {
                            requireLogin: true,
                            roles: ['admin']
                        }
                    });



        }
    ]);
})(window.angular);

