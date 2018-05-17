(function (ng) {
    //def del modulo
    var mod = ng.module("adquisicionModule", ['ui.router']);
    //Configuracion de los estados
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            //basePath es donde se encuentran los templates y el controlador
            var basePath = 'src/modules/adquisicion/';
            //estado por defecto
            $urlRouterProvider.otherwise("/adquisicionList");
            //estado 'adquisicionList'
            $stateProvider.state('adquisicionList', {

                url: '/adquisicion/list',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'adquisicion.list.html',
                        controller: 'adquisicionCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: ['admin', 'cliente']
                }

            })
                    .state('adquisicionCreate',
                            {
                                url: '/adquisicion/create',
                                views: {
                                    'mainView': {
                                        templateUrl: basePath + 'adquisicion.create.html',
                                        controller: 'adquisicionCtrl',
                                        controllerAs: 'ctrl'
                                    }
                                },
                                data: {
                                    requireLogin: false,
                                    roles: ['admin', 'cliente']
                                }
                            });
        }
    ]);
})(window.angular);





