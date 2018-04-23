(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
       
        // Internal modules dependencies       
        'sierraModule',
        'especieModule',
        'mascotaModule',
        'mascotaadopModule',
        'calificacionModule',
        'facturaModule',
        'adquisicionModule',
        'clienteModule'
    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);
