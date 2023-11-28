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
  `id_usuario` varchar(14) COLLATE utf8mb4_general_ci NOT NULL,
  `data` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usuario` (`id_usuario`),
  CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinhos`
--

LOCK TABLES `carrinhos` WRITE;
/*!40000 ALTER TABLE `carrinhos` DISABLE KEYS */;
INSERT INTO `carrinhos` VALUES (16,'040.217.400-31','28/11/2023'),(17,'040.217.400-31','28/11/2023'),(18,'040.217.400-31','28/11/2023'),(19,'040.217.400-31','28/11/2023');
/*!40000 ALTER TABLE `carrinhos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estoque` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` text COLLATE utf8mb4_general_ci,
  `marca` varchar(150) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `valor_unitario` double DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  `tipo` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
INSERT INTO `estoque` VALUES (1,'Calçado esportivo com tecnologia de amortecimento','Nike','Tênis Air Max',499.99,100,0),(2,'Impressora monocromática de alta velocidade','HP','Impressora LaserJet Pro',899.9,30,0),(3,'Console de última geração com suporte a 4K','Sony','PlayStation 5',4999,20,0),(4,'Bebida carbonatada','Coca-Cola','Refrigerante Original',12.99,200,0),(5,'Camiseta esportiva de tecido respirável','Adidas','Camiseta ClimaLite',79.9,150,0),(6,'Notebook com processador Intel Core i7','Dell','Laptop Inspiron 15',4199,50,0),(7,'Conjunto com 4 unidades de lâminas de barbear','Gillette','Lâminas Mach3',29.99,80,0),(8,'Barra de chocolate crocante','Nestlé','Chocolate Kit Kat',7.5,120,0),(9,'Televisão com resolução 4K e tecnologia QLED','Samsung','Smart TV QLED 55',3799,15,0),(10,'Blusa de moletom com capuz','Nike','Moletom Sportswear',149.99,80,0),(11,'Fone com cancelamento de ruído','Bose','Fone de Ouvido QuietComfort 35 II',1199,40,0),(12,'Shampoo reparador para cabelos danificados','L\'Oréal','Shampoo Elvive',15.99,200,0),(13,'Celular retrô com bateria de longa duração','Nokia','Celular Nokia 3310',199.9,60,0),(14,'Calça legging esportiva','Reebok','Legging CrossFit',69.9,70,0),(15,'Caixa de som portátil à prova d\'água','JBL','Caixa de Som Bluetooth Charge 4',699,25,0),(16,'Tablet Android com tela Full HD','Lenovo','Tablet Tab P11',1299,35,0),(17,'Sabonete hidratante','Dove','Sabonete em Barra Original',9.99,150,0),(18,'Tênis esportivo com design moderno','Puma','Tênis RS-X³ Puzzle',349.9,90,0),(19,'Relógio resistente a choques e água','Casio','Relógio G-Shock',599,50,0),(20,'Smartphone com câmera de 64MP e 5G','Samsung','Galaxy S21',3299,50,5);
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico`
--

DROP TABLE IF EXISTS `historico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `carrinho_id` int NOT NULL,
  `endereco` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `data` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `forma_pagamento` int NOT NULL,
  `entrega` int NOT NULL,
  `total_compra` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_itens_carrinho` (`carrinho_id`),
  CONSTRAINT `fk_carrinho_historico` FOREIGN KEY (`carrinho_id`) REFERENCES `carrinhos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico`
--

LOCK TABLES `historico` WRITE;
/*!40000 ALTER TABLE `historico` DISABLE KEYS */;
INSERT INTO `historico` VALUES (14,16,' ',' ',2,0,4999.9),(15,17,'Rua=\'Dona Alice\', numero=\'115\', complemento=\'Casa\', nome=\'Minha Casa\', bairro=\'Santa Luzia\', cidade=\'Capão da Canoa\', estado=\'UnidadeFederacao{nome=\'Rio Grande do Sul\', sigla=\'RS\', capital=\'Porto Alegre\'}\', cep=\'95555-000\'}','10/10/2023',2,1,899.9),(16,18,'Rua=\'Ceci\', numero=\'608\', complemento=\'Casa\', nome=\'Casa Mãe\', bairro=\'Zona Nova\', cidade=\'Capão da Canoa\', estado=\'UnidadeFederacao{nome=\'Rio Grande do Sul\', sigla=\'RS\', capital=\'Porto Alegre\'}\', cep=\'95555-000\'}','10/02/2023',1,1,5489.37),(17,19,' ',' ',1,0,1499.97);
/*!40000 ALTER TABLE `historico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_escolhido`
--

DROP TABLE IF EXISTS `item_escolhido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_escolhido` (
  `id` int NOT NULL AUTO_INCREMENT,
  `produto_id` int DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `usuario_id` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_produtos` (`produto_id`),
  CONSTRAINT `fk_produtos` FOREIGN KEY (`produto_id`) REFERENCES `estoque` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_escolhido`
--

LOCK TABLES `item_escolhido` WRITE;
/*!40000 ALTER TABLE `item_escolhido` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_escolhido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_carrinho`
--

DROP TABLE IF EXISTS `itens_carrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itens_carrinho` (
  `id` int NOT NULL AUTO_INCREMENT,
  `carrinho_id` int NOT NULL,
  `produto_id` int NOT NULL,
  `quantidade` int NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_carrinho` (`carrinho_id`),
  KEY `fk_produto` (`produto_id`),
  CONSTRAINT `fk_carrinho` FOREIGN KEY (`carrinho_id`) REFERENCES `carrinhos` (`id`),
  CONSTRAINT `fk_produto` FOREIGN KEY (`produto_id`) REFERENCES `estoque` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_carrinho`
--

LOCK TABLES `itens_carrinho` WRITE;
/*!40000 ALTER TABLE `itens_carrinho` DISABLE KEYS */;
INSERT INTO `itens_carrinho` VALUES (35,16,1,10,4999.9),(36,17,2,1,899.9),(37,18,2,6,5399.4),(38,18,7,3,89.97),(39,19,1,3,1499.97);
/*!40000 ALTER TABLE `itens_carrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `cpf` varchar(14) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `data_nascimento` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `nome` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `senha` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `tipo` int NOT NULL,
  PRIMARY KEY (`cpf`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('040.217.400-31','andre2016mendes@gmail.com','03/07/2003','André Mendes Pinto','030720033',0),('684.242.500-01','ryosuke.sorye@gmail.com','20/08/2003','Lune Seraphim Vieira','andrezinho17',0);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-28  4:20:16
