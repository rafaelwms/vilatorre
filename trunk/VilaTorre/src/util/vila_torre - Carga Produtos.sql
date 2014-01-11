-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2013 at 07:04 PM
-- Server version: 5.6.11
-- PHP Version: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `vila_torre`
--
CREATE DATABASE IF NOT EXISTS `vila_torre` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `vila_torre`;

--
-- Dumping data for table `produto`
--

INSERT INTO `produto` (`id`, `descricao`, `nome`, `categoria`, `preco`) VALUES
(1, '', 'Antonio Rabelo - ALHO', 'Burgers', 10.3),
(2, '', 'Benjamin Constante - ALHO', 'Burgers', 9.5),
(3, '', 'Conde de Irajá - ALHO', 'Burgers', 8.2),
(4, '', 'Coca-Cola 500ml', 'Bebidas', 4),
(5, '', 'Coca-Cola lata', 'Bebidas', 3.5);

--
-- Dumping data for table `produto_ingredientes`
--

INSERT INTO `produto_ingredientes` (`produto`, `ingrediente`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 8),
(1, 17),
(1, 18),
(1, 20),
(2, 1),
(2, 2),
(2, 3),
(2, 10),
(2, 17),
(2, 18),
(2, 20),
(3, 1),
(3, 2),
(3, 3),
(3, 10),
(3, 17),
(3, 18),
(3, 20),
(4, 4),
(5, 5);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
