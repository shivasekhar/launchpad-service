CREATE TABLE `event_management_db`.`events` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `venue` VARCHAR(45) NULL,
  `date` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `event_management_db`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `register_no` VARCHAR(45) NULL,
  `department` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `event_id_fk_idx` (`event_id` ASC),
  CONSTRAINT `event_id_fk`
    FOREIGN KEY (`event_id`)
    REFERENCES `event_management_db`.`events` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);