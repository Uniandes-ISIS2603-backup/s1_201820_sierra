(function(ng){
 
 var mod=ng.module('certificadoModule',[]);
 mod.constant('certificadoContext','api/certificados');
 mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
         var basePath = 'src/modules/certificado/';
         $urlRouterProvider.otherwise("/certificadosList");
         $stateProvider.state('certificados',{
             url:'/certificados',
             abstrac:true,
             views:
                     {
                       mainView:{
                       templateUrl: basePath+"certificados.html",
                       controller:'certificadoCtrl',
                       controllerAs: 'Crtl'
                         }
                     },
                 data: {
                    requireLogin: true,
                     roles: ['admin']
                   }
             })
                     
               //Estado de lista
                .state('certificadosList',{
               url: '/list',
               parent: 'certificados',
               views:{
                   'listView':{
                       templateUrl: basePath+"certificado.list.html",
                       controller:'certificadoCtrl',
                       controllerAs: 'Crtl'
                   }
               },
                data: {
                    requireLogin: false
                }
             })
            //EstadoDetail
            .state('certificadoDetail',{
              url:'/{certificadoId:int}/detail',
              parent:'certificados',
              param:{
                  especiId:null
              },
              views:{
                  'listView':{
                       templateUrl: basePath+"certificado.list.html"
                   }
                   ,detailView:{
                       templateUrl: basePath+"certificadoDetail.html",
                       controller:'certificadoDetailCtrl',
                       controllerAs: 'Crtl'
                   }
              },
                data: {
                    requireLogin: false
                }
              
            })
               .state('certificadoEdit',
            {
               url:'/edit/{certificadoId:int}',
              parent:'certificados',
              param:{
                  certificadoId:null
              },
               views:
               {
                   'listView':{
                      templateUrl: basePath+"certificado.list.html"
                   },
                   detailView:{
                   templateUrl: basePath + "/update/certificado.edit.html",
                   controller:'certificadoeditCtrl',
                   controllerAs: 'Crtl'
                   }
                           
               },
                 data: {
                    requireLogin: true,
                     roles: ['admin']
                   }
     
         })
           .state('certificadoDelete',
            {
               url:'/delete/{certificadoId:int}',
              parent:'certificados',
              param:{
                  certificadoId:null
              },
               views:
               {
                   'listView':{
                      templateUrl: basePath+"certificado.list.html"
                   },
                   detailView:{
                   templateUrl: basePath + "/delete/certificado.delete.html",
                   controller:'certificadoDeleteCtrl',
                   controllerAs: 'Crtl'
                   }
                           
               },
                 data: {
                    requireLogin: true,
                     roles: ['admin']
                   }
     
         })         
            //Estado de registro 
             .state('certificadocreate', 
            {
             url:'/registrar',
             parent:'certificados',
             views:
              {
                'listView':{
                       templateUrl: basePath+"certificado.list.html"
                   },  
               'detailView':
                {
                   templateUrl: basePath + "/new/certificado.create.html",
                   controller:'certificadocreateCtrl',
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