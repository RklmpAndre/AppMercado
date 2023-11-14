-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: appmercado_bd
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `carrinhos`
--

DROP TABLE IF EXISTS `carrinhos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrinhos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userID` varchar(14) DEFAULT NULL,
  `data_criação` varchar(10) DEFAULT NULL,
  `condição` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userID` (`userID`),
  CONSTRAINT `carrinhos_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `usuários` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinhos`
--

LOCK TABLES `carrinhos` WRITE;
/*!40000 ALTER TABLE `carrinhos` DISABLE KEYS */;
INSERT INTO `carrinhos` VALUES (4,'033.017.891-33','02/11/2023',1),(5,'040.217.400-31','02/11/2023',1),(6,'616.884.450-30','02/11/2023',1),(7,'810.989.140-31','02/11/2023',1),(8,'633.153.710-40','02/11/2023',1);
/*!40000 ALTER TABLE `carrinhos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `historico_id` int DEFAULT NULL,
  `data_compra` varchar(10) NOT NULL,
  `pedido_entrega` int NOT NULL,
  `forma_pagamento` int NOT NULL,
  `total_compra` double NOT NULL,
  `produtos` text NOT NULL,
  `endereco_entrega` varchar(255) DEFAULT NULL,
  `data_entrega` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
INSERT INTO `compras` VALUES (1,1,'07/11/2023',0,0,10.1,'[Produto: Nove54 Sifão 10un R$20.2\n, Produto: Castela Brasil Bicicleta De Equilíbrio Infantil Sem Pedal KBK-068 10un R$20.2\n, Produto: SunSun Termomêtro 10un R$20.2\n, Produto: Grenal Corte de cabelo 10un R$20.2\n]',' ',NULL),(2,1,'08/11/2023',0,2,843.0000000000001,'[]',' ',NULL),(3,1,'08/11/2023',0,2,18.3,'[]',' ',NULL),(4,1,'08/11/2023',0,2,198.3,'[]',' ',NULL),(5,1,'08/11/2023',0,2,383.4,'[Produto: Nove54 Sifão 6un R$109.80000000000001\n, Produto: SunSun Termomêtro 3un R$33.599999999999994\n, Produto: Grenal Corte de cabelo 6un R$240.0\n]',' ',NULL),(6,1,'08/11/2023',0,2,627.88,'[Produto: Nove54 Sifão 4un R$73.2\n, Produto: Castela Brasil Bicicleta De Equilíbrio Infantil Sem Pedal KBK-068 3un R$461.88\n, Produto: SunSun Termomêtro 4un R$44.8\n, Produto: Pringgles Salgadinho 4un R$48.0\n]',' ',NULL),(7,1,'08/11/2023',0,2,84,'[Produto: Pringgles Salgadinho 7un R$84.0\n]',' ',NULL),(8,1,'08/11/2023',0,2,24,'[Produto: Pringgles Salgadinho 2un R$24.0\n]',' ',NULL),(9,1,'11/11/2023',0,1,54.900000000000006,'[Produto: Nove54 Sifão 3un R$54.900000000000006\n]',' ',NULL),(10,1,'13/11/2023',0,0,91.5,'[Produto: Nove54 Sifão 5un R$91.5\n]',' ',' '),(11,1,'13/11/2023',1,0,73.2,'[Produto: Nove54 Sifão 4un R$73.2\n]','Endereco{rua=\'Santa Luzia\', numero=\'115\', complemento=\'Rua sem saída\', bairro=\'Dona Alice\', cidade=\'Capão da Canoa\', estado=\'UnidadeFederacao{nome=\'Amazonas\', sigla=\'AM\', capital=\'Manaus\'}\', cep=\'95555-000\'}','13/11/2023'),(12,1,'13/11/2023',1,0,109.80000000000001,'[Produto: Nove54 Sifão 6un R$109.80000000000001\n]','Endereco{rua=\'Dona Alice\', numero=\'115\', complemento=\'Rua sem saída\', bairro=\'Santa Luzia\', cidade=\'Capão da Canoa\', estado=\'UnidadeFederacao{nome=\'Amazonas\', sigla=\'AM\', capital=\'Manaus\'}\', cep=\'95555-000\'}','23/10/2025'),(13,1,'13/11/2023',1,0,18.3,'[Produto: Nove54 Sifão 1un R$18.3\n]','Rua=\'Dona Alice\', numero=\'115\', complemento=\'Rua sem saída\', nome=\'Casa do pai\', bairro=\'Santa Luzia\', cidade=\'Capão da Canoa\', estado=\'UnidadeFederacao{nome=\'Amazonas\', sigla=\'AM\', capital=\'Manaus\'}\', cep=\'95555-000\'}','10/10/2022');
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estoque` (
  `id` int NOT NULL AUTO_INCREMENT,
  `marca` varchar(150) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `quantidade` int NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `preco` double NOT NULL,
  `tipo` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
INSERT INTO `estoque` VALUES (18,'Nove54','Sifão',58,'Bomba manual para linquídos',18.3,4),(19,'Castela Brasil','Bicicleta De Equilíbrio Infantil Sem Pedal KBK-068',1,'Bicicleta 4 rodas',153.96,4),(20,'SunSun','Termomêtro',41,'Termomêtro de vidro',11.2,4),(21,'Grenal','Corte de cabelo',20,'Corte de cabelo ao estilo que quiser',40,1),(22,'Pringgles','Salgadinho',5,'Sabor listerine',12,0);
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historicos`
--

DROP TABLE IF EXISTS `historicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historicos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`),
  CONSTRAINT `fk_HistoricoUsuario` FOREIGN KEY (`user_id`) REFERENCES `usuários` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historicos`
--

LOCK TABLES `historicos` WRITE;
/*!40000 ALTER TABLE `historicos` DISABLE KEYS */;
INSERT INTO `historicos` VALUES (1,'040.217.400-31');
/*!40000 ALTER TABLE `historicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_carrinho`
--

DROP TABLE IF EXISTS `item_carrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_carrinho` (
  `carrinho_id` int NOT NULL,
  `produto_id` int NOT NULL,
  `quantidade` int DEFAULT NULL,
  PRIMARY KEY (`carrinho_id`,`produto_id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `item_carrinho_ibfk_1` FOREIGN KEY (`carrinho_id`) REFERENCES `carrinhos` (`id`),
  CONSTRAINT `item_carrinho_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `estoque` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_carrinho`
--

LOCK TABLES `item_carrinho` WRITE;
/*!40000 ALTER TABLE `item_carrinho` DISABLE KEYS */;
INSERT INTO `item_carrinho` VALUES (4,18,8),(4,20,4),(4,22,5);
/*!40000 ALTER TABLE `item_carrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuários`
--

DROP TABLE IF EXISTS `usuários`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuários` (
  `cpf` varchar(14) NOT NULL,
  `email` varchar(100) NOT NULL,
  `nome` varchar(75) NOT NULL,
  `dataNascimento` varchar(255) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `tipoUsuario` int NOT NULL,
  PRIMARY KEY (`cpf`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuários`
--

LOCK TABLES `usuários` WRITE;
/*!40000 ALTER TABLE `usuários` DISABLE KEYS */;
INSERT INTO `usuários` VALUES ('033.017.891-33','kurz2011@outlook.com','Helena Kurz Gonçalvez','27/05/2004','2149451',0),('040.217.400-31','andre2016mendes@yahoo.com','André Mendes Pinto','03/07/2003','030720033',0),('616.884.450-30','a@a.com','Paulo Lorenzo Parecel','11/04/2012','Madrelajj22!',0),('633.153.710-40','c@c.com','André Mendes Pinto','04/02/2003','jjjj2222',0),('810.989.140-31','b@b.com','André Mendes Pinto','03/07/2003','jjjj2222',0),('949.185.560-35','d@a.com','André Mendes Pinto','03/07/2003','jjjj2222',0),('957.778.650-20','douglas2911@gmail.com','Douglas Adornes Pinto','03/07/2003','12345678',0);
/*!40000 ALTER TABLE `usuários` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-14 10:54:12
