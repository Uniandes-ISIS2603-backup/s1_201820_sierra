delete from AcontecimientoEntity;
delete from PublicacionEntity;
delete from ClienteEntity;
delete from MedioDePagoEntity;
delete from MEDIODEPAGOENTITY_CLIENTEENTITY;
delete from AdquisicionEntity;
delete from CalificacionEntity;
delete from CertificadoEntity;
delete from ComprobanteEntity;
delete from FacturaEntity;
delete from MascotaAdoptadaEntity;
delete from MascotaEntity;
delete from MascotaVentaEntity;
delete from RazaEntity;
delete from SierraEntity;
delete from EspecieEntity;




insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor) values (1, 'Open-source modular help-desk', 'Statistician I', 3.41);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor) values (2, 'Multi-channelled full-range knowledge base', 'Systems Administrator I', 3.83);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor) values (3, 'Operative coherent matrix', 'Editor', 1.53);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor) values (4, 'Robust dynamic structure', 'Administrative Assistant III', 1.04);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor) values (5, 'Ameliorated systemic encryption', 'Staff Accountant II', 2.09);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor) values (6, 'Seamless high-level website', 'VP Quality Control', 2.08);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor) values (7, 'Customer-focused even-keeled secured line', 'Web Developer I', 2.54);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor) values (8, 'Grass-roots disintermediate moderator', 'Electrical Engineer', 1.93);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor) values (9, 'Operative value-added pricing structure', 'Web Designer III', 2.42);
insert into CALIFICACIONENTITY (id, comentarios, sugerencia, valor) values (10, 'Re-contextualized executive adapter', 'Programmer IV', 1.78);

insert into ADQUISICIONENTITY (id, fecha, valorTotal) values (1, '11/24/2017', 2146379);
insert into ADQUISICIONENTITY (id, fecha, valorTotal) values (2, '12/3/2017', 2843100);
insert into ADQUISICIONENTITY (id, fecha, valorTotal) values (3, '2/1/2018', 4617331);
insert into ADQUISICIONENTITY (id, fecha, valorTotal) values (4, '6/23/2017', 715105);
insert into ADQUISICIONENTITY (id, fecha, valorTotal) values (5, '11/12/2017', 2802294);
insert into ADQUISICIONENTITY (id, fecha, valorTotal) values (6, '12/9/2017', 3466209);
insert into ADQUISICIONENTITY (id, fecha, valorTotal) values (7, '1/24/2018', 3573395);
insert into ADQUISICIONENTITY (id, fecha, valorTotal) values (8, '3/8/2017', 4900605);
insert into ADQUISICIONENTITY (id, fecha, valorTotal) values (9, '7/23/2017', 3683016);
insert into ADQUISICIONENTITY (id, fecha, valorTotal) values (10, '5/6/2017', 1970169);

insert into CertificadoEntity(id, fecha, descripcion, imagen) values (10, '01/01/2018', 'El perro cuenta con todas las vacunas', 'http://m.cdn.blog.hu/ko/kockagyar/image/harry_potter_poster/harry_potter_1.jpg');

insert into ClienteEntity(id, nombre, apellido, cedula, telefono, correo, contrasenia) values (1, 'Andres', 'Rodriguez', 1072585123, 3125225625, 'andres001@gmail.com', '123456789');
insert into ClienteEntity(id, nombre, apellido, cedula, telefono, correo, contrasenia) values (2, 'Durant', 'de Broke', 39548662, 3125225625, 'durantbroke@hotmail.com', '987654321');
insert into ClienteEntity(id, nombre, apellido, cedula, telefono, correo, contrasenia) values (3, 'Basile', 'Youle', 132254899, 3205485498, 'youle254@gmail.com', 'casa1234');
insert into ClienteEntity(id, nombre, apellido, cedula, telefono, correo, contrasenia) values (4, 'Hollis', 'Gair', 1069654987, 3125489699, 'gairhollis@hotmail.com', 'mascotas123');
insert into ClienteEntity(id, nombre, apellido, cedula, telefono, correo, contrasenia) values (5, 'Goodby', 'Knapp', 39265488, 3215448500, 'hnap2018@yahoo.com', 'perros2018');

/**
*INSERCION DE LAS  ESPECIES INICIALES DENTRO DE LA  BASE DE DATOS
**/
insert into EspecieEntity(id, nombre, caracteristicas, clasificacion,imagen) values (111, 'Canino', 'Descendientes de los lobos, fieles, amorosos y el mejor amigo del hombre', 'Mamifero','recursos/img/siluetaPerro.png');
insert into EspecieEntity(id, nombre, caracteristicas, clasificacion,imagen) values (112, 'Felino', 'Independientes agiles, un poco destructivos pero te otorgaran cariño', 'Mamifero','recursos/img/siluetaGato.png');
insert into EspecieEntity(id, nombre, caracteristicas, clasificacion,imagen) values (114, 'Loro',' Grandes conversadores  coloridos y divertidos', 'Ave','recursos/img/siluetaAve.png');
insert into EspecieEntity(id, nombre, caracteristicas, clasificacion,imagen) values (115, 'Pez','Coloridos acuaticos ', 'Pez','recursos/img/siluetaPez.png');


/**
**INSERCION DE LAS  RAZAS INICIALES DENTRO DE LA BASE DE DATOS
**/
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(111,'Lobo Siberiano','Perros con rasgos de sus ancestros los lobos con un pelaje de color combinado','Su pelaje y cadera','fieles, activos y juguetones',111);
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(112,'Labrador','Pelo dorado, amigables','Ninguno','consentidos, tiernos y juguetones',111);
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(113,'Samoyedo','Pelaje blanco y apachurrable','Su pelaje','Tiernos  y tienen un animo agradable',111);
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(114,'Shiba Inu','Pequeños parecidos a los zorros','Su tamaño','Independiente',111);
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(115,'Gato Siames','Rostro peculiar y colorido','Araña todo','Independiente',112);
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(116,'Korat','Gordos y grises','Poco activo','Independiente',112);
insert into RazaEntity(id,nombreraza, caracteristicas,cuidados,destacable,especie_id)values(117,'Pixie Bob','Multicolor y agradable','Super','Independiente',112);

/**
*INSERCION DE LAS MASCOTAS DENTRO DE LA BASE DE DATOS
**/
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (111,'MascotaAdoptadaEntity','Zeus','Grande','Masculino',1,'recursos/img/samoyedo.jpg','Blanco',0,0,'6/23/2017',111,113);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (112,'MascotaAdoptadaEntity','Kiba','Grande','Femenino',3,'recursos/img/siberiano.jpg','Negro y Blanco',0,1,'1/05/2015',111,111);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (113,'MascotaAdoptadaEntity','Shiba','Mediana','Femenino',2,'recursos/img/labrador.jpg','Amarillo Dorado',0,1,'6/23/2016',111,112);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (114,'MascotaAdoptadaEntity','Dacota','Pequeña','Femenino',5,'recursos/img/ShibaInu.jpg','Dorada',1,0,'6/23/2013',111,114);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (115,'MascotaAdoptadaEntity','Jacob','Grande','Masculino',3,'recursos/img/Siberiano2.jpg','Blanco',0,1,'6/23/2015',111,111);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (116,'MascotaAdoptadaEntity','Mishu','Pequeño','Masculino',2,'recursos/img/gatoSiames.jpg','Blanco y negro',0,0,'6/23/2016',112,115);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (117,'MascotaAdoptadaEntity','Yasha','Pequeño','Femenino',2,'recursos/img/Korat.jpg','Gris',0,0,'6/23/2016',112,116);
insert into MascotaEntity(id,DType,nombre,tamano,genero,edad,imagen,color,adquirido,esteril,nacimiento,especie_id,raza_id) values (118,'MascotaAdoptadaEntity','Turron','Pequeño','Masculino',1,'recursos/img/pixieBob.jpg','Blanco naranja y negro',0,0,'6/23/2017',112,117);

/*
*INSERCION EN LA  CLASIFICACION DE  MASCOTAS PARA ADOPCION DE LA BASE DE DATOS
*/
insert into MascotaAdoptadaEntity(id) values(111);
insert into MascotaAdoptadaEntity(id) values(112);
insert into MascotaAdoptadaEntity(id) values(113);
insert into MascotaAdoptadaEntity(id) values(114);
insert into MascotaAdoptadaEntity(id) values(115);
insert into MascotaAdoptadaEntity(id) values(116);
insert into MascotaAdoptadaEntity(id) values(117);
insert into MascotaAdoptadaEntity(id) values(118);



insert into MedioDePagoEntity(id, numeroReferencia, tipo) values (1, 10, 'efectivo');
insert into MedioDePagoEntity(id, numeroReferencia, tipo) values (2, 20, 'tarjeta debito');
insert into MedioDePagoEntity(id, numeroReferencia, tipo) values (3, 30, 'tarjeta credito');


insert into facturaEntity(id, idCliente, nombreCliente, valor) values (100,1,'Andres', 20000);
insert into facturaEntity(id, idCliente, nombreCliente, valor) values (101,1,'Andres', 130000);

/*
*Insercion en la tabla Acontecimientos de la base de datos
*/
insert into AcontecimientoEntity (id, nombre, descripcion, fecha, importancia, tipo, fotoURL, mascotaAdopcion_Id) values (111,'Adopcion de Zeus', 'Dia en el que se adopto la mascota', '01/01/2015', 1, 'historico', 'recursos/img/samoyedo.jpg', 111);
insert into AcontecimientoEntity (id, nombre, descripcion, fecha, importancia, tipo, fotoURL, mascotaAdopcion_Id) values (112,'Zeus gana una competencia', 'Zeus y su dueno ganan una carrera de canicross', '01/08/2016', 1, 'historico', 'recursos/img/ZeusCompetencia.jpg', 111);
insert into AcontecimientoEntity (id, nombre, descripcion, fecha, importancia, tipo, fotoURL, mascotaAdopcion_Id) values (113,'Adopcion de Kiba', 'Dia en el que Kiba fue adoptado', '07/03/2014', 1, 'historico', 'recursos/img/siberiano.jpg', 112);
insert into AcontecimientoEntity (id, nombre, descripcion, fecha, importancia, tipo, fotoURL, mascotaAdopcion_Id) values (114,'Adopcion de Shiba', 'Dia en el que se adopto la mascota', '09/19/2017', 1, 'historico', 'recursos/img/labrador.jpg', 113);
insert into AcontecimientoEntity (id, nombre, descripcion, fecha, importancia, tipo, fotoURL, mascotaAdopcion_Id) values (115,'Adopcion de Mishu', 'Dia en el que se adopto a Mishu el gato', '09/18/2016', 1, 'historico', 'recursos/img/gatoSiames.jpg', 116);
insert into AcontecimientoEntity (id, nombre, descripcion, fecha, importancia, tipo, fotoURL, mascotaAdopcion_Id) values (116,'Zeus fallece', 'Lamentablemente Zeus fallecio hoy, que en paz descance', '01/01/2018', 7, 'tragico', 'recursos/img/samoyedo.jpg', 111);

/*
*Insercion en la tabla publicaciones de la base de datos
*/
insert into PublicacionEntity (id, comentario, fecha, fotoUrl, name, tipo, mascota_Id)values(111, 'Shiba pasa una tarde en la piscina', '09/29/2017','recursos/img/shibaPiscina.jpg','Shiba pasa una tarde  en la piscina ','gracioso',  113);
insert into PublicacionEntity (id, comentario, fecha, fotoUrl, name, tipo, mascota_Id)values(112, 'Zeus compitiendo por el gran premio', '08/01/2016','recursos/img/ZeusCompetencia.jpg','Zeus compite en carrera de canicross ','Deportivo',  111);
insert into PublicacionEntity (id, comentario, fecha, fotoUrl, name, tipo, mascota_Id)values(113, 'Mishu se come al pez nemo de la pecera de su dueno', '09/25/2017','recursos/img/siluetaPez.jpg','Mishu se come a su hermanito nemo ','gracioso',  116);
insert into PublicacionEntity (id, comentario, fecha, fotoUrl, name, tipo, mascota_Id)values(114, 'El gato Mishu conoce nuevos amigos', '09/04/2018','recursos/img/gatos.jpg','Mishu conoce nuevos amigos ','tierno',  116);
insert into PublicacionEntity (id, comentario, fecha, fotoUrl, name, tipo, mascota_Id)values(115, 'El entierro de Zeus se realizara el proximo fin de semana', '01/05/2018','recursos/img/samoyero.jpg','Entierro de Zeus ','tragico',  111);
insert into PublicacionEntity (id, comentario, fecha, fotoUrl, name, tipo, mascota_Id)values(116, 'Mishu se traga los pericos australianos de su dueno', '09/29/2017','recursos/img/pericos_australianos.jpg','Mishu se traga los pericos australianos de su dueno ','gracioso',  116);
