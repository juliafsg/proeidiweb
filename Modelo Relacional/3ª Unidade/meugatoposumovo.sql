-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema proeidiweb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema proeidiweb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proeidiweb` DEFAULT CHARACTER SET utf8 ;
USE `proeidiweb` ;

-- -----------------------------------------------------
-- Table `proeidiweb`.`sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`sala` (
  `idSala` INT NOT NULL,
  `sDescricao` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idSala`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`curso` (
  `idCurso` INT NOT NULL,
  `cNome` VARCHAR(150) NOT NULL,
  `cDescricao` VARCHAR(100) NOT NULL,
  `cargaHoraria` INT NOT NULL,
  PRIMARY KEY (`idCurso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`turma` (
  `idTurma` INT NOT NULL,
  `tVagas` INT NOT NULL,
  `idSala` INT NOT NULL,
  `idCurso` INT NOT NULL,
  `consolidada` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idTurma`),
  INDEX `fk_turma_1_idx` (`idSala` ASC),
  INDEX `fk_turma_2_idx` (`idCurso` ASC),
  CONSTRAINT `fk_turma_1`
    FOREIGN KEY (`idSala`)
    REFERENCES `proeidiweb`.`sala` (`idSala`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_turma_2`
    FOREIGN KEY (`idCurso`)
    REFERENCES `proeidiweb`.`curso` (`idCurso`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`pessoa` (
  `idPessoa` INT NOT NULL,
  `pNome` VARCHAR(50) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `cpf` CHAR(11) NOT NULL,
  `pEmail` VARCHAR(100) NULL,
  `ativo` TINYINT(1) NOT NULL,
  `senha` VARCHAR(255) NOT NULL,
  `dataMatricula` DATETIME NOT NULL,
  PRIMARY KEY (`idPessoa`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`frequencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`frequencia` (
  `idTurma` INT NOT NULL,
  `idPessoa` INT NOT NULL,
  `data` DATE NOT NULL,
  `estavaFrequente` TINYINT(1) NOT NULL,
  INDEX `fk_frequencia_1_idx` (`idTurma` ASC),
  INDEX `fk_frequencia_2_idx` (`idPessoa` ASC),
  PRIMARY KEY (`idTurma`, `idPessoa`, `data`),
  CONSTRAINT `fk_frequencia_1`
    FOREIGN KEY (`idTurma`)
    REFERENCES `proeidiweb`.`turma` (`idTurma`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_frequencia_2`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `proeidiweb`.`pessoa` (`idPessoa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`voluntario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`voluntario` (
  `idPessoa` INT NOT NULL,
  `DDD` INT NULL,
  `telefone` VARCHAR(9) NULL,
  `gerenciador` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idPessoa`),
  CONSTRAINT `fk_voluntario_1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `proeidiweb`.`pessoa` (`idPessoa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`turma_voluntario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`turma_voluntario` (
  `idTurma` INT NOT NULL,
  `idPessoa` INT NOT NULL,
  `ano` YEAR NOT NULL,
  `semestre` INT NOT NULL,
  INDEX `fk_turma_professor_2_idx` (`idPessoa` ASC),
  PRIMARY KEY (`idTurma`, `idPessoa`),
  CONSTRAINT `fk_turma_professor_1`
    FOREIGN KEY (`idTurma`)
    REFERENCES `proeidiweb`.`turma` (`idTurma`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_turma_professor_2`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `proeidiweb`.`voluntario` (`idPessoa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`postagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`postagem` (
  `idPostagem` INT NOT NULL,
  `idPessoa` INT NOT NULL,
  `texto` VARCHAR(1000) NOT NULL,
  `data` DATE NOT NULL,
  `assunto` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idPostagem`),
  CONSTRAINT `fk_postagem_1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `proeidiweb`.`pessoa` (`idPessoa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`aluno` (
  `idPessoa` INT NOT NULL,
  `DDD` INT NOT NULL,
  `telefone` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`idPessoa`),
  CONSTRAINT `fk_table1_1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `proeidiweb`.`pessoa` (`idPessoa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`horario_disponibilidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`horario_disponibilidade` (
  `idPessoa` INT NOT NULL,
  `horario_disponibilidade` VARCHAR(3) NOT NULL,
  `ano` INT NOT NULL,
  `periodo` INT NOT NULL,
  INDEX `fk_horario_disponibilidade_1_idx` (`idPessoa` ASC),
  CONSTRAINT `fk_horario_disponibilidade_1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `proeidiweb`.`voluntario` (`idPessoa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`turma_aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`turma_aluno` (
  `idTurma` INT NOT NULL,
  `idPessoa` INT NOT NULL,
  INDEX `fk_turma_aluno_2_idx` (`idPessoa` ASC),
  CONSTRAINT `fk_turma_aluno_1`
    FOREIGN KEY (`idTurma`)
    REFERENCES `proeidiweb`.`turma` (`idTurma`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_turma_aluno_2`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `proeidiweb`.`aluno` (`idPessoa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`responsavel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`responsavel` (
  `idTurma` INT NOT NULL,
  `idPessoa` INT NOT NULL,
  INDEX `fk_responsavel_1_idx` (`idTurma` ASC),
  INDEX `fk_responsavel_2_idx` (`idPessoa` ASC),
  CONSTRAINT `fk_responsavel_1`
    FOREIGN KEY (`idTurma`)
    REFERENCES `proeidiweb`.`turma` (`idTurma`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_responsavel_2`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `proeidiweb`.`voluntario` (`idPessoa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`horario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`horario` (
  `idTurma` INT NOT NULL,
  `horaInicio` TIME NOT NULL,
  `horaFim` TIME NOT NULL,
  `data` DATE NOT NULL,
  CONSTRAINT `fk_horario_1`
    FOREIGN KEY (`idTurma`)
    REFERENCES `proeidiweb`.`turma` (`idTurma`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`Data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`Data` (
  `idTurma` INT NOT NULL,
  `dataAula` DATE NOT NULL,
  CONSTRAINT `fk_Data_1`
    FOREIGN KEY (`idTurma`)
    REFERENCES `proeidiweb`.`turma` (`idTurma`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`agendar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`agendar` (
  `idAluno` INT NOT NULL,
  `idVoluntario` INT NOT NULL,
  `confirmado` TINYINT(1) NOT NULL,
  `data` DATE NOT NULL,
  `horario` CHAR(3) NOT NULL,
  PRIMARY KEY (`idVoluntario`, `data`, `horario`, `idAluno`),
  INDEX `fk_agendar_2_idx` (`idVoluntario` ASC),
  CONSTRAINT `fk_agendar_1`
    FOREIGN KEY (`idAluno`)
    REFERENCES `proeidiweb`.`aluno` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_agendar_2`
    FOREIGN KEY (`idVoluntario`)
    REFERENCES `proeidiweb`.`voluntario` (`idPessoa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`anexo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`anexo` (
  `idPostagem` INT NOT NULL,
  `enderecoAnexo` VARCHAR(1000) NOT NULL,
  CONSTRAINT `fk_anexo_1`
    FOREIGN KEY (`idPostagem`)
    REFERENCES `proeidiweb`.`postagem` (`idPostagem`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`matricula` (
  `idAluno` INT NOT NULL,
  `idVoluntario` INT NOT NULL,
  `dataMatricula` DATETIME NOT NULL,
  INDEX `fk_matricula_1_idx` (`idAluno` ASC),
  INDEX `fk_matricula_2_idx` (`idVoluntario` ASC),
  CONSTRAINT `fk_matricula_1`
    FOREIGN KEY (`idAluno`)
    REFERENCES `proeidiweb`.`aluno` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_2`
    FOREIGN KEY (`idVoluntario`)
    REFERENCES `proeidiweb`.`voluntario` (`idPessoa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proeidiweb`.`lista_espera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proeidiweb`.`lista_espera` (
  `idAluno` INT NOT NULL,
  `idCurso` INT NOT NULL,
  `data` DATETIME NOT NULL,
  `confirmado` TINYINT(1) NOT NULL,
  INDEX `fk_lista_espera_1_idx` (`idCurso` ASC),
  INDEX `fk_lista_espera_2_idx` (`idAluno` ASC),
  CONSTRAINT `fk_lista_espera_1`
    FOREIGN KEY (`idCurso`)
    REFERENCES `proeidiweb`.`curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lista_espera_2`
    FOREIGN KEY (`idAluno`)
    REFERENCES `proeidiweb`.`aluno` (`idPessoa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
