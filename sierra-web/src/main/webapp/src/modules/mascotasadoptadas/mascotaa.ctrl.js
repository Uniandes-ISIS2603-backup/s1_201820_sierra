(function(ng){
   var mod=ng.module('mascotaaModule');
   mod.constant=('mascotaaContext','api/mascotasa');
   mod.controller('mascotaaCtrl',['$scope', '$http','mascotaaContext',
       function($scope, $http, $mascotaaContext){
           $http.get('data/mascotaa.json').then(function(response)
           {
               $scope.mascotaaRecords=response.data;
           });
       }
    ]);
})(window.angular);




