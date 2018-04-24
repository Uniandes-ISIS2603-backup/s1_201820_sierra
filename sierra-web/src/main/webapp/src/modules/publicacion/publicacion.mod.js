(function(ng){ 
 var mod = ng.module("publicacionModule", ['ui.router']) ;
  mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider){
          var basePath = "src/modules/publicacion/";
          $urlRouterProvider.otherwise("/publicacionList");
          $stateProvider.state('publicacionList',{
          url :'/publicacion/list',
          views :{
          'mainView': {
                        templateUrl: basePath + 'publicacion.list.html',
                        controller: 'publicacionCtrl',     
                        controllerAs: 'ctrl'
                       }
              }
          });
  }
  ]);
} )(window.angular);

