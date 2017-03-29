CREATE TABLE `pizza` (
  `id` int(11) auto_increment NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `reference` varchar(10) NOT NULL,
  `prix` double DEFAULT NULL,
  `url_image` varchar(255) DEFAULT NULL,
  `categorie_pizza` varchar(30)  DEFAULT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO `pizza` (`libelle`, `reference`, `prix`, `url_image`, `categorie_pizza`) VALUES
('Pizadda', 'PIZA', '25', 'pizaurl', 'VIANDE');