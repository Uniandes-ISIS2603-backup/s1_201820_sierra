
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
            $stateProvider.state('acontecimientoList', {
                url: '/acontecimiento/list',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'acontecimiento.list.html',
                        controller: 'acontecimientoCtrl',     
                        controllerAs: 'ctrl'
                       }
                }
            })
                    .state('acontecimientoCreate',{
                        url:'/acontecimiento/create',
                views:{
                    'mainView':{
                        templateUrl: basePath + 'acontecimiento.create.html',
                        controller: 'acontecimientoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                    }
                    );
        }
    ]);
})(window.angular);

