CREATE TABLE `passengers` (
  `id`               INT                     NOT NULL  AUTO_INCREMENT,
  `version`          INT                     NOT NULL  DEFAULT 0,
  `name`             VARCHAR(45)             NOT NULL,
  `age`              INT                     NOT NULL,
  `gender`           ENUM('MALE', 'FEMALE')  NOT NULL,
  `created`          DATETIME                NOT NULL   DEFAULT now(),
  `modified`         DATETIME                NOT NULL   DEFAULT now(),
  `credit_balance`   INT                     NOT NULL   DEFAULT 0,
  PRIMARY KEY (`id`));