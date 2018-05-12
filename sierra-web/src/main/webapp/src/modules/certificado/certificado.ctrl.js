(function(ng){
    
    var mod=ng.module('razaModule');
    mod.constant('razaContext','api/razas');
    mod.controller('razaCtrl',['$scope','$http','razaContext',
            function($scope, $http, razaContext,$state,$filter){
            // carga las entidades de especie
            $http.get(razaContext).then(function (response) {
                $scope.razasRecords = response.data;
            });
    }]);
    
})(window.angular);

