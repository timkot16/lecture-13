CREATE TABLE IF NOT EXISTS `Cars`
(
    `id`          int(11) unsigned NOT NULL AUTO_INCREMENT,
    `car`         varchar(15)      NOT NULL DEFAULT '',
    `vin`         varchar(17)      NOT NULL DEFAULT '',
    `number`      varchar(7)       NOT NULL DEFAULT '',
    `year`        int(4)           NOT NULL,
    `customer_id` int(11) unsigned          DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `customer's car` (`customer_id`),
    CONSTRAINT `customer's car` FOREIGN KEY (`customer_id`) REFERENCES `Customer` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
)