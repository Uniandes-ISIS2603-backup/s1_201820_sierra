delete from AcontecimientoEntity;
delete from AdquisicionEntity;
delete from CalificacionEntity;
delete from CertificadoEntity;
delete from ClienteEntity;
delete from ComprobanteEntity;
delete from EspecieEntity;
delete from FacturaEntity;
delete from MascotaAdoptadaEntity;
delete from MascotaVentaEntity;
delete from MedioDePagoEntity;
delete from PublicacionEntity;
delete from RazaEntity;
delete from SierraEntity;

insert into AcontecimientoEntity (id, nombre, descripcion, fecha, importancia, tipo, fotoURL) values (10,'Adopcion', 'Dia en el que se adopto la mascota', '01/01/2018', 1, 'historico', 'https://images-na.ssl-images-amazon.com/images/I/516GyHY9p6L.jpg');

insert into AdquisicionEntity(id, valorTotal, fecha) values (10, 120000.0,'01/01/2018');

insert into CalificacionEntity(id, comentarios, valor, sugerencia ) values (10, 'El servicio fue adecuado', 5, 'Podrian mejorar la realizacion del papeleo');

insert into CertificadoEntity(id, fecha, descripcion, imagen) values (10, '01/01/2018', 'El perro cuenta con todas las vacunas', 'http://m.cdn.blog.hu/ko/kockagyar/image/harry_potter_poster/harry_potter_1.jpg')

insert into ClienteEntity(id, nombre, apellido, cedula, telefono) values (10, 'Andres', 'Rodriguez', 1072585123, 3125225625);

insert into ComprobanteEntity(id, valorTotal, fecha, clienteId) values (10, 120000, '01/01/2018', 10 );

insert into EspecieEntity(id, nombre, caracteristicas, clasificacion) values (1, 'mamifero', 'Amigables  y amistosos, similares a los lobos', 'canino');
insert into EspecieEntity(id, nombre, caracteristicas, clasificacion) values (2, 'mamifero', 'Independientes y agiles', 'felino');
insert into EspecieEntity(id, nombre, caracteristicas, clasificacion) values (3, 'Ave', 'Su voz es un extasis a los oidos', 'ave');
insert into EspecieEntity(id, nombre, caracteristicas, clasificacion) values (4, 'Pez', 'Nadadores hermosos con un gran impacto  visual', 'Pez');


insert into FacturaEntity(id, valorTotal, fecha) values (10, 120000, '01/01/2018'),

insert into MascotaAdoptadaEntity()values ();


insert into MascotaVentaEntity() values ();

insert into MedioDePagoEntity(id, numeroReferencia, tipo) values (10, 20, 'tarjeta debito');

insert into PublicacionEntity() values ();

insert into RazaEntity() values ();

insert into SierraEntity() values ();