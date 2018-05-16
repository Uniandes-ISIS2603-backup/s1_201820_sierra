(function(ng){
 
var mod= ng.module('mascotaModule',[]);
mod.constant('mascotaContext','api/mascotas');
mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider)
    {
        var basePath='src/modules/mascotas/';
        $stateProvider.state('mascotasList',
        {
            url:'/mascotas',
            views:{
                mainView:{
                    
                    templateUrl: basePath+'mascota.list.html',
                    controller:'mascotaCtrl',
                    controllerAs: 'Ctrl'
                }
            },
            data: {
                    requireLogin: false,
                    roles: ['admin']
                }
        }); 
    }]);
})(window.angular);