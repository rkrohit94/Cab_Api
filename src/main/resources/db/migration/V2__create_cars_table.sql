CREATE TABLE `cars` (
  `id`         INT                   NOT NULL AUTO_INCREMENT,
  `version`    INT                   NOT NULL DEFAULT 0,
  `make`       VARCHAR(45)           NOT NULL,
  `model`      VARCHAR(45)           NOT NULL,
  `year`       INT                   NOT NULL,
  `type`       ENUM('BASIC', 'LUX') NOT NULL,
  `created`    DATETIME              NOT NULL DEFAULT now(),
  `modified`   DATETIME              NOT NULL DEFAULT now(),
  PRIMARY KEY (`id`));
