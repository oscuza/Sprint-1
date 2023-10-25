-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Cul_ampolla
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Cul_ampolla
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Cul_ampolla` DEFAULT CHARACTER SET utf8mb4 ;
USE `Cul_ampolla` ;

-- -----------------------------------------------------
-- Table `Cul_ampolla`.`Supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cul_ampolla`.`Supplier` (
  `supplierID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `adress` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `fax` VARCHAR(45) NULL,
  `nif` VARCHAR(45) NULL,
  PRIMARY KEY (`supplierID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cul_ampolla`.`Glasses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cul_ampolla`.`Glasses` (
  `glassesID` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(45) NOT NULL,
  `graduation` DOUBLE NULL,
  `typeFrame` ENUM('rimless', 'platic', 'metal') NULL,
  `colorFrame` VARCHAR(45) NULL,
  `colorLens` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  `supplierID` INT NOT NULL,
  PRIMARY KEY (`glassesID`),
  INDEX `supplierID_idx` (`supplierID` ASC) VISIBLE,
  CONSTRAINT `supplierID`
    FOREIGN KEY (`supplierID`)
    REFERENCES `Cul_ampolla`.`Supplier` (`supplierID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cul_ampolla`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cul_ampolla`.`Customer` (
  `customerID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `postOffice` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `registrationDate` DATE NULL,
  `recomendeCustomerID` INT NULL,
  `employeeSale` VARCHAR(45) NULL,
  `glassesID` INT NOT NULL,
  PRIMARY KEY (`customerID`),
  INDEX `glassesID_idx` (`glassesID` ASC) VISIBLE,
  CONSTRAINT `glassesID`
    FOREIGN KEY (`glassesID`)
    REFERENCES `Cul_ampolla`.`Glasses` (`glassesID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
