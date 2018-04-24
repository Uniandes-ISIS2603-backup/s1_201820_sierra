(function (ng){
    var mod = ng.module("clienteModule",['ui.router']);
    mod.constant("clienteContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider){
            
            var basePath = 'src/modules/clientes/';
            $urlRouterProvider.otherwise("/clientesList");
            
            $stateProvider.state('clientes', {
                url: '/clientes',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'clientes.list.html',
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
                url: '{clienteId:int}/detail',
                parent: 'clientes',
                param: {
                    clienteId: 1
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'clientes.list.html',
                        controller: 'clienteCtrl',
                        controllerAs: 'ctrl'
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


