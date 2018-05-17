(function (ng) {
    var mod = ng.module("publicacionModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = "src/modules/publicacion/";
            $urlRouterProvider.otherwise("/publicacionList");
            $stateProvider.state('publicacionDelete', {
                url: '/publicacion/{publicacionId:int}/delete',
                param: {
                    publicacionId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + "delete/publicacion.delete.html",
                        controller: 'publicacionDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                    data: {
                        requireLogin: true,
                        roles: ['cliente','admin']
                    }
            }
            )
                    .state('publicaciones', {
                        url: '/publicaciones',
                        abstrac: true,
                        views: {
                            'mainView': {
                                templateUrl: basePath + 'publicacion.html',
                                controller: 'publicacionCtrl',
                                controllerAs: 'ctrl'
                            }
                        },
                    data: {
                        requireLogin: true,
                        roles: ['cliente','admin']
                    }
                    })
                    .state('publicacionList', {
                        url: '/publicaciones/list',
                        views: {
                            'mainView': {
                                templateUrl: basePath + 'list/publicacion.list.html',
                                controller: 'publicacionCtrl',
                                controllerAs: 'ctrl'
                            }
                        },
                    data: {
                        requireLogin: true,
                        roles: ['cliente','admin']
                    }
                    })
                    .state('publicacionCreate', {
                        url: '/publicacion/create',
                        views: {
                            'mainView': {
                                templateUrl: basePath + 'create/publicacion.create.html',
                                controller: 'publicacionCreateCtrl',
                                controllerAs: 'ctrl'
                            }
                        },
                    data: {
                        requireLogin: true,
                        roles: ['cliente','admin']
                    }

                    })
                    .state('publicacionUpdate', {
                        url: '/publicacion/{publicacionId:int}/update',
                        param: {
                            publicacionId: null
                        },
                        views: {
                            'mainView': {
                                templateUrl: basePath + 'update/publicacion.update.html',
                                controller: 'publicacionUpdateCtrl'
                            }
                        },
                    data: {
                        requireLogin: true,
                        roles: ['cliente','admin']
                    }
                    });
        }
    ]);
})(window.angular);

