-- tabla tipo documento --

CREATE TABLE IF NOT EXISTS proyectoabc.tipodocumento (
                                                         `idTipoDocumento` int NOT NULL AUTO_INCREMENT,
                                                         `tipoDocumento` varchar(100) NOT NULL unique,
                                                         PRIMARY KEY (`idTipoDocumento`)
);

-- tabla rol --
CREATE TABLE IF NOT EXISTS proyectoabc.rol (
                                               `idRol` int NOT NULL AUTO_INCREMENT,
                                               `rol` varchar(100) DEFAULT NULL,
                                               PRIMARY KEY (`idRol`)
);


-- tabla usuario  --
CREATE TABLE IF NOT EXISTS proyectoabc.usuario (
                                                   `id_usuario` int NOT NULL AUTO_INCREMENT,
                                                   `nombre_usuario` varchar(100) NOT NULL,
                                                   `email` varchar(255) NOT NULL,
                                                   `password` varchar(255) NOT NULL,
                                                   PRIMARY KEY (`id_usuario`),
                                                   UNIQUE KEY `email` (`email`)
) ;


-- tabla empleado --
CREATE TABLE IF NOT EXISTS proyectoabc.empleado (
                                                    `idEmpleado` INT NOT NULL AUTO_INCREMENT,
                                                    `nombre` VARCHAR(100) DEFAULT NULL,
                                                    `direccion` VARCHAR(255) DEFAULT NULL,
                                                    `salario` DECIMAL(10,2) DEFAULT NULL,
                                                    `fecha_ingreso` DATE DEFAULT NULL,
                                                    `fecha_nacimiento` DATE DEFAULT NULL,
                                                    `tipo_documento_id` INT DEFAULT NULL,
                                                    `numero_documento` VARCHAR(50) DEFAULT NULL,
                                                    `telefono` VARCHAR(20) DEFAULT NULL,
                                                    `id_usuario` INT NOT NULL,
                                                    PRIMARY KEY (`idEmpleado`),
                                                    KEY `tipo_documento_id` (`tipo_documento_id`),
                                                    CONSTRAINT `fk_usuario_empleado` FOREIGN KEY (`id_usuario`) REFERENCES `proyectoabc`.`usuario` (`id_usuario`)
);


-- tabla empleado_rol --

CREATE TABLE IF NOT EXISTS proyectoabc.empleado_rol (
                                                        `idEmpleadoRol` int NOT NULL AUTO_INCREMENT,
                                                        `idEmpleado` int NOT NULL,
                                                        `idRol` int NOT NULL,
                                                        PRIMARY KEY (`idEmpleadoRol`),
                                                        KEY `idEmpleado` (`idEmpleado`),
                                                        KEY `idRol` (`idRol`),
                                                        CONSTRAINT `empleado_rol_ibfk_1` FOREIGN KEY (`idEmpleado`) REFERENCES `proyectoabc`.`empleado` (`idEmpleado`),
                                                        CONSTRAINT `empleado_rol_ibfk_2` FOREIGN KEY (`idRol`) REFERENCES `proyectoabc`.`rol` (`idRol`)
);

-- tabla equipo proyecto --

CREATE TABLE IF NOT EXISTS proyectoabc.equipoproyecto (
                                                          `idEquipoProyecto` int NOT NULL AUTO_INCREMENT,
                                                          `nombre_equipo` varchar(100) DEFAULT NULL,
                                                          `descripcion` varchar(255) DEFAULT NULL,
                                                          `fecha_creacion` date DEFAULT NULL,
                                                          `idEmpleado` int DEFAULT NULL,
                                                          PRIMARY KEY (`idEquipoProyecto`),
                                                          KEY `idEmpleado` (`idEmpleado`),
                                                          CONSTRAINT `equipoproyecto_ibfk_1` FOREIGN KEY (`idEmpleado`) REFERENCES `proyectoabc`.`empleado` (`idEmpleado`)
);

-- tabla proyecto --

CREATE TABLE IF NOT EXISTS proyectoabc.proyecto (
                                                    `idProyecto` int NOT NULL AUTO_INCREMENT,
                                                    `nombre` varchar(255) DEFAULT NULL,
                                                    `descripcion` varchar(255) DEFAULT NULL,
                                                    `fecha_inicio` date DEFAULT NULL,
                                                    `fecha_fin_prevista` date DEFAULT NULL,
                                                    `presupuesto` decimal(10,2) DEFAULT NULL,
                                                    `estado` varchar(50) DEFAULT NULL,
                                                    `idLiderProyecto` int DEFAULT NULL,
                                                    PRIMARY KEY (`idProyecto`),
                                                    KEY `idLiderProyecto` (`idLiderProyecto`),
                                                    CONSTRAINT `proyecto_ibfk_1` FOREIGN KEY (`idLiderProyecto`) REFERENCES `proyectoabc`.`empleado` (`idEmpleado`)
);

-- tabla historial cambios --

CREATE TABLE IF NOT EXISTS proyectoabc.historialcambios (
                                                            `idHistorial` int NOT NULL AUTO_INCREMENT,
                                                            `idProyecto` int DEFAULT NULL,
                                                            `fecha_cambio` date DEFAULT NULL,
                                                            `descripcion_cambio` text,
                                                            `idEmpleado` int DEFAULT NULL,
                                                            PRIMARY KEY (`idHistorial`),
                                                            KEY `idProyecto` (`idProyecto`),
                                                            KEY `idEmpleado` (`idEmpleado`),
                                                            CONSTRAINT `historialcambios_ibfk_1` FOREIGN KEY (`idProyecto`) REFERENCES `proyectoabc`.`proyecto` (`idProyecto`),
                                                            CONSTRAINT `historialcambios_ibfk_2` FOREIGN KEY (`idEmpleado`) REFERENCES `proyectoabc`.`empleado` (`idEmpleado`)
);



-- tabla proyectoequipo --

CREATE TABLE IF NOT EXISTS proyectoabc.proyectoequipo (
                                                          `idProyecto` int NOT NULL ,
                                                          `idEquipoProyecto` int NOT NULL,
                                                          PRIMARY KEY (`idProyecto`,`idEquipoProyecto`),
                                                          KEY `idEquipoProyecto` (`idEquipoProyecto`),
                                                          CONSTRAINT `proyectoequipo_ibfk_1` FOREIGN KEY (`idProyecto`) REFERENCES `proyectoabc`.`proyecto` (`idProyecto`),
                                                          CONSTRAINT `proyectoequipo_ibfk_2` FOREIGN KEY (`idEquipoProyecto`) REFERENCES `proyectoabc`.`equipoproyecto` (`idEquipoProyecto`)
);



-- tabla seguimiento proyecto  --

CREATE TABLE IF NOT EXISTS proyectoabc.seguimientoproyecto (
                                                               `idSeguimiento` int NOT NULL AUTO_INCREMENT,
                                                               `idProyecto` int DEFAULT NULL,
                                                               `fecha_seguimiento` date DEFAULT NULL,
                                                               `observaciones` text,
                                                               PRIMARY KEY (`idSeguimiento`),
                                                               KEY `idProyecto` (`idProyecto`),
                                                               CONSTRAINT `seguimientoproyecto_ibfk_1` FOREIGN KEY (`idProyecto`) REFERENCES `proyectoabc`.`proyecto` (`idProyecto`)
);

-- tabla seguimiento tiempo --

CREATE TABLE IF NOT EXISTS proyectoabc.seguimientotiempo (
                                                             `idSeguimientoTiempo` int NOT NULL AUTO_INCREMENT,
                                                             `idProyecto` int DEFAULT NULL,
                                                             `idEmpleado` int DEFAULT NULL,
                                                             `horas_trabajadas` decimal(10,2) DEFAULT NULL,
                                                             `fecha_registro` date DEFAULT NULL,
                                                             PRIMARY KEY (`idSeguimientoTiempo`),
                                                             KEY `idProyecto` (`idProyecto`),
                                                             KEY `idEmpleado` (`idEmpleado`),
                                                             CONSTRAINT `seguimientotiempo_ibfk_1` FOREIGN KEY (`idProyecto`) REFERENCES `proyectoabc`.`proyecto` (`idProyecto`),
                                                             CONSTRAINT `seguimientotiempo_ibfk_2` FOREIGN KEY (`idEmpleado`) REFERENCES `proyectoabc`.`empleado` (`idEmpleado`)
);

-- tabla tarea --

CREATE TABLE IF NOT EXISTS proyectoabc.tarea (
                                                 `idTarea` int NOT NULL AUTO_INCREMENT,
                                                 `idProyecto` int DEFAULT NULL,
                                                 `descripcion` text,
                                                 `fecha_inicio` date DEFAULT NULL,
                                                 `fecha_fin_prevista` date DEFAULT NULL,
                                                 `estado` varchar(50) DEFAULT NULL,
                                                 PRIMARY KEY (`idTarea`),
                                                 KEY `idProyecto` (`idProyecto`),
                                                 CONSTRAINT `tarea_ibfk_1` FOREIGN KEY (`idProyecto`) REFERENCES `proyectoabc`.`proyecto` (`idProyecto`)
);