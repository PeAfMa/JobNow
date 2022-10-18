

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP TABLE IF EXISTS `Aceita` ;

CREATE TABLE IF NOT EXISTS `Aceita` (
  `Ordem de Serviço_IDserviço` INT NOT NULL,
  `Trabalhador_ID` INT NOT NULL,
  `Pago` TINYINT NOT NULL,
  PRIMARY KEY (`Ordem de Serviço_IDserviço`, `Trabalhador_ID`),
  CONSTRAINT `fk_Aceita_Ordem de Serviço1`
    FOREIGN KEY (`Ordem de Serviço_IDserviço`)
    REFERENCES `Ordem de Serviço` (`IDserviço`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Aceita_Trabalhador1`
    FOREIGN KEY (`Trabalhador_ID`)
    REFERENCES `Trabalhador` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Area de Atuação`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Area de Atuação` ;

CREATE TABLE IF NOT EXISTS `Area de Atuação` (
  `Trabalhador_ID` INT NOT NULL,
  `IDArea` INT NOT NULL,
  PRIMARY KEY (`IDArea`, `Trabalhador_ID`),
  CONSTRAINT `fk_Area de Atuação_Trabalhador1`
    FOREIGN KEY (`Trabalhador_ID`)
    REFERENCES `Trabalhador` (`ID`)
   ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Contrata`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Contrata` ;

CREATE TABLE IF NOT EXISTS `Contrata` (
  `Trabalhador_ID` INT NOT NULL,
  `Empregador_ID` INT NOT NULL,
  `Pago` TINYINT NOT NULL,
  `Local` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Trabalhador_ID`, `Empregador_ID`),
  CONSTRAINT `fk_Contrata_Trabalhador1`
    FOREIGN KEY (`Trabalhador_ID`)
    REFERENCES `Trabalhador` (`ID`)
     ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Contrata_Empregador1`
    FOREIGN KEY (`Empregador_ID`)
    REFERENCES `Empregador` (`ID`)
     ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Empregador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Empregador` ;

CREATE TABLE IF NOT EXISTS `Empregador` (
  `ID` INT NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Telefone` VARCHAR(20) NOT NULL,
  `Login` VARCHAR(45) NOT NULL,
  `Senha` VARCHAR(45) NOT NULL,
  `Premium` TINYINT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `CPF` VARCHAR(20) NOT NULL,
  `Avaliação` INT NOT NULL,
  `Recomendação` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Ordem de Serviço`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Ordem de Serviço` ;

CREATE TABLE IF NOT EXISTS `Ordem de Serviço` (
  `Empregador` INT NOT NULL,
  `IDserviço` INT NOT NULL,
  `Local` VARCHAR(45) NOT NULL,
  `Trabalho` VARCHAR(45) NOT NULL,
  `Preço` INT NULL,
  PRIMARY KEY (`Empregador`, `IDserviço`),
  CONSTRAINT `fk_Ordem de Serviço_Empregador`
    FOREIGN KEY (`Empregador`)
    REFERENCES `Empregador` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Trabalhador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Trabalhador` ;

CREATE TABLE IF NOT EXISTS `Trabalhador` (
  `ID` INT NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Telefone` VARCHAR(45) NOT NULL,
  `Login` VARCHAR(45) NOT NULL,
  `Senha` VARCHAR(45) NOT NULL,
  `Premium` TINYINT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Sobrenome` VARCHAR(45) NOT NULL,
  `CPF` VARCHAR(45) NOT NULL,
  `Avaliação` INT NOT NULL,
  `Recomendação` VARCHAR(45) NOT NULL,
  `Local` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
