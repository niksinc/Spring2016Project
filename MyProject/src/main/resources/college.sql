
CREATE SCHEMA `college` ;


CREATE TABLE `college`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `phoneNumber` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));



CREATE TABLE `college`.`course` (
  `courseId` INT NOT NULL AUTO_INCREMENT,
  `courseCode` VARCHAR(45) NULL,
  `courseName` VARCHAR(45) NULL,
  `CourseSection` VARCHAR(45) NULL,
  `facultyId` INT NOT NULL,
  PRIMARY KEY (`courseId`));


CREATE TABLE `college`.`faculty` (
  `facultyId` INT NOT NULL AUTO_INCREMENT,
  `facultyName` VARCHAR(45) NULL,
  `phoneNumber` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `facultyCode` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`facultyId`));


CREATE TABLE `college`.`mycourses` (
  `studentId` INT NOT NULL,
  `courseId` INT NOT NULL,
  PRIMARY KEY (`studentId`, `courseId`));
