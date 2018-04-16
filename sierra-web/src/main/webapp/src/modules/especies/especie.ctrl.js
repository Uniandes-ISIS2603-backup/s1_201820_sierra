(function(ng){
    
    var mod=ng.module('especieModule');
    mod.constant('especieContext','api/especies');
    mod.controller('especieCtrl',['$scope','$http','especieContext', 
            function($scope, $http, especieContext){
            // carga las entidades de especie
            $http.get("data/especie.json").then(function (response) {
                $scope.especiesRecords = response.data;
            });
    }]);
    
})(window.angular);

