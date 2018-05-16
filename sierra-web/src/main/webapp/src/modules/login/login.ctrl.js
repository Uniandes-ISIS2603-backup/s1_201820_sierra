(function (ng) {
    var mod = ng.module("loginModule");
    mod.controller('loginCtrl', ['$scope', '$http', '$state', '$rootScope',
       function ($scope, $http, $state, $rootScope) {

            $scope.user = {};
            $scope.data = {};
            
            $http.get('data/usuarios.json').then(function (response) {
                $scope.users = response.data;
       
            });
            
            //Validacion de la informacion ingresada
               $scope.autenticar = function () {
                var flag = false;
                  for (var item in $scope.users) {
                    if ($scope.users[item].user === $scope.data.user && $scope.users[item].password === $scope.data.password && $scope.users[item].rol === $scope.data.rol) {
                        flag = true;
                        $scope.user = $scope.users[item];
                        $state.go('especiesList', {}, {reload: true});
                        break;
                    }
                }
                    if (!flag) {
                    $rootScope.alerts.push({type: "danger", msg: "Incorrect username or password."});
                } else {
                    sessionStorage.token = $scope.user.token;
                    sessionStorage.setItem("user", $scope.user.user);
                    sessionStorage.setItem("nombre", $scope.user.nombre);
                    sessionStorage.setItem("rol", $scope.user.rol);
                    $rootScope.currentUser = $scope.user.nombre; 
                }
            };
            
                
        }
    ]);
}
)(window.angular);

