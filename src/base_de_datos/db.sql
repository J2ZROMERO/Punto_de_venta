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
  CONSTRAINT `caja_FK_3` FOREIGN KEY (`fk_usuarios`) REFERENCES `usuarios` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja`
--

LOCK TABLES `caja` WRITE;
/*!40000 ALTER TABLE `caja` DISABLE KEYS */;
INSERT INTO `caja` VALUES (2,5000,'entrada',5000,3000,'gastos',5000,NULL,'2022-06-03 00:00:00',NULL,NULL,NULL),(3,5000,'entrada',5000,3000,'gastos',5000,NULL,'2022-06-03 00:00:00',NULL,NULL,NULL),(4,5000,'entrada',5000,3000,'gastos',5000,NULL,'2022-06-03 00:00:00',NULL,NULL,NULL),(5,5000,'entrada',5000,3000,'gastos',5000,NULL,'2022-06-03 00:00:00',NULL,NULL,NULL),(7,5000,'entrada',5000,3000,'gastos',5000,NULL,'2022-06-03 00:00:00',NULL,NULL,NULL),(8,5000,'entrada',5000,3000,'gastos',5000,NULL,'2022-06-03 00:00:00',NULL,NULL,NULL),(10,5000,'entrada',5000,3000,'gastos',5000,NULL,'2022-06-03 00:00:00',NULL,NULL,NULL),(23,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-06 20:51:38',NULL,NULL,NULL),(24,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 18:17:15',NULL,NULL,NULL),(25,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 18:34:00',NULL,NULL,NULL),(26,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 18:34:00',NULL,NULL,NULL),(27,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 18:35:00',NULL,NULL,NULL),(28,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 19:04:11',NULL,NULL,NULL),(29,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 19:04:16',NULL,NULL,NULL),(30,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 08:00:56',NULL,NULL,NULL),(31,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 07:17:25',NULL,NULL,NULL),(32,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 19:20:25',NULL,NULL,NULL),(33,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 19:27:54',NULL,NULL,NULL),(34,500450,'entrada',5000,3000,'gastos',5000,6541,'2022-06-09 20:05:11',NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (5,'ganso'),(9,'leche'),(10,'otra caeoria');
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
  `movimiento` varchar(50) DEFAULT NULL,
  `motivo` varchar(240) DEFAULT NULL,
  `monto` double DEFAULT NULL,
  `saldo_total` double DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `fk_idusuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cierre_caja_FK` (`fk_idusuario`),
  CONSTRAINT `cierre_caja_FK` FOREIGN KEY (`fk_idusuario`) REFERENCES `usuarios` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cierre_caja`
--

LOCK TABLES `cierre_caja` WRITE;
/*!40000 ALTER TABLE `cierre_caja` DISABLE KEYS */;
INSERT INTO `cierre_caja` VALUES (2,800,'ENTRADA DE EFECTIVO','ya no servia',300,1100,'2022-08-30 22:13:08',NULL),(3,800,'ENTRADA DE EFECTIVO','ya no servia',300,1100,'2022-08-30 22:13:27',NULL),(4,800,'ENTRADA DE EFECTIVO','ya no servia',300,1100,'2022-08-30 22:13:41',80),(5,800,'SALIDA DE EFECTIVO','ya no servia',300,500,'2022-08-30 22:13:58',80),(6,800,'SALIDA DE EFECTIVO','ya no servia',600,200,'2022-08-31 21:16:54',80),(7,1500,'SALIDA DE EFECTIVO','ya no servia',600,900,'2022-08-31 21:52:00',80),(8,1500,'SALIDA DE EFECTIVO','ya no servia',0,1500,'2022-08-31 21:52:31',80),(9,1500,'ENTRADA DE EFECTIVO','ya no servia',3800,5300,'2022-08-31 21:53:41',80);
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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (2,'dara','gachu','pedrito','22280010101','2022-06-29 18:19:05'),(10,'Jose ','Juan ','Zepeda','Romero...','2022-07-22 17:06:41'),(12,'Carlos Juarez','Sanchez ','domignuees','2228103004','2022-07-22 17:10:28'),(28,'ghd','hg','h','12121','2022-08-10 07:36:26'),(29,'12','31','31','312','2022-08-10 07:37:30'),(30,'1221','212','212','121','2022-08-10 07:38:26'),(39,'das','d','sadas','322','2022-08-10 08:06:53'),(41,'perez','dsa','da','222','2022-08-10 08:10:51'),(47,'joaquin','sanches','rodir','22/8103301','2022-09-03 11:02:54');
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
INSERT INTO `devoluciones` VALUES (1,5,'no los quiso','2022-06-22 17:02:04',NULL,NULL,NULL),(3,5,'no los quiso','2022-06-22 17:02:23',NULL,NULL,NULL),(5,5,'no los quiso','2022-06-22 17:04:03',31475,NULL,NULL),(6,5,'nuevoprudcot','2022-06-23 20:05:17',31456,NULL,NULL),(7,5,'omitido','2022-06-28 20:46:51',NULL,NULL,NULL),(8,78,'omitido','2022-06-28 22:00:49',NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linea`
--

LOCK TABLES `linea` WRITE;
/*!40000 ALTER TABLE `linea` DISABLE KEYS */;
INSERT INTO `linea` VALUES (8,'what about'),(10,'good');
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES (4,'gansito'),(5,'nueva marca');
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
INSERT INTO `movimientos_productos` VALUES (95059279,'dasdas','dsads',3243,0,'eliminado',NULL,'2022-08-04 17:05:49'),(1,'ggggggg','ddddddd',100,1235,'actualizado',80,'2022-08-04 17:08:50'),(1231,'ggggggg','ddddddd',0,1235,'insertado',80,'2022-08-04 17:19:36'),(2393854961446,'dasddsa','dsad',0,21321,'agregado',NULL,'2022-08-05 16:19:17'),(9505927961156,'dasdas','dsads',3243,0,'eliminado',NULL,'2022-08-05 16:19:31'),(3758734962476,'adada','dsafasdfa',0,1312,'agregado',NULL,'2022-08-05 18:11:55'),(2190839452139,'adada','dsafasdfa',0,1312,'agregado',NULL,'2022-08-05 18:12:31'),(1231,'aaaaaaa','ddddddd',1235,1235,'actualizado',NULL,'2022-08-05 18:14:22'),(1231,'aaaaaaa','ddddddd',1235,1235,'actualizado',NULL,'2022-08-05 18:14:23'),(3758734962476,'adada','dsafasdfa',1312,0,'eliminado',NULL,'2022-08-05 18:14:43'),(31475,'fdsfsdfs','de colores',5,5,'actualizado',NULL,'2022-08-05 18:16:36'),(1,'gggggggss','ddddddd',1235,1235,'actualizado',NULL,'2022-08-05 18:17:32'),(54521321,'s','sdfsd',0,546,'agregado',NULL,'2022-08-08 07:40:15'),(9578302976396,'2313','3213',0,123,'agregado',NULL,'2022-08-08 07:40:35'),(9578302976396,'s2222','dfas',123,12321,'actualizado',NULL,'2022-08-08 07:58:35'),(9578302976396,'s2222','dfas',12321,12321,'actualizado',NULL,'2022-08-08 07:59:23'),(9578302976396,'s2222','dfas',12321,12321,'actualizado',NULL,'2022-08-08 08:13:17'),(9578302976396,'s2222','dfas',12321,12321,'actualizado',NULL,'2022-08-08 08:17:51'),(7502278750135,'asd','sdsa',0,14,'agregado',NULL,'2022-08-09 13:15:34'),(7502010421330,'asda','asdd',0,1,'agregado',NULL,'2022-08-09 15:58:26'),(7502010421330,'asda','asdd',1,1,'actualizado',NULL,'2022-08-09 15:58:36'),(1,'gggggggss','ddddddd',1235,235,'actualizado',NULL,'2022-08-09 20:18:56'),(1231,'aaaaaaa','ddddddd',1235,1000,'actualizado',NULL,'2022-08-09 20:24:42'),(6825166629653,'jhgjf','j',0,31,'agregado',NULL,'2022-08-10 07:36:16'),(1231,'aaaaaaa','ddddddd',1000,765,'actualizado',NULL,'2022-08-10 09:16:33'),(1,'gggggggss','ddddddd',235,200,'actualizado',NULL,'2022-08-10 09:54:48'),(7,'asdas','asdas',2,0,'actualizado',NULL,'2022-08-10 10:08:47'),(7,'asdas','asdas',0,-2,'actualizado',NULL,'2022-08-10 10:10:01'),(2,'asdas','asdas',2,1,'actualizado',NULL,'2022-08-10 10:11:58'),(1,'gggggggss','ddddddd',200,165,'actualizado',NULL,'2022-08-10 10:18:52'),(7,'asdas','asdas',-2,-3,'actualizado',NULL,'2022-08-10 10:19:41'),(2,'asdas','asdas',1,0,'actualizado',NULL,'2022-08-10 10:19:41'),(1231,'aaaaaaa','ddddddd',765,758,'actualizado',NULL,'2022-08-10 10:19:41'),(7,'asdas','asdas',-3,0,'actualizado',NULL,'2022-08-10 10:20:49'),(7,'asdas','asdas',0,0,'actualizado',NULL,'2022-08-10 12:44:47'),(1,'gggggggss','ddddddd',165,160,'actualizado',NULL,'2022-08-10 12:44:47'),(2,'asdas','asdas',0,0,'actualizado',NULL,'2022-08-10 12:44:47'),(1,'gggggggss','ddddddd',160,155,'actualizado',NULL,'2022-08-10 13:00:39'),(1,'gggggggss','ddddddd',155,150,'actualizado',NULL,'2022-08-10 13:00:41'),(2,'asdas','asdas',0,0,'actualizado',NULL,'2022-08-10 13:01:02'),(2,'asdas','asdas',0,0,'actualizado',NULL,'2022-08-10 13:01:16'),(1,'gggggggss','ddddddd',150,147,'actualizado',NULL,'2022-08-10 13:09:18'),(1,'gggggggss','ddddddd',147,144,'actualizado',NULL,'2022-08-10 13:09:37'),(1,'gggggggss','ddddddd',144,137,'actualizado',NULL,'2022-08-10 13:09:47'),(1,'gggggggss','ddddddd',137,130,'actualizado',NULL,'2022-08-10 13:09:47'),(1,'gggggggss','ddddddd',130,123,'actualizado',NULL,'2022-08-10 13:09:47'),(1,'gggggggss','ddddddd',123,116,'actualizado',NULL,'2022-08-10 13:09:48'),(1,'gggggggss','ddddddd',116,109,'actualizado',NULL,'2022-08-10 13:09:48'),(1,'gggggggss','ddddddd',109,108,'actualizado',NULL,'2022-08-10 13:11:02'),(1,'gggggggss','ddddddd',108,105,'actualizado',NULL,'2022-08-10 13:12:03'),(1,'gggggggss','ddddddd',105,104,'actualizado',NULL,'2022-08-10 13:13:04'),(1,'gggggggss','ddddddd',104,103,'actualizado',NULL,'2022-08-10 13:14:46'),(1,'gggggggss','ddddddd',103,68,'actualizado',NULL,'2022-08-10 14:20:03'),(1,'gggggggss','ddddddd',68,33,'actualizado',NULL,'2022-08-10 14:35:28'),(1,'gggggggss','ddddddd',33,-2,'actualizado',NULL,'2022-08-10 15:15:49'),(1231,'aaaaaaa','ddddddd',758,754,'actualizado',NULL,'2022-08-10 20:43:53'),(1,'gggggggss','ddddddd',-2,-3,'actualizado',NULL,'2022-08-10 22:49:02'),(1,'gggggggss','ddddddd',-3,1,'actualizado',NULL,'2022-08-14 06:01:54'),(1231,'aaaaaaa','ddddddd',754,751,'actualizado',NULL,'2022-08-15 12:50:41'),(1,'gggggggss','ddddddd',1,0,'actualizado',NULL,'2022-08-23 22:17:39'),(6834126888937,'njvvbn','nbvnvn',0,33,'agregado',80,'2022-08-28 19:29:05'),(1,'gggggggss','ddddddd',0,-35,'actualizado',NULL,'2022-08-29 21:41:23'),(1231,'aaaaaaa','ddddddd',751,750,'actualizado',NULL,'2022-08-29 21:43:41'),(1231,'aaaaaaa','ddddddd',750,749,'actualizado',NULL,'2022-08-29 21:47:07'),(6679656518349,'ggg','gghhh',0,45,'agregado',80,'2022-08-29 21:47:48'),(6679656518349,'ggg','gghhh',45,90,'actualizado',NULL,'2022-08-29 21:49:01'),(6679656518349,'ggg','gghhh',90,2,'actualizado',NULL,'2022-08-29 21:49:11'),(4611236312485,'jjj','jhgj',0,213,'agregado',80,'2022-09-03 11:11:45'),(4611236312485,'chipileta','jhgj',213,213,'actualizado',NULL,'2022-09-03 11:12:24'),(7502278750135,'asd','sdsa',14,14,'actualizado',121,'2022-09-03 11:14:56'),(4611236312485,'chipileta','verde',213,213,'actualizado',80,'2022-09-03 11:16:08'),(7502010421330,'asda','asdd',1,0,'eliminado',NULL,'2022-09-03 11:16:23'),(8915738148233,'saesae','546',654,0,'eliminado',NULL,'2022-09-03 11:19:42'),(1434,'sad','sad',23,0,'eliminado',NULL,'2022-09-03 11:23:13'),(7502278750135,'asd','sdsa',14,0,'eliminado',121,'2022-09-03 11:23:58'),(1,'gggggggss','ddddddd',-35,5,'actualizado',80,'2022-09-03 14:08:58'),(1,'gggggggss','ddddddd',5,4,'actualizado',80,'2022-09-03 14:40:19'),(688089514256,' bvcbcvnb','vnbvnbv',0,1231,'agregado',80,'2022-09-25 14:37:31'),(31475,'fdsfsdfs','de colores',5,3,'actualizado',NULL,'2022-09-25 14:48:16'),(4646513,'sad','sad',23,22,'actualizado',NULL,'2022-11-13 12:01:32'),(31456,'nuevos panes e duces','chocolate',80,78,'actualizado',NULL,'2022-11-13 12:24:14'),(31456,'nuevos panes e duces','chocolate',78,77,'actualizado',NULL,'2022-11-13 12:26:12'),(1,'gggggggss','ddddddd',4,3,'actualizado',80,'2022-11-13 13:31:18'),(4420061396957,'gfdg','dfgdfgdf',345,344,'actualizado',NULL,'2022-11-13 15:27:55'),(4420061396957,'gfdg','dfgdfgdf',344,343,'actualizado',NULL,'2022-11-13 15:27:55'),(31456,'nuevos panes e duces','chocolate',77,76,'actualizado',NULL,'2022-11-13 15:28:50'),(31456,'nuevos panes e duces','chocolate',76,75,'actualizado',NULL,'2022-11-13 15:28:50'),(31456,'nuevos panes e duces','chocolate',75,74,'actualizado',NULL,'2022-11-13 15:28:50'),(31456,'nuevos panes e duces','chocolate',74,73,'actualizado',NULL,'2022-11-13 15:28:50'),(12313,'sda','ffsad',25,23,'actualizado',NULL,'2022-11-20 16:26:21'),(12313,'sda','ffsad',23,22,'actualizado',NULL,'2022-11-20 16:27:10'),(12313,'sda','ffsad',22,21,'actualizado',NULL,'2022-11-20 16:28:19'),(12313,'sda','ffsad',21,20,'actualizado',NULL,'2022-11-20 16:41:32'),(12313,'sda','ffsad',20,19,'actualizado',NULL,'2022-11-20 16:42:03'),(1231,'aaaaaaa','ddddddd',749,748,'actualizado',NULL,'2022-11-20 16:42:45'),(1231,'aaaaaaa','ddddddd',748,747,'actualizado',NULL,'2022-11-20 16:42:45'),(12313,'sda','ffsad',19,16,'actualizado',NULL,'2022-11-20 16:44:10'),(12313,'sda','ffsad',16,14,'actualizado',NULL,'2022-11-20 16:45:26'),(12313,'sda','ffsad',14,12,'actualizado',NULL,'2022-11-20 16:45:26'),(1,'gggggggss','ddddddd',3,2,'actualizado',80,'2022-11-20 17:08:49'),(1,'gggggggss','ddddddd',2,1,'actualizado',80,'2022-11-20 17:08:49'),(12313,'sda','ffsad',12,11,'actualizado',NULL,'2022-11-20 17:38:04'),(12313,'sda','ffsad',11,10,'actualizado',NULL,'2022-11-20 17:41:23'),(12313,'sda','ffsad',10,9,'actualizado',NULL,'2022-11-20 17:43:12'),(12313,'sda','ffsad',9,8,'actualizado',NULL,'2022-11-20 17:44:08'),(12313,'sda','ffsad',8,7,'actualizado',NULL,'2022-11-20 17:45:46'),(12313,'sda','ffsad',7,6,'actualizado',NULL,'2022-11-20 17:47:13'),(12313,'sda','ffsad',6,5,'actualizado',NULL,'2022-11-20 17:48:26'),(12313,'sda','ffsad',5,4,'actualizado',NULL,'2022-11-20 17:48:58'),(12313,'sda','ffsad',4,3,'actualizado',NULL,'2022-11-20 17:52:10'),(12313,'sda','ffsad',3,2,'actualizado',NULL,'2022-11-20 17:52:29'),(1231,'aaaaaaa','ddddddd',747,746,'actualizado',NULL,'2022-11-20 17:55:09'),(1231,'aaaaaaa','ddddddd',746,745,'actualizado',NULL,'2022-11-20 17:55:54'),(1231,'aaaaaaa','ddddddd',745,744,'actualizado',NULL,'2022-11-20 17:56:16'),(1231,'aaaaaaa','ddddddd',744,743,'actualizado',NULL,'2022-11-20 17:58:24'),(1231,'aaaaaaa','ddddddd',743,742,'actualizado',NULL,'2022-11-20 18:01:31'),(1231,'aaaaaaa','ddddddd',742,741,'actualizado',NULL,'2022-11-20 18:02:04'),(1231,'aaaaaaa','ddddddd',741,740,'actualizado',NULL,'2022-11-20 18:06:06'),(1231,'aaaaaaa','ddddddd',740,739,'actualizado',NULL,'2022-11-20 18:12:22'),(1231,'aaaaaaa','ddddddd',739,738,'actualizado',NULL,'2022-11-20 18:13:40'),(1231,'aaaaaaa','ddddddd',738,737,'actualizado',NULL,'2022-11-20 18:14:09'),(1231,'aaaaaaa','ddddddd',737,736,'actualizado',NULL,'2022-11-20 18:14:30'),(1231,'aaaaaaa','ddddddd',736,735,'actualizado',NULL,'2022-11-20 18:14:57'),(1231,'aaaaaaa','ddddddd',735,734,'actualizado',NULL,'2022-11-20 18:15:33'),(1231,'aaaaaaa','ddddddd',734,733,'actualizado',NULL,'2022-11-20 18:16:40'),(1231,'aaaaaaa','ddddddd',733,732,'actualizado',NULL,'2022-11-20 18:17:03'),(1231,'aaaaaaa','ddddddd',732,731,'actualizado',NULL,'2022-11-20 18:18:05'),(1231,'aaaaaaa','ddddddd',731,730,'actualizado',NULL,'2022-11-20 22:36:39'),(1231,'aaaaaaa','ddddddd',730,729,'actualizado',NULL,'2022-11-20 22:37:26'),(1231,'aaaaaaa','ddddddd',729,728,'actualizado',NULL,'2022-11-20 22:41:27'),(1231,'aaaaaaa','ddddddd',728,727,'actualizado',NULL,'2022-11-20 22:42:20'),(31456,'nuevos panes e duces','chocolate',73,70,'actualizado',NULL,'2022-11-20 22:46:18'),(4646513,'sad','sad',22,21,'actualizado',NULL,'2022-11-20 22:47:40'),(4646513,'sad','sad',21,20,'actualizado',NULL,'2022-11-20 22:47:40'),(4611236312485,'chipileta','verde',213,212,'actualizado',80,'2022-11-20 22:49:34'),(4611236312485,'chipileta','verde',212,211,'actualizado',80,'2022-11-20 22:49:34'),(4611236312485,'chipileta','verde',211,210,'actualizado',80,'2022-11-20 22:49:34');
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perdidas_devoluciones`
--

LOCK TABLES `perdidas_devoluciones` WRITE;
/*!40000 ALTER TABLE `perdidas_devoluciones` DISABLE KEYS */;
INSERT INTO `perdidas_devoluciones` VALUES (5,1,'gggggggss','ddddddd','as',123,321,'omitido','2022-08-05 21:59:24',NULL,NULL),(6,1,'gggggggss','ddddddd','as',3,213,'DEVOLUCION','2022-08-05 21:59:41',NULL,NULL),(7,1231,'aaaaaaa','ddddddd','as',4,212,'DEVOLUCION','2022-08-05 22:08:12',NULL,NULL),(8,1,'gggggggss','ddddddd','as',3,2122,'MAL ESTADO','2022-08-05 23:12:54',NULL,NULL),(9,1,'gggggggss','ddddddd','as',3,2122,'MAL ESTADO','2022-08-05 23:13:03',NULL,NULL),(10,1,'gggggggss','ddddddd','as',1,50,'DEVOLUCION','2022-08-10 18:18:28',NULL,NULL),(11,1,'gggggggss','ddddddd','as',3,50,'CADUCADO','2022-08-28 19:14:19',NULL,NULL),(12,1,'gggggggss','ddddddd','as',3,50,'CADUCADO','2022-08-28 19:14:54',NULL,NULL),(13,2,'asdas','asdas','asdas',3,66,'DEVOLUCION','2022-08-28 19:21:16',30,80),(14,2,'asdas','asdas','asdas',3,66,'DEVOLUCION','2022-08-28 19:21:48',30,80),(15,2,'asdas','asdas','asdas',2,245,'DEVOLUCION','2022-09-03 10:34:25',39,80),(16,1231,'aaaaaaa','ddddddd','as',3,667,'ABIERTO','2022-09-03 10:40:46',NULL,80),(17,1,'gggggggss','ddddddd','as',3,22,'MAL ESTADO','2022-09-03 10:43:23',NULL,80),(18,2,'asdas','asdas','asdas',4,1212,'SELECCIONAR','2022-09-03 10:43:47',NULL,80),(19,2,'asdas','asdas','asdas',3,2121,'DEVOLUCION','2022-09-03 10:44:02',NULL,80),(20,1,'gggggggss','ddddddd','as',2,2121,'DEVOLUCION','2022-09-03 10:51:42',NULL,80),(21,2,'asdas','asdas','asdas',3,21312,'DEVOLUCION','2022-09-03 10:58:58',NULL,80),(22,2,'asdas','asdas','asdas',2,21,'MAL ESTADO','2022-09-03 11:00:12',NULL,80);
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
INSERT INTO `productos` VALUES (1,'gggggggss','ddddddd','as',1,432,4324,15646,'sad','gramdD',123,132156,'2022-07-29 16:34:37',4,4,10,5,80,'actualizado'),(2,'asdas','asdas','asdas',0,122.12,122.12,122.12,'asdas','122.12',122.12,122.12,'2022-07-29 18:29:25',NULL,NULL,NULL,NULL,NULL,'anadido'),(7,'asdas','asdas','asdas',0,122.12,122.12,122.12,'asdas','122.12',122.12,122.12,'2022-07-29 18:42:03',NULL,NULL,NULL,NULL,NULL,'anadido'),(1231,'aaaaaaa','ddddddd','as',727,432,4324,15646,'sad','gramdD',123,132156,'2022-08-04 17:19:36',4,4,10,5,NULL,'actualizado'),(2131,'3213','21312','3123',32,NULL,NULL,NULL,'',NULL,31232131,12312,'2022-07-29 19:13:44',NULL,NULL,NULL,NULL,NULL,'anadido'),(3145,'panes de dulce','de colores','',0,156,1233,0,'0','0',56,2555,'2022-06-22 16:02:07',NULL,NULL,NULL,NULL,NULL,'anadido'),(6565,'46546','45645645','654654',6546,456,6456,4564,'',NULL,64564565,564,'2022-07-29 19:16:18',NULL,NULL,NULL,NULL,NULL,'anadido'),(12312,'231','321','321321',2312314,NULL,NULL,NULL,'',NULL,213123,312312,'2022-07-29 19:42:50',NULL,NULL,NULL,NULL,NULL,'anadido'),(12313,'sda','ffsad','ffsad',2,25,25,25,'25','25',25,25,'2022-08-02 14:17:08',NULL,NULL,NULL,NULL,NULL,'actualizado'),(31456,'nuevos panes e duces','chocolate','con chispas muchas chispas',70,180,NULL,NULL,NULL,NULL,90,120,'2022-06-23 20:01:52',NULL,NULL,NULL,NULL,NULL,'actualizado'),(31475,'fdsfsdfs','de colores','',3,156,1233,NULL,'0','0',56,2555,'2022-06-22 16:02:08',4,5,NULL,NULL,NULL,'actualizado'),(54654,'6546','546546','45454',454,123,123,1321,'1231','1231',54654,6546,'2022-07-29 18:57:10',NULL,NULL,NULL,NULL,NULL,'anadido'),(456546,'45645','6546456','54654654',5465,54654,45654,456546,'',NULL,645654654,54645654,'2022-07-29 19:10:41',NULL,NULL,NULL,NULL,NULL,'anadido'),(999558,'45645','6546456','54654654',5465,NULL,45654,NULL,'',NULL,645654654,54645654,'2022-07-29 19:11:10',NULL,NULL,NULL,NULL,NULL,'anadido'),(3527525,'jhj','gjghj','ghjghj',1231,NULL,NULL,NULL,'',NULL,2312321,231,'2022-07-29 22:36:57',NULL,NULL,NULL,NULL,NULL,'anadido'),(4646513,'sad','sad','as',20,432,4324,4324,'sad','gramdD',123,3213,'2022-08-02 14:01:42',NULL,NULL,NULL,NULL,NULL,'anadido'),(9995586,'45645','6546456','54654654',5465,NULL,4545,NULL,'',NULL,645654654,54645654,'2022-07-29 19:11:49',NULL,NULL,NULL,NULL,NULL,'anadido'),(54521321,'s','sdfsd',NULL,546,NULL,NULL,NULL,NULL,NULL,5464,5464,'2022-08-08 07:40:15',NULL,NULL,NULL,NULL,NULL,'asDasd'),(75925168,'jhj','gjghj','ghjghj',1231,NULL,NULL,NULL,'',NULL,2312321,231,'2022-07-29 22:37:20',NULL,NULL,NULL,NULL,NULL,'anadido'),(688089514256,' bvcbcvnb','vnbvnbv','nbv',1231,NULL,NULL,NULL,'',NULL,3213213,3213,'2022-09-25 14:37:31',NULL,NULL,NULL,NULL,80,'cxzcxz'),(2190839452139,'adada','dsafasdfa','fdsafaddfs',1312,4564,6546,4564,'verde','grande',21321,3123,'2022-08-05 18:12:31',16,5,NULL,5,NULL,'anadido'),(2393854961446,'dasddsa','dsad','asdas',21321,NULL,NULL,NULL,'',NULL,21321,3213,'2022-08-05 16:19:17',NULL,NULL,NULL,NULL,NULL,'anadido'),(3576953937339,'<','asdsdasd','sadasdas',2123,12321,3123,123,'ghdfg','gf',321321,21321,'2022-08-02 13:28:54',NULL,NULL,NULL,NULL,NULL,'anadido'),(4420061396957,'gfdg','dfgdfgdf','gdfgdf',343,NULL,NULL,NULL,'',NULL,312,3456,'2022-07-29 22:39:19',NULL,NULL,NULL,NULL,NULL,'anadido'),(4611236312485,'chipileta','verde','ghjgh',210,2,2,132,'verde','grande',21312,3123,'2022-09-03 11:11:45',4,5,8,9,80,''),(6243340423249,'ayyyyy','yyy','yyyyy',232323,432,4324,15646,'sad','gramdD',123.021321,132156.03213,'2022-08-03 15:50:41',NULL,NULL,NULL,NULL,NULL,'anadido'),(6679656518349,'ggg','gghhh','hhhhh',2,NULL,NULL,NULL,'',NULL,8787,787,'2022-08-29 21:47:48',NULL,NULL,NULL,NULL,NULL,''),(6825166629653,'jhgjf','j','ghfj',31,NULL,NULL,NULL,'',NULL,321,13,'2022-08-10 07:36:16',NULL,NULL,NULL,NULL,NULL,''),(6834126888937,'njvvbn','nbvnvn','bvnbvnv',33,NULL,NULL,NULL,'',NULL,2323,32,'2022-08-28 19:29:05',NULL,NULL,NULL,NULL,80,'gfhgf'),(9578302976396,'s2222','dfas','',12321,NULL,NULL,NULL,'','231',32131,2131,'2022-08-08 07:40:35',NULL,NULL,NULL,NULL,NULL,'tttttttt');
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
INSERT INTO `productos_eliminados` VALUES (NULL,NULL,'panes de dulce','de colores','Eliminado','2022-06-22 15:32:12'),(NULL,NULL,'panes de dulce','de colores','Eliminado','2022-06-22 15:33:54'),(NULL,NULL,'panes de dulce','de colores','Eliminado','2022-06-22 16:03:06'),(NULL,NULL,' dulce','de','Eliminado','2022-06-22 16:03:42'),(NULL,NULL,' dulce','de','Eliminado','2022-06-23 20:02:17'),(NULL,NULL,'nuevos panes e duces','chocolate','Eliminado','2022-07-28 14:25:01'),(80,NULL,'fds','fdsf','Eliminado','2022-08-03 16:25:33'),(NULL,NULL,'45645','6546456','Eliminado','2022-08-03 16:26:37'),(NULL,NULL,'asdas','asdas','Eliminado','2022-08-03 16:35:06'),(80,NULL,'panes de dulce','chocolate','Eliminado','2022-08-03 16:35:30'),(NULL,NULL,'nuevos panes e duces','chocolate','Eliminado','2022-08-03 16:58:37'),(NULL,NULL,'21321','312321321','Eliminado','2022-08-03 16:59:07'),(80,NULL,'dasdas','dsads','Eliminado','2022-08-04 17:05:49'),(NULL,NULL,'dasdas','dsads','Eliminado','2022-08-05 16:19:31'),(NULL,NULL,'adada','dsafasdfa','Eliminado','2022-08-05 18:14:43');
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provedores`
--

LOCK TABLES `provedores` WRITE;
/*!40000 ALTER TABLE `provedores` DISABLE KEYS */;
INSERT INTO `provedores` VALUES (4,'jose','zeepda','romero','bimbo','carlos joaquin','22222222'),(5,'carlos juares','sdas','sdadsaAAAAAAAAAAA','sas','dsadas','dasdasdas'),(16,'juan nm','zxczxczxc','zxczx','carroserias carlos','czxczxczx','czxczxczx');
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
INSERT INTO `users` VALUES (1,'jose juan ','zepeda','romero','jhosep','ÔøΩÔøΩn`\0≈∂ÔøΩ>s$ÔøΩÔøΩ~'),(2,'carlos','zepeda','romero','carlangas','ÔøΩÔøΩ{ÔøΩÔøΩÔøΩ◊∑ÔøΩU0QÔøΩ'),(4,'carlosgfs','zepeda','romero','car','ÔøΩÔøΩ{ÔøΩÔøΩÔøΩ◊∑ÔøΩU0QÔøΩ'),(56,'jose','zepeda','roemro','carlos','Jm\"ÿN∏Nbö¯ø¨Œb¯');
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
INSERT INTO `usuarios` VALUES (80,'ADMINISTRADOR','javier','comisario','flores','javi','ß√%Moö}¿Å\Z(√”<','2022-07-27 16:48:13'),(121,'EMPLEADO','jazmin','sanchez','romero','jaz','ˇRtó)‡Ì‚ l0ì','2022-08-23 22:09:36'),(1231,'ADMINISTRADOR','jose juan ','zeoeda romer','','zepeda','˜’Dh€”Á¡yî	QRL3','2022-09-25 14:46:18');
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
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (5,2,'asdas','asdas',122.12,1,528746.12,'2022-08-10 10:11:58',NULL,NULL,NULL),(13,1,'gggggg','ollas de barro',123,235,123,'2022-08-09 20:18:56',NULL,NULL,NULL),(14,1231,'gggggg','ollas de barro',123,235,123,'2022-08-09 20:24:42',NULL,NULL,NULL),(15,1231,'gggggg','ollas de barro',123,235,123,'2022-08-10 09:16:33',NULL,NULL,NULL),(50,1,'gggggggss','ddddddd',132156,35,300,'2022-08-10 09:54:48',NULL,NULL,NULL),(51,1,'gggggggss','ddddddd',132156,35,300,'2022-08-10 10:18:52',NULL,NULL,56),(52,7,'asdas','asdas',122.12,1,925336.24,'2022-08-10 10:19:41',NULL,NULL,7),(53,2,'asdas','asdas',122.12,1,925336.24,'2022-08-10 10:19:41',NULL,NULL,7),(54,1231,'aaaaaaa','ddddddd',132156,7,925336.24,'2022-08-10 10:19:41',NULL,NULL,7),(55,7,'asdas','asdas',122.12,0,660780,'2022-08-10 12:44:47',NULL,NULL,10),(56,1,'gggggggss','ddddddd',132156,5,660780,'2022-08-10 12:44:47',NULL,NULL,10),(57,2,'asdas','asdas',122.12,0,660780,'2022-08-10 12:44:47',NULL,NULL,10),(58,1,'gggggggss','ddddddd',132156,5,660780,'2022-08-10 13:00:39',NULL,NULL,13),(59,1,'gggggggss','ddddddd',132156,5,660780,'2022-08-10 13:00:41',NULL,NULL,13),(60,2,'asdas','asdas',122.12,0,528624,'2022-08-10 13:01:02',NULL,NULL,15),(61,2,'asdas','asdas',122.12,0,528624,'2022-08-10 13:01:16',NULL,NULL,15),(62,1,'gggggggss','ddddddd',132156,3,396468,'2022-08-10 13:09:18',NULL,NULL,17),(63,1,'gggggggss','ddddddd',132156,3,396468,'2022-08-10 13:09:37',NULL,NULL,18),(64,1,'gggggggss','ddddddd',132156,7,925092,'2022-08-10 13:09:47',NULL,NULL,18),(65,1,'gggggggss','ddddddd',132156,7,925092,'2022-08-10 13:09:47',NULL,NULL,18),(66,1,'gggggggss','ddddddd',132156,7,925092,'2022-08-10 13:09:47',NULL,NULL,18),(67,1,'gggggggss','ddddddd',132156,7,925092,'2022-08-10 13:09:48',NULL,NULL,18),(68,1,'gggggggss','ddddddd',132156,7,925092,'2022-08-10 13:09:48',NULL,NULL,18),(69,1,'gggggggss','ddddddd',132156,1,132156,'2022-08-10 13:11:02',NULL,NULL,24),(70,1,'gggggggss','ddddddd',132156,3,300000,'2022-08-10 13:12:03',NULL,NULL,25),(71,1,'gggggggss','ddddddd',132156,1,132156,'2022-08-10 13:13:04',NULL,NULL,26),(72,1,'gggggggss','ddddddd',132156,1,153444,'2022-08-10 13:14:46',NULL,NULL,27),(73,1,'gggggggss','ddddddd',132156,35,300,'2022-08-10 14:20:03',NULL,NULL,56),(74,1,'gggggggss','ddddddd',132156,35,300,'2022-08-10 14:35:28',NULL,NULL,56),(75,1,'gggggggss','ddddddd',132156,35,300,'2022-08-10 15:15:49',NULL,80,56),(76,1231,'aaaaaaa','ddddddd',132156,4,660780,'2022-08-10 20:43:53',NULL,NULL,31),(77,1,'gggggggss','ddddddd',132156,1,132156,'2022-08-10 22:49:02',NULL,NULL,32),(78,1231,'aaaaaaa','ddddddd',132156,3,528624,'2022-08-15 12:50:41',NULL,NULL,33),(79,1,'gggggggss','ddddddd',132156,1,132156,'2022-08-23 22:17:39',NULL,NULL,34),(80,1,'gggggggss','ddddddd',132156,35,300,'2022-08-29 21:41:23',NULL,NULL,56),(81,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-08-29 21:43:41',12,121,36),(82,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-08-29 21:47:07',2,80,37),(83,1,'gggggggss','ddddddd',132156,1,132156,'2022-09-03 14:40:19',NULL,80,38),(84,31475,'fdsfsdfs','de colores',2555,2,5110,'2022-09-25 14:48:16',NULL,80,38),(85,4646513,'sad','sad',3213,1,3203,'2022-11-13 12:01:32',NULL,80,38),(86,31456,'nuevos panes e duces','chocolate',120,2,240,'2022-11-13 12:24:14',NULL,80,41),(87,31456,'nuevos panes e duces','chocolate',120,1,5000,'2022-11-13 12:26:12',NULL,80,42),(88,1,'gggggggss','ddddddd',132156,1,135279,'2022-11-13 13:31:18',NULL,80,43),(89,4420061396957,'gfdg','dfgdfgdf',3456,1,4243,'2022-11-13 15:27:55',NULL,80,44),(90,4420061396957,'gfdg','dfgdfgdf',3456,1,4243,'2022-11-13 15:27:55',NULL,80,44),(91,31456,'nuevos panes e duces','chocolate',120,1,4376,'2022-11-13 15:28:50',NULL,80,46),(92,31456,'nuevos panes e duces','chocolate',120,1,4376,'2022-11-13 15:28:50',NULL,80,46),(93,31456,'nuevos panes e duces','chocolate',120,1,4376,'2022-11-13 15:28:50',NULL,80,46),(94,31456,'nuevos panes e duces','chocolate',120,1,4376,'2022-11-13 15:28:50',NULL,80,46),(95,12313,'sda','ffsad',25,2,50,'2022-11-20 16:26:21',NULL,NULL,26),(96,12313,'sda','ffsad',25,1,25,'2022-11-20 16:27:10',NULL,NULL,26),(97,12313,'sda','ffsad',25,1,25,'2022-11-20 16:28:19',NULL,NULL,26),(98,12313,'sda','ffsad',25,1,25,'2022-11-20 16:41:32',NULL,NULL,26),(99,12313,'sda','ffsad',25,1,25,'2022-11-20 16:42:03',NULL,NULL,26),(100,1231,'aaaaaaa','ddddddd',132156,1,132281,'2022-11-20 16:42:45',NULL,NULL,26),(101,1231,'aaaaaaa','ddddddd',132156,1,132281,'2022-11-20 16:42:45',NULL,NULL,26),(102,12313,'sda','ffsad',25,3,75,'2022-11-20 16:44:10',NULL,NULL,26),(103,12313,'sda','ffsad',25,2,132206,'2022-11-20 16:45:26',NULL,NULL,26),(104,12313,'sda','ffsad',25,2,132206,'2022-11-20 16:45:26',NULL,NULL,26),(105,1,'gggggggss','ddddddd',132156,1,132206,'2022-11-20 17:08:49',NULL,NULL,26),(106,1,'gggggggss','ddddddd',132156,1,132206,'2022-11-20 17:08:49',NULL,NULL,26),(107,12313,'sda','ffsad',25,1,25,'2022-11-20 17:38:04',NULL,NULL,26),(108,12313,'sda','ffsad',25,1,25,'2022-11-20 17:41:23',NULL,NULL,26),(109,12313,'sda','ffsad',25,1,25,'2022-11-20 17:43:12',NULL,NULL,26),(110,12313,'sda','ffsad',25,1,25,'2022-11-20 17:44:08',NULL,NULL,26),(111,12313,'sda','ffsad',25,1,25,'2022-11-20 17:45:46',NULL,NULL,26),(112,12313,'sda','ffsad',25,1,25,'2022-11-20 17:47:13',NULL,NULL,26),(113,12313,'sda','ffsad',25,1,25,'2022-11-20 17:48:26',NULL,NULL,26),(114,12313,'sda','ffsad',25,1,25,'2022-11-20 17:48:58',NULL,NULL,26),(115,12313,'sda','ffsad',25,1,25,'2022-11-20 17:52:10',NULL,NULL,26),(116,12313,'sda','ffsad',25,1,25,'2022-11-20 17:52:29',NULL,NULL,26),(117,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 17:55:09',NULL,NULL,26),(118,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 17:55:54',NULL,NULL,26),(119,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 17:56:16',NULL,NULL,26),(120,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 17:58:24',NULL,NULL,26),(121,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 18:01:31',NULL,NULL,26),(122,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 18:02:04',NULL,NULL,26),(123,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 18:06:06',NULL,NULL,26),(124,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 18:12:22',NULL,NULL,26),(125,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 18:13:40',NULL,NULL,26),(126,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 18:14:09',NULL,NULL,26),(127,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 18:14:30',NULL,NULL,26),(128,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 18:14:57',NULL,NULL,26),(129,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 18:15:32',NULL,NULL,26),(130,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 18:16:40',NULL,NULL,26),(131,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 18:17:03',NULL,NULL,26),(132,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 18:18:05',NULL,NULL,26),(133,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 22:36:38',NULL,NULL,26),(134,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 22:37:26',NULL,NULL,26),(135,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 22:41:27',NULL,NULL,26),(136,1231,'aaaaaaa','ddddddd',132156,1,132156,'2022-11-20 22:42:20',NULL,NULL,26),(137,31456,'nuevos panes e duces','chocolate',120,3,360,'2022-11-20 22:46:18',NULL,NULL,26),(138,4646513,'sad','sad',3213,1,3453,'2022-11-20 22:47:40',NULL,NULL,26),(139,4646513,'sad','sad',3213,1,3453,'2022-11-20 22:47:40',NULL,NULL,26),(140,4611236312485,'chipileta','verde',3123,1,3388,'2022-11-20 22:49:34',NULL,NULL,26),(141,4611236312485,'chipileta','verde',3123,1,3388,'2022-11-20 22:49:34',NULL,NULL,26),(142,4611236312485,'chipileta','verde',3123,1,3388,'2022-11-20 22:49:34',NULL,NULL,26);
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `anadir_devoluciones_perdidas`(id_productoDB bigint,unidadesDB int, cantidadDB double,motivoDB varchar(100),fk_clienteDB varchar(100),fk_usuarioDB varchar(100))
begin
declare descripcion1In varchar (100);
declare descripcion2In varchar (150);
declare productoIn varchar(100);
declare usuarioIn int;

set usuarioIn = (select id from pv_canoa_segunda.usuarios where nickname = fk_usuarioDB);
set descripcion1In 	  = (select tipo from pv_canoa_segunda.productos  where id = id_productoDB);
set descripcion2In  = (select extra_distinctive  from pv_canoa_segunda.productos  where id = id_productoDB);
set productoIn  = (select product from pv_canoa_segunda.productos where id = id_productoDB);
	
INSERT INTO pv_canoa_segunda.perdidas_devoluciones
(id_producto, producto, descripcion1, descripcion2, unidades, cantidad_devolver, motivo ,fecha, fk_cliente, fk_usuario)
VALUES(id_productoDB ,productoIn ,descripcion1In  ,descripcion2In  ,unidadesDB ,cantidadDB, motivoDB ,now(), fk_clienteDB ,usuarioIn);



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `a√±adir_producto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `a√±adir_producto`(idDB bigint, productDB varchar(50), tipoDB varchar(50) , extra_distinctiveDB varchar (50), stockDB int, kilogramosDB double, medidaDB double, mililitrosDB double, colorDB varchar(20), tamanoDB varchar(50), precioCompraDB double ,precioVentaDB double ,  fk_provedoresDB varchar(30) , fk_marcaDB varchar(30), fk_lineaDB varchar(30), fk_categoriaDB varchar(30), fk_usuarioDB varchar(30),notas_ventaDB varchar(300))
begin

	

	declare razonDB varchar (30);
declare provedoresCast int;
declare marcaCast int;
declare lineaCast int;
declare categoriaCast int;
declare usuariosCast int;

set provedoresCast = (select id from pv_canoa_segunda.provedores where nombre = fk_provedoresDB );
set marcaCast  = (select id from pv_canoa_segunda.marcas  where marca  =  fk_marcaDB) ;
set lineaCast  = (select id from pv_canoa_segunda.linea  where  linea = fk_lineaDB  );
set categoriaCast  = (select id from pv_canoa_segunda.categoria  where categoria  = fk_categoriaDB );
set usuariosCast  = (select id from pv_canoa_segunda.usuarios  where nickname = fk_usuarioDB );

set razonDB = "anadido";

	

	INSERT INTO pv_canoa_segunda.productos

(id, product, tipo, extra_distinctive, stock, kilogramos, medida, mililitros, color, tamano, precioCompra, precioVenta, fecha, fk_provedores, fk_marca, fk_linea, fk_categoria,fk_usuario,notas_de_venta)



VALUES(idDB, productDB, tipoDB, extra_distinctiveDB , stockDB, kilogramosDB, medidaDB, mililitrosDB, colorDB , tamanoDB, precioCompraDB ,precioVentaDB , now() ,  provedoresCast  ,marcaCast , lineaCast  , categoriaCast ,usuariosCast ,notas_ventaDB);



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
	
	select count(*) from pv_canoa_segunda.venta group by numero_venta ; 
	
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_venta`(fk_productosDB bigint, cantidadDB double, totalDB double, fk_clientesDB int, fk_usuariosDB varchar(50),id_venta int)
begin
	
declare stock_disponible int;
declare cantidad_recibida double;
declare total_stock  double;

declare productoIn varchar(100);
declare distintivoIn  varchar(150); 
declare precioIn  double;
declare usuario_in int;

set productoIn = (select product from pv_canoa_segunda.productos where id = fk_productosDB);
set distintivoIn  = (select tipo from pv_canoa_segunda.productos where id = fk_productosDB);
set precioIn = (select precioVenta  from pv_canoa_segunda.productos where id = fk_productosDB);
set usuario_in  = (select id from pv_canoa_segunda.usuarios  where nickname =  fk_usuariosDB);

INSERT INTO pv_canoa_segunda.venta
		
(fk_productos, producto, distintivo1, precio, cantidad, total, fecha, fk_clientes, fk_usuarios,numero_venta)
VALUES(fk_productosDB ,productoIn  ,distintivoIn  , precioIn  ,cantidadDB ,totalDB ,now(), fk_clientesDB ,usuario_in ,id_venta);

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `validar_usuario`(in nicknameDB varchar(100), in passDB varchar (100),out acceso boolean)
begin
	
 declare nickname_in int ;

 declare  pass_in varchar (100) ;

	declare salt varchar(50);

set salt = '153624'; 

 /*SET nickname_in  = (SELECT nickname   FROM pv_canoa_segunda.usuarios   where id  = idDB);*/


 SET  pass_in  = (select cast (aes_decrypt( pass  ,153624) as char) from pv_canoa_segunda.usuarios  where nickname  = nicknameDB);





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

-- Dump completed on 2022-11-21 20:41:31
