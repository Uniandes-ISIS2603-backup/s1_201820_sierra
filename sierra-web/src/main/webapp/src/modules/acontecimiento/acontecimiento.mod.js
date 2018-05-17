
(function (ng)
{
    //Definicion del modulo.
    var modulo = ng.module("acontecimientoModule", ['ui.router']);
    //Configuracion de los estados.
    modulo.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider)
        {
            //basePath es la variable con la ruta para encontrar los templates, controladores y modulo.
            var basePath = 'src/modules/acontecimiento/';
            //Estado por defecto
            $urlRouterProvider.otherwise("/acontecimientoList");
            //Definicion de los estados
            //Estado iincial
            $stateProvider.state('acontecimientoDelete', {
                url: '/acontecimiento/{acontecimientoId:int}/delete',
                param: {
                    acontecimientoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + "delete/acontecimiento.delete.html",
                        controller: 'acontecimientoDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            }
            )
                    .state('acontecimientos', {
                        url: '/acontecimientos',
                        abstrac: true,
                        views: {
                            'mainView': {
                                templateUrl: basePath + 'acontecimiento.html',
                                controller: 'acontecimientoCtrl'
                            }
                        }
                    })
                    // Define el estado lista
                    .state('acontecimientoList', {
                        url: '/acontecimiento/list',
                        views: {
                            'mainView': {
                                templateUrl: basePath + 'list/acontecimiento.list.html',
                                controller: 'acontecimientoCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                    })
                    //Estado crear
                    .state('acontecimientoCreate', {
                        url: '/acontecimiento/create',
                        views: {
                            'mainView': {
                                templateUrl: basePath + 'create/acontecimiento.create.html',
                                controller: 'acontecimientoCreateCtrl',
                                controllerAs: 'ctrl'
                            }
                        }, data: {
                            requireLogin: true,
                            roles: ['admin']
                        }

                    }
                    )
                    //Estado actualizar
                    .state('acontecimientoUpdate', {
                        url: '/acontecimiento/{acontecimientoId:int}/update',
                        param: {
                            acontecimientoId: null
                        },
                        views: {
                            'mainView': {
                                templateUrl: basePath + 'update/acontecimiento.update.html',
                                controller: 'acontecimientoUpdateCtrl'
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

