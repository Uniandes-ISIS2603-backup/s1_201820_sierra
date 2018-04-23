(function(ng){
    
    var mod=ng.module('acontecimientosModule');
    mod.constant('acontecimientosContext','api/acontecimientos');
    mod.controller('acontecimientosCtrl',['$scope','$http','acontecimientosContext', 
            function($scope, $http, acontecimientosContext){
            // carga las entidades de acontecimientos
            $http.get("data/acontecimientos.json").then(function (response) {
                $scope.acontecimientosRecords = response.data;
           
            });
    }]);
    
})(window.angular);
