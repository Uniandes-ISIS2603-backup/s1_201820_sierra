(function(ng){
 
var mod= ng.module('mascotaadopModule',[]);
mod.constant('mascotaadopContext','api/mascotasadop');
mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider)
    {
        var basePath='src/modules/mascotasadop/';
        $urlRouterProvider.otherwise("/mascotasadopList");
        $stateProvider.state('mascotasadopList',
        {
            url:'/mascotasadop',
            views:{
                mainView:{
                    
                    templateUrl: basePath+'mascotaadop.list.html',
                    controller:'mascotaadopCtrl',
                    controllerAs: 'Ctrl'
                }
            }
        }); 
    }]);
})(window.angular);