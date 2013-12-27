-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2013 at 05:34 PM
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
-- Dumping data for table `ingrediente`
--

INSERT INTO `ingrediente` (`id`, `descricao`, `nome`, `medida`, `qtd`, `materia`) VALUES
(1, '', 'Alface porção', 'porção', 0.1, 1),
(2, '', 'Alho porção', 'porção', 0.05, 2),
(3, '', 'Batata Palha porção', 'porção', 0.05, 3),
(4, '', 'Coca-Cola 500ml ', 'unidade', 1, 5),
(5, '', 'Coca-Cola lata ', 'unidade', 1, 6),
(6, '', 'Fanta 500ml ', 'unidade', 1, 7),
(7, '', 'Fanta lata', 'unidade', 1, 8),
(8, '', 'Hamburger Frango 110g', 'gramas', 0.11, 10),
(9, '', 'Hamburger Frango 150g', 'gramas', 0.15, 10),
(10, '', 'Hamburguer Bovino 110g', 'gramas', 0.11, 4),
(11, '', 'Hamburguer Bovino 150g', 'gramas', 0.15, 4),
(12, '', 'Hamburguer Fillet 110g', 'gramas', 0.11, 9),
(13, '', 'Hamburguer Fillet 150g', 'gramas', 0.15, 9),
(14, '', 'Hamburguer Picanha 110g', 'gramas', 0.11, 19),
(15, '', 'Hamburguer Picanha 150g', 'gramas', 0.15, 19),
(16, '', 'Heineken longneck', 'unidade', 1, 11),
(17, '', 'Maionese porção', 'porção', 0.05, 12),
(18, '', 'Milho porção', 'porção', 0.05, 13),
(19, '', 'Ovo', 'unidade', 1, 14),
(20, '', 'Pão Bola (burguer)', 'unidade', 1, 15),
(21, '', 'Pão Bola (super-burguer)', 'unidade', 1, 16),
(22, '', 'Pão Caixa 1fatia', 'unidade', 1, 17),
(23, '', 'Pão Caixa 2 fatais', 'unidade', 2, 17),
(24, '', 'Pão Caixa 3 fatias', 'unidade', 3, 17),
(25, '', 'Pão Francês', 'unidade', 1, 18),
(26, '', 'Polpa de Acerola ', 'unidade', 1, 20),
(27, '', 'Polpa de Graviola', 'unidade', 1, 21),
(28, '', 'Polpa de Uva', 'unidade', 1, 22),
(29, '', 'Skoll lata', 'unidade', 1, 23),
(30, '', 'Sprite 500ml', 'unidade', 1, 24),
(31, '', 'Sprite lata', 'unidade', 1, 25);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
