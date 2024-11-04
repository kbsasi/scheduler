CREATE DATABASE  IF NOT EXISTS `scheduler`;
USE `scheduler`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `user` VALUES
	(1,'Sasi','Tesfahun','tesfahunewket@gmail.com'),
	(2,'Kb','Demeke','kdemeke5@gmail.com');

