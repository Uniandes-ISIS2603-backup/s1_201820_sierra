(function(ng){
 
 var mod=ng.module('acontecimientosModule',[]);
 mod.constant('acontecimientosContext','api/acontecimientos');
 mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
         var basePath = 'src/modules/acontecimientos/';
         $urlRouterProvider.otherwise("/acontecimientosList");
         $stateProvider.state('acontecimientosList',{
               url: '/acontecimientos',
               views:{
                   mainView:{
                       templateUrl: basePath + "acontecimientos.list.html",
                       controller:'acontecimientosCtrl',
                       controllerAs: 'Crtl'
                   }
               }
         });
        }
 
    ]);
})(window.angular);

