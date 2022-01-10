DROP TABLE IF EXISTS drink CASCADE;
CREATE TABLE `drink` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `alcoholic` bit(1) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);
