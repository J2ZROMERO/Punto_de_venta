-- MariaDB dump 10.19  Distrib 10.6.5-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: pv_canoa_segunda
-- ------------------------------------------------------
-- Server version	10.6.5-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `caja`
--

DROP TABLE IF EXISTS `caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saldoInicial` double NOT NULL,
  `movimiento` varchar(50) NOT NULL,
  `entrada` double DEFAULT NULL,
  `salida` double DEFAULT NULL,
  `motivo` varchar(200) NOT NULL,
  `monto` double NOT NULL,
  `saldoTotalDelDia` double DEFAULT NULL,
  `fecha` datetime NOT NULL,
  `fk_usuarios` int(11) DEFAULT NULL,
  `fk_provedores` int(11) DEFAULT NULL,
  `fk_ventas` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `caja_FK_3` (`fk_usuarios`),
  KEY `caja_FK` (`fk_provedores`),
  KEY `caja_FK_1` (`fk_ventas`),
  CONSTRAINT `caja_FK` FOREIGN KEY (`fk_provedores`) REFERENCES `provedores` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `caja_FK_1` FOREIGN KEY (`fk_ventas`) REFERENCES `ventas` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `caja_FK_3` FOREIGN KEY (`fk_usuarios`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja`
--

LOCK TABLES `caja` WRITE;
/*!40000 ALTER TABLE `caja` DISABLE KEYS */;
INSERT INTO `caja` VALUES (2,5000,'entrada',5000,3000,'gastos',5000,NULL,'2022-06-03 00:00:00',43,NULL,NULL),(3,5000,'entrada',5000,3000,'gastos',5000,NULL,'2022-06-03 00:00:00',43,NULL,NULL),(4,5000,'entrada',5000,3000,'gastos',5000,NULL,'2022-06-03 00:00:00',43,NULL,NULL),(5,5000,'entrada',5000,3000,'gastos',5000,NULL,'2022-06-03 00:00:00',43,NULL,NULL),(7,5000,'entrada',5000,3000,'gastos',5000,NULL,'2022-06-03 00:00:00',413,NULL,NULL),(8,5000,'entrada',5000,3000,'gastos',5000,NULL,'2022-06-03 00:00:00',413,NULL,NULL),(10,5000,'entrada',5000,3000,'gastos',5000,NULL,'2022-06-03 00:00:00',43,NULL,NULL),(23,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-06 20:51:38',43,NULL,NULL),(24,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 18:17:15',43,NULL,NULL),(25,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 18:34:00',43,NULL,NULL),(26,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 18:34:00',43,NULL,NULL),(27,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 18:35:00',43,NULL,NULL),(28,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 19:04:11',43,NULL,NULL),(29,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 19:04:16',43,NULL,NULL),(30,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 08:00:56',43,NULL,NULL),(31,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 07:17:25',43,NULL,NULL),(32,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 19:20:25',43,NULL,NULL),(33,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 19:27:54',43,NULL,NULL),(34,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 20:05:11',43,NULL,NULL);
/*!40000 ALTER TABLE `caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (5,'ganso');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cierre_caja`
--

DROP TABLE IF EXISTS `cierre_caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cierre_caja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saldo_inicial` double NOT NULL,
  `entradas` double NOT NULL,
  `salidas` double NOT NULL,
  `total_in_caja` double NOT NULL,
  `fecha` datetime NOT NULL,
  `fk_usuarios` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cierre_caja_FK` (`fk_usuarios`),
  CONSTRAINT `cierre_caja_FK` FOREIGN KEY (`fk_usuarios`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cierre_caja`
--

LOCK TABLES `cierre_caja` WRITE;
/*!40000 ALTER TABLE `cierre_caja` DISABLE KEYS */;
INSERT INTO `cierre_caja` VALUES (1,1500,500,250,1750,'2022-06-13 19:25:02',43);
/*!40000 ALTER TABLE `cierre_caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (2,'dara','gachu','jjjjjjjjjjjjjjjjj','22280010101','2022-06-29 18:19:05'),(5,'asasasas','aa','dddddddddddddd','aa','2022-07-19 19:22:15'),(9,'','','','','2022-07-22 17:05:17'),(10,'Jose ','Juan ','Zepeda','Romero...','2022-07-22 17:06:41'),(12,'Carlos Juarez','Sanchez ','domignuees','2228103004','2022-07-22 17:10:28'),(14,'zxczxcxcx','xc<<<<<<<<<','aaa','543534534','2022-07-22 17:59:32'),(15,'jsope nja ','sdasdad','dsadas','dasd','2022-07-22 18:08:55'),(18,'zxczxcxcx','xc<<<<<<<<<','aaa','543534534','2022-07-22 18:10:53'),(21,'jose juan zepeda romero','castilo','fsdf','rojas','2022-07-25 18:58:16');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `devoluciones`
--

DROP TABLE IF EXISTS `devoluciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `devoluciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `motivo` varchar(150) NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `fk_producto` bigint(20) DEFAULT NULL,
  `fk_clientes` int(11) DEFAULT NULL,
  `fk_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `devoluciones_FK` (`fk_producto`),
  KEY `devoluciones_FK_1` (`fk_clientes`),
  KEY `devoluciones_FK_2` (`fk_usuario`),
  CONSTRAINT `devoluciones_FK` FOREIGN KEY (`fk_producto`) REFERENCES `productos` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `devoluciones_FK_1` FOREIGN KEY (`fk_clientes`) REFERENCES `clientes` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `devoluciones_FK_2` FOREIGN KEY (`fk_usuario`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devoluciones`
--

LOCK TABLES `devoluciones` WRITE;
/*!40000 ALTER TABLE `devoluciones` DISABLE KEYS */;
INSERT INTO `devoluciones` VALUES (1,5,'no los quiso','2022-06-22 17:02:04',NULL,NULL,NULL),(3,5,'no los quiso','2022-06-22 17:02:23',NULL,NULL,413),(5,5,'no los quiso','2022-06-22 17:04:03',31475,NULL,413),(6,5,'nuevoprudcot','2022-06-23 20:05:17',31456,NULL,413),(7,5,'omitido','2022-06-28 20:46:51',65,NULL,413),(8,78,'omitido','2022-06-28 22:00:49',65,NULL,413);
/*!40000 ALTER TABLE `devoluciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadisticas`
--

DROP TABLE IF EXISTS `estadisticas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadisticas` (
  `fk_usuarios` int(11) NOT NULL,
  `fk_clientes` int(11) NOT NULL,
  `fk_ventas` int(11) NOT NULL,
  `fk_producto` bigint(20) NOT NULL,
  `fk_devoluciones` int(11) DEFAULT NULL,
  `fk_caja` int(11) DEFAULT NULL,
  KEY `estadisticas_FK_2` (`fk_clientes`),
  KEY `estadisticas_FK_3` (`fk_usuarios`),
  KEY `estadisticas_FK_5` (`fk_ventas`),
  KEY `estadisticas_FK` (`fk_producto`),
  KEY `estadisticas_FK_1` (`fk_devoluciones`),
  KEY `estadisticas_FK_4` (`fk_caja`),
  CONSTRAINT `estadisticas_FK` FOREIGN KEY (`fk_producto`) REFERENCES `productos` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `estadisticas_FK_1` FOREIGN KEY (`fk_devoluciones`) REFERENCES `devoluciones` (`id`),
  CONSTRAINT `estadisticas_FK_2` FOREIGN KEY (`fk_clientes`) REFERENCES `clientes` (`id`),
  CONSTRAINT `estadisticas_FK_3` FOREIGN KEY (`fk_usuarios`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `estadisticas_FK_4` FOREIGN KEY (`fk_caja`) REFERENCES `caja` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `estadisticas_FK_5` FOREIGN KEY (`fk_ventas`) REFERENCES `ventas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadisticas`
--

LOCK TABLES `estadisticas` WRITE;
/*!40000 ALTER TABLE `estadisticas` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadisticas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linea`
--

DROP TABLE IF EXISTS `linea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `linea` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linea`
--

LOCK TABLES `linea` WRITE;
/*!40000 ALTER TABLE `linea` DISABLE KEYS */;
INSERT INTO `linea` VALUES (7,'otr'),(8,'what about'),(10,'good');
/*!40000 ALTER TABLE `linea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marcas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES (3,'otra nueva marca'),(4,'gansito');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `id` bigint(20) NOT NULL,
  `product` varchar(50) NOT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `extra_distinctive` varchar(50) DEFAULT NULL,
  `stock` smallint(6) NOT NULL,
  `kilogramos` double DEFAULT NULL,
  `medida` double DEFAULT NULL,
  `mililitros` double DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `tamano` double DEFAULT NULL,
  `precioCompra` double NOT NULL,
  `precioVenta` double NOT NULL,
  `fecha` datetime NOT NULL,
  `fk_provedores` int(11) DEFAULT NULL,
  `fk_marca` int(11) DEFAULT NULL,
  `fk_linea` int(11) DEFAULT NULL,
  `fk_categoria` int(11) DEFAULT NULL,
  `fk_usuario` int(11) DEFAULT NULL,
  `razon` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `productos_FK_3` (`fk_provedores`),
  KEY `productos_FK` (`fk_categoria`),
  KEY `productos_FK_1` (`fk_linea`),
  KEY `productos_FK_2` (`fk_marca`),
  KEY `productos_FK_4` (`fk_usuario`),
  CONSTRAINT `productos_FK` FOREIGN KEY (`fk_categoria`) REFERENCES `categoria` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `productos_FK_1` FOREIGN KEY (`fk_linea`) REFERENCES `linea` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `productos_FK_2` FOREIGN KEY (`fk_marca`) REFERENCES `marcas` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `productos_FK_3` FOREIGN KEY (`fk_provedores`) REFERENCES `provedores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `productos_FK_4` FOREIGN KEY (`fk_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='just id,name,stock,purchase sale,selling price can not be empty';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (65,'panes de dulce','chocolate','con chispas muchas chispas',80,180,NULL,NULL,NULL,NULL,90,120,'2022-06-28 20:41:53',NULL,NULL,NULL,NULL,413,'anadido'),(78,'panes de dulce','chocolate','con chispas muchas chispas',75,180,NULL,NULL,NULL,NULL,90,120,'2022-06-28 22:00:35',NULL,NULL,NULL,NULL,413,'anadido'),(3145,'panes de dulce','de colores','',0,156,1233,0,'0',0,56,2555,'2022-06-22 16:02:07',NULL,NULL,NULL,NULL,413,'anadido'),(31456,' dulce','de','',0,156,1233,0,'0',0,56,2555,'2022-06-23 20:01:52',NULL,NULL,NULL,NULL,413,'anadido'),(31475,'panes de dulce','de colores','',5,156,1233,0,'0',0,56,2555,'2022-06-22 16:02:08',NULL,NULL,NULL,NULL,413,'anadido');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos_eliminados`
--

DROP TABLE IF EXISTS `productos_eliminados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos_eliminados` (
  `fk_usuario` int(11) DEFAULT NULL,
  `fk_producto` bigint(20) DEFAULT NULL,
  `product` varchar(50) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `razon` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  KEY `productos_eliminados_FK` (`fk_usuario`),
  KEY `productos_eliminados_FK_1` (`fk_producto`),
  CONSTRAINT `productos_eliminados_FK` FOREIGN KEY (`fk_usuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `productos_eliminados_FK_1` FOREIGN KEY (`fk_producto`) REFERENCES `productos` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos_eliminados`
--

LOCK TABLES `productos_eliminados` WRITE;
/*!40000 ALTER TABLE `productos_eliminados` DISABLE KEYS */;
INSERT INTO `productos_eliminados` VALUES (413,NULL,'panes de dulce','de colores','Eliminado','2022-06-22 15:32:12'),(413,NULL,'panes de dulce','de colores','Eliminado','2022-06-22 15:33:54'),(413,NULL,'panes de dulce','de colores','Eliminado','2022-06-22 16:03:06'),(413,NULL,' dulce','de','Eliminado','2022-06-22 16:03:42'),(413,NULL,' dulce','de','Eliminado','2022-06-23 20:02:17');
/*!40000 ALTER TABLE `productos_eliminados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provedores`
--

DROP TABLE IF EXISTS `provedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provedores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido1` varchar(20) DEFAULT NULL,
  `apellido2` varchar(20) DEFAULT NULL,
  `empresa` varchar(20) DEFAULT NULL,
  `nombreSupervisor` varchar(50) DEFAULT NULL,
  `contactoSupervisor` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provedores`
--

LOCK TABLES `provedores` WRITE;
/*!40000 ALTER TABLE `provedores` DISABLE KEYS */;
INSERT INTO `provedores` VALUES (4,'jose','zeepda','romero','bimbo','carlos joaquin','2228103004'),(5,'jose','zeepda','romero','bimbo','carlos joaquin','2228103004'),(6,'jose','zeepda','romero','bimbo','carlos joaquin','2228103004');
/*!40000 ALTER TABLE `provedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(3) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `first_name` varchar(15) NOT NULL,
  `second_name` varchar(20) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `pass` blob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'jose juan ','zepeda','romero','jhosep','��n`\0Ŷ�>s$��~'),(2,'carlos','zepeda','romero','carlangas','��{���׷�U0Q�'),(4,'carlosgfs','zepeda','romero','car','��{���׷�U0Q�');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `rol` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido1` varchar(30) DEFAULT NULL,
  `apellido2` varchar(30) DEFAULT NULL,
  `nickname` varchar(30) NOT NULL,
  `pass` blob NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (43,'jefe','hernand11ez',NULL,NULL,'men','K���՗7�U�2��6Io','2022-05-26 00:00:00'),(413,'empleado','jose juan','zepeda',' romero','jhosep','��{���׷�U0Q�','2022-05-27 00:00:00');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto` varchar(50) DEFAULT NULL,
  `distintivo1` varchar(50) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `fecha` datetime NOT NULL,
  `fk_clientes` int(11) DEFAULT NULL,
  `fk_usuarios` int(11) DEFAULT NULL,
  `fk_productos` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ventas_FK` (`fk_clientes`),
  KEY `ventas_FK_1` (`fk_usuarios`),
  KEY `ventas_FK_2` (`fk_productos`),
  CONSTRAINT `ventas_FK` FOREIGN KEY (`fk_clientes`) REFERENCES `clientes` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `ventas_FK_1` FOREIGN KEY (`fk_usuarios`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,'1',NULL,NULL,78,NULL,'2022-06-29 00:00:00',NULL,413,3145),(2,'1',NULL,NULL,3,NULL,'2022-06-29 00:00:00',NULL,413,3145),(3,'1',NULL,NULL,0,NULL,'2022-06-29 19:10:59',NULL,413,3145),(4,'1',NULL,NULL,40,NULL,'2022-06-29 19:31:58',NULL,413,3145),(5,'1',NULL,NULL,40,NULL,'2022-06-29 19:32:22',NULL,413,3145),(6,'1',NULL,NULL,3,NULL,'2022-06-29 19:32:34',NULL,413,3145),(7,'1',NULL,NULL,3,NULL,'2022-06-29 19:34:56',NULL,413,3145),(8,'1',NULL,NULL,5,NULL,'2022-06-29 20:00:34',NULL,413,78),(9,'1',NULL,NULL,5,NULL,'2022-06-29 20:01:12',NULL,413,3145),(10,'1',NULL,NULL,5,NULL,'2022-06-29 20:09:34',NULL,413,31456),(11,'1','ollas de barro',NULL,0,NULL,'2022-06-30 19:31:32',NULL,43,31456),(12,'gansito','ollas de barro',NULL,0,NULL,'2022-06-30 19:32:09',NULL,43,31456);
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'pv_canoa_segunda'
--
/*!50003 DROP FUNCTION IF EXISTS `eliminar_provedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `eliminar_provedores`(idDB int) RETURNS varchar(40) CHARSET latin1
begin

	

	declare idVAR int;

declare aviso varchar(40);	



set idVAR = (select id from pv_canoa_segunda.provedores where id = idDB);

if(idVAR = idDB) then

	DELETE  FROM pv_canoa_segunda.provedores WHERE id= idDB;

set aviso  ="datos eliminados";

else

set aviso = "no hay nada que eliminar";



end if;



return aviso;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `users_validate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `users_validate`(nickname_p varchar(20), pass_p varchar(50)) RETURNS varchar(100) CHARSET latin1
BEGIN

    

 declare nickname varchar (20) ;

 declare  pass varchar (100) ;

	declare salt varchar(50);

set salt = '153624'; 









	SET nickname  = (SELECT pv_canoa_segunda.users.nickname   FROM pv_canoa_segunda.users where  pv_canoa_segunda.users.nickname  = nickname_p);

    SET  pass = (select (cast (aes_decrypt( pv_canoa_segunda.users.pass  ,153624) as char)) from pv_canoa_segunda.users where  pv_canoa_segunda.users.nickname = nickname_p);



   if (nickname_p  = nickname) & (pass_p = pass) then



  return 'correct' ;       

 else

 return 'incorrect';

end if;

 

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_clientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_clientes`(idDb int,nombreDB varchar(30), apellidoDB varchar(30), nicknameDB varchar(30), telefonoDB varchar(30))
begin



	UPDATE pv_canoa_segunda.clientes

SET nombre=nombreDB , apellido=apellidoDB , nickname=nicknameDB , telefono=telefonoDB 

WHERE id=idDB;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_producto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_producto`(idDB bigint, productDB varchar(50), tipoDB varchar(50) , extra_distinctiveDB varchar (50), stockDB smallint, kilogramosDB double, medidaDB double, mililitrosDB double, colorDB varchar(20), tamanoDB double, precioCompraDB double ,precioVentaDB double ,  fk_provedoresDB int , fk_marcaDB varchar(30), fk_lineaDB varchar(30), fk_categoriaDB varchar(30), fk_usuarioDB int)
BEGIN



	declare razonDB varchar (30);

set razonDB = "actualizado";

	

	UPDATE pv_canoa_segunda.productos

SET product=productDB , tipo=tipoDB , extra_distinctive=extra_distinctiveDB , stock=stockDB , kilogramos=kilogramosDB , medida= medidaDB , mililitros=mililitrosDB , color=colorDB , tamano=tamanoDB , precioCompra=precioCompraDB , precioVenta=precioVentaDB , fk_provedores=fk_provedoresDB , fk_marca=fk_marcaDB , fk_linea=fk_lineaDB , fk_categoria=fk_categoriaDB, fk_usuario = fk_usuarioDB, razon = razonDB  

WHERE id=idDB ;



	end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_provedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_provedores`(idDB int,nombreDB varchar(50),apellido1DB varchar(20),apellido2DB varchar(20), empresaDB varchar(20),nombresupervisorDB varchar(50), contactosupervisorDB varchar(50))
begin

	

	declare idVAR int;

declare aviso varchar(20);	

set idVAR = (select id from pv_canoa_segunda.provedores where  id  = idDB);



if(idVAR = idDB)then

	update pv_canoa_segunda.provedores set nombre = nombreDB ,apellido1 = apellido1DB ,apellido2  = apellido2DB ,empresa = empresaDB , nombreSupervisor = nombresupervisorDB ,contactoSupervisor = contactosupervisorDB where id = idDB ; 

	

else

set aviso = "no coinciden";

select aviso;





end if;







END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_usuarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_usuarios`(idDB int, rolDB varchar(30),  nombreDB varchar(30), apellido1DB varchar(30), apellido2DB varchar(30), nicknameDB varchar(30), passDB blob)
begin

	declare salt varchar(50);

set salt = '153624'; 

	







	UPDATE pv_canoa_segunda.usuarios

SET rol=rolDB , nombre=nombreDB , apellido1=apellido1DB , apellido2=apellido2DB , nickname=nicknameDB , pass=AES_ENCRYPT(passDB,salt)

WHERE id=idDB ;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `anadir_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `anadir_cliente`(nombreDB varchar(30), apellidoDB varchar(30), nicknameDB varchar(30), telefonoDB varchar(15))
begin

	

	INSERT INTO pv_canoa_segunda.clientes

(nombre, apellido, nickname, telefono, fecha)

VALUES(nombreDB ,apellidoDB ,nicknameDB , telefonoDB , now());



	

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `añadir_producto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `añadir_producto`(idDB bigint, productDB varchar(50), tipoDB varchar(50) , extra_distinctiveDB varchar (50), stockDB smallint, kilogramosDB double, medidaDB double, mililitrosDB double, colorDB varchar(20), tamanoDB double, precioCompraDB double ,precioVentaDB double ,  fk_provedoresDB int , fk_marcaDB varchar(30), fk_lineaDB varchar(30), fk_categoriaDB varchar(30), fk_usuarioDB int)
begin

	

	declare razonDB varchar (30);

set razonDB = "anadido";

	

	INSERT INTO pv_canoa_segunda.productos

(id, product, tipo, extra_distinctive, stock, kilogramos, medida, mililitros, color, tamano, precioCompra, precioVenta, fecha, fk_provedores, fk_marca, fk_linea, fk_categoria,fk_usuario,razon)



VALUES(idDB, productDB, tipoDB, extra_distinctiveDB , stockDB, kilogramosDB, medidaDB, mililitrosDB, colorDB , tamanoDB, precioCompraDB ,precioVentaDB , now() ,  fk_provedoresDB  , fk_marcaDB, fk_lineaDB , fk_categoriaDB,fk_usuarioDB,razonDB);



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_clientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_clientes`(idDB int)
BEGIN



	SELECT id, nombre, apellido, nickname, telefono, fecha

FROM pv_canoa_segunda.clientes where id = idDB ;



	

	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_etiquetas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_etiquetas`(idDB int)
begin

	

	SELECT  product, tipo, extra_distinctive

FROM pv_canoa_segunda.productos where  id = idDB ;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_provedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_provedores`(in idDB int(20))
begin

	

	declare provedorVAR int;

	set provedorVAR  =(select pv_canoa_segunda.provedores.id from pv_canoa_segunda.provedores where id = idDB);

	if(provedorVAR  = idDB)then

	select * from pv_canoa_segunda.provedores where id = idDB ;

else

select id,nombre,empresa from pv_canoa_segunda.provedores ;



end if;

	

	

	

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_usuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_usuario`(idDB int)
begin

	

	SELECT id, rol, nombre, apellido1, apellido2, nickname, pass, fecha

FROM pv_canoa_segunda.usuarios where id = idDB;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `busca_producto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `busca_producto`( idDB bigint)
BEGIN



SELECT id, product, tipo, extra_distinctive, stock, kilogramos, medida, mililitros, color, tamano, precioCompra, precioVenta, fecha, fk_provedores, fk_marca, fk_linea, fk_categoria

FROM pv_canoa_segunda.productos where id  = idDB ;



	

	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `cargar_movimiento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cargar_movimiento`(saldoInicialDB double, movimientoDB varchar(50), entradaDB double, salidaDB double, motivoDB varchar(200), montoDB double, saldoTotalDelDiaDB double, fk_usuariosDB int)
begin
	
declare datetimeDB datetime;


  

INSERT INTO pv_canoa_segunda.caja
(saldoInicial, movimiento, entrada, salida, motivo, monto, saldoTotalDelDia, fecha, fk_usuarios)



VALUES(saldoInicialDB , movimientoDB ,entradaDB ,salidaDB ,motivoDB,montoDB  ,saldoTotalDelDiaDB  , now() ,  fk_usuariosDB );



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `close_caja` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `close_caja`(saldoInicialDB double, entradasDB double,salidasDB double, usuarioDB int)
BEGIN



	

	

	

	

	

	

	declare totalDB  double;

set totalDB = ((saldoInicialDB+entradasDB)-salidasDB) ; 

	







	INSERT INTO pv_canoa_segunda.cierre_caja

(saldo_inicial, entradas, salidas, total_in_caja, fecha, fk_usuarios)

 VALUES(saldoinicialDB ,entradasDB  ,salidasDB  ,totalDB  , now(), usuarioDB);



	

	



	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_clientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_clientes`(idDB int)
begin

	DELETE FROM pv_canoa_segunda.clientes

WHERE id=idDB ;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `devoluciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `devoluciones`(cantidadDB int,motivoDB varchar (150),fk_productoDB bigint, fk_clienteDB int, fk_usuarioDB int)
begin



	

	

	INSERT INTO pv_canoa_segunda.devoluciones

(cantidad, motivo, fecha_hora, fk_producto, fk_clientes, fk_usuario)

VALUES(cantidadDB ,motivoDB ,now(),fk_productoDB , fk_clienteDB,fk_usuarioDB);



	

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_categoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_categoria`(in categoriaDB varchar(50))
BEGIN



DELETE FROM pv_canoa_segunda.categoria
WHERE id= categoriaDB ;


	end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_linea` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_linea`(in lineaDB varchar(30))
BEGIN

DELETE FROM pv_canoa_segunda.linea WHERE linea=lineaDB ;



	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_marca` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_marca`(in marcaDB varchar(30))
begin

DELETE FROM pv_canoa_segunda.marcas
WHERE marca =  marcaDB ;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_producto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_producto`( usuarioDB int,idproductDB  bigint )
begin

	


	
	
CALL pv_canoa_segunda.tabla_productos_eliminados(usuarioDB,idproductDB);
	

DELETE FROM pv_canoa_segunda.productos WHERE id=idproductDB ;




end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_usuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_usuario`(idDB int )
begin

	DELETE FROM pv_canoa_segunda.usuarios

WHERE id= idDB;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `estadisticas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `estadisticas`(idDB bigint, tabla varchar (50), motivo varchar (50), horainicial varchar (15),horafinal varchar (15) )
BEGIN



	



	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `estadisticas_ganancias` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `estadisticas_ganancias`()
BEGIN



	

	

	

	

	

	

	

	

	

	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `generar_venta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_venta`(productoDB varchar(50), distintivo1DB varchar(50), precioDB double, cantidadDB int, totalDB double, fk_clientesDB int, fk_usuariosDB int, fk_productosDB int)
begin

declare cantidad_total  int;

declare stock_database int;



set stock_database  = (SELECT stock FROM pv_canoa_segunda.productos where id = fk_productosDB  );

set cantidad_total  = (stock_database  - cantidadDB);



if( cantidad_total  >= 0) then

 

	INSERT INTO pv_canoa_segunda.ventas

(producto, distintivo1, precio, cantidad, total, fecha, fk_clientes, fk_usuarios, fk_productos)

VALUES(productoDB ,distintivo1DB ,precioDB ,cantidadDB ,totalDB ,now(), fk_clientesDB , fk_usuariosDB ,fk_productosDB);



UPDATE pv_canoa_segunda.productos

SET  stock= cantidad_total 

WHERE id= fk_productosDB ;



else



select "no alcansa el stock tienes " , stock_database ;



end if;















	

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_user` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_user`()
BEGIN

 DECLARE nom varchar(100);

	declare nick cursor for  select pv_canoa_segunda.users.nickname from pv_canoa_segunda.users;

	 



open nick;



read_loop: loop

fetch nick into nom;

leave read_loop ;

end loop;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_categoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_categoria`(in categoriaDB varchar(30))
BEGIN


INSERT INTO pv_canoa_segunda.categoria (categoria)
VALUES(categoriaDB);


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_linea` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_linea`(in lineaDB varchar(30))
BEGIN



INSERT INTO pv_canoa_segunda.linea
(linea)
VALUES(lineaDB);





	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_marca` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_marca`(in marcaDB varchar(30))
BEGIN


INSERT INTO pv_canoa_segunda.marcas
(marca)
VALUES(marcaDB);




	

	

	

	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_provedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_provedores`(in nombreDB varchar(50),in apellido1DB varchar(20),in apellido2DB varchar(20),in empresaDB varchar(20),in nombreSupervisorDB varchar(50),in contactoSupervisorDB varchar(20))
begin

	

	INSERT INTO pv_canoa_segunda.provedores

(nombre, apellido1, apellido2, empresa, nombreSupervisor, contactoSupervisor)

VALUES(nombreDB, apellido1DB, apellido2DB, empresaDB, nombreSupervisorDB, contactoSupervisorDB);



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_usuarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_usuarios`(in idDB int(11), in rolDB varchar(30), in nombreDB varchar(30), in apellido1DB varchar(30), in apellido2DB varchar(30),in nicknameDB varchar(30),in passDB blob)
BEGIN



declare salt varchar(50);



set salt = '153624'; 

	















INSERT INTO pv_canoa_segunda.usuarios

(id, rol, nombre, apellido1, apellido2, nickname, pass, fecha)

VALUES(idDB , rolDB ,nombreDB , apellido1DB ,apellido2DB , nicknameDB ,AES_ENCRYPT(passDB,salt)  , now());





	



	end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mostrar_movimientos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrar_movimientos`(fechaInicioDB varchar(15), horaInicioDB varchar(15),fechaFinDB varchar(15), horaFinDB varchar(15))
BEGIN



	
	declare fechaRecibida1 datetime;
declare fechaRecibida2 datetime;

set fechaRecibida1  = str_to_date(concat(fechaInicioDB," ",horaInicioDB),"%Y-%m-%d %H:%i:%s" );
set fechaRecibida2  = str_to_date(concat(fechaFinDB," ",horaFinDB),"%Y-%m-%d %H:%i:%s");


select * from pv_canoa_segunda.caja  where fecha between fechaRecibida1 and fechaRecibida2 ; 




	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `prueba` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `prueba`(inout n int)
BEGIN



	select 150 into n;

	

	

	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `search_data` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `search_data`(in insert_id bigint, in insert_product varchar (50))
begin

	SELECT id, product, tipo, extra_distinctive, stock, kilogramos, centimeters, mililiters, color, purchase_price, selling_price, extra_data

FROM pv_canoa_segunda.products where id = insert_id or product = insert_product;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `tabla_productos_eliminados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `tabla_productos_eliminados`(usuarioDB int, productoDB bigint)
BEGIN


	declare razonDB varchar (30);
declare Nproducto  varchar(50);
declare tipoDB varchar(50);

   set Nproducto  = (select product from pv_canoa_segunda.productos where id = productoDB); 
   set tipoDB = (select tipo from pv_canoa_segunda.productos where id =  productoDB);
  
INSERT INTO pv_canoa_segunda.productos_eliminados (fk_usuario, fk_producto, product, tipo , razon, fecha)

VALUES(usuarioDB , productoDB ,Nproducto  ,tipoDB  ,"Eliminado", now());


	end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `test` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `test`()
begin

	

declare var int ;



set var   = (SELECT stock  FROM pv_canoa_segunda.productos where id  = 65);





select var ;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `users_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `users_insert`(in id_p int(3) ,in name_p varchar(20), in  first_name_p varchar(20),in second_name_p varchar(20), in nickame_p varchar(20),in pass_p varchar(100))
begin


	declare salt varchar(50);


set salt = '153624'; 

	





INSERT INTO pv_canoa_segunda.users (id, nombre, first_name, second_name, nickname, pass) values( id_p , name_p  , first_name_p  ,second_name_p  , nickame_p  , AES_ENCRYPT(pass_p  ,salt));





	

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ver_categoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ver_categoria`()
begin
	
	SELECT id,categoria
FROM pv_canoa_segunda.categoria;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ver_clientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ver_clientes`()
begin

	SELECT id, nombre, apellido, nickname, telefono, fecha

FROM pv_canoa_segunda.clientes;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ver_lineas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ver_lineas`()
begin
SELECT id, linea
FROM pv_canoa_segunda.linea;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ver_marcas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ver_marcas`()
begin
	
SELECT id, marca
FROM pv_canoa_segunda.marcas;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ver_movimientos_devoluciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ver_movimientos_devoluciones`(fechaInicioDB varchar(15), horaInicioDB varchar(15),fechaFinDB varchar(15), horaFinDB varchar(15))
BEGIN





	

	declare fechaRecibida1 datetime;

declare fechaRecibida2 datetime;

declare diferencia int ;


set fechaRecibida1  = str_to_date(concat(fechaInicioDB," ",horaInicioDB),"%Y-%m-%d %H:%i:%s" );

set fechaRecibida2  = str_to_date(concat(fechaFinDB," ",horaFinDB),"%Y-%m-%d %H:%i:%s");

set diferencia = timestampdiff(hour ,fechaRecibida1 ,fechaRecibida2);

 
if(fechaRecibida1 = fechaRecibida2) then
select usuarios.nickname,clientes.id ,devoluciones.fecha_hora,productos.id,productos.product,productos.tipo,devoluciones.motivo,devoluciones.cantidad  from pv_canoa_segunda.devoluciones left join productos  ON  devoluciones.fk_producto = productos.id  left join usuarios on devoluciones.fk_usuario = usuarios.id left  join clientes  on fk_clientes = clientes.id where fecha_hora >= fechaRecibida1 and fecha_hora <= fechaRecibida2;select usuarios.nickname,clientes.id ,devoluciones.fecha_hora,productos.id,productos.product,productos.tipo,devoluciones.motivo,devoluciones.cantidad  from pv_canoa_segunda.devoluciones left join productos  ON  devoluciones.fk_producto = productos.id  left join usuarios on devoluciones.fk_usuario = usuarios.id left  join clientes  on fk_clientes = clientes.id where fecha_hora like concat('%', date_format(fechaRecibida1,"%Y-%m-%d"),'%' );


else


select usuarios.nickname,clientes.id ,devoluciones.fecha_hora,productos.id,productos.product,productos.tipo,devoluciones.motivo,devoluciones.cantidad  from pv_canoa_segunda.devoluciones left join productos  ON  devoluciones.fk_producto = productos.id  left join usuarios on devoluciones.fk_usuario = usuarios.id left  join clientes  on fk_clientes = clientes.id where fecha_hora >= fechaRecibida1 and fecha_hora <= date_add( fechaRecibida2, interval  1  hour);
 

end if;







	

	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ver_ventas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ver_ventas`(idDb int,fechaInicioDB varchar(15), horaInicioDB varchar(15),fechaFinDB varchar(15), horaFinDB varchar(15))
begin

	declare fechaRecibida1 datetime;

declare fechaRecibida2 datetime;

declare intervalo int;





set fechaRecibida1  = str_to_date(concat(fechaInicioDB," ",horaInicioDB),"%Y-%m-%d %H:%i:%s" );

set fechaRecibida2  = str_to_date(concat(fechaFinDB," ",horaFinDB),"%Y-%m-%d %H:%i:%s");

set intervalo =  timestampdiff (second,fechaRecibida1,fechaRecibida2); 




if(fechaRecibida1 = fechaRecibida2 && idDb != 0) then

select usuarios.nickname,clientes.nombre ,ventas.id,productos.product, productos.tipo , productos.precioVenta , ventas.cantidad ,ventas.total,ventas.fecha from pv_canoa_segunda.ventas  left join productos  ON  ventas.fk_productos = productos.id  left join usuarios on ventas.fk_usuarios  = usuarios.id left  join clientes  on ventas.fk_clientes  = clientes.id where ventas.fecha like concat('%', date_format(fechaRecibida1,"%Y-%m-%d"),'%')  && ventas.fk_usuarios  = idDb;

elseif (fechaRecibida1 = fechaRecibida2 && idDb = 0) then 

select usuarios.nickname,clientes.nombre ,ventas.id,productos.product, productos.tipo , productos.precioVenta , ventas.cantidad ,ventas.total,ventas.fecha from pv_canoa_segunda.ventas  left join productos  ON  ventas.fk_productos = productos.id  left join usuarios on ventas.fk_usuarios  = usuarios.id left  join clientes  on ventas.fk_clientes  = clientes.id where ventas.fecha like concat('%', date_format(fechaRecibida1,"%Y-%m-%d"),'%')  ;




elseif (fechaRecibida1 != fechaRecibida2 && idDb = 0 ) then 

select usuarios.nickname,clientes.nombre ,ventas.id,productos.product, productos.tipo , productos.precioVenta , ventas.cantidad ,ventas.total,ventas.fecha from pv_canoa_segunda.ventas left join productos  ON  ventas.fk_productos  = productos.id  left join usuarios on ventas.fk_usuarios  = usuarios.id left  join clientes  on ventas.fk_clientes  = clientes.id where ventas.fecha >= fechaRecibida1  and ventas.fecha <= date_add( fechaRecibida1, interval  intervalo  second)   ;





else

select usuarios.nickname,clientes.nombre ,ventas.id,productos.product, productos.tipo , productos.precioVenta , ventas.cantidad ,ventas.total,ventas.fecha from pv_canoa_segunda.ventas left join productos  ON  ventas.fk_productos  = productos.id  left join usuarios on ventas.fk_usuarios  = usuarios.id left  join clientes  on ventas.fk_clientes  = clientes.id where ventas.fecha >= fechaRecibida1 and ventas.fecha >= fechaRecibida1  and ventas.fecha <= date_add( fechaRecibida1, interval  intervalo  second) && ventas.fk_usuarios = idDb ;
 

end if;









END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-26 15:31:40
