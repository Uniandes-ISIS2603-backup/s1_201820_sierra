(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
       
        // Internal modules dependencies       
        'sierraModule',
        'especieModule',
        'mascotaModule',
        'calificacionModule',
        'facturaModule',
<<<<<<< HEAD
        'mascotaadopModule'
=======
        'adquisicionModule'
>>>>>>> b72ec8ebbb20e94f4d2bdf71d46565c4911e4ec4

    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);
