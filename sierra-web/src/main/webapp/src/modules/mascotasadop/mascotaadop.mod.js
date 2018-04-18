(function(ng){
 
var mod= ng.module('mascotaadopModule',[]);
mod.constant('mascotaadopContext','api/mascotasadoptadas');
mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider)
    {
        var basePath='src/modules/mascotasadop/';
        $stateProvider.state('mascotasadopList',
        {
            url:'/mascotasadopt',
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