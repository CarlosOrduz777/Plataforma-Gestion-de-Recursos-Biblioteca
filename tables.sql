-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE `user_eci` (
	`id` INT,
	`name` varchar(45),
	`role` varchar(13)
);
CREATE TABLE `recursos` (
    `id` INT primary key not null,
    `nombre` varchar(50) not null,
    `ubicacion` varchar(20) not null,
    `disponible` bool not null,
    `tipo` varchar(40) not null,
    `descripcion` varchar(400)
);
CREATE TABLE `usuarios` (
    `id` INT primary key not null,
    `nombre` varchar(50) not null,
    `email` varchar(150) not null
);
CREATE TABLE `reservas` (
    `id` INT primary key not null,
    `fechaInicio` date not null,
    `fechaFin` date not null,
    `usario_id` int not null,
    `recurso_id` int not null

);