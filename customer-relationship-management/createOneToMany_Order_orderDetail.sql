
use `web_customer_tracker`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_date` varchar(128) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
   
  PRIMARY KEY (`id`),
  
  KEY `FK_ORDER_idx` (`customer_id`),
  
  CONSTRAINT `FK_ORDER` 
  FOREIGN KEY (`customer_id`) 
  REFERENCES `customer` (`id`) 
  
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `order_detail`;

CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` varchar(128) DEFAULT NULL,
  `item_description` varchar(128) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  KEY `FK_INSTRUCTOR_idx` (`order_id`),
  
  CONSTRAINT `FK_INSTRUCTOR` 
  FOREIGN KEY (`order_id`) 
  REFERENCES `order` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;
