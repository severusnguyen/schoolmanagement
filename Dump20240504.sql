CREATE DATABASE  IF NOT EXISTS `schoolmanagement` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `schoolmanagement`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: schoolmanagement
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) NOT NULL,
  `amount_student` int(11) DEFAULT NULL,
  `class_head` varchar(255) DEFAULT NULL,
  `homeroom_teacher` varchar(255) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_class_teacher_id` (`teacher_id`),
  CONSTRAINT `fk_class_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (1,'Class A',30,'Haha','Mr.A',1),(2,'Class B',25,'Hihi','Ms.B',2),(3,'Class C',28,'Hehe','Mrs.C',3);
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_code` varchar(50) NOT NULL,
  `department_name` varchar(255) NOT NULL,
  `department_description` text,
  `department_head` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `department_code` (`department_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'D1','Computer Science','Department of Computer Science','Dr. Smith'),(2,'D2','Mathematics','Department of Mathematics','Prof. Johnson'),(3,'D3','History','Department of History','Dr. Davis');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `grade` float DEFAULT NULL,
  `grade_type` varchar(50) DEFAULT NULL,
  `grade_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_gread_student_id` (`student_id`),
  KEY `fk_grade_subject_id` (`subject_id`),
  CONSTRAINT `fk_grade_subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`),
  CONSTRAINT `fk_gread_student_id` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grades`
--

LOCK TABLES `grades` WRITE;
/*!40000 ALTER TABLE `grades` DISABLE KEYS */;
INSERT INTO `grades` VALUES (14,1,1,8,'Midterm','2024-03-15 00:00:00.000000'),(15,2,2,9,'Final','2024-05-01 00:00:00.000000'),(16,3,3,7,'Homework','2024-04-20 00:00:00.000000'),(17,1,1,9,'h','2020-01-10 00:10:00.000000'),(18,1,1,9,'h','2020-01-10 00:10:00.000000');
/*!40000 ALTER TABLE `grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_code` varchar(100) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) NOT NULL,
  `image` text,
  `email` varchar(100) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `admission_date` datetime(6) DEFAULT NULL,
  `graduation_date` datetime(6) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_code` (`student_code`),
  UNIQUE KEY `email` (`email`),
  KEY `fk_student_department_id` (`department_id`),
  KEY `fk_student_class_id` (`class_id`),
  CONSTRAINT `fk_student_class_id` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`),
  CONSTRAINT `fk_student_department_id` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'01','$2a$12$kmXd.ZYraH2fNix4XVZHV.pHQfPeJIAt4C0oJI6n9Yif/IrFY42l6','Alice Johnson','student1.jpg','alice.johnson@example.com','555-555-5555','789 Pine St, City',1,'2019-09-01 00:00:00.000000','2023-06-30 00:00:00.000000',1,1),(2,'02','123456','Bob Smith','student2.jpg','bob.smith@example.com','666-666-6666','234 Cedar St, Town',1,'2020-02-15 00:00:00.000000','2024-06-30 00:00:00.000000',2,2),(3,'03','123456','Eva Martinez','student3.jpg','eva.martinez@example.com','777-777-7777','567 Maple St, Village',1,'2021-03-20 00:00:00.000000','2025-06-30 00:00:00.000000',3,3);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subjects_name` varchar(255) NOT NULL,
  `subjects_code` varchar(50) NOT NULL,
  `credits` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `subjects_code` (`subjects_code`),
  KEY `FKdati6v4sxdveiejlgabijmijd` (`teacher_id`),
  CONSTRAINT `FKdati6v4sxdveiejlgabijmijd` FOREIGN KEY (`teacher_id`) REFERENCES `classes` (`id`),
  CONSTRAINT `fk_subject_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'Introduction to Programming','CS101',3,1),(2,'Calculus I','MATH101',4,2),(3,'World History','HIST101',3,3);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `teachers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_code` varchar(100) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `teacher_name` varchar(255) NOT NULL,
  `image` text,
  `email` varchar(100) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `teacher_code` (`teacher_code`),
  UNIQUE KEY `email` (`email`),
  KEY `fk_teacher_department_id` (`department_id`),
  CONSTRAINT `fk_teacher_department_id` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (1,'T1','password1','John Doe','teacher1.jpg','john.doe@example.com','123-456-7890','123 Main St, City','2020-01-01 00:00:00.000000',1),(2,'T2','password2','Jane Smith','teacher2.jpg','jane.smith@example.com','987-654-3210','456 Oak St, Town','2019-08-15 00:00:00.000000',2),(3,'T3','password3','David Brown','teacher3.jpg','david.brown@example.com','111-222-3333','789 Elm St, Village','2021-03-10 00:00:00.000000',3);
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-04 14:34:34
