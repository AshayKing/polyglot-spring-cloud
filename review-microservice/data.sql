CREATE DATABASE review_db;
CREATE TABLE `review`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `product_id` VARCHAR(100) NOT NULL, 
    `rating` int(1) NOT NULL,
    `customer_id` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`)
);
