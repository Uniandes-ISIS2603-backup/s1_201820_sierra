(function(ng){
    
    var mod=ng.module('certificadoModule');
    mod.constant('certificadoContext','api/certificados');
    mod.controller('certificadoCtrl',['$scope','$http','certificadoContext',
            function($scope, $http, certificadoContext,$state,$filter){
            // carga las entidades de especie
            $http.get(certificadoContext).then(function (response) {
                $scope.certificadosRecords = response.data;
            });
    }]);
    
})(window.angular);

