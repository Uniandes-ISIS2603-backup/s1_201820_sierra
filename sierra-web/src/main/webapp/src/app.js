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
})(window.angular);
