(function (ng) {
    var mod = ng.module("publicacionModule");
    mod.constant("publicacionContext", "api/publicaciones");
    mod.controller('publicacionUpdateCtrl', ['$scope', '$http', 'publicacionContext', '$state', '$rootScope',  
        function ($scope, $http ,publicacionContext ,$state ,$rootScope) {
            $rootScope.edit = true;
            $scope.data = {};
            $scope.selectedItems = [];
            $scope.availableItems = [];
            var publicacionId = $state.params.publicacionId;
            $http.get(publicacionContext + '/' + publicacionId).then(function (response) {
                var auxiliar = response.data;
                $scope.data.fecha = auxiliar.fecha;
                $scope.data.tipo = auxiliar.tipo;
                $scope.data.comentario= auxiliar.comentario;
                $scope.data.fotoURL = auxiliar.fotoURL; 
            });
            $scope.updatePublicacion = function () {
                $http.put(publicacionContext + "/" + publicacionId, $scope.data).then(function (response) 
                {
                    $state.go('publicacionList', {publicacionId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);


