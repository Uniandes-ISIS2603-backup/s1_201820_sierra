(function (ng){
    var mod = ng.module("clienteModule",['ui.router']);
    mod.constant("clienteContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider){
            
            var basePath = 'src/modules/clientes/';
            var basePathMedios = 'src/modules/mediosDePago/';
            $urlRouterProvider.otherwise("/clientesList");
            
            $stateProvider.state('clientes', {
                url: '/clientes',
                  abstrac:true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'clientes.html',
                        controller: 'clienteCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                 data: {
                    requireLogin: true,
                     roles: ['admin']
                   }   
            }).state('clientesList',{
               url: '/List',
               parent: 'clientes',
               views:{
                   'listView':{
                       templateUrl: basePath+"clientes.list.html",
                       controller:'clienteCtrl',
                       controllerAs: 'Crtl'
                   }
               }
             })
            .state ('clienteCreate', {
                url:'/cliente/create',
                views: {
                    'mainView':{
                        controller: 'clienteNewCtrl',
                        templateUrl: basePath + 'cliente.create.html'
                    }
                },
                 data: {
                    requireLogin: true,
                     roles: ['admin']
                   }
            }).state('clienteDetail', {
                url: '/{clienteId:int}/detail',
                parent: 'clientes',
                param: {
                    clienteId: null
                },
                views: {
                    'listView':{
                       templateUrl:basePathMedios +  'mediosDePago.list.html',
                       controller:'clienteDetailCtrl'
                   }

                },
                data: {
                    requireLogin: false
                }
               

            }).state('clienteDelete', {
                url:'/{clienteId:int}/delete',
                parent:'clientes',
                param:{
                    clienteId:null
                },
                views:{
                    'listView':{
                      templateUrl: basePath+"clientes.list.html",
                      controller:'deleteClienteCtrl',
                    controllerAs: 'Crtl'
                   }
                },
                 data: {
                    requireLogin: true,
                     roles: ['admin']
                   }
            }).state('clienteUpdate', {
                url:'/{clienteId:int}/update',
                parent:'clientes',
                param:{
                    clienteId:null
                },
                views:{
                    'detailView':{
                    templateUrl: basePath + 'cliente.create.html',
                    controller:'clienteUpdateCtrl'
                  
                   }
                }
                ,
                 data: {
                    requireLogin: true,
                     roles: ['admin']
                   }
            });
        }]);
})(window.angular);


