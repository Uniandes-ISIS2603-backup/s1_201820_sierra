(function(ng){
    
    var mod = ng.module('comprobanteModule',[]);
    mod.constant('comprobanteContext','api/comprobantes');
    mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider)
    {
        var basePath='src/modules/comprobantes/';
        $urlRouterProvider.otherwise("/comprobantesList");
        $stateProvider.state('comprobantesList',
        {
            url:'/comprobantes/list',
            views:{
                mainView:{
                    
                    templateUrl: basePath+'list/comprobante.list.html',
                    controller:'comprobanteCtrl',
                    controllerAs: 'Ctrl'
                }
            }
        })
        .state('comprobantes',
        {
            url:'/comprobantes',
            views:{
                mainView:{
                    
                    templateUrl: basePath+'comprobante.html',
                    controller:'comprobanteCtrl',
                    controllerAs: 'Ctrl'
                }
            }
        })
        .state('comprobanteCreate',
        {
            url:'/comprobantes/create)',
            views:{
                mainView:{
                    
                    templateUrl: basePath+'create/comprobante.create.html',
                    controller:'comprobanteCreateCtrl',
                    controllerAs: 'Ctrl'
                }
            }
        })
        .state('comprobanteUpdate',
        {
            url:'/comprobantes/update',
            views:{
                mainView:{
                    
                    templateUrl: basePath+'update/comprobante.update.html',
                    controller:'comprobanteUpdateCtrl',
                    controllerAs: 'Ctrl'
                }
            }
        })
        .state('comprobanteDelete',
        {
            url:'/comprobantes/list',
            views:{
                mainView:{
                    
                    templateUrl: basePath+'comprobante.list.html',
                    controller:'comprobanteDeleteCtrl',
                    controllerAs: 'Ctrl'
                }
            }
        }); 
    }]);
})(window.angular);

