(function (ng) {
var mod = ng.module("sierraModule", []);
    mod.constant("sierraContext", "api/sierras");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/sierra/';
            $urlRouterProvider.otherwise("/sierraList");

            $stateProvider.state('sierraList', {
                url: '/sierra',
                views: {
                    'mainView': {
                        controller: 'sierraCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'sierra.list.html'
                    }
                }
            }).state('sierraCreate', {
                url: '/sierra/create',
                views: {
                    'mainView': {
                        controller: 'sierraCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'sierra.create.html'
                    }
                }

            }).state('sierraEdit', {
                url: '/sierra/:sierraId',
                param: {
                    sierraId: null
                },
                views: {
                    'mainView': {
                        controller: 'sierraCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'sierra.create.html'
                    }
                }
            });
        }]);

})(window.angular);

