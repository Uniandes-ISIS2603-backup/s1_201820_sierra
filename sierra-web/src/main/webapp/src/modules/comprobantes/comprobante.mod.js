(function(ng){
    
    var mod = ng.module('comprobanteModule',[]);
    mod.constant('comprobanteContext','api/comprobantes');
    mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider)
    {
        var basePath='src/modules/comprobantes/';
        $urlRouterProvider.otherwise("/comprobantesList");
        $stateProvider.state('comprobantesList',
        {
            url:'/comprobantes',
            views:{
                mainView:{
                    
                    templateUrl: basePath+'comprobante.list.html',
                    controller:'comprobanteCtrl',
                    controllerAs: 'Ctrl'
                }
            }
        }); 
    }]);
})(window.angular);

