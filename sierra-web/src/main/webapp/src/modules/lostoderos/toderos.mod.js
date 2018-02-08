(function (ng) {
var mod = ng.module("SierraModule", []);
    mod.constant("SierraContext", "api/Sierra");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/Sierra/';
            $urlRouterProvider.otherwise("/SierraList");

            $stateProvider.state('SierraList', {
                url: '/Sierra',
                views: {
                    'mainView': {
                        controller: 'SierraCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'Sierra.list.html'
                    }
                }
            }).state('SierraCreate', {
                url: '/Sierra/create',
                views: {
                    'mainView': {
                        controller: 'SierraCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'Sierra.create.html'
                    }
                }

            }).state('SierraEdit', {
                url: '/Sierra/:SierraId',
                param: {
                    SierraId: null
                },
                views: {
                    'mainView': {
                        controller: 'SierraCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'Sierra.create.html'
                    }
                }
            });
        }]);

})(window.angular);

