(function(ng){
 
var mod= ng.module('mascotaaModule',[]);
mod.constant('mascotaaContext','api/mascotasa');
mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider)
    {
        var basePath='src/modules/mascotasadoptadas/';
        $urlRouterProvider.otherwise("/mascotasaList");
        $stateProvider.state('mascotasaList',
        {
            url:'/mascotasAdoptadas',
            views:{
                mainView:{
                    
                    templateUrl: basePath+'mascotaa.list.html',
                    controller:'mascotaaCtrl',
                    controllerAs: 'Ctrl'
                }
            }
        }); 
    }]);
})(window.angular);