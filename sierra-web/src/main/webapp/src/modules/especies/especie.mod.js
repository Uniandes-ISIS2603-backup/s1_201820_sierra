(function(ng){
 
 var mod=ng.module('especieModule',[]);
 mod.constant('especieContext','api/especies');
 mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
         var basePath = 'src/modules/especies/';
         $urlRouterProvider.otherwise("/especiesList");
         $stateProvider.state( 'epeciesList',{
               url: '/especie ',
               views:{
                   mainView:{
                       controller:'especie.Ctrl',
                       controllerAs: 'Crtl',
                       templatUrl: basePath+"especie.list.html"
                   }
               }
         });
        }
 
    ]);
})(window.angular);