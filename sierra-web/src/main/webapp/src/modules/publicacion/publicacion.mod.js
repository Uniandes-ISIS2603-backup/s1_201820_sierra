(function(ng){ 
 var mod = ng.module("publicacionModule", ['ui.router']) ;
  mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider){
          var basePath = "src/modules/publicacion/";
          $urlRouterProvider.otherwise("/publicacionList");
          $stateProvider.state('publicaciones', {
              url: '/publicaciones',
              views:{
                  'mainView':{
                      templateUrl : basePath + 'publicacion.html',
                      controller: 'publicacionCtrl',
                      controllerAs: 'ctrl'
                  }
              }
          })
                  .state('publicacionList',{
          url :'/publicacion/list',
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
                      templateUrl: basePath + 'publicacion.create.html',
                      controller:'publicacionCtrl',
                      controllerAs:'ctrl'
                  }
              }
                      
          });
  }
  ]);
} )(window.angular);

