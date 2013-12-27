-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2013 at 02:55 PM
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
-- Dumping data for table `materiaprima`
--

INSERT INTO `materiaprima` (`id`, `descricao`, `nome`, `unidade`) VALUES
(1, '', 'Alface', 'unidade'),
(2, '', 'Alho', 'unidade'),
(3, '', 'Batata Palha', 'unidade'),
(4, '', 'Carne Bovina', 'kg'),
(5, '', 'Coca-Cola 500ml', 'unidade'),
(6, '', 'Coca-Cola lata', 'unidade'),
(7, '', 'Fanta 500ml', 'unidade'),
(8, '', 'Fanta lata', 'unidade'),
(9, '', 'Filet Bovino', 'kg'),
(10, '', 'Frango', 'kg'),
(11, '', 'Heineken longneck', 'unidade'),
(12, '', 'Maionese', 'g'),
(13, '', 'Milho', 'unidade'),
(14, '', 'Ovos', 'unidade'),
(15, '', 'Pão Bola (burguer)', 'unidade'),
(16, '', 'Pão Bola (super-burguer)', 'unidade'),
(17, '', 'Pão Caixa', 'unidade'),
(18, '', 'Pão Francês', 'unidade'),
(19, '', 'Picanha Bovina', 'unidade'),
(20, '', 'Polpa de Acerola', 'unidade'),
(21, '', 'Polpa de Graviola', 'unidade'),
(22, '', 'Polpa de Uva', 'unidade'),
(23, '', 'Skoll lata', 'unidade'),
(24, '', 'Sprite 500ml', 'unidade'),
(25, '', 'Sprite lata', 'unidade');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
