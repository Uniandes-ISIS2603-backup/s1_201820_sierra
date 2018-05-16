(function (ng) {

    var mod = ng.module('mascotaVentaModule', []);
    mod.constant('mascotaVentaContext', 'api/mascotasVenta');
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider)
        {
            var basePath = 'src/modules/mascotasVenta/';
            $urlRouterProvider.otherwise("/mascotasVentaList");
            $stateProvider.state('mascotasVenta', {
                url: '/mascotasVenta',
                abstrac: true,
                views:
                        {
                            mainView: {
                                templateUrl: basePath + "mascotaVenta.html",
                                controller: 'mascotaVentaCtrl',
                                controllerAs: 'Crtl'
                            }
                        }
            }).state('mascotasVentaList',
                    {
                        url: '/mascotasVenta',
                        parent: 'mascotasVenta',
                        views: {
                            'listView': {
                                templateUrl: basePath + 'mascotaVenta.list.html',
                                controller: 'mascotaVentaCtrl',
                                controllerAs: 'Ctrl'
                            }
                        }
                    })//EstadoDetail
                    .state('mascotaVentaDetail', {
                        url: '/{mascotaId:int}/detail',
                        parent: 'mascotasVenta',
                        param: {
                            mascotaId: null
                        },
                        views: {
                            'listView': {
                                templateUrl: basePath + "mascotaVenta.list.html"
                            }
                            , detailView: {
                                templateUrl: basePath + "mascotaVentaDetail.html",
                                controller: 'mascotaVentaDetailCtrl',
                                controllerAs: 'Crtl'
                            }
                        }

                    }).state('mascotaVentaEdit',
                    {
                        url: '/edit/{mascotaId:int}',
                        parent: 'mascotasVenta',
                        param: {
                            mascotaId: null
                        },
                        views:
                                {
                                    'listView': {
                                        templateUrl: basePath + "mascotaVenta.list.html"
                                    },
                                    detailView: {
                                        templateUrl: basePath + "/update/mascota.edit.html",
                                        controller: 'mascotaVentaEditCtrl',
                                        controllerAs: 'Crtl'
                                    }

                                }

                    }).state('mascotaVentaDelete',
                    {
                        url: '/delete/{mascotaId:int}',
                        parent: 'mascotasVenta',
                        param: {
                            mascotaId: null
                        },
                        views:
                                {
                                    'listView': {
                                        templateUrl: basePath + "mascotaVenta.list.html"
                                    },
                                    detailView: {
                                        templateUrl: basePath + "/delete/mascota.delete.html",
                                        controller: 'mascotaVentaDeleteCtrl',
                                        controllerAs: 'Crtl'
                                    }

                                }

                    })   //Estado de registro 
                    .state('mascotaVentaCreate',
                            {
                                url: '/registrar',
                                parent: 'mascotasVenta',
                                views:
                                        {
                                            'listView': {
                                                templateUrl: basePath + "mascotaVenta.list.html"
                                            },
                                            'detailView':
                                                    {
                                                        templateUrl: basePath + "/new/mascota.create.html",
                                                        controller: 'mascotaVentaCreateCtrl',
                                                        controllerAs: 'Crtl'
                                                    }
                                        }
                            });

        }]);
})(window.angular);