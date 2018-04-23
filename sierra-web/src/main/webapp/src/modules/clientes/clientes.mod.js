(function (ng){
    var mod = ng.module("clienteModule",['ui.router']);
    mod.constant("clienteContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider){
            
            var basePath = 'src/modules/clientes/';
            $urlRouterProvider.otherwise("/clientesList");
            
            $stateProvider.state('clientes', {
                url:'/clientes',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'clientes.list.html',
                        controller: 'clienteCtrl',
                        controllerAs:'ctrl'
                    }
                }
           
            });
    }]);
}
)(window.angular);


