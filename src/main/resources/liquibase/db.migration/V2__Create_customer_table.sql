CREATE TABLE IF NOT EXISTS `Customer`
(
    `id`         int(11) unsigned NOT NULL AUTO_INCREMENT,
    `first_name` varchar(255)     NOT NULL DEFAULT '',
    `last_name`  varchar(255)     NOT NULL DEFAULT '',
    `tel_number` varchar(15)      NOT NULL DEFAULT '',
    PRIMARY KEY (`id`)
)