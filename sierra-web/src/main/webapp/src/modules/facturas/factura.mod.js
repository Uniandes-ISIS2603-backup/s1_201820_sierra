(function(ng){
 
var mod= ng.module('facturaModule',['ui.router']);
mod.constant('facturaContext','api/facturas');
mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider)
    {
        var basePath='src/modules/facturas/';
        $urlRouterProvider.otherwise("/facturasList");
        $stateProvider.state('facturasList',
        {
            url:'/facturas',
            views:{
                mainView:{
                    
                    templateUrl: basePath+'factura.list.html',
                    controller:'facturaCtrl',
                    controllerAs: 'Ctrl'
                }
            }
        }); 
    }]);
})(window.angular);

