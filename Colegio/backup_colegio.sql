-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-08-2022 a las 02:22:04
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `colegio`
--
CREATE DATABASE IF NOT EXISTS `colegio` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `colegio`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colegios`
--

CREATE TABLE `colegios` (
  `rut` int(11) NOT NULL,
  `nombre` varchar(120) COLLATE utf8_unicode_ci DEFAULT NULL,
  `direccion` varchar(120) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contacto_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `colegios`
--

INSERT INTO `colegios` (`rut`, `nombre`, `direccion`, `contacto_id`) VALUES
(651521556, 'CSCJ Alto Hospicio', 'Santa Rosa 3120 Alto Hospicio', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contactos`
--

CREATE TABLE `contactos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `apellido` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `correo` varchar(120) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `contactos`
--

INSERT INTO `contactos` (`id`, `nombre`, `apellido`, `telefono`, `correo`, `activo`) VALUES
(1, 'Eliana Josefa', 'Guerrero Mamani', 123456789, 'secretaria@cscj.cl', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `nombre`, `activo`) VALUES
(1, 'Administrador PRUEBA EDICION', 1),
(2, 'Subvencion', 1),
(3, 'Informatico', 1),
(4, 'Administrativo', 0),
(5, 'ROL NUEVO', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `rut` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `apellido` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clave` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `celular` int(11) DEFAULT NULL,
  `correo` varchar(120) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rol_id` int(11) DEFAULT NULL,
  `colegio_id` int(11) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`rut`, `nombre`, `apellido`, `clave`, `celular`, `correo`, `rol_id`, `colegio_id`, `activo`) VALUES
(137309637, 'Jorge Alejandro', 'Urrutia Gutiérrez', 'iacc', 99180316, 'jorgeurrutia_g@hotmail.com', 1, 651521556, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `colegios`
--
ALTER TABLE `colegios`
  ADD PRIMARY KEY (`rut`),
  ADD KEY `contacto_id` (`contacto_id`);

--
-- Indices de la tabla `contactos`
--
ALTER TABLE `contactos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`rut`),
  ADD KEY `rol_id` (`rol_id`),
  ADD KEY `colegio_id` (`colegio_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `contactos`
--
ALTER TABLE `contactos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `colegios`
--
ALTER TABLE `colegios`
  ADD CONSTRAINT `colegios_ibfk_1` FOREIGN KEY (`contacto_id`) REFERENCES `contactos` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `usuarios_ibfk_2` FOREIGN KEY (`colegio_id`) REFERENCES `colegios` (`rut`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;