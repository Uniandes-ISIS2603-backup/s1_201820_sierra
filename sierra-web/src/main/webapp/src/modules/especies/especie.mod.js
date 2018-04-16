(function(ng){
 
 var mod=ng.module('especieModule',[]);
 mod.constant('especieContext','api/especies');
 mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
         var basePath = 'src/modules/especies/';
         $urlRouterProvider.otherwise("/especiesList");
         $stateProvider.state('especiesList',{
               url: '/especie ',
               views:{
                   mainView:{
                       templateUrl: basePath+"especie.list.html",
                       controller:'especieCtrl',
                       controllerAs: 'Crtl'
                   }
               }
         });
        }
 
    ]);
})(window.angular);