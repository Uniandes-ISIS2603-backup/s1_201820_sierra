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
            }).state ('clienteCreate', {
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

            });
        }]);
})(window.angular);


