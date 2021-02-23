CREATE DATABASE "rest-employees"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Colombia.1252'
    LC_CTYPE = 'Spanish_Colombia.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


-- -----------------------------------------------------
-- Table "PROFILES"
-- -----------------------------------------------------
CREATE TABLE  PROFILES (
  "id_profile" SERIAL NOT NULL,
  "name" VARCHAR(45) NOT NULL,
  "active" BOOLEAN NOT NULL,
  PRIMARY KEY ("id_profile"));


-- -----------------------------------------------------
-- Table "USERS"
-- -----------------------------------------------------
CREATE TABLE  USERS (
  "id_user" SERIAL NOT NULL,
  "username" VARCHAR(50) NULL,
  "password" VARCHAR(150),
  "id_profile" INT NOT NULL,
  "name" VARCHAR(100) NOT NULL,
  "lastname" VARCHAR(100) NOT NULL,
  "email" VARCHAR(150) NOT NULL,
  "phone" VARCHAR(50 NULL),
  "active" BOOLEAN NULL,
  PRIMARY KEY ("id_user"),
  CONSTRAINT "fk_USERS_PROFILES"
    FOREIGN KEY ("id_profile")
    REFERENCES PROFILES ("id_profile")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "EMPLOYEES"
-- -----------------------------------------------------
CREATE TABLE EMPLOYEES (
  "id_employee" SERIAL NOT NULL,
  "id_user" INT NOT NULL,
  "total_salary" DECIMAL(15,3) NOT NULL,
  "percentage" DECIMAL(5,2),
  "id_boss" INT NULL,
  PRIMARY KEY ("id_employee"),
  CONSTRAINT "fk_EMPLOYEES_USERS"
    FOREIGN KEY ("id_user")
    REFERENCES USERS ("id_user")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_EMPLOYEES_BOSS"
    FOREIGN KEY ("id_boss")
    REFERENCES EMPLOYEES ("id_employee")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
  );

