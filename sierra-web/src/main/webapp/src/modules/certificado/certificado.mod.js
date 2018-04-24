(function (ng) {
    // Definición del módulo
    var mod = ng.module("certificadoModule", ['ui.router']);

    // Configuración de los estados del módulo
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            // En basePath se encuentran los templates y controladores de módulo
            var basePath = 'src/modules/certificado/';
            // Mostrar la lista de autores será el estado por defecto del módulo
            $urlRouterProvider.otherwise("/certificadoList");
            // Definición del estado 'authorsList' donde se listan los autores
            $stateProvider.state('certificado', {
                // Url que aparecerá en el browser
                url: '/certificados',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'certificado.html',
                        controller: 'certificadoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('certificadoCreate', {
                url: '/create',
                parent: 'certificado',
                views: {
                    'detailView': {
                        templateUrl: basePath + 'certificado.new.html',
                        controller: 'certificadoNewCtrl'
                    }
                }
            }).state('certificadoUpdate', {
                url: '/update/{certificadoId:int}',
                parent: 'certificado',
                param: {
                    certificadoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'certificado.new.html',
                        controller: 'certificadoUpdateCtrl'
                    }
                }
            }).state('certificadoList', {
                url: '/list',
                parent: 'certificado',
                views: {
                    'listView': {
                        templateUrl: basePath + 'certificado.list.html',
                        controller: 'certificadoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('certificadoDetail', {
                url: '/{cerificadoId:int}/detail',
                parent: 'certificado',
                param: {
                    mensajeId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'certificado.detail.html',
                        controller: 'certificadoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            })
        }
    ]);
})(window.angular);
