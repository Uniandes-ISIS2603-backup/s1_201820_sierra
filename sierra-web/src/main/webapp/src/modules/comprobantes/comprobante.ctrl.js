(function(ng){
        var mod = ng.module('comprobanteModule');
        mod.constant=('comprobanteContext','api/comprobantes');
        mod.controller('comprobanteCtrl',['$scope','$http','comprobanteContext',
        function($scope,$http, $comprobanteContext){
            $http.get('data/comprobantes.json').then(function(response)
            {
                $scope.comprobanteRecords=response.data;
            });
        }
    ]);
})(window.angular);

