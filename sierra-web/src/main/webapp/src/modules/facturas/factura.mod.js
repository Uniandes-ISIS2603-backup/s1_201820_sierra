(function (ng) {
    //def del modulo
    var mod = ng.module("facturaModule", ['ui.router']);
    //Configuracion de los estados
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            //basePath es donde se encuentran los templates y el controlador
            var basePath = 'src/modules/facturas/';
            //estado por defecto
            $urlRouterProvider.otherwise("/facturasList");
            //estado 'calificacionList'
            $stateProvider.state('facturasList', {
                
                url: '/facturas/list',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'factura.list.html',
                        controller: 'facturaCtrl',     
                        controllerAs: 'ctrl'
                    }
                }
                
            })
            .state('facturaCreate', 
            {
                url:'/facturas/create',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'create/factura.create.html',
                        controller: 'facturaCreateCtrl'
                    }
                }
            });
        }
    ]);
})(window.angular);





