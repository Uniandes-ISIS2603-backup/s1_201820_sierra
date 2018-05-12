(function(ng){ 
 var mod = ng.module("publicacionModule", ['ui.router']) ;
  mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider){
          var basePath = "src/modules/publicacion/";
          $urlRouterProvider.otherwise("/publicaciones");
          $stateProvider.state('publicaciones', {
              url: '/publicaciones',
              abstrac:true,
              views:{
                  'mainView':{
                      templateUrl : basePath + 'publicacion.html',
                      controller: 'publicacionCtrl',
                      controllerAs: 'ctrl'
                  }
              }
          })
                  .state('publicacionList',{
          url :'/publicaciones/list',
          views :{
          'mainView': {
                        templateUrl: basePath + 'list/publicacion.list.html',
                        controller: 'publicacionCtrl',     
                        controllerAs: 'ctrl'
                       }
              }
          })
                  .state('publicacionCreate',{
                      url: '/publicacion/create',
              views:{
                  'mainView':{
                      templateUrl: basePath + 'create/publicacion.create.html',
                      controller:'publicacionCreateCtrl',
                      controllerAs:'ctrl'
                  }
              }
                      
          })
          .state('publicacionUpdate', {
                url:'/publicacion/{publicacionId:int}/update',
                param:{
                   publicacionId:null
                },
                views:{
                    'mainView':{
                      templateUrl: basePath + 'update/publicacion.update.html',
                      controller:'publicacionUpdateCtrl'
                   }
                }
            });
  }
  ]);
} )(window.angular);

