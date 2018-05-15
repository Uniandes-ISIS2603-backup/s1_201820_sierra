(function(ng){
    
    var mod=ng.module('mascotaVentaModule');
    mod.constant('mascotaVentaContext','api/mascotasVenta');
    mod.controller('mascotaVentaCtrl',['$scope','$http','mascotaVentaContext',
            function($scope, $http, mascotaVentaContext,$state,$filter){
            // carga las entidades de especie
            $http.get(mascotaVentaContext).then(function (response) {
                $scope.mascotaVentaRecords = response.data;
            });
    }]);
    
})(window.angular);




