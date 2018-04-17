(function (ng) {
    //def del modulo
    var mod = ng.module("calificacionModule", ['ui.router']);
    //Configuracion de los estados
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            //basePath es donde se encuentran los templates y el controlador
            var basePath = 'src/modules/calificacion/';
            //estado por defecto
            $urlRouterProvider.otherwise("/calificacionList");
            //estado 'calificacionList'
            $stateProvider.state('calificacionList', {
                
                url: '/calificacion/list',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'calificacion.list.html',
                        controller: 'calificacionCtrl',     
                        controllerAs: 'ctrl'
                    }
                }
                
            })
            .state('calificacionCreate', 
            {
                url:'/calificacion/create',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'calificacion.create.html',
                        controller: 'calificacionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);





