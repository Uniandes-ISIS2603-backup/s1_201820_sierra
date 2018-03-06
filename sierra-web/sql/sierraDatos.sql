delete from AcontecimientoEntity;
delete from AdquisicionEntity;
delete from CalificacionEntity;
delete from CertificadoEntity;
delete from ClienteEntity;
delete from ComprobanteEntity;
delete from EspecieEntity;
delete from FacturaEntity;
/*delete from MascotaAdoptadaEntity;
delete from MascotaVentaEntity;*/
delete from MedioDePagoEntity;
delete from PublicacionEntity;
delete from RazaEntity;
delete from SierraEntity;

insert into AcontecimientoEntity (id, nombre, descripcion, fecha, importancia, tipo, fotoURL) values (10,'Adopcion', 'Dia en el que se adopto la mascota', '01/01/2018', 1, 'historico', 'https://images-na.ssl-images-amazon.com/images/I/516GyHY9p6L.jpg');



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

insert into ClienteEntity(id, nombre, apellido, cedula, telefono) values (10, 'Andres', 'Rodriguez', 1072585123, 3125225625);

insert into ComprobanteEntity(id, valorTotal, fecha, clienteId) values (10, 120000, '01/01/2018', 10 );

insert into EspecieEntity(id, nombre, caracteristicas, clasificacion) values (1, 'mamifero', 'Amigables  y amistosos, similares a los lobos', 'canino');
insert into EspecieEntity(id, nombre, caracteristicas, clasificacion) values (2, 'mamifero', 'Independientes y agiles', 'felino');
insert into EspecieEntity(id, nombre, caracteristicas, clasificacion) values (3, 'Ave', 'Su voz es un extasis a los oidos', 'ave');
insert into EspecieEntity(id, nombre, caracteristicas, clasificacion) values (4, 'Pez', 'Nadadores hermosos con un gran impacto  visual', 'Pez');

insert into MedioDePagoEntity(id, numeroReferencia, tipo) values (10, 20, 'tarjeta debito');