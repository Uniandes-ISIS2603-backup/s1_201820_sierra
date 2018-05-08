(function(ng)
{   
    var modulo = ng.module("publicacionModule");
    modulo.constant("publicacionContext", "api/publicaciones");
    modulo.controller('publicacionCtrl', ['$scope', '$http', 'publicacionContext',
                      function($scope, $http, publicacionContext)
                      {
                      $http.get(publicacionContext).then(function (response) {
                       $scope.publicaciones = response.data;
            });
} 
]);
})(window.angular);


