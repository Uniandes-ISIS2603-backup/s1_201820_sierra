(function (ng){
    var mod = ng.module("mediosDePagoModule",['ui.router']);
    mod.constant("mediosDePagoContext", "api/mediosDePago");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider){
            
            var basePath = 'src/modules/mediosDePago/';
            $urlRouterProvider.otherwise("/mediosDePagoList");
            
            $stateProvider.state('mediosDePago', {
                url: '/mediosDePago',
                  abstrac:true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'mediosDePago.html',
                        controller: 'mediosDePagoCtrl'
                    }
                },
                    data: {
                        requireLogin: true,
                        roles: ['admin','cliente']
                    }   
            }).state('mediosDePagoList',{
               url: '/List',
               parent: 'mediosDePago',
               views:{
                   'listView':{
                       templateUrl: basePath+"mediosDePago.list.html",
                       controller:'mediosDePagoCtrl'
                   }
               },
                    data: {
                        requireLogin: true,
                        roles: ['cliente','admin']
                    }
             })
            .state ('mediosDePagoCreate', {
                url:'/mediosDePago/create',
                views: {
                    'mainView':{
                        controller: 'mediosDePagoNewCtrl',
                        templateUrl: basePath + 'mediosDePago.create.html'
                    }
                },
                    data: {
                        requireLogin: true,
                        roles: ['admin']
                    }
            }).state('mediosDePagoDetail', {
                url: '/{mediosDePagoId:int}/detail',
                parent: 'mediosDePago',
                param: {
                    mediosDePagoId: null
                },
                views: {
                    'listView':{
                       templateUrl: basePath+"mediosDePago.list.html"
                   },
                    'detailView': {
                        templateUrl: basePath + 'mediosDePago.detail.html',
                        controller: 'mediosDePagoDetailCtrl'
                       
                    }
                },
                    data: {
                        requireLogin: true,
                        roles: ['cliente','admin']
                    }
            }).state('mediosDePagoDelete', {
                url:'/{mediosDePagoId:int}/delete',
                parent:'mediosDePago',
                param:{
                    mediosDePagoId:null
                },
                views:{
                    'listView':{
                      templateUrl: basePath+"mediosDePago.list.html",
                      controller:'deleteMediosDePagoCtrl',
                      controllerAs:'ctrl'
                   }
                },
                    data: {
                        requireLogin: true,
                        roles: ['admin']
                    }
            }).state('mediosDePagoUpdate', {
                url:'/{mediosDePagoId:int}/update',
                parent:'mediosDePago',
                param:{
                    mediosDePagoId:null
                },
                views:{
                    'detailView':{
                      templateUrl: basePath + 'mediosDePago.create.html',
                      controller:'mediosDePagoUpdateCtrl'
                   }
                },
                    data: {
                        requireLogin: true,
                        roles: ['admin']
                    }
            });
        }]);
})(window.angular);


