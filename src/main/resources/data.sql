INSERT INTO usuarios
(username, nombre, apellido,
password, red_social, fecha_nacimiento, enabled, image)
VALUES
('luis.hurtado@est.iudigital.edu.co', 'Luis', 'Hurtado',
'', 0, '1977-05-15', 1, '');

INSERT INTO roles(nombre, descripcion)
VALUES ('ROLE_ADMIN', 'administrador');

INSERT INTO roles(nombre, descripcion)
VALUES ('ROLE_USER', 'usuario normal');

INSERT INTO roles_usuarios(usuarios_id, roles_id)
VALUES (1, 1);

INSERT INTO roles_usuarios(usuarios_id, roles_id)
VALUES (1, 2);

INSERT INTO delitos (nombre, descripcion, usuarios_id)
VALUES ('hurto', 'Cuando lo roban a uno', 1);

INSERT INTO delitos (nombre, descripcion, usuarios_id)
VALUES ('homicidio', 'Cuando lo matan a uno', 1);

