(function(ng){
 
 var mod=ng.module('razaModule',[]);
 mod.constant('razaContext','api/especies/razas');
 mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
         var basePath = 'src/modules/especies/razas';
         $urlRouterProvider.otherwise("/razasList");
         $stateProvider
               .state('razasList',{
               url: '/raza',
               views:{
                   mainView:{
                       templateUrl: basePath+"raza.list.html",
                       controller:'razaCtrl',
                       controllerAs: 'Crtl'
                   }
               }
         })
         
        }
 
    ]);
})(window.angular);