(function(ng)
{
    var mod = ng.module("facturaModule");
    mod.constant("facturaContext","api/facturas");
    mod.controller('facturaCreateCtrl',['$scope','$http','facturaContext','$state','$rootScope',
        function($scope,$http,facturaContext,$state,$rootScope){
            $rootScope.edit = false;
           $scope.data = {};
            $scope.createFactura = function()
            {
               $http.post(facturaContext, $scope.data).then(function(response){
                   $state.go('facturaList',{facturaId: response.data.id}, {reload:true});
               }); 
            };
        }
        
    ]);
}
)(window.angular);


