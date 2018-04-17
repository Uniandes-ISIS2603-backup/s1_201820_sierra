(function(ng){
   var mod=ng.module('facturaModule');
   mod.constant=('facturaContext','api/facturas');
   mod.controller('facturaCtrl',['$scope', '$http','facturaContext',
       function($scope, $http, $facturaContext){
           $http.get('data/facturas.json').then(function(response)
           {
               $scope.facturaRecords=response.data;
           });
       }
    ]);
})(window.angular);


