
(function (ng)
{
   //Definicion del modulo.
    var modulo = ng.module("acontecimientoModule",  ['ui.router']);
   //Configuracion de los estados.
    modulo.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider)
        {
            //basePath es la variable con la ruta para encontrar los templates, controladores y modulo.
            var basePath = 'src/modules/acontecimiento/';
            //Estado por defecto
            $urlRouterProvider.otherwise("/acontecimientoList");
           //Definicion de los estados
            //Estado iincial
            $stateProvider.state('acontecimientos',{
                url:'/acontecimientos',
                views: {
                    'mainView':{
                        templateUrl: basePath + 'acontecimiento.html',
                        controller: 'acontecimientoCtrl',
                        controllerAs:'ctrl'
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
                    .state('acontecimientoCreate',{
                        url:'/acontecimiento/create',
                views:{
                    'mainView':{
                        templateUrl: basePath + 'create/acontecimiento.create.html',
                        controller: 'acontecimientoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                    }
                    );
        }
    ]);
})(window.angular);

