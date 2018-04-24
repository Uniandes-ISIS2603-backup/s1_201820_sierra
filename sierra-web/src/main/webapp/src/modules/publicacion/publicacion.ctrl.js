(function(ng){
    
    var modulo = ng.module("publicacionModule");
    modulo.constant("publicacionContext", "api/publicaciones");
    modulo.controller('publicacionCtrl', ['$scope', '$http', 'publicacionContext',
                      function($scope, $http, publicacionContext)
                      {
                       $scope.publicaciones = {};
                       $http.get('data/publicaciones.json').then(function (response) 
                                                                   {
                                                                    $scope.publicaciones = response.data;   
                                                                   }
                                                                   );
} 
]);
})(window.angular);


