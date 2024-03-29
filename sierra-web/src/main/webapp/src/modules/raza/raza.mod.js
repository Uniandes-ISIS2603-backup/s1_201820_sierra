(function(ng){
 
 var mod=ng.module('razaModule',[]);
 mod.constant('razaContext','api/razas');
 mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider){
         var basePath = 'src/modules/raza/';
         $stateProvider.state('razas',{
             url:'/razas',
             abstrac:true,
             views:
                     {
                       mainView:{
                       templateUrl: basePath+"razas.html",
                       controller:'razaCtrl',
                       controllerAs: 'Crtl'
                         }
                     },
                      data: {
                    requireLogin: false,
                     roles: ['admin']
                   }
             })
                     
               //Estado de lista
                .state('razasList',{
               url: '/list',
               parent: 'razas',
               views:{
                   'listView':{
                       templateUrl: basePath+"raza.list.html",
                       controller:'razaCtrl',
                       controllerAs: 'Crtl'
                   },
                   data: {
                    requireLogin:false
                   }

               }
             })
            //EstadoDetail
            .state('razaDetail',{
              url:'/{razaId:int}/detail',
              parent:'razas',
              param:{
                  especiId:null
              },
              views:{
                  'listView':{
                       templateUrl: basePath+"raza.list.html"
                   }
                   ,detailView:{
                       templateUrl: basePath+"razaDetail.html",
                       controller:'razaDetailCtrl',
                       controllerAs: 'Crtl'
                   }
              },
              data: {
                    requireLogin: false
                   }

              
            })
               .state('razaEdit',
            {
               url:'/edit/{razaId:int}',
              parent:'razas',
              param:{
                  razaId:null
              },
               views:
               {
                   'listView':{
                      templateUrl: basePath+"raza.list.html"
                   },
                   detailView:{
                   templateUrl: basePath + "/update/raza.edit.html",
                   controller:'razaeditCtrl',
                   controllerAs: 'Crtl'
                   }
                           
               },
               data: {
                    requireLogin: true,
                    roles: ['admin']
                 }

     
         })
           .state('razaDelete',
            {
               url:'/delete/{razaId:int}',
              parent:'razas',
              param:{
                  razaId:null
              },
               views:
               {
                   'listView':{
                      templateUrl: basePath+"raza.list.html"
                   },
                   detailView:{
                   templateUrl: basePath + "/delete/raza.delete.html",
                   controller:'razaDeleteCtrl',
                   controllerAs: 'Crtl'
                   }
                           
               },
               data: {
                    requireLogin: true,
                    roles: ['admin']
                   }

     
         })         
            //Estado de registro 
             .state('razacreate', 
            {
             url:'/registrar',
             parent:'razas',
             views:
              {
                'listView':{
                       templateUrl: basePath+"raza.list.html"
                   },  
               'detailView':
                {
                   templateUrl: basePath + "/new/raza.create.html",
                   controller:'razacreateCtrl',
                   controllerAs: 'Crtl'
                }
              },
              data: {
                    requireLogin: true,
                    roles: ['admin']
                   }

         });
         
        }
 
    ]);
})(window.angular);