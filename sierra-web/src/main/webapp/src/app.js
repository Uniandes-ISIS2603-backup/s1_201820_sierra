(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        // Internal modules dependencies       
        'sierraModule',
        //Juan Sanchez
        'especieModule',
        'mascotaModule',
        'mascotaadopModule',
        'loginModule',
        //Esteban
        'clienteModule',
        'mediosDePagoModule',
        //Jhonatan
        'facturaModule',
        'comprobanteModule',
        //Rodrigo
        'certificadoModule',
        'razaModule',
        //Juan David
         'adquisicionModule',
         'calificacionModule',
         'mascotaVentaModule',
        //Julio 
        'acontecimientoModule',
        'publicacionModule'
    ]);
     
      // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);

    //Corre bloque inicial
    app.run(['$rootScope', '$transitions', function ($rootScope, $transitions) {

            $transitions.onSuccess({to: '*'}, function (trans) {

                var $state = trans.router.stateService;
                var requireLogin = $state.current.data.requireLogin;
                var roles = $state.current.data.roles;
               

                /**
                 * @ngdoc function
                 * @name isAuthenticated
                 * @methodOf mainApp.module:mainApp
                 * @description Esta función define si el usuario se encuentra
                 * dentro de su cuenta.
                 * @returns {Boolean} Verdadero si está dentro de su cuenta.
                 */
                $rootScope.isAuthenticated = function () {
                    if (sessionStorage.getItem("user") != null) {
                        $rootScope.currentUser = sessionStorage.getItem("nombre");
                        return true;
                    } else {
                        return false;
                    }
                };
                
                /**
                 * @ngdoc function
                 * @name hasPermissions
                 * @methodOf mainApp.module:mainApp
                 * @description Esta función define si el usuario tiene permisos
                 * para acceder a la aplicación.
                 * @returns {Boolean} Verdadero si el usuario tiene permisos.
                 */
                $rootScope.hasPermissions = function () {
                    if (($rootScope.isAuthenticated) && (roles.indexOf(sessionStorage.getItem("rol")) > -1)) {
                        return true;
                    } else {
                        return false;
                    }
                };

                if (requireLogin && (sessionStorage.getItem("user") == null)) {
                    event.preventDefault();
                    $state.go('login', $state.params);
                }

            });

        }]);
})(window.angular);
