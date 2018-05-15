/*REINICIO DE LAS  TABLAS */
delete from SierraEntity;
delete from AcontecimientoEntity;
delete from PublicacionEntity;
delete from MedioDePagoEntity;
delete from CalificacionEntity;
delete from AdquisicionEntity;
delete from ComprobanteEntity;
delete from FacturaEntity;
delete from MascotaAdoptadaEntity;
delete from MascotaVentaEntity;
delete from CertificadoEntity;
delete from MascotaEntity;
delete from ClienteEntity;
delete from MEDIODEPAGOENTITY_CLIENTEENTITY;
delete from RazaEntity;
delete from EspecieEntity;

/*ESPECIES*/
    /*ESPECIE QUE MODELA CANINOS*/
insert into EspecieEntity(id,nombre, caracteristicas, clasificacion,imagen) values (111, 'Canino', 'Los mejores amigos del hombre, descendientes de los lobos, juguetones y muy amigables', 'Mamifero','recursos/img/siluetaPerro.png');
    /*ESPECIE QUE MODELA FELINOS*/
insert into EspecieEntity(id, nombre, caracteristicas, clasificacion,imagen) values (112, 'Felino', 'Poseen un cuerpo esbelto, oído agudo, hocico corto y excelente vista. Son los mamíferos cazadores más sigilosos.', 'Mamifero','recursos/img/siluetaGato.png');
    /*ESPECIE QUE MODELA AVES*/
insert into EspecieEntity(id, nombre, caracteristicas, clasificacion,imagen) values (114, 'Ave','  mientras que las extremidades anteriores están modificadas como alas que, al igual que muchas otras características anatómicas únicas que les permiten, en la mayoría de los casos, volar, pero no todas vuelan. Tienen el cuerpo recubierto de plumas', 'Ave','recursos/img/siluetaAve.png');
    /*ESPECIE QUE MODELA PECES*/ 
insert into EspecieEntity(id, nombre, caracteristicas, clasificacion,imagen) values (115, 'Pez','generalmente ectotérmicos y con respiración por branquias. Suelen estar recubiertos por escamas, y están dotados de aletas y branquias, con las que captan el oxígeno disuelto en el agua. ', 'Pez','recursos/img/siluetaPez.png');

/*RAZAS*/

                                                               /*CANINOS*/
    /*RAZA QUE MODELA LOS LOBOS SIBERIANOS*/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(111,'Husky Siberiano','Perros con rasgos de sus ancestros los lobos con un pelaje de color combinado','Su pelaje y cadera','fieles, activos y juguetones',111);
    /*RAZA QUE MODELA LOS Golden Retriever*/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(112,'Golden Retriever','Pelo dorado, amigables','Ninguno','consentidos, tiernos y juguetones',111);
    /*RAZA QUE MODELOA LOS SAMOYEDO*/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(113,'Samoyedo','Pelaje blanco y apachurrable','Su pelaje','Tiernos  y tienen un animo agradable',111);
    /*RAZA QUE MODELA LOS PASTOR ALEMAN*/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(114,'Pastor Aleman','Grandes y asociados a ser perros policia','Su tamaño','Independiente',111);
  /*RAZA QUE MODELA LOS ALASKA MALAMUT*/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(115,'Alaska Malamut','Grandes peludos similares a los siberianos  sin emabrgo son mas grandes ','Su tamaño','Independiente',111);
  /*RAZA QUE MODELA LOS ROTTWEILER*/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(116,'Rottweiler','Temibles por su cara y fuerza','Su tamaño','Independiente',111);
  /*RAZA QUE MODELA LOS CHOW CHOW*/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(117,'Chow Chow','Bolas de pelo cariñosas, muy tiernos','Su tamaño','Independiente',111);
  /*RAZA QUE MODELA LOS BORDER COLLIE*/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(118,'Border Collie','La intelligencia tiene su descripcion en este perro','Su tamaño','Independiente',111);
  /*RAZA QUE MODELA LOS BULL TERRIR*/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(119,'Bull Terrier','Asociados como los perros mas peligrosos son  grandes y fuertes','Su tamaño','Independiente',111);
  /*RAZA QUE MODELA LOS FOX  TERRIER*/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(120,'Fox Terrier','Una raza tierna y nueva para  compatir  momentos','Su tamaño','Independiente',111);

                                                            /*FELINOS*/
    /*RAZA QUE MODELA LOS GATOS SIAMES*/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(121,'Gato Siames','Rostro peculiar y colorido','Araña todo','Independiente',112);
    /*RAZA QUE MODELA LOS KORAT*/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(122,'Korat','Gordos y grises','Poco activo','Independiente',112);
    /*RAZA QUE MODELA LOS PIXIE BOB*/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(123,'Pixie Bob','Multicolor y agradable','Super','Independiente',112);
    /*RAZA QUE MODELA LOS GATOS PERSAS*/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(124,'Persa','internacionalmente blanco','Super','Independiente',112);
    /*RAZA QUE MODELA LOS RUSO AZUL*/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(125,'Ruso Azul','Gris y con un color de ojos  penetrante','Super','Independiente',112);


/*CLIENTES*/
insert into ClienteEntity(id, nombre, apellido, cedula, telefono, correo, contrasenia) values (111, 'Andres', 'Rodriguez', 1072585123, 3125225625, 'andres001@gmail.com', '123456789');
insert into ClienteEntity(id, nombre, apellido, cedula, telefono, correo, contrasenia) values (112, 'Durant', 'de Broke', 39548662, 3125225625, 'durantbroke@hotmail.com', '987654321');
insert into ClienteEntity(id, nombre, apellido, cedula, telefono, correo, contrasenia) values (113, 'Basile', 'Youle', 132254899, 3205485498, 'youle254@gmail.com', 'casa1234');
insert into ClienteEntity(id, nombre, apellido, cedula, telefono, correo, contrasenia) values (114, 'Hollis', 'Gair', 1069654987, 3125489699, 'gairhollis@hotmail.com', 'mascotas123');
insert into ClienteEntity(id, nombre, apellido, cedula, telefono, correo, contrasenia) values (115, 'Goodby', 'Knapp', 39265488, 3215448500, 'hnap2018@yahoo.com', 'perros2018');



/*MASCOTAS*/

        /*ADOPCION*/
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (112,'MascotaAdoptadaEntity','Kiba','Grande','Femenino',2,'recursos/img/siberiano.jpg','Negro y Blanco',0,1,'1/05/2016',111,111);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id,cliente_id) values (113,'MascotaAdoptadaEntity','Jacob','Grande','Masculino',3,'recursos/img/Siberiano2.jpg','Negro y Blanco',1,1,'6/23/2015',111,111,111);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (114,'MascotaAdoptadaEntity','Daju','Grande','Masculino',2,'recursos/img/siberiano3.jpg','Negro y Blanco',0,0,'3/12/2016',111,111);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (115,'MascotaVentaEntity','Deyeyiah','Grande','Masculino',4,'recursos/img/siberiano4.jpg','Negro y Blanco',0,0,'5/11/2014',111,111);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (116,'MascotaAdoptadaEntity','Zeus','Grande','Masculino',1,'recursos/img/Alaska.jpg','Blanco y negro',0,0,'6/03/2017',111,115);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (117,'MascotaVentaEntity','Luna','Mediana','Femenino',2,'recursos/img/border.jpg','Blanco negro',0,1,'5/05/2016',111,118);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id,cliente_id) values (118,'MascotaAdoptadaEntity','Magdalena','Mediana','Femenino',1,'recursos/img/border2.jpg','Blanco y negro',1,0,'6/11/2017',111,118,112);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (119,'MascotaAdoptadaEntity','Matias','Pequeño','Masculino',2,'recursos/img/border3.jpg','Blanco y negro',0,0,'12/02/2016',111,118);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (120,'MascotaAdoptadaEntity','Blanca','Mediana','Femenino',1,'recursos/img/bull.jpg','blanco',0,0,'6/23/2017',111,119);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id,cliente_id) values (121,'MascotaVentaEntity','Perro','Mediana','Maculino',1,'recursos/img/bull2.jpg','blanco',1,0,'6/23/2017',111,119,111);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (122,'MascotaAdoptadaEntity','Rocko','Mediana','Masculino',1,'recursos/img/bull3.jpg','blanco',0,1,'6/23/2017',111,119);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id,cliente_id) values (123,'MascotaVentaEntity','Bolita','Mediana','Femenino',1,'recursos/img/chow.jpg','dorado',1,1,'6/23/2017',111,117,113);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (124,'MascotaAdoptadaEntity','zorro','pequeño','Masculino',2,'recursos/img/fox.jpg','blanco dorado',0,0,'6/23/2017',111,120);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (125,'MascotaVentaEntity','Doradita','Mediana','Femenino',1,'recursos/img/golden.jpg','Dorado',0,0,'6/23/2017',111,112);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (126,'MascotaAdoptadaEntity','pastore','Mediano','Masculino',1,'recursos/img/pastor.jpg','dorado negro',0,0,'6/23/2017',111,114);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (127,'MascotaVentaEntity','Raka','Mediana','Femenino',3,'recursos/img/pastor2.jpg','dorado negro',0,1,'6/23/2017',111,114);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id,cliente_id) values (128,'MascotaAdoptadaEntity','Roto','Mediano','Masculino',1,'recursos/img/rott.jpg','dorado negro',1,0,'6/23/2017',111,116,113);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (129,'MascotaVentaEntity','Manco','Mediana','Masculino',1,'recursos/img/rott2.jpg','dorado negro',0,1,'6/23/2017',111,116);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (130,'MascotaAdoptadaEntity','Nieve','Mediana','Femenino',1,'recursos/img/samoyedo.jpg','dorado negro',0,0,'6/23/2017',111,113);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id,cliente_id) values (131,'MascotaVentaEntity','Thor','Mediano','Masculino',1,'recursos/img/samoyedo2.jpg','dorado negro',1,0,'6/23/2017',111,113,114);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id,cliente_id) values (132,'MascotaAdoptadaEntity','Turron','Pequeño','Masculino',1,'recursos/img/persa.jpg','Blanco',1,1,'6/23/2017',112,124,111);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (133,'MascotaVentaEntity','Thanos','pequeño','Masculino',1,'recursos/img/persa2.jpg','blanco',0,0,'6/23/1900',112,124);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (134,'MascotaAdoptadaEntity','Masco','pequeño','Masculino',1,'recursos/img/ruso.jpg','gris',0,0,'6/23/1900',112,125);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id,cliente_id) values (135,'MascotaVentaEntity','Vocado','pequeño','Masculino',1,'recursos/img/ruso2.jpg','gris',1,0,'6/23/1900',112,125,112);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (136,'MascotaAdoptadaEntity','Pex','pequeño','Masculino',1,'recursos/img/siames.jpg','multi color',0,0,'6/23/1900',112,121);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (137,'MascotaAdoptadaEntity','Trynda','pequeño','Masculino',1,'recursos/img/siames2.jpg','multi color',0,0,'6/23/1900',112,121);


/*ADOPTADAS*/
insert into MascotaAdoptadaEntity(id) values(112);
insert into MascotaAdoptadaEntity(id) values(113);
insert into MascotaAdoptadaEntity(id) values(114);
insert into MascotaAdoptadaEntity(id) values(116);
insert into MascotaAdoptadaEntity(id) values(118);
insert into MascotaAdoptadaEntity(id) values(119);
insert into MascotaAdoptadaEntity(id) values(120);
insert into MascotaAdoptadaEntity(id) values(122);
insert into MascotaAdoptadaEntity(id) values(124);
insert into MascotaAdoptadaEntity(id) values(126);
insert into MascotaAdoptadaEntity(id) values(128);
insert into MascotaAdoptadaEntity(id) values(130);
insert into MascotaAdoptadaEntity(id) values(132);
insert into MascotaAdoptadaEntity(id) values(134);
insert into MascotaAdoptadaEntity(id) values(136);
insert into MascotaAdoptadaEntity(id) values(137);

/*
*Insercion en la tabla Acontecimientos de la base de datos
*/
insert into AcontecimientoEntity (id, nombre, descripcion, fecha, importancia, tipo, fotoURL, mascotaAdopcion_Id) values (111,'Adopcion de Zeus', 'Dia en el que se adopto la mascota', '01/01/2015', 1, 'historico', 'recursos/img/samoyedo.jpg', 112);
insert into AcontecimientoEntity (id, nombre, descripcion, fecha, importancia, tipo, fotoURL, mascotaAdopcion_Id) values (112,'Zeus gana una competencia', 'Zeus y su dueno ganan una carrera de canicross', '01/08/2016', 1, 'historico', 'recursos/img/ZeusCompetencia.jpg', 116);
insert into AcontecimientoEntity (id, nombre, descripcion, fecha, importancia, tipo, fotoURL, mascotaAdopcion_Id) values (113,'Adopcion de Kiba', 'Dia en el que Kiba fue adoptado', '07/03/2014', 1, 'historico', 'recursos/img/siberiano.jpg', 114);
insert into AcontecimientoEntity (id, nombre, descripcion, fecha, importancia, tipo, fotoURL, mascotaAdopcion_Id) values (114,'Adopcion de Shiba', 'Dia en el que se adopto la mascota', '09/19/2017', 1, 'historico', 'recursos/img/labrador.jpg', 118);



/*VENTA*/
insert into MascotaVentaEntity(id, precio) values(115, 842872);
insert into MascotaVentaEntity(id, precio) values(117, 842872);
insert into MascotaVentaEntity(id, precio) values(121, 3123100);
insert into MascotaVentaEntity(id, precio) values(123, 842872);
insert into MascotaVentaEntity(id, precio) values(125, 3141410);
insert into MascotaVentaEntity(id, precio) values(127, 41241200);
insert into MascotaVentaEntity(id, precio) values(129, 32132131);
insert into MascotaVentaEntity(id, precio) values(131, 842872);
insert into MascotaVentaEntity(id, precio) values(133, 3213123);
insert into MascotaVentaEntity(id, precio) values(135, 312321312);

/*FACTURA*/
insert into facturaEntity(id, idCliente, nombreCliente, valor) values (100,111,'Andres', 20000);
insert into facturaEntity(id, idCliente, nombreCliente, valor) values (111,111,'Andres', 130000);
insert into facturaEntity(id, idCliente, nombreCliente, valor) values (112,111,'Andres', 130000);
insert into facturaEntity(id, idCliente, nombreCliente, valor) values (113,111,'Andres', 130000);
insert into facturaEntity(id, idCliente, nombreCliente, valor) values (114,112,'Andrdsadas', 130000);
insert into facturaEntity(id, idCliente, nombreCliente, valor) values (115,113,'Andredsadass', 130000);
insert into facturaEntity(id, idCliente, nombreCliente, valor) values (116,113,'dsadandres', 130000);
insert into facturaEntity(id, idCliente, nombreCliente, valor) values (117,114,'Adsdadsas', 130000);


/*<!--Añado las  adquisiciones a las tablas -->*/
insert into ADQUISICIONENTITY (id, fecha, valorTotal,cliente_id) values (101, '11/24/2017', 2146379,111);
insert into ADQUISICIONENTITY (id, fecha, valorTotal,cliente_id) values (102, '12/3/2017', 2843100,111);
insert into ADQUISICIONENTITY (id, fecha, valorTotal,cliente_id) values (103, '2/1/2018', 4617331,111);
insert into ADQUISICIONENTITY (id, fecha, valorTotal,cliente_id) values (104, '6/23/2017', 715105,111);
insert into ADQUISICIONENTITY (id, fecha, valorTotal,cliente_id) values (105, '11/12/2017', 2802294,113);
insert into ADQUISICIONENTITY (id, fecha, valorTotal,cliente_id) values (106, '12/9/2017', 3466209,112);
insert into ADQUISICIONENTITY (id, fecha, valorTotal,cliente_id) values (107, '1/24/2018', 3573395,112);
insert into ADQUISICIONENTITY (id, fecha, valorTotal,cliente_id) values (108, '3/8/2017', 4900605,113);



/*CALIFICACIONES*/
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor, adquisicion_id) values (101, 'Open-source modular help-desk', 'Statistician I', 3.41, 101);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor, adquisicion_id) values (102, 'Multi-channelled full-range knowledge base', 'Systems Administrator I', 3.83, 102);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor, adquisicion_id) values (103, 'Operative coherent matrix', 'Editor', 1.53, 103);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor, adquisicion_id) values (104, 'Robust dynamic structure', 'Administrative Assistant III', 1.04, 104);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor, adquisicion_id) values (105, 'Ameliorated systemic encryption', 'Staff Accountant II', 2.09, 105);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor, adquisicion_id) values (106, 'Seamless high-level website', 'VP Quality Control', 2.08, 106);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor, adquisicion_id) values (107, 'Customer-focused even-keeled secured line', 'Web Developer I', 2.54, 107);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor, adquisicion_id) values (108, 'Grass-roots disintermediate moderator', 'Electrical Engineer', 1.93, 108);

/*CERTIFICADOS*/
insert into CertificadoEntity(id, fecha, descripcion, imagen,mascotaventa_id) values (111, '01/02/2018', 'El perro cuenta con todas las vacunas', 'recursos/img/cer.jpg',115);
insert into CertificadoEntity(id, fecha, descripcion, imagen,mascotaventa_id) values (112, '03/03/2017', 'El perro cuenta con todas las vacunas', 'recursos/img/cer.jpg',117);
insert into CertificadoEntity(id, fecha, descripcion, imagen,mascotaventa_id) values (113, '11/04/2016', 'El perro cuenta con todas las vacunas', 'recursos/img/cer.jpg',121);
insert into CertificadoEntity(id, fecha, descripcion, imagen,mascotaventa_id) values (114, '11/05/2017', 'El perro cuenta con todas las vacunas', 'recursos/img/cer.jpg',123);
insert into CertificadoEntity(id, fecha, descripcion, imagen,mascotaventa_id) values (115, '05/06/2018', 'El perro cuenta con todas las vacunas', 'recursos/img/cer.jpg',125);


/*MEDIOS DE PAGO*/
insert into MedioDePagoEntity(id, numeroReferencia, tipo,cliente_id) values (1, 10, 'efectivo',111);
insert into MedioDePagoEntity(id, numeroReferencia, tipo,cliente_id) values (2, 20, 'tarjeta debito',112);
insert into MedioDePagoEntity(id, numeroReferencia, tipo,cliente_id) values (3, 30, 'tarjeta credito',113);


/*PUBLICACIONSES*/
insert into PublicacionEntity (id, comentario, fecha, fotoUrl, name, tipo, mascota_Id)values(111, 'Shiba pasa una tarde en la piscina', '09/29/2017','recursos/img/shibaPiscina.jpg','Shiba pasa una tarde  en la piscina ','gracioso',  113);
insert into PublicacionEntity (id, comentario, fecha, fotoUrl, name, tipo, mascota_Id)values(112, 'Zeus compitiendo por el gran premio', '08/01/2016','recursos/img/ZeusCompetencia.jpg','Zeus compite en carrera de canicross ','Deportivo',  112);
insert into PublicacionEntity (id, comentario, fecha, fotoUrl, name, tipo, mascota_Id)values(113, 'Mishu se come al pez nemo de la pecera de su dueno', '09/25/2017','recursos/img/siluetaPez.png','Mishu se come a su hermanito nemo ','gracioso',  116);
insert into PublicacionEntity (id, comentario, fecha, fotoUrl, name, tipo, mascota_Id)values(114, 'El gato Mishu conoce nuevos amigos', '09/04/2018','recursos/img/gatos.jpg','Mishu conoce nuevos amigos ','tierno',  116);
insert into PublicacionEntity (id, comentario, fecha, fotoUrl, name, tipo, mascota_Id)values(115, 'El entierro de Zeus se realizara el proximo fin de semana', '01/05/2018','recursos/img/samoyedo.jpg','Entierro de Zeus ','tragico',  112);
insert into PublicacionEntity (id, comentario, fecha, fotoUrl, name, tipo, mascota_Id)values(116, 'Mishu se traga los pericos australianos de su dueno', '09/29/2017','recursos/img/pericos australianos.jpg','Mishu se traga los pericos australianos de su dueno ','gracioso',  116);
