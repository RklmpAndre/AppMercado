-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 01-Nov-2023 às 15:49
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `appmercado_bd`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE `estoque` (
  `id` int(11) NOT NULL,
  `marca` varchar(150) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `preco` double NOT NULL,
  `tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Extraindo dados da tabela `estoque`
--

INSERT INTO `estoque` (`id`, `marca`, `nome`, `quantidade`, `descricao`, `preco`, `tipo`) VALUES
(1, 'Lacta', 'Chocolate ao leite', 1000, 'Um barra de chocolate ao leite', 9.99, 0),
(2, 'Garoto', 'Chocolate ao leite', 1010, 'Um barra de chocolate ao leite', 2.99, 0),
(3, 'Paulo lunes', 'Chocolate ao leite', 1010, 'Um barra de chocolate ao leite', 2.99, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `cpf` varchar(14) NOT NULL,
  `nome` varchar(75) NOT NULL,
  `dataNascimento` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `tipoUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`cpf`, `nome`, `dataNascimento`, `email`, `senha`, `tipoUsuario`) VALUES
('040.217.400-31', 'André Mendes Pinto', '03/07/2003', 'a@a.com', '12345678', 0),
('111.222.333-41', 'André Mendes Pinto', '03/07/2003', 'e@a.com', '12345678', 0),
('211.222.302-31', 'André Mendes Pinto', '03/07/2003', 'B@a.com', '12345678', 0);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cpf`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `estoque`
--
ALTER TABLE `estoque`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
