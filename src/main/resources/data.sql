-- Insertar un rol ADMIN
INSERT INTO "Roles" (id_rol, name_role)
VALUES (1, 'ADMIN')
    ON CONFLICT (id_rol) DO NOTHING;

-- Insertar un usuario administrador
-- Contraseña: admin123 (encriptada con BCrypt)
INSERT INTO "Usuarios" (
    username,
    password,
    enabled,
    id_rol,
    name_usuario,
    apellido_usuario,
    fecha_usuario,
    gmail_usuario,
    dniusuario,
    especialidad_usuario,
    numerocolegiatura_usuario,
    apoderado_usuario
) VALUES (
             'admin',
             '$2a$10$8.UnVuG9HHgffUDAlE5BK.WfSdbvEa7AuWP4Q0TnK/9.1jCmS6l6a',
             true,
             1,
             'Administrador',
             'Sistema',
             '1990-01-01',
             'admin@sistema.com',
             12345678,
             NULL,
             NULL,
             NULL
         )
    ON CONFLICT (username) DO NOTHING;