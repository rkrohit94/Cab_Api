CREATE TABLE `reviews` (
  `id`             INT                        NOT NULL     AUTO_INCREMENT,
  `version`        INT                        NOT NULL     DEFAULT         0,
  `score`          INT                        NOT NULL     DEFAULT         0,
  `reviewed_by`    ENUM('DRIVER','PASSENGER') NOT NULL,
  `description`    VARCHAR(250)               NOT NULL,
  `created`        DATETIME                   NOT NULL     DEFAULT         now(),
  `modified`       DATETIME                   NOT NULL     DEFAULT         now(),
  `driver_id`      INT                        NOT NULL,
  `passenger_id`   INT                       NOT NULL,

  PRIMARY KEY (`id`));