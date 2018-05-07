(function (ng){
    var mod = ng.module("clienteModule",['ui.router']);
    mod.constant("clienteContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider){
            
            var basePath = 'src/modules/clientes/';
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
                }
            }).state('clienteDetail', {
                url: '/{clienteId:int}/detail',
                parent: 'clientes',
                param: {
                    clienteId: null
                },
                views: {
                    'listView':{
                       templateUrl: basePath+"clientes.list.html"
                   },
                    'detailView': {
                        templateUrl: basePath + 'clientes.detail.html',
                        controller: 'clienteDetailCtrl',
                        controllerAs:"ctrl"
                    }

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
            });
        }]);
})(window.angular);


