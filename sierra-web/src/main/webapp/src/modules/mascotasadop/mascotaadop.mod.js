(function(ng){
 
var mod= ng.module('mascotaadopModule',[]);
mod.constant('mascotaadopContext','api/mascotasadop');
mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider)
    {
        var basePath='src/modules/mascotasadop/';
        $urlRouterProvider.otherwise("/mascotasadopList");
        $stateProvider.state('mascotasadoptadas',{
             url:'/mascotasadoptadas',
             abstrac:true,
             views:
                     {
                       mainView:{
                       templateUrl: basePath+"mascotas.html",
                       controller:'mascotaaCtrl',
                       controllerAs: 'Crtl'
                         }
                     }
             }).state('mascotasaList',
         {
            url:'/mascotasadop',
            parent:'mascotasadoptadas',
            views:{
                'listView':{
                    templateUrl: basePath+'mascotaadop.list.html',
                    controller:'mascotaaCtrl',
                    controllerAs: 'Ctrl'
                }
            }
        })//EstadoDetail
            .state('mascotaaDetail',{
              url:'/{mascotaId:int}/detail',
              parent:'mascotasadoptadas',
              param:{
                  mascotaId:null
              },
              views:{
                  'listView':{
                       templateUrl: basePath+"mascotaadop.list.html"
                   }
                   ,detailView:{
                       templateUrl: basePath+"mascotaDetail.html",
                       controller:'mascotaDetailCtrl',
                       controllerAs: 'Crtl'
                   }
              }
              
            })  .state('mascotaEdit',
            {
               url:'/edit/{mascotaId:int}',
              parent:'mascotasadoptadas',
              param:{
                  mascotaId:null
              },
               views:
               {
                   'listView':{
                      templateUrl: basePath+"mascotaadop.list.html"
                   },
                   detailView:{
                   templateUrl: basePath + "/update/mascota.edit.html",
                   controller:'mascotaeditCtrl',
                   controllerAs: 'Crtl'
                   }
                           
               }
     
             }).state('mascotaDelete',
            {
               url:'/delete/{mascotaId:int}',
              parent:'mascotasadoptadas',
              param:{
                  mascotaId:null
              },
               views:
               {
                   'listView':{
                      templateUrl: basePath+"mascotaadop.list.html"
                   },
                   detailView:{
                   templateUrl: basePath + "/delete/mascota.delete.html",
                   controller:'mascotaDeleteCtrl',
                   controllerAs: 'Crtl'
                   }
                           
               }
     
            })   //Estado de registro 
             .state('mascotacreate', 
            {
             url:'/registrar',
             parent:'mascotasadoptadas',
             views:
              {
                'listView':{
                       templateUrl: basePath+"mascotaadop.list.html"
                   },  
               'detailView':
                {
                   templateUrl: basePath + "/new/mascota.create.html",
                   controller:'mascotacreateCtrl',
                   controllerAs: 'Crtl'
                }
              }
         });
         
    }]);
})(window.angular);