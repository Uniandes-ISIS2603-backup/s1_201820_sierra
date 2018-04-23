(function(ng){
 
var mod= ng.module('mascotaModule',[]);
mod.constant('mascotaContext','api/mascotas');
mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider)
    {
        var basePath='src/modules/mascotas/';
        $urlRouterProvider.otherwise("/mascotasList");
        $stateProvider.state('mascotasList',
        {
            url:'/mascotas',
            views:{
                mainView:{
                    
                    templateUrl: basePath+'mascota.list.html',
                    controller:'mascotaCtrl',
                    controllerAs: 'Ctrl'
                }
            }
        }); 
    }]);
})(window.angular);