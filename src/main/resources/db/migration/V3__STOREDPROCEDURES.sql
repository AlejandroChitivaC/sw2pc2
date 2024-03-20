-- Actualizar proyecto --
DELIMITER //

CREATE PROCEDURE proyectoabc.actualizar_proyecto(
    IN p_idProyecto INT,
    IN p_estado VARCHAR(50),
    IN p_presupuesto DECIMAL(10, 2),
    IN p_fecha_inicio DATE,
    IN p_fecha_fin_prevista DATE
)
BEGIN
    -- Actualizar el estado, el presupuesto y las fechas del proyecto
    UPDATE proyecto
    SET estado             = p_estado,
        presupuesto        = p_presupuesto,
        fecha_inicio       = p_fecha_inicio,
        fecha_fin_prevista = p_fecha_fin_prevista
    WHERE idProyecto = p_idProyecto;
END //

DELIMITER ;

-- Asignar equipo de trabajo --
DELIMITER //

CREATE PROCEDURE proyectoabc.asignar_equipo_trabajo(
    IN p_idProyecto INT,
    IN p_idEquipoProyecto INT
)
BEGIN
    -- Verificar si el proyecto y el equipo existen
    DECLARE proyecto_equipo_existente INT;

    SELECT COUNT(*)
    INTO proyecto_equipo_existente
    FROM proyecto p
             INNER JOIN equipoproyecto ep ON p.idProyecto = ep.idEquipoProyecto
    WHERE p.idProyecto = p_idProyecto
      AND ep.idEquipoProyecto = p_idEquipoProyecto;

    IF proyecto_equipo_existente = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El proyecto o el equipo especificado no existe';
    ELSE
        -- Asignar equipo al proyecto
        INSERT INTO proyectoequipo (idProyecto, idEquipoProyecto) VALUES (p_idProyecto, p_idEquipoProyecto);

        -- Mensaje de éxito
        SELECT 'Equipo asignado correctamente al proyecto' AS Mensaje;
    END IF;

END //

DELIMITER ;

-- Asignar rol a empleado --
DELIMITER //

CREATE PROCEDURE proyectoabc.asignar_rol_a_empleado(
    IN p_idEmpleado INT,
    IN p_idRol INT
)
BEGIN
    -- Insertar la asignación de rol en la tabla de empleado_rol
    INSERT INTO empleado_rol (idEmpleado, idRol)
    VALUES (p_idEmpleado, p_idRol);
END //

DELIMITER ;

-- Realizar seguimiento --
DELIMITER //

CREATE PROCEDURE proyectoabc.realizar_seguimiento(
    IN p_idProyecto INT,
    IN p_fecha_seguimiento DATE,
    IN p_observaciones TEXT
)
BEGIN
    -- Insertar el seguimiento en la tabla de seguimiento de proyectos
    INSERT INTO seguimientoproyecto (idProyecto, fecha_seguimiento, observaciones)
    VALUES (p_idProyecto, p_fecha_seguimiento, p_observaciones);
END //

DELIMITER ;

-- Registrar empleados --
DELIMITER //

CREATE PROCEDURE proyectoabc.registrar_empleado(
    IN p_nombre VARCHAR(100),
    IN p_direccion VARCHAR(255),
    IN p_salario DECIMAL(10, 2),
    IN p_fecha_ingreso DATE,
    IN p_fecha_nacimiento DATE,
    IN p_tipo_documento_id INT,
    IN p_numero_documento VARCHAR(50),
    IN p_telefono VARCHAR(20)
)
BEGIN
    -- Insertar el nuevo empleado en la tabla de empleados
    INSERT INTO empleado (nombre, direccion, salario, fecha_ingreso, fecha_nacimiento, tipo_documento_id,
                          numero_documento, telefono)
    VALUES (p_nombre, p_direccion, p_salario, p_fecha_ingreso, p_fecha_nacimiento, p_tipo_documento_id,
            p_numero_documento, p_telefono);
END //

DELIMITER ;


-- Registrar proyecto --
DELIMITER //

CREATE PROCEDURE proyectoabc.registrar_equipo_proyecto(
    IN p_nombre_equipo VARCHAR(100),
    IN p_descripcion VARCHAR(255),
    IN p_fecha_creacion DATE,
    IN p_idEmpleado INT
)
BEGIN
    -- Insertar el nuevo equipo de proyecto en la tabla de equipos de proyecto
    INSERT INTO equipoproyecto (nombre_equipo, descripcion, fecha_creacion, idEmpleado)
    VALUES (p_nombre_equipo, p_descripcion, p_fecha_creacion, p_idEmpleado);
END //

DELIMITER ;

-- Registrar historial de cambios --
DELIMITER //

CREATE PROCEDURE proyectoabc.registrar_historial_cambios(
    IN p_idProyecto INT,
    IN p_fecha_cambio DATE,
    IN p_descripcion_cambio TEXT,
    IN p_idEmpleado INT
)
BEGIN
    -- Insertar un nuevo registro de historial de cambios en la tabla de historialcambios
    INSERT INTO historialcambios (idProyecto, fecha_cambio, descripcion_cambio, idEmpleado)
    VALUES (p_idProyecto, p_fecha_cambio, p_descripcion_cambio, p_idEmpleado);
END //

DELIMITER ;

-- Registrar proyecto --
DELIMITER //

CREATE PROCEDURE proyectoabc.registrar_proyecto(
    IN p_nombre VARCHAR(255),
    IN p_descripcion VARCHAR(255),
    IN p_fecha_inicio DATE,
    IN p_fecha_fin_prevista DATE,
    IN p_presupuesto DECIMAL(10, 2),
    IN p_estado VARCHAR(50),
    IN p_idLiderProyecto INT
)
BEGIN
    -- Insertar el nuevo proyecto en la tabla de proyectos
    INSERT INTO proyecto (nombre, descripcion, fecha_inicio, fecha_fin_prevista, presupuesto, estado, idLiderProyecto)
    VALUES (p_nombre, p_descripcion, p_fecha_inicio, p_fecha_fin_prevista, p_presupuesto, p_estado, p_idLiderProyecto);
END //

DELIMITER ;

-- Registrar seguimiento tiempo --
DELIMITER //

CREATE PROCEDURE proyectoabc.registrar_seguimiento_tiempo(
    IN p_idProyecto INT,
    IN p_idEmpleado INT,
    IN p_horas_trabajadas DECIMAL(10, 2),
    IN p_fecha_registro DATE
)
BEGIN
    -- Insertar un nuevo registro de seguimiento de tiempo en la tabla de seguimientotiempo
    INSERT INTO seguimientotiempo (idProyecto, idEmpleado, horas_trabajadas, fecha_registro)
    VALUES (p_idProyecto, p_idEmpleado, p_horas_trabajadas, p_fecha_registro);
END //

DELIMITER ;

-- Registrar tarea --
DELIMITER //

CREATE PROCEDURE proyectoabc.registrar_tarea(
    IN p_idProyecto INT,
    IN p_descripcion TEXT,
    IN p_fecha_inicio DATE,
    IN p_fecha_fin_prevista DATE,
    IN p_estado VARCHAR(50)
)
BEGIN
    -- Insertar una nueva tarea en la tabla de tareas
    INSERT INTO tarea (idProyecto, descripcion, fecha_inicio, fecha_fin_prevista, estado)
    VALUES (p_idProyecto, p_descripcion, p_fecha_inicio, p_fecha_fin_prevista, p_estado);
END //

DELIMITER ;

-- Registrar usuario --
DELIMITER //


CREATE PROCEDURE proyectoabc.registrar_usuario(
    IN p_nombre_usuario VARCHAR(100),
    IN p_email VARCHAR(255),
    IN p_password VARCHAR(255),
    IN p_idEmpleado INT
)
BEGIN
    -- Insertar el nuevo usuario en la tabla de usuarios
    INSERT INTO proyectoabc.usuario (nombre_usuario, email, password, idEmpleado)
    VALUES (p_nombre_usuario, p_email, p_password, p_idEmpleado);

    -- Mensaje de éxito
    SELECT 'Usuario registrado correctamente' AS Mensaje;
END //

DELIMITER ;