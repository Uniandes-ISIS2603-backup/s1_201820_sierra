(function(ng){
    
    var mod=ng.module('especieModule');
    mod.constant('especieContext','api/especies');
    mod.controller('especieCtrl',['$scope','$state','$stateParams', '$http','especieContext', 
            function($scope, $state, $stateParams, $http, especieContext){
           
             // inicialmente el listado de entidades de especies está vacio   
             $scope.records={};
            
            // carga las entidades de especie
            $http.get('data/especie.json').then(function (response) {
                $scope.especiesRecords = response.data;
            });
    }]);
    
})(window.angular);

