-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: pv_canoa_segunda
-- ------------------------------------------------------
-- Server version	5.5.5-10.6.5-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
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
  `motivo` varchar(200) NOT NULL,
  `monto` double NOT NULL,
  `fecha` datetime NOT NULL,
  `fk_usuarios` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `caja_FK_3` (`fk_usuarios`),
  CONSTRAINT `caja_FK_3` FOREIGN KEY (`fk_usuarios`) REFERENCES `usuarios` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=186 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja`
--

LOCK TABLES `caja` WRITE;
/*!40000 ALTER TABLE `caja` DISABLE KEYS */;
INSERT INTO `caja` VALUES (159,10,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',10,'2022-12-04 18:42:13',1),(160,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 18:44:24',1),(161,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 18:45:02',1),(162,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 18:46:30',1),(163,0,'ENTRADA DE EFECTIVO','ingreso extra',20,'2022-12-04 18:47:14',1),(164,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 18:58:21',1),(165,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 19:02:48',1),(166,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 19:07:05',1),(167,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 19:08:30',1),(168,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 19:09:24',1),(169,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 19:10:16',1),(170,0,'ENTRADA','SALDO INICIAL',0,'2022-12-04 19:11:43',NULL),(171,100,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',100,'2022-12-04 19:13:26',1),(172,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 19:13:40',1),(173,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 19:41:49',1),(174,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 19:42:33',1),(175,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 19:47:31',1),(176,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 19:52:51',1),(177,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 19:53:38',1),(178,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 19:54:23',1),(179,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 20:15:49',1),(180,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 20:21:07',1),(181,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 20:21:31',1),(182,45,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',45,'2022-12-04 20:22:11',1),(183,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 20:22:28',1),(184,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-04 20:25:43',1),(185,0,'ENTRADA DE EFECTIVO INICIAL','SALDO INICIAL',0,'2022-12-06 10:20:34',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (27,'bebidas');
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
  `saldo_inicial` double DEFAULT NULL,
  `entradas` double DEFAULT NULL,
  `salidas` double DEFAULT NULL,
  `saldo_total` double DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `fk_idusuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cierre_caja_FK` (`fk_idusuario`),
  CONSTRAINT `cierre_caja_FK` FOREIGN KEY (`fk_idusuario`) REFERENCES `usuarios` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cierre_caja`
--

LOCK TABLES `cierre_caja` WRITE;
/*!40000 ALTER TABLE `cierre_caja` DISABLE KEYS */;
INSERT INTO `cierre_caja` VALUES (27,0,114,20,94,'2022-12-04 19:10:59',1),(28,100,114,20,194,'2022-12-04 19:13:35',1),(29,0,166,20,146,'2022-12-04 20:15:52',1),(30,0,166,20,146,'2022-12-04 20:21:14',1),(31,0,166,20,146,'2022-12-04 20:21:49',1),(32,45,166,20,191,'2022-12-04 20:22:19',1),(33,0,166,20,146,'2022-12-04 20:26:26',1),(34,0,0,0,0,'2022-12-06 10:22:04',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (67,'rosa ','sanchez','primera','22265124','2022-12-04 18:03:47');
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
  CONSTRAINT `devoluciones_FK` FOREIGN KEY (`fk_producto`) REFERENCES `productos` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `devoluciones_FK_1` FOREIGN KEY (`fk_clientes`) REFERENCES `clientes` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `devoluciones_FK_2` FOREIGN KEY (`fk_usuario`) REFERENCES `usuarios` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devoluciones`
--

LOCK TABLES `devoluciones` WRITE;
/*!40000 ALTER TABLE `devoluciones` DISABLE KEYS */;
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
  CONSTRAINT `estadisticas_FK_4` FOREIGN KEY (`fk_caja`) REFERENCES `caja` (`id`) ON UPDATE CASCADE
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
-- Table structure for table `impresora`
--

DROP TABLE IF EXISTS `impresora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `impresora` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_empresa` varchar(200) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `despedida` varchar(100) NOT NULL,
  `nombre_impresora` varchar(100) DEFAULT NULL,
  `fecha` datetime NOT NULL,
  `usuario` int(11) NOT NULL,
  `cliente` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impresora`
--

LOCK TABLES `impresora` WRITE;
/*!40000 ALTER TABLE `impresora` DISABLE KEYS */;
/*!40000 ALTER TABLE `impresora` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linea`
--

LOCK TABLES `linea` WRITE;
/*!40000 ALTER TABLE `linea` DISABLE KEYS */;
INSERT INTO `linea` VALUES (27,'refrescos');
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES (19,'Coca cola');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos_productos`
--

DROP TABLE IF EXISTS `movimientos_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimientos_productos` (
  `codigo_producto` bigint(20) DEFAULT NULL,
  `producto` varchar(100) DEFAULT NULL,
  `distintivo1` varchar(100) DEFAULT NULL,
  `stock_antiguo` int(11) DEFAULT NULL,
  `stock_nuevo` int(11) DEFAULT NULL,
  `motivo` varchar(27) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos_productos`
--

LOCK TABLES `movimientos_productos` WRITE;
/*!40000 ALTER TABLE `movimientos_productos` DISABLE KEYS */;
INSERT INTO `movimientos_productos` VALUES (1,'gggggggss','ddddddd',0,0,'eliminado',1,'2022-11-28 19:28:49'),(2,'asdas','asdas',0,0,'eliminado',1,'2022-11-28 19:28:49'),(7,'asdas','asdas',0,0,'eliminado',NULL,'2022-11-28 19:28:49'),(60,'s2222','dfas',12321,0,'eliminado',NULL,'2022-11-28 19:28:49'),(80,'s2222','dfas',12321,0,'eliminado',NULL,'2022-11-28 19:28:49'),(90,'s2222','dfas',12321,0,'eliminado',NULL,'2022-11-28 19:28:49'),(1231,'aaaaaaa','ddddddd',365,0,'eliminado',NULL,'2022-11-28 19:28:49'),(2131,'3213','21312',32,0,'eliminado',NULL,'2022-11-28 19:28:49'),(3145,'panes de dulce','de colores',0,0,'eliminado',NULL,'2022-11-28 19:28:49'),(6565,'46546','45645645',6546,0,'eliminado',NULL,'2022-11-28 19:28:49'),(12312,'231','321',2312314,0,'eliminado',NULL,'2022-11-28 19:28:49'),(12313,'sda','ffsad',1,0,'eliminado',NULL,'2022-11-28 19:28:49'),(25518,'hgfhf','hgfhg',1,0,'eliminado',1,'2022-11-28 19:28:49'),(31456,'nuevos panes e duces','chocolate',66,0,'eliminado',NULL,'2022-11-28 19:28:49'),(31475,'fdsfsdfs','de colores',-2,0,'eliminado',NULL,'2022-11-28 19:28:49'),(54654,'6546','546546',454,0,'eliminado',NULL,'2022-11-28 19:28:49'),(66152,'vcvxcv','vxcvxv',210,0,'eliminado',1,'2022-11-28 19:28:49'),(235599,'fsdfsdfs','fsdfdsf',20,0,'eliminado',1,'2022-11-28 19:28:49'),(322792,'hgf','hgfhgfh',212,0,'eliminado',1,'2022-11-28 19:28:49'),(398636,'hgfhfh','ghfhgf',10,0,'eliminado',1,'2022-11-28 19:28:49'),(456546,'45645','6546456',5465,0,'eliminado',NULL,'2022-11-28 19:28:49'),(765055,'bvnbv','nbvnbv',12,0,'eliminado',1,'2022-11-28 19:28:49'),(786269,'hgfhgf','hgfhgf',2,0,'eliminado',1,'2022-11-28 19:28:49'),(999558,'45645','6546456',5465,0,'eliminado',NULL,'2022-11-28 19:28:49'),(3527525,'jhj','gjghj',1231,0,'eliminado',NULL,'2022-11-28 19:28:49'),(4646513,'sad','sad',10,0,'eliminado',NULL,'2022-11-28 19:28:49'),(9995586,'45645','6546456',5465,0,'eliminado',NULL,'2022-11-28 19:28:49'),(75925168,'jhj','gjghj',1231,0,'eliminado',NULL,'2022-11-28 19:28:49'),(780083146221,'brosoflux','medicina',5,0,'eliminado',1,'2022-11-28 19:28:49'),(2190839452139,'adada','dsafasdfa',1312,0,'eliminado',NULL,'2022-11-28 19:28:49'),(3576953937339,'<','asdsdasd',2123,0,'eliminado',NULL,'2022-11-28 19:28:49'),(4420061396957,'gfdg','dfgdfgdf',343,0,'eliminado',NULL,'2022-11-28 19:28:49'),(6243340423249,'ayyyyy','yyy',232323,0,'eliminado',NULL,'2022-11-28 19:28:49'),(6679656518349,'ggg','gghhh',2,0,'eliminado',NULL,'2022-11-28 19:28:49'),(6825166629653,'jhgjf','j',30,0,'eliminado',NULL,'2022-11-28 19:28:49'),(9578302976396,'s2222','dfas',12321,0,'eliminado',NULL,'2022-11-28 19:28:49'),(515606,'pepsi','ertiquetra',0,20,'agregado',1,'2022-12-04 18:50:15'),(515606,'pepsi','ertiquetra',20,18,'actualizado',1,'2022-12-04 18:53:52'),(515606,'pepsi','ertiquetra',18,17,'actualizado',1,'2022-12-04 19:29:14'),(1,'s2222','dfas',0,12321,'agregado',NULL,'2022-12-05 14:09:10'),(123,'pasado','dfas',0,12321,'agregado',NULL,'2022-12-05 14:09:51'),(124,'hoy','dfas',0,12321,'agregado',NULL,'2022-12-05 14:10:08'),(66,'15 dias','dfas',0,12321,'agregado',NULL,'2022-12-05 14:10:25'),(689,'hoy','dfas',0,12321,'agregado',NULL,'2022-12-05 14:15:38'),(66,'15 dias','dfas',12321,12321,'actualizado',NULL,'2022-12-05 14:16:38'),(123,'pasado','dfas',12321,12321,'actualizado',NULL,'2022-12-05 14:16:38'),(604488,'sssssssssssss','sssssssssssss',0,434,'agregado',1,'2022-12-06 10:20:51'),(589741,'kkk','kkk',0,54,'agregado',1,'2022-12-06 10:21:08'),(892278,'dddd','dddddddddddd',0,43,'agregado',1,'2022-12-06 10:21:32');
/*!40000 ALTER TABLE `movimientos_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perdidas_devoluciones`
--

DROP TABLE IF EXISTS `perdidas_devoluciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perdidas_devoluciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` bigint(20) DEFAULT NULL,
  `producto` varchar(100) DEFAULT NULL,
  `descripcion1` varchar(150) DEFAULT NULL,
  `descripcion2` varchar(200) DEFAULT NULL,
  `unidades` int(11) DEFAULT NULL,
  `cantidad_devolver` double DEFAULT NULL,
  `motivo` varchar(100) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `fk_cliente` int(11) DEFAULT NULL,
  `fk_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `perdidas_devoluciones_FK` (`fk_cliente`),
  KEY `perdidas_devoluciones_FK_1` (`fk_usuario`),
  CONSTRAINT `perdidas_devoluciones_FK` FOREIGN KEY (`fk_cliente`) REFERENCES `clientes` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `perdidas_devoluciones_FK_1` FOREIGN KEY (`fk_usuario`) REFERENCES `usuarios` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perdidas_devoluciones`
--

LOCK TABLES `perdidas_devoluciones` WRITE;
/*!40000 ALTER TABLE `perdidas_devoluciones` DISABLE KEYS */;
INSERT INTO `perdidas_devoluciones` VALUES (43,1,NULL,NULL,NULL,2,20,'CADUCADO','2022-12-04 18:22:48',67,1);
/*!40000 ALTER TABLE `perdidas_devoluciones` ENABLE KEYS */;
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
  `tipo` varchar(50) NOT NULL,
  `extra_distinctive` varchar(50) DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `kilogramos` double DEFAULT NULL,
  `medida` double DEFAULT NULL,
  `mililitros` double DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `tamano` varchar(17) DEFAULT NULL,
  `precioCompra` double NOT NULL,
  `precioVenta` double NOT NULL,
  `fecha` datetime NOT NULL,
  `fk_provedores` int(11) DEFAULT NULL,
  `fk_marca` int(11) DEFAULT NULL,
  `fk_linea` int(11) DEFAULT NULL,
  `fk_categoria` int(11) DEFAULT NULL,
  `fk_usuario` int(11) DEFAULT NULL,
  `notas_de_venta` varchar(300) DEFAULT NULL,
  `caducidad` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `productos_FK_3` (`fk_provedores`),
  KEY `productos_FK` (`fk_categoria`),
  KEY `productos_FK_1` (`fk_linea`),
  KEY `productos_FK_2` (`fk_marca`),
  KEY `productos_FK_4` (`fk_usuario`),
  CONSTRAINT `productos_FK` FOREIGN KEY (`fk_categoria`) REFERENCES `categoria` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
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
INSERT INTO `productos` VALUES (1,'s2222','dfas',NULL,12321,NULL,NULL,NULL,NULL,'231',32131,2131,'2022-12-05 14:09:10',NULL,NULL,NULL,NULL,NULL,'fasda','2022-12-30 00:00:00'),(66,'15 dias','dfas',NULL,12321,NULL,NULL,NULL,NULL,'231',32131,2131,'2022-12-05 14:10:25',NULL,NULL,NULL,NULL,NULL,'fasda','2022-12-20 00:00:00'),(123,'pasado','dfas',NULL,12321,NULL,NULL,NULL,NULL,'231',32131,2131,'2022-12-05 14:09:51',NULL,NULL,NULL,NULL,NULL,'fasda','2022-12-21 00:00:00'),(124,'hoy','dfas',NULL,12321,NULL,NULL,NULL,NULL,'231',32131,2131,'2022-12-05 14:10:08',NULL,NULL,NULL,NULL,NULL,'fasda','2022-11-25 00:00:00'),(689,'hoy','dfas',NULL,12321,NULL,NULL,NULL,NULL,'231',32131,2131,'2022-12-05 14:15:38',NULL,NULL,NULL,NULL,NULL,'fasda','2022-12-05 00:00:00'),(515606,'pepsi','ertiquetra','',17,20,5,40,'rojo','grande',1000,52,'2022-12-04 18:50:15',53,19,27,27,1,'se vende sueltos','0000-00-00 00:00:00'),(589741,'kkk','kkk','',54,NULL,NULL,NULL,'',NULL,545,65,'2022-12-06 10:21:08',NULL,NULL,NULL,NULL,1,'','2022-12-06 00:00:00'),(604488,'sssssssssssss','sssssssssssss','',434,NULL,NULL,NULL,'',NULL,324,33,'2022-12-06 10:20:51',NULL,NULL,NULL,NULL,1,'','0000-00-00 00:00:00'),(892278,'dddd','dddddddddddd','',43,NULL,NULL,NULL,'',NULL,43,43,'2022-12-06 10:21:32',NULL,NULL,NULL,NULL,1,'','2023-10-06 00:00:00');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER anadir_producto_AI
AFTER INSERT
ON productos FOR EACH ROW
INSERT INTO pv_canoa_segunda.movimientos_productos
(codigo_producto, producto, distintivo1, stock_antiguo, stock_nuevo, motivo, usuario, fecha)
VALUES(new.id, new.product,  new.tipo, 0, new.stock, "agregado", new.fk_usuario, now()) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER actualiza_productos_BU
BEFORE update 
ON productos FOR EACH row



INSERT INTO pv_canoa_segunda.movimientos_productos
(codigo_producto, producto, distintivo1, stock_antiguo, stock_nuevo, motivo, usuario, fecha)

VALUES(new.id , new.product, new.tipo, old.stock, new.stock , "actualizado", new.fk_usuario, now()) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER elimina_productos_AD
AFTER delete
ON productos FOR EACH row

INSERT INTO pv_canoa_segunda.movimientos_productos
(codigo_producto, producto, distintivo1, stock_antiguo, stock_nuevo, motivo, usuario, fecha)
VALUES(old.id, old.product, old.tipo, old.stock, 0 , "eliminado", old.fk_usuario,now()) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
  CONSTRAINT `productos_eliminados_FK` FOREIGN KEY (`fk_usuario`) REFERENCES `usuarios` (`id`) ON DELETE SET NULL,
  CONSTRAINT `productos_eliminados_FK_1` FOREIGN KEY (`fk_producto`) REFERENCES `productos` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos_eliminados`
--

LOCK TABLES `productos_eliminados` WRITE;
/*!40000 ALTER TABLE `productos_eliminados` DISABLE KEYS */;
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
  `contacto` varchar(20) DEFAULT NULL,
  `empresa` varchar(20) DEFAULT NULL,
  `nombreSupervisor` varchar(50) DEFAULT NULL,
  `contactoSupervisor` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provedores`
--

LOCK TABLES `provedores` WRITE;
/*!40000 ALTER TABLE `provedores` DISABLE KEYS */;
INSERT INTO `provedores` VALUES (53,'joaquin ','doriga','22201023004','','','');
/*!40000 ALTER TABLE `provedores` ENABLE KEYS */;
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
INSERT INTO `usuarios` VALUES (1,'ADMINISTRADOR','ADMIN ','','','ADMIN',':`ÊÃä¿tÝ5¦³ÿaD','2022-11-28 19:45:13');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fk_productos` bigint(20) DEFAULT NULL,
  `producto` varchar(50) DEFAULT NULL,
  `distintivo1` varchar(50) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `fecha` datetime NOT NULL,
  `fk_clientes` int(11) DEFAULT NULL,
  `fk_usuarios` int(11) DEFAULT NULL,
  `numero_venta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ventas_FK` (`fk_clientes`),
  KEY `ventas_FK_1` (`fk_usuarios`),
  KEY `ventas_FK_2` (`fk_productos`),
  CONSTRAINT `venta_FK` FOREIGN KEY (`fk_usuarios`) REFERENCES `usuarios` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `venta_FK_1` FOREIGN KEY (`fk_clientes`) REFERENCES `clientes` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=307 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (305,515606,'pepsi','ertiquetra',52,2,94,'2022-12-04 18:53:52',NULL,1,2),(306,515606,'pepsi','ertiquetra',52,1,52,'2022-12-04 19:29:14',67,1,3);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
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









	SET nickname  = (SELECT pv_canoa_segunda.usuarios.nickname    FROM pv_canoa_segunda.usuarios   where  nickname  = nickname_p);

    SET  pass = (select (cast (aes_decrypt( pv_canoa_segunda.usuarios  ,153624) as char)) from pv_canoa_segunda.usuarios  where  pv_canoa_segunda.users.nickname = nickname_p);



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
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_producto`(idDB bigint, productDB varchar(50), tipoDB varchar(50) , extra_distinctiveDB varchar (50), stockDB smallint, kilogramosDB double, medidaDB double, mililitrosDB double, colorDB varchar(20), tamanoDB varchar(50), precioCompraDB double ,precioVentaDB double ,  fk_provedoresDB varchar(50) , fk_marcaDB varchar(50), fk_lineaDB varchar(50), fk_categoriaDB varchar(50), fk_usuarioDB varchar(50),notas_ventaDB varchar (300))
BEGIN

declare	 provedoresDB  int;
declare	 marcaDB int; 
declare lineaDB int; 
declare	 categoriaDB int;
declare	 usuarioDB int;
declare razonDB varchar (30);

set provedoresDB  = (select id from pv_canoa_segunda.provedores where nombre = fk_provedoresDB  );
set marcaDB = (select id from pv_canoa_segunda.marcas  where marca  = fk_marcaDB   );
set lineaDB  = (select id from pv_canoa_segunda.linea  where linea  = fk_lineaDB   );
set categoriaDB  = (select id from pv_canoa_segunda.categoria  where categoria  = fk_categoriaDB   );
set usuarioDB  = (select id from pv_canoa_segunda.usuarios  where nickname  = fk_usuarioDB  );
set razonDB = "actualizado";


	

	UPDATE pv_canoa_segunda.productos

SET product=productDB , tipo=tipoDB , extra_distinctive=extra_distinctiveDB , stock=stockDB , kilogramos=kilogramosDB , medida= medidaDB , mililitros=mililitrosDB , color=colorDB , tamano=tamanoDB , precioCompra=precioCompraDB , precioVenta=precioVentaDB , fk_provedores=provedoresDB , fk_marca=marcaDB , fk_linea=lineaDB , fk_categoria=categoriaDB, fk_usuario = usuarioDB,notas_de_venta = notas_ventaDB 

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_provedores`(idDB int,nombreDB varchar(50),apellido1DB varchar(20),contactoDB varchar(20), empresaDB varchar(20),nombresupervisorDB varchar(50), contactosupervisorDB varchar(50))
begin

	/*
	declare idVAR int;
declare aviso varchar(20);	
set idVAR = (select id from pv_canoa_segunda.provedores where  id  = idDB);
if(idVAR = idDB)then
	update pv_canoa_segunda.provedores set nombre = nombreDB ,apellido1 = apellido1DB ,apellido2  = apellido2DB ,empresa = empresaDB , nombreSupervisor = nombresupervisorDB ,contactoSupervisor = contactosupervisorDB where id = idDB ; 
else
set aviso = "no coinciden";
select aviso;
end if;

*/
UPDATE pv_canoa_segunda.provedores
set nombre = nombreDB ,apellido1 = apellido1DB ,contacto  = contactoDB  ,empresa = empresaDB , nombreSupervisor = nombresupervisorDB ,contactoSupervisor = contactosupervisorDB where id = idDB; 






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
/*!50003 DROP PROCEDURE IF EXISTS `anadir_devoluciones_perdidas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `anadir_devoluciones_perdidas`(id_productoDB bigint,unidadesDB int, cantidadDB double,motivoDB varchar(100),fk_clienteDB varchar(100),fk_usuarioDB int)
begin
declare descripcion1In varchar (100);
declare descripcion2In varchar (150);
declare productoIn varchar(100);

set descripcion1In 	  = (select tipo from pv_canoa_segunda.productos  where id = id_productoDB);
set descripcion2In  = (select extra_distinctive  from pv_canoa_segunda.productos  where id = id_productoDB);
set productoIn  = (select product from pv_canoa_segunda.productos where id = id_productoDB);
	
INSERT INTO pv_canoa_segunda.perdidas_devoluciones
(id_producto, producto, descripcion1, descripcion2, unidades, cantidad_devolver, motivo ,fecha, fk_cliente, fk_usuario)
VALUES(id_productoDB ,productoIn ,descripcion1In  ,descripcion2In  ,unidadesDB ,cantidadDB, motivoDB ,now(), fk_clienteDB ,fk_usuarioDB);



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `aÃ±adir_producto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `aÃ±adir_producto`(idDB bigint, productDB varchar(50), tipoDB varchar(50) , extra_distinctiveDB varchar (50), stockDB int, kilogramosDB double, medidaDB double, mililitrosDB double, colorDB varchar(20), tamanoDB varchar(50), precioCompraDB double ,precioVentaDB double ,  fk_provedoresDB varchar(30) , fk_marcaDB varchar(30), fk_lineaDB varchar(30), fk_categoriaDB varchar(30), fk_usuarioDB varchar(30),notas_ventaDB varchar(300), caducidadP varchar(30))
begin

declare fechaRecibida1 datetime;

declare razonDB varchar (30);
declare provedoresCast int;
declare marcaCast int;
declare lineaCast int;
declare categoriaCast int;
declare usuariosCast int;
set fechaRecibida1  = str_to_date(caducidadP ,"%Y-%m-%d" );
set provedoresCast = (select id from pv_canoa_segunda.provedores where nombre = fk_provedoresDB );
set marcaCast  = (select id from pv_canoa_segunda.marcas  where marca  =  fk_marcaDB) ;
set lineaCast  = (select id from pv_canoa_segunda.linea  where  linea = fk_lineaDB  );
set categoriaCast  = (select id from pv_canoa_segunda.categoria  where categoria  = fk_categoriaDB );
set usuariosCast  = (select id from pv_canoa_segunda.usuarios  where nickname = fk_usuarioDB );

set razonDB = "anadido";

	

	INSERT INTO pv_canoa_segunda.productos

(id, product, tipo, extra_distinctive, stock, kilogramos, medida, mililitros, color, tamano, precioCompra, precioVenta, fecha, fk_provedores, fk_marca, fk_linea, fk_categoria,fk_usuario,notas_de_venta,caducidad)



VALUES(idDB, productDB, tipoDB, extra_distinctiveDB , stockDB, kilogramosDB, medidaDB, mililitrosDB, colorDB , tamanoDB, precioCompraDB ,precioVentaDB , now() ,  provedoresCast  ,marcaCast , lineaCast  , categoriaCast ,usuariosCast ,notas_ventaDB,fechaRecibida1);



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
/*!50003 DROP PROCEDURE IF EXISTS `buscar_id_ventas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_id_ventas`(in idDB bigint)
begin
	SELECT id, product, tipo, stock, precioVenta , notas_de_venta 
FROM pv_canoa_segunda.productos where id  = idDB ;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_producto_per_dev` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_producto_per_dev`(idDB int)
begin
	SELECT  product, tipo, extra_distinctive, precioVenta
FROM pv_canoa_segunda.productos where id = idDB ;
	
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

	
/*
	declare provedorVAR int;

	set provedorVAR  =(select pv_canoa_segunda.provedores.id from pv_canoa_segunda.provedores where id = idDB);

	if(provedorVAR  = idDB)then

	select * from pv_canoa_segunda.provedores where id = idDB ;

else

select id,nombre,empresa from pv_canoa_segunda.provedores ;



end if;

	
*/SELECT id, nombre, apellido1, contacto, empresa, nombreSupervisor, contactoSupervisor
FROM pv_canoa_segunda.provedores where id = idDB ;


	

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_usuario`(idDB int,out passDB varchar(100))
begin

	

 

 declare  passvar varchar (100) ;

	declare salt varchar(50);

set salt = '153624'; 






	

    SET  passDB  = (select (cast (aes_decrypt( pv_canoa_segunda.usuarios.pass  ,153624) as char)) from pv_canoa_segunda.usuarios  where  pv_canoa_segunda.usuarios.id  = idDB);


   	
   
	SELECT id, rol, nombre, apellido1, apellido2, nickname, pass , fecha

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `busca_producto`(idDB bigint)
BEGIN




SELECT productos.id, productos.product, productos.tipo, productos.extra_distinctive, productos.stock, productos.kilogramos, productos.medida, productos.mililitros, productos.color, productos.tamano, productos.precioCompra, productos.precioVenta, provedores.nombre ,marcas.marca , linea.linea , categoria.categoria , usuarios.nickname,productos.notas_de_venta  
FROM pv_canoa_segunda.productos left join provedores on productos.fk_provedores = provedores.id  left join marcas on productos.fk_marca = marcas.id left join linea on productos.fk_linea = linea.id left join categoria on productos.fk_categoria = categoria.id  left join usuarios on productos.fk_usuario = usuarios.nickname where productos.id  = idDB ;




	

	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `calcularEntradasCaja` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calcularEntradasCaja`(dataInicio varchar(20), idP int)
begin

	declare fechaRecibida1 datetime;

set fechaRecibida1  = str_to_date(dataInicio,"%Y-%m-%d %H:%i:%s" );

	select sum(monto)  from pv_canoa_segunda.caja 
where fecha like concat('%', date_format(fechaRecibida1,"%Y-%m-%d"),'%') AND fk_usuarios  = idP AND movimiento != 'ENTRADA DE EFECTIVO INICIAL'AND movimiento != 'SALIDA DE EFECTIVO';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `calcularPerdidasDevoluciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calcularPerdidasDevoluciones`(dataInicio varchar(20), idP int)
begin

	declare fechaRecibida1 datetime;

set fechaRecibida1  = str_to_date(dataInicio,"%Y-%m-%d %H:%i:%s" );

	select sum(cantidad_devolver)  from pv_canoa_segunda.perdidas_devoluciones
where fecha like concat('%', date_format(fechaRecibida1,"%Y-%m-%d"),'%') AND fk_usuario  = idP ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `calcularSalidasCaja` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calcularSalidasCaja`(dataInicio varchar(20), idP int)
begin

	declare fechaRecibida1 datetime;

set fechaRecibida1  = str_to_date(dataInicio,"%Y-%m-%d %H:%i:%s" );

	select sum(monto)  from pv_canoa_segunda.caja 
where fecha like concat('%', date_format(fechaRecibida1,"%Y-%m-%d"),'%') AND fk_usuarios  = idP AND movimiento = 'SALIDA DE EFECTIVO';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `calcularTotalVentas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calcularTotalVentas`(dataInicio varchar(30), idP int)
begin
	declare fechaRecibida1 datetime;
set fechaRecibida1  = str_to_date(dataInicio,"%Y-%m-%d %H:%i:%s" );

	select  total from pv_canoa_segunda.venta where fecha  like concat('%', date_format(fechaRecibida1,"%Y-%m-%d"),'%') and fk_usuarios = idP  ;



end ;;
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
/*!50003 DROP PROCEDURE IF EXISTS `cargar_movimiento_caja` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cargar_movimiento_caja`(saldoinicialDB double,movimientoDB varchar(50)
,motivoDB varchar(250),montoDB double, fk_usuarioDB varchar(50))
begin
	
	declare entrada double;
declare salida double;
	declare id_usuarioIn int;
declare saldiInicial_in double;

 set id_usuarioIn  = (select id from pv_canoa_segunda.usuarios where nickname  = fk_usuarioDB );

if movimientoDB  = "ENTRADA DE EFECTIVO" then
 
set entrada  = saldoinicialDB  + montoDB;

INSERT INTO pv_canoa_segunda.cierre_caja
(saldo_inicial, movimiento, motivo, monto, saldo_total, fecha, fk_idusuario)
VALUES(saldoinicialDB  ,movimientoDB , motivoDB , montoDB  , entrada ,now(), id_usuarioIn);


else

set salida = saldoinicialDB  - montoDB;

INSERT INTO pv_canoa_segunda.cierre_caja
(saldo_inicial, movimiento, motivo, monto, saldo_total, fecha, fk_idusuario)
VALUES(saldoinicialDB  ,movimientoDB , motivoDB , montoDB  , salida  ,now(), id_usuarioIn);

end if;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `cerrarCaja` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cerrarCaja`(saldo_inicialP double, entradasP double, salidasP double, saldo_totalP double, fk_idusuarioP int)
begin
	INSERT INTO pv_canoa_segunda.cierre_caja
(saldo_inicial, entradas, salidas, saldo_total, fecha, fk_idusuario)
VALUES(saldo_inicialP, entradasP, salidasP, saldo_totalP, now(), fk_idusuarioP);

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
/*!50003 DROP PROCEDURE IF EXISTS `compararCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `compararCliente`(in idP integer, out acceso boolean)
begin
	declare valor integer ;

set valor = (select  id from pv_canoa_segunda.clientes  where id = idP); 
	
if (valor  = idP) then

set acceso  = true;

        

 else
set acceso = false;

  

end if;
	
	
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `compararProvedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `compararProvedores`(in idP integer, out acceso boolean)
begin
	declare valor integer ;

set valor = (select  id from pv_canoa_segunda.provedores where id = idP); 
	
if (valor  = idP) then

set acceso  = true;

        

 else
set acceso = false;

  

end if;
	
	
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `conteo_filas_venta_generadas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `conteo_filas_venta_generadas`()
begin
	
	select numero_venta ,count(*) from pv_canoa_segunda.venta group by numero_venta ; 
	
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_categoria`(in categoriaDB int)
BEGIN



DELETE FROM pv_canoa_segunda.categoria
WHERE id = categoriaDB ;


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
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_linea`(in lineaDB int)
BEGIN

DELETE FROM pv_canoa_segunda.linea WHERE id =lineaDB ;



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
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_marca`(in marcaDB int)
begin

DELETE FROM pv_canoa_segunda.marcas
WHERE id =  marcaDB ;



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
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_producto`( usuarioDB varchar(50),idproductDB  bigint )
begin

	


	
	
/*CALL pv_canoa_segunda.tabla_productos_eliminados(usuarioDB,idproductDB);*/
	

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
/*!50003 DROP PROCEDURE IF EXISTS `elimina_provedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `elimina_provedores`(idDB int)
begin
	DELETE FROM pv_canoa_segunda.provedores
WHERE id=idDB;

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_venta`(fk_productosDB bigint, cantidadDB double, totalDB double, fk_clientesDB int, fk_usuariosDB int,id_venta int)
begin
	
declare stock_disponible int;
declare cantidad_recibida double;
declare total_stock  double;

declare productoIn varchar(100);
declare distintivoIn  varchar(150); 
declare precioIn  double;


set productoIn = (select product from pv_canoa_segunda.productos where id = fk_productosDB);
set distintivoIn  = (select tipo from pv_canoa_segunda.productos where id = fk_productosDB);
set precioIn = (select precioVenta  from pv_canoa_segunda.productos where id = fk_productosDB);


INSERT INTO pv_canoa_segunda.venta
		
(fk_productos, producto, distintivo1, precio, cantidad, total, fecha, fk_clientes, fk_usuarios,numero_venta)
VALUES(fk_productosDB ,productoIn  ,distintivoIn  , precioIn  ,cantidadDB ,totalDB ,now(), fk_clientesDB ,fk_usuariosDB  ,id_venta);

set stock_disponible = (select stock from pv_canoa_segunda.productos where  id = fk_productosDB  );
set cantidad_recibida  = cantidadDB ;

set total_stock  = (stock_disponible - cantidad_recibida );

UPDATE pv_canoa_segunda.productos

SET  stock= total_stock 

WHERE id= fk_productosDB ;

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
/*!50003 DROP PROCEDURE IF EXISTS `id_generado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `id_generado`(idDB bigint, out existe_id boolean)
begin
	
	declare id_recibido bigint;

set id_recibido  = (select id from pv_canoa_segunda.productos where id = idDB);   

if id_recibido = idDB then 

set existe_id  = true;

else

set existe_id  = false;

end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertarMoviminentosCaja` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarMoviminentosCaja`(saldoP double,movimientoP varchar(50),motivoP varchar(200),montoP double, userId int)
begin
	
  INSERT INTO pv_canoa_segunda.caja
(saldoInicial, movimiento, motivo, monto, fecha, fk_usuarios)
VALUES(saldoP , movimientoP ,motivoP , montoP , now(), userId);

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_provedores`(in nombreDB varchar(50),in apellido1DB varchar(20),in contactoDB varchar(20),in empresaDB varchar(20),in nombreSupervisorDB varchar(50),in contactoSupervisorDB varchar(20))
begin

	

INSERT INTO pv_canoa_segunda.provedores
(nombre, apellido1, contacto, empresa, nombreSupervisor, contactoSupervisor)

VALUES(nombreDB, apellido1DB, contactoDB, empresaDB, nombreSupervisorDB, contactoSupervisorDB);



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
/*!50003 DROP PROCEDURE IF EXISTS `insertPrintData` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertPrintData`(nombre varchar(200),nombref varchar(200),nombred varchar(200),nombres varchar(200) )
begin
	INSERT INTO pv_canoa_segunda.impresora
(nombre_empresa, direccion, despedida, nombre_impresora)
VALUES('', '', '', NULL);

END ;;
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
/*!50003 DROP PROCEDURE IF EXISTS `productosEnStock` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `productosEnStock`(in idp int, out acceso boolean)
begin
	
	
declare valor int;
	

set valor = (select stock from pv_canoa_segunda.productos where id = idp); 
	
if (valor  > 0) then

set acceso  = true;

        

 else
set acceso = false;

  

end if;
	
	
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `productos_like` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `productos_like`(in productDB varchar(50),in tipoDB varchar(50) ,in extra_distinctiveDB varchar (100),in stockDB varchar(50),in kilogramosDB varchar(50),in medidaDB varchar(50),in mililitrosDB varchar(50),in colorDB varchar(20),in tamanoDB varchar(20),in precioCompraDB varchar(10) ,in precioVentaDB varchar(10) ,in  fk_provedoresDB varchar(50) ,in fk_marcaDB varchar(50),in fk_lineaDB varchar(50),in fk_categoriaDB varchar(50),in fk_usuarioDB varchar(50),in notas_ventaDB varchar(300))
begin
	declare provedoresIn int;
declare marcaIn int;
declare lineaIn int;
declare categoriaIn int;
declare usuarioIn int;

set provedoresIn  =  (select id from pv_canoa_segunda.provedores  where nombre  = fk_provedoresDB );	
set marcaIn  =  (select id from pv_canoa_segunda.marcas where marca = fk_marcaDB);
set lineaIn  =  (select id from pv_canoa_segunda.linea   where linea = fk_lineaDB );	
set categoriaIn  =  (select id from pv_canoa_segunda.categoria  where categoria  = fk_categoriaDB );	
set usuarioIn  =  (select id from pv_canoa_segunda.usuarios  where   nickname  = fk_usuarioDB );	



	SELECT productos.id, productos.product, productos.tipo, productos.extra_distinctive, productos.stock, productos.kilogramos, productos.medida, productos.mililitros, productos.color, productos.tamano, productos.precioCompra, productos.precioVenta,  provedores.nombre , marcas.marca  , linea.linea , categoria.categoria , usuarios.nickname,notas_de_venta  
	FROM pv_canoa_segunda.productos 
left join provedores on productos.fk_provedores = provedores.id  
left join marcas on productos.fk_marca = marcas.id   
left join linea on productos.fk_linea = linea.id
left join categoria on productos.fk_categoria  = categoria.id
left join usuarios on productos.fk_usuario = usuarios.id 

where product like concat('%',productDB,'%') || tipo  like concat('%',tipoDB,'%') || extra_distinctive  like concat('%',extra_distinctiveDB,'%') || stock  like concat('%',stockDB ,'%') || kilogramos  like concat('%',kilogramosDB,'%') || medida  like concat('%',medidaDB ,'%') || mililitros  like concat('%',mililitrosDB ,'%') || color  like concat('%',colorDB ,'%') || tamano  like concat('%',tamanoDB ,'%') || precioCompra  like concat('%',precioCompraDB ,'%') || precioVenta  like concat('%',precioVentaDB ,'%') || productos.fk_provedores   = provedoresIn  || productos.fk_marca = marcaIn  || productos.fk_linea = lineaIn  || productos.fk_categoria = categoriaIn || notas_de_venta  like concat("%",notas_ventaDB , "%") ;


/*
 * just i we want  to look for user  write this code at the end  productos.fk_usuario =  usuarioIn */


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
CREATE DEFINER=`root`@`localhost` PROCEDURE `tabla_productos_eliminados`(usuarioDB varchar(50), productoDB bigint)
BEGIN

declare userIn int;
declare razonDB varchar (30);
declare Nproducto  varchar(50);
declare tipoDB varchar(50);

   set Nproducto  = (select product from pv_canoa_segunda.productos where id = productoDB); 
   set tipoDB = (select tipo from pv_canoa_segunda.productos where id =  productoDB);
set userIn = (select id from pv_canoa_segunda.usuarios where nickname = usuarioDB); 
INSERT INTO pv_canoa_segunda.productos_eliminados (fk_usuario, fk_producto, product, tipo , razon, fecha)

VALUES(userIn  , productoDB ,Nproducto  ,tipoDB  ,"Eliminado", now());


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
/*!50003 DROP PROCEDURE IF EXISTS `validar_usuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validar_usuario`(in iduser int, in passDB varchar (100),out acceso boolean)
begin
	
  declare  pass_in varchar (100) ;

	declare salt varchar(50);

set salt = '153624'; 

 /*SET nickname_in  = (SELECT nickname   FROM pv_canoa_segunda.usuarios   where id  = idDB);*/


 SET  pass_in  = (select cast (aes_decrypt( pass  ,153624) as char) from pv_canoa_segunda.usuarios  where id  = iduser);





 if (pass_in = passDB) then


/*select "1" ;*/
 
 set acceso = true;

else


/*select "0";*/
set acceso = false;
end if;
 




END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `verCierresCaja` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `verCierresCaja`(dataInicio varchar(30), dataFin varchar(30))
begin
	

declare fechaRecibida1 datetime;
declare fechaRecibida2 datetime;
declare intervalo int;

set fechaRecibida1  = str_to_date(dataInicio,"%Y-%m-%d %H:%i:%s" );
set fechaRecibida2  = str_to_date(dataFin ,"%Y-%m-%d %H:%i:%s");

set intervalo =  timestampdiff (second,fechaRecibida1,fechaRecibida2); 

if(fechaRecibida1 = fechaRecibida2) then

select saldo_inicial ,entradas ,salidas ,saldo_total,cierre_caja.fecha,usuarios.nickname  from pv_canoa_segunda.cierre_caja  left join usuarios on usuarios.id = cierre_caja.fk_idusuario  where cierre_caja.fecha   like concat('%', date_format(fechaRecibida1,"%Y-%m-%d"),'%');

else 
select saldo_inicial,entradas ,salidas ,saldo_total,cierre_caja.fecha,usuarios.nickname  from pv_canoa_segunda.cierre_caja  left join usuarios on usuarios.id = cierre_caja.fk_idusuario    where cierre_caja.fecha >= fechaRecibida1 && cierre_caja.fecha  <=  date_add( fechaRecibida1, interval  intervalo  second);


end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `verificarExistenciaProducto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `verificarExistenciaProducto`(in idP Bigint, out acceso boolean)
begin

	declare valor bigint ;
set valor = (select  id from pv_canoa_segunda.productos where id = idP); 
if (valor  = idP) then
set acceso  = true;

        

 else
set acceso = false;

  

end if;
	
	
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `verificarExistenciaUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `verificarExistenciaUsuario`(in idP Bigint, out acceso boolean)
begin

	declare valor bigint ;
set valor = (select  id from pv_canoa_segunda.usuarios where id = idP); 
if (valor  = idP) then
set acceso  = true;

        

 else
set acceso = false;

  

end if;
	
	
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `verMovimientosCaja` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `verMovimientosCaja`(dataInicio varchar(30), dataFin varchar(30))
begin
	

declare fechaRecibida1 datetime;
declare fechaRecibida2 datetime;
declare intervalo int;

set fechaRecibida1  = str_to_date(dataInicio,"%Y-%m-%d %H:%i:%s" );
set fechaRecibida2  = str_to_date(dataFin ,"%Y-%m-%d %H:%i:%s");

set intervalo =  timestampdiff (second,fechaRecibida1,fechaRecibida2); 

if(fechaRecibida1 = fechaRecibida2) then

select saldoInicial,movimiento ,motivo ,monto,caja.fecha,usuarios.nickname  from pv_canoa_segunda.caja left join usuarios on usuarios.id = caja.fk_usuarios  where caja.fecha   like concat('%', date_format(fechaRecibida1,"%Y-%m-%d"),'%');

else 
select saldoInicial,movimiento ,motivo ,monto,caja.fecha,usuarios.nickname  from  pv_canoa_segunda.caja  left join usuarios on usuarios.id = caja.fk_usuarios where caja.fecha >= fechaRecibida1 && caja.fecha  <=  date_add( fechaRecibida1, interval  intervalo  second);


end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `verProductosCaducados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `verProductosCaducados`(dataInicio varchar(30), dataFin varchar(30))
begin
	

declare fechaRecibida1 datetime;
declare fechaRecibida2 datetime;
declare intervalo int;

set fechaRecibida1  = str_to_date(dataInicio,"%Y-%m-%d %H:%i:%s"  );
set fechaRecibida2  = str_to_date(dataFin, "%Y-%m-%d %H:%i:%s" );

set intervalo =  timestampdiff (second,fechaRecibida1,fechaRecibida2); 

if(fechaRecibida1 = fechaRecibida2) then

select id,product ,tipo ,stock,precioCompra,precioVenta,fecha,caducidad from productos where caducidad  between str_to_date(now() ,"%Y-%m-%d" )  and DATE_ADD(str_to_date(now() ,"%Y-%m-%d" ) , INTERVAL 15 DAY);

else 
select id,product ,tipo ,stock,precioCompra,precioVenta,fecha,caducidad from pv_canoa_segunda.productos where caducidad   between str_to_date(fechaRecibida1,"%Y-%m-%d"  ) and str_to_date(fechaRecibida2,"%Y-%m-%d"  );


end if;

END ;;
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
/*!50003 DROP PROCEDURE IF EXISTS `ver_devoluciones_perdidas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ver_devoluciones_perdidas`(dataInicio varchar(30), dataFin varchar(30))
begin
	

declare fechaRecibida1 datetime;
declare fechaRecibida2 datetime;
declare intervalo int;

set fechaRecibida1  = str_to_date(dataInicio,"%Y-%m-%d %H:%i:%s" );
set fechaRecibida2  = str_to_date(dataFin ,"%Y-%m-%d %H:%i:%s");

set intervalo =  timestampdiff (second,fechaRecibida1,fechaRecibida2); 

if(fechaRecibida1 = fechaRecibida2) then

select id_producto,producto ,descripcion1 ,descripcion2 ,unidades ,cantidad_devolver ,motivo , clientes.nombre, usuarios.nickname, perdidas_devoluciones.fecha from perdidas_devoluciones left join clientes on clientes.id = perdidas_devoluciones.fk_cliente  left join usuarios on usuarios.id = perdidas_devoluciones.fk_usuario  where perdidas_devoluciones.fecha   like concat('%', date_format(fechaRecibida1,"%Y-%m-%d"),'%');

else 
select id_producto,producto ,descripcion1 ,descripcion2 ,unidades ,cantidad_devolver ,motivo , clientes.nombre, usuarios.nickname,perdidas_devoluciones.fecha  from perdidas_devoluciones left join clientes on clientes.id = perdidas_devoluciones.fk_cliente  left join usuarios on usuarios.id = perdidas_devoluciones.fk_usuario   where perdidas_devoluciones.fecha  >= fechaRecibida1 && perdidas_devoluciones.fecha  <=  date_add( fechaRecibida1, interval  intervalo  second);


end if;

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `ver_movimientos_devoluciones`(fechaInicioDB varchar(50),fechaFinDB varchar(50))
BEGIN





	

	declare fechaRecibida1 datetime;

declare fechaRecibida2 datetime;

declare diferencia int ;


set fechaRecibida1  = str_to_date(fechaInicioDB,"%Y-%m-%d %H:%i:%s" );
/*set fechaRecibida2  = str_to_date(concat(fechaFinDB," ",horaFinDB),"%Y-%m-%d %H:%i:%s");*/
set fechaRecibida2  = str_to_date(fechaFinDB,"%Y-%m-%d %H:%i:%s");

set diferencia = timestampdiff(second  ,fechaRecibida1 ,fechaRecibida2);

 
if(fechaRecibida1 = fechaRecibida2) then
/*select usuarios.nickname,clientes.id ,devoluciones.fecha_hora,productos.id,productos.product,productos.tipo,devoluciones.motivo,devoluciones.cantidad  from pv_canoa_segunda.devoluciones left join productos  ON  devoluciones.fk_producto = productos.id  left join usuarios on devoluciones.fk_usuario = usuarios.id left  join clientes  on fk_clientes = clientes.id where fecha_hora >= fechaRecibida1 and fecha_hora <= fechaRecibida2;*/
select usuarios.nickname,clientes.id ,devoluciones.fecha_hora,productos.id,productos.product,productos.tipo,devoluciones.motivo,devoluciones.cantidad  from pv_canoa_segunda.devoluciones left join productos  ON  devoluciones.fk_producto = productos.id  left join usuarios on devoluciones.fk_usuario = usuarios.id left  join clientes  on fk_clientes = clientes.id where fecha_hora like concat('%', date_format(fechaRecibida1,"%Y-%m-%d"),'%' );


else


select usuarios.nickname,clientes.id ,devoluciones.fecha_hora,productos.id,productos.product,productos.tipo,devoluciones.motivo,devoluciones.cantidad  from pv_canoa_segunda.devoluciones left join productos  ON  devoluciones.fk_producto = productos.id  left join usuarios on devoluciones.fk_usuario = usuarios.id left  join clientes  on fk_clientes = clientes.id where fecha_hora >= fechaRecibida1 and fecha_hora <= date_add( fechaRecibida2, interval diferencia  second);
 

end if;







	

	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ver_movimientos_productos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ver_movimientos_productos`(dataInicio varchar(30), dataFin varchar(30))
begin
	
	
		declare fechaRecibida1 datetime;

declare fechaRecibida2 datetime;

declare intervalo int;





set fechaRecibida1  = str_to_date(dataInicio,"%Y-%m-%d %H:%i:%s" );

set fechaRecibida2  = str_to_date(dataFin ,"%Y-%m-%d %H:%i:%s");

set intervalo =  timestampdiff (second,fechaRecibida1,fechaRecibida2); 

if(fechaRecibida1 = fechaRecibida2) then

select movimientos_productos.codigo_producto,movimientos_productos.producto , movimientos_productos.distintivo1  ,movimientos_productos.stock_antiguo , movimientos_productos.stock_nuevo ,movimientos_productos.motivo ,usuarios.nickname,movimientos_productos.fecha from movimientos_productos left join usuarios on usuarios.id = movimientos_productos.usuario where movimientos_productos.fecha   like concat('%', date_format(fechaRecibida1,"%Y-%m-%d"),'%');

else 
select movimientos_productos.codigo_producto,movimientos_productos.producto , movimientos_productos.distintivo1  ,movimientos_productos.stock_antiguo , movimientos_productos.stock_nuevo ,movimientos_productos.motivo ,usuarios.nickname,movimientos_productos.fecha from movimientos_productos left join usuarios on usuarios.id = movimientos_productos.usuario where movimientos_productos.fecha  >= fechaRecibida1 && movimientos_productos.fecha <=  date_add( fechaRecibida1, interval  intervalo  second);

end if;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ver_movimientos_ventas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ver_movimientos_ventas`(dataInicio varchar(30), dataFin varchar(30))
begin
	
	
		declare fechaRecibida1 datetime;

declare fechaRecibida2 datetime;

declare intervalo int;





set fechaRecibida1  = str_to_date(dataInicio,"%Y-%m-%d %H:%i:%s" );

set fechaRecibida2  = str_to_date(dataFin ,"%Y-%m-%d %H:%i:%s");

set intervalo =  timestampdiff (second,fechaRecibida1,fechaRecibida2); 

if(fechaRecibida1 = fechaRecibida2) then

SELECT venta.fk_productos, venta.producto, venta.distintivo1, venta.precio, venta.cantidad, venta.total, venta.fecha,clientes.nombre ,usuarios.nickname , venta.numero_venta 
FROM pv_canoa_segunda.venta left join clientes on clientes.id = venta.fk_clientes  left join usuarios on usuarios.id = venta.fk_usuarios  where venta.fecha   like concat('%', date_format(fechaRecibida1,"%Y-%m-%d"),'%');

else 
SELECT venta.fk_productos, venta.producto, venta.distintivo1, venta.precio, venta.cantidad, venta.total, venta.fecha,clientes.nombre ,usuarios.nickname , venta.numero_venta 
FROM pv_canoa_segunda.venta left join clientes on clientes.id = venta.fk_clientes  left join usuarios on usuarios.id = venta.fk_usuarios  where venta.fecha  >= fechaRecibida1 && venta.fecha <=  date_add( fechaRecibida1, interval  intervalo  second);

end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ver_provedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ver_provedores`()
begin
SELECT id, nombre, apellido1, contacto, empresa, nombreSupervisor, contactoSupervisor
FROM pv_canoa_segunda.provedores;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ver_total_caja` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ver_total_caja`()
begin
	
	declare id_ultimo_cierre_caja int;
declare fecha_id_ultimo_cierre datetime;

set id_ultimo_cierre_caja  =  (select last_insert_id() as ide  from pv_canoa_segunda.cierre_caja group by ide);
set fecha_id_ultimo_cierre = (select fecha from pv_canoa_segunda.cierre_caja where id = id_ultimo_cierre_caja);

select saldo_inicial ,saldo_total from pv_canoa_segunda.cierre_caja where fecha >= fecha_id_ultimo_cierre ;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ver_usuarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ver_usuarios`()
begin
	SELECT id, rol,nickname
FROM pv_canoa_segunda.usuarios;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ver_usuarios_nickname` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ver_usuarios_nickname`()
begin
		SELECT nickname
FROM pv_canoa_segunda.usuarios;

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
/*!50003 DROP PROCEDURE IF EXISTS `view_barcode` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `view_barcode`(idDB bigint)
begin
	SELECT product, tipo, extra_distinctive, stock, precioVenta, notas_de_venta
FROM pv_canoa_segunda.productos where id  = idDB;

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

-- Dump completed on 2022-12-06 10:27:18
