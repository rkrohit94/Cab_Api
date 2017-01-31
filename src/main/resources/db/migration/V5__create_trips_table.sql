CREATE TABLE `trips` (
  `id`              INT       NOT NULL AUTO_INCREMENT,
  `version`         INT       NOT NULL DEFAULT 0,
  `car_id`          INT       NOT NULL,
  `driver_id`       INT       NOT NULL,
  `passenger_id`    INT       NOT NULL,
  `city_id`         INT       NOT NULL,
  `created`         DATETIME  NOT NULL DEFAULT now(),
  `modified`        DATETIME  NOT NULL DEFAULT now(),
  `kms_driven`      INT       NOT NULL DEFAULT 0,
  `duration`        INT       NOT NULL DEFAULT 0,
  `trip_start_time` DATETIME  NOT NULL DEFAULT now(),
  `trip_end_time`   DATETIME  NOT NULL DEFAULT now(),
  `trip_cost`       INT       NOT NULL DEFAULT 0,
  `tip`             INT       NOT NULL DEFAULT 0,
  `total_trip_cost` INT       NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),

  CONSTRAINT `fk_trip_driver_id`
  FOREIGN KEY (`driver_id`)
  REFERENCES `drivers` (`id`),

  CONSTRAINT `fk_trip_city_id`
  FOREIGN KEY (`city_id`)
  REFERENCES `cities` (`id`),

  CONSTRAINT `fk_trip_car_id`
  FOREIGN KEY (`car_id`)
  REFERENCES `cars` (`id`),

  CONSTRAINT `fk_trip_passenger_id`
  FOREIGN KEY (`passenger_id`)
  REFERENCES `passengers` (`id`));