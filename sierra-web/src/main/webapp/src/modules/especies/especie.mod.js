(function(ng){
 
 var mod=ng.module('especieModule',[]);
 mod.constant('especieContext','api/especies');
 mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
         var basePath = 'src/modules/especies/';
         $urlRouterProvider.otherwise("/especiesList");
         $stateProvider.state('especies',{
             url:'/especies',
             abstrac:true,
             views:
                     {
                       mainView:{
                       templateUrl: basePath+"especies.html",
                       controller:'especieCtrl',
                       controllerAs: 'Crtl'
                         }
                     }
             })
                     
               //Estado de lista
                .state('especiesList',{
               url: '/List',
               parent: 'especies',
               views:{
                   'listView':{
                       templateUrl: basePath+"especie.list.html",
                       controller:'especieCtrl',
                       controllerAs: 'Crtl'
                   }
               }
             })
            //EstadoDetail
            .state('especieDetail',{
              url:'/{especieId:int}/detail',
              parent:'especies',
              param:{
                  especiId:null
              },
              views:{
                  'listView':{
                       templateUrl: basePath+"especie.list.html"
                   }
                   ,detailView:{
                       templateUrl: basePath+"especieDetail.html",
                       controller:'especieDetailCtrl',
                       controllerAs: 'Crtl'
                   }
              }
              
            })
              .state('especieEdit',
            {
               url:'/edit/{especieId:int}',
              parent:'especies',
              param:{
                  especieId:null
              },
               views:
               {
                   'listView':{
                      templateUrl: basePath+"especie.list.html"
                   },
                   detailView:{
                   templateUrl: basePath + "/update/especie.edit.html",
                   controller:'especieeditCtrl',
                   controllerAs: 'Crtl'
                   }
                           
               }
     
         })
           .state('especieDelete',
            {
               url:'/delete/{especieId:int}',
              parent:'especies',
              param:{
                  especieId:null
              },
               views:
               {
                   'listView':{
                      templateUrl: basePath+"especie.list.html"
                   },
                   detailView:{
                   templateUrl: basePath + "/delete/especie.delete.html",
                   controller:'especieDeleteCtrl',
                   controllerAs: 'Crtl'
                   }
                           
               }
     
         })         
            //Estado de registro 
             .state('especiecreate', 
            {
             url:'/registrar',
             parent:'especies',
             views:
              {
                'listView':{
                       templateUrl: basePath+"especie.list.html"
                   },  
               'detailView':
                {
                   templateUrl: basePath + "/new/especie.create.html",
                   controller:'especiecreateCtrl',
                   controllerAs: 'Crtl'
                }
              }
         });
         
        }
 
    ]);
})(window.angular);