(function(ng){
   var mod=ng.module('mascotaModule');
   mod.constant=('mascotaContext','api/mascotas');
   mod.controller('mascotaCtrl',['$scope', '$http','mascotaContext',
       function($scope, $http, $mascotaContext){
           $http.get('data/mascotaadop.json').then(function(response)
           {
               $scope.mascotaRecords=response.data;
           });
       }
    ]);
})(window.angular);




