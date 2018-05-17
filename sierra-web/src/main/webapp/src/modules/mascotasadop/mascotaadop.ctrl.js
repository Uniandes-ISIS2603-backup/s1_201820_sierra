(function(ng){
    
    var mod=ng.module('mascotaadopModule');
    mod.constant('mascotaaContext','api/mascotasAdoptadas');
    mod.controller('mascotaaCtrl',['$scope','$http','mascotaaContext',
            function($scope, $http, mascotaaContext){
            // carga las entidades de especie
            $http.get(mascotaaContext).then(function (response) {
                 $scope.mascotaaRecords = response.data;
            });
    }]);
    
})(window.angular);




