CREATE DATABASE demo;
USE demo;
CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `last_name` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci DELAY_KEY_WRITE=1;

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`) VALUES (1,'Noah','Yuval','Noa@yuval.com');
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`) VALUES (2,'papa','fransesco','papa@qwat');
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`) VALUES (3,'Einstein','Albert','alb@ein.com');
