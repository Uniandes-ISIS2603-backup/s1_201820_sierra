(function(ng){
   var mod=ng.module('mascotaadopModule');
   mod.constant=('mascotaadopContext','api/mascotas');
   mod.controller('mascotaadopCtrl',['$scope', '$http','mascotaadopContext',
       function($scope, $http, $mascotaadopContext){
           $http.get('data/mascotaadop.json').then(function(response)
           {
               $scope.mascotaadopRecords=response.data;
           });
       }
    ]);
})(window.angular);




