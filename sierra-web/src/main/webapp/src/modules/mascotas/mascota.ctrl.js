(function(ng){
   var mod=ng.module('mascotaModule');
   mod.constant=('mascotaaContext','api/mascotasAdoptadas','mascotaVentaContext','api/mascotasVenta');
   mod.controller('mascotaCtrl',['$scope', '$http','mascotaaContext','mascotaVentaContext',
       function($scope, $http, mascotaaContext,mascotaVentaContext){
           
           $http.get(mascotaaContext).then(function (response) {
                $scope.mascotaaRecords = response.data;
            });
           
             $http.get(mascotaVentaContext).then(function (response) {
                $scope.mascotaVentaRecords = response.data;
            });
            
       }
    ]);
})(window.angular);




