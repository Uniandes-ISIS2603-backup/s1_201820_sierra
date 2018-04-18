(function(ng){
 
 var mod=ng.module('especieModule',[]);
 mod.constant('especieContext','api/especies');
 mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
         var basePath = 'src/modules/especies/';
         $urlRouterProvider.otherwise("/especiesList");
         $stateProvider
               
                 .state('especiesList',{
               url: '/especies',
               views:{
                   'mainView':{
                       templateUrl: basePath+"especie.list.html",
                       controller:'especieCtrl',
                       controllerAs: 'Crtl'
                   }
               }
         })
             .state('especiecreate', 
            {
             url:'/especies/registrar',
             views:
              {
               'mainView':
                {
                   templateUrl: basePath + "especie.create.html",
                   controller:'especieCtrl',
                   controllerAs: 'Crtl'
                }
              }
         });
         
        }
 
    ]);
})(window.angular);