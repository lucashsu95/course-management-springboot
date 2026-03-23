-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: coursemanagement
-- ------------------------------------------------------
-- Server version	8.0.45

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `id` varchar(45) NOT NULL,
  `courseName` varchar(45) NOT NULL,
  `courseCredit` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES ('CS101','Introduction to Programming',3),('CS102','Database Management Systems',3),('CS103','Web Application Development',3),('CS104','Data Structures and Algorithms',4),('CS105','Operating Systems',3),('CS106','Computer Networks',3),('CS107','Software Engineering',2),('CS108','Artificial Intelligence',3),('CS301','作業系統',3);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course_relation`
--

DROP TABLE IF EXISTS `student_course_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_course_relation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `course_id` varchar(45) NOT NULL,
  `grade` varchar(45) DEFAULT NULL,
  `remark` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course_relation`
--

LOCK TABLES `student_course_relation` WRITE;
/*!40000 ALTER TABLE `student_course_relation` DISABLE KEYS */;
INSERT INTO `student_course_relation` VALUES (1,11440001,'CS101','95','期末表現優異','2025-01-01 09:10:00'),(2,11440001,'CS102','78','Normal','2025-01-01 11:20:00'),(3,11440001,'CS103','92','Excellent','2025-01-01 14:35:00'),(4,11440001,'CS104','95','期末表現優異','2025-01-01 16:45:00'),(5,11440002,'CS101','76','Normal','2025-01-02 09:05:00'),(6,11440002,'CS102','81','Good','2025-01-02 10:15:00'),(7,11440002,'CS103','69','Pass','2025-01-02 13:20:00'),(8,11440002,'CS105','90','Excellent','2025-01-02 15:40:00'),(9,11440003,'CS101','84','Good','2025-01-03 08:30:00'),(10,11440003,'CS104','73','Pass','2025-01-03 10:25:00'),(11,11440003,'CS106','87','Nice','2025-01-03 14:10:00'),(12,11440003,'CS108','91','Excellent','2025-01-03 17:50:00'),(13,11440004,'CS102','79','Normal','2025-01-04 09:40:00'),(14,11440004,'CS103','83','Good','2025-01-04 11:30:00'),(15,11440004,'CS105','95','Top','2025-01-04 14:50:00'),(16,11440004,'CS107','74','Pass','2025-01-04 16:20:00'),(17,11440005,'CS101','68','Pass','2025-01-05 08:15:00'),(18,11440005,'CS104','77','Normal','2025-01-05 10:45:00'),(19,11440005,'CS106','85','Good','2025-01-05 13:55:00'),(20,11440005,'CS108','89','Nice','2025-01-05 18:05:00'),(21,11440006,'CS102','91','Excellent','2025-01-06 09:25:00'),(22,11440006,'CS103','72','Pass','2025-01-06 11:35:00'),(23,11440006,'CS105','80','Normal','2025-01-06 14:15:00'),(24,11440006,'CS107','86','Good','2025-01-06 16:45:00'),(25,11440007,'CS101','93','Excellent','2025-01-07 08:50:00'),(26,11440007,'CS102','88','Nice','2025-01-07 10:20:00'),(27,11440007,'CS106','75','Pass','2025-01-07 13:40:00'),(28,11440007,'CS108','82','Good','2025-01-07 17:10:00'),(29,11440008,'CS103','79','Normal','2025-01-08 09:00:00'),(30,11440008,'CS104','84','Good','2025-01-08 11:10:00'),(31,11440008,'CS105','71','Pass','2025-01-08 13:30:00'),(32,11440008,'CS107','90','Excellent','2025-01-08 16:55:00'),(33,11440009,'CS101','87','Nice','2025-01-09 08:40:00'),(34,11440009,'CS103','76','Normal','2025-01-09 10:50:00'),(35,11440009,'CS106','92','Excellent','2025-01-09 14:20:00'),(36,11440009,'CS108','78','Normal','2025-01-09 17:35:00'),(37,11440010,'CS102','85','Good','2025-01-10 09:15:00'),(38,11440010,'CS104','69','Pass','2025-01-10 11:25:00'),(39,11440010,'CS105','88','Nice','2025-01-10 14:05:00'),(40,11440010,'CS107','94','Top','2025-01-10 16:45:00'),(41,11440011,'CS101','82','Good','2025-01-11 08:30:00'),(42,11440011,'CS102','74','Pass','2025-01-11 10:20:00'),(43,11440011,'CS103','89','Nice','2025-01-11 13:50:00'),(44,11440011,'CS106','91','Excellent','2025-01-11 17:00:00'),(45,11440012,'CS104','77','Normal','2025-01-12 09:10:00'),(46,11440012,'CS105','83','Good','2025-01-12 11:30:00'),(47,11440012,'CS107','68','Pass','2025-01-12 14:40:00'),(48,11440012,'CS108','86','Good','2025-01-12 18:00:00'),(49,11440013,'CS101','90','Excellent','2025-01-13 08:45:00'),(50,11440013,'CS103','81','Good','2025-01-13 10:55:00'),(51,11440013,'CS105','73','Pass','2025-01-13 13:25:00'),(52,11440013,'CS107','88','Nice','2025-01-13 16:35:00'),(53,11440014,'CS102','84','Good','2025-01-14 09:05:00'),(54,11440014,'CS104','79','Normal','2025-01-14 11:20:00'),(55,11440014,'CS106','93','Excellent','2025-01-14 14:50:00'),(56,11440014,'CS108','75','Pass','2025-01-14 17:30:00'),(57,11440015,'CS101','78','Normal','2025-01-15 08:35:00'),(58,11440015,'CS103','85','Good','2025-01-15 10:45:00'),(59,11440015,'CS105','91','Excellent','2025-01-15 13:55:00'),(60,11440015,'CS107','72','Pass','2025-01-15 16:20:00'),(61,11440016,'CS102','87','Nice','2025-01-16 09:00:00'),(62,11440016,'CS104','80','Normal','2025-01-16 11:10:00'),(63,11440016,'CS106','76','Normal','2025-01-16 14:30:00'),(64,11440016,'CS108','92','Excellent','2025-01-16 17:40:00'),(65,11440017,'CS101','83','Good','2025-01-17 08:50:00'),(66,11440017,'CS102','70','Pass','2025-01-17 10:15:00'),(67,11440017,'CS103','88','Nice','2025-01-17 13:45:00'),(68,11440017,'CS104','94','Top','2025-01-17 16:55:00'),(69,11440018,'CS105','79','Normal','2025-01-18 09:25:00'),(70,11440018,'CS106','84','Good','2025-01-18 11:35:00'),(71,11440018,'CS107','67','Pass','2025-01-18 14:10:00'),(72,11440018,'CS108','89','Nice','2025-01-18 17:20:00'),(73,11440019,'CS101','91','Excellent','2025-01-19 08:30:00'),(74,11440019,'CS103','77','Normal','2025-01-19 10:40:00'),(75,11440019,'CS105','82','Good','2025-01-19 13:50:00'),(76,11440019,'CS107','74','Pass','2025-01-19 16:30:00'),(77,11440020,'CS102','86','Good','2025-01-20 09:10:00'),(78,11440020,'CS104','78','Normal','2025-01-20 11:25:00'),(79,11440020,'CS106','90','Excellent','2025-01-20 14:35:00'),(80,11440020,'CS108','85','Good','2025-01-20 17:45:00'),(81,11440021,'CS101','72','Pass','2025-01-21 08:40:00'),(82,11440021,'CS102','84','Good','2025-01-21 10:50:00'),(83,11440021,'CS103','88','Nice','2025-01-21 13:20:00'),(84,11440021,'CS105','93','Excellent','2025-01-21 16:10:00'),(85,11440022,'CS104','75','Pass','2025-01-22 09:05:00'),(86,11440022,'CS106','81','Good','2025-01-22 11:15:00'),(87,11440022,'CS107','87','Nice','2025-01-22 14:25:00'),(88,11440022,'CS108','69','Pass','2025-01-22 17:55:00'),(89,11440023,'CS101','89','Nice','2025-01-23 08:30:00'),(90,11440023,'CS103','76','Normal','2025-01-23 10:40:00'),(91,11440023,'CS105','84','Good','2025-01-23 13:50:00'),(92,11440023,'CS107','91','Excellent','2025-01-23 16:35:00'),(93,11440024,'CS102','73','Pass','2025-01-24 09:00:00'),(94,11440024,'CS104','86','Good','2025-01-24 11:10:00'),(95,11440024,'CS106','92','Excellent','2025-01-24 14:20:00'),(96,11440024,'CS108','80','Normal','2025-01-24 17:30:00'),(97,11440025,'CS101','85','Good','2025-01-25 08:45:00'),(98,11440025,'CS102','79','Normal','2025-01-25 10:55:00'),(99,11440025,'CS103','90','Excellent','2025-01-25 13:35:00'),(100,11440025,'CS104','74','Pass','2025-01-25 16:15:00'),(101,11440026,'CS105','88','Nice','2025-01-26 09:10:00'),(102,11440026,'CS106','82','Good','2025-01-26 11:25:00'),(103,11440026,'CS107','76','Normal','2025-01-26 14:45:00'),(104,11440026,'CS108','91','Excellent','2025-01-26 17:50:00'),(105,11440027,'CS101','77','Normal','2025-01-27 08:30:00'),(106,11440027,'CS103','85','Good','2025-01-27 10:40:00'),(107,11440027,'CS105','89','Nice','2025-01-27 13:50:00'),(108,11440027,'CS107','92','Excellent','2025-01-27 16:35:00'),(109,11440028,'CS102','81','Good','2025-01-28 09:00:00'),(110,11440028,'CS104','73','Pass','2025-01-28 11:15:00'),(111,11440028,'CS106','88','Nice','2025-01-28 14:30:00'),(112,11440028,'CS108','90','Excellent','2025-01-28 17:45:00'),(113,11440029,'CS101','84','Good','2025-01-29 08:50:00'),(114,11440029,'CS103','78','Normal','2025-01-29 10:55:00'),(115,11440029,'CS105','92','Excellent','2025-01-29 13:40:00'),(116,11440029,'CS107','75','Pass','2025-01-29 16:20:00'),(128,11440031,'CS101',NULL,'一般選課','2026-03-30 05:39:27'),(129,11440032,'CS101',NULL,'一般選課','2026-03-30 05:39:35'),(130,11440001,'CS108','95','期末表現優異','2026-03-30 06:17:48'),(131,11440001,'CS107',NULL,'一般選課','2026-03-30 06:18:09'),(132,11440001,'CS106',NULL,'一般選課','2026-03-30 06:25:52'),(133,11440032,'CS102',NULL,'一般選課','2026-03-30 06:58:01');
/*!40000 ALTER TABLE `student_course_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES ('11046101','王小明','xiaoming@example.com'),('11440001','Liam Johnson','liam.johnson@mail.com'),('11440002','Noah Smith','noah.smith@mail.com'),('11440003','Oliver Williams','oliver.williams@mail.com'),('11440004','Elijah Brown','elijah.brown@mail.com'),('11440005','James Jones','james.jones@mail.com'),('11440006','William Garcia','william.garcia@mail.com'),('11440007','Benjamin Miller','benjamin.miller@mail.com'),('11440008','Lucas Davis','lucas.davis@mail.com'),('11440009','Henry Rodriguez','henry.rodriguez@mail.com'),('11440010','Alexander Martinez','alexander.martinez@mail.com'),('11440011','Mason Hernandez','mason.hernandez@mail.com'),('11440012','Michael Lopez','michael.lopez@mail.com'),('11440013','Ethan Gonzalez','ethan.gonzalez@mail.com'),('11440014','Daniel Wilson','daniel.wilson@mail.com'),('11440015','Jacob Anderson','jacob.anderson@mail.com'),('11440016','Logan Thomas','logan.thomas@mail.com'),('11440017','Jackson Taylor','jackson.taylor@mail.com'),('11440018','Levi Moore','levi.moore@mail.com'),('11440019','Sebastian Jackson','sebastian.jackson@mail.com'),('11440020','Mateo Martin','mateo.martin@mail.com'),('11440021','Jack Lee','jack.lee@mail.com'),('11440022','Owen Perez','owen.perez@mail.com'),('11440023','Theodore Thompson','theodore.thompson@mail.com'),('11440024','Aiden White','aiden.white@mail.com'),('11440025','Samuel Harris','samuel.harris@mail.com'),('11440026','Joseph Sanchez','joseph.sanchez@mail.com'),('11440027','John Clark','john.clark@mail.com'),('11440028','David Ramirez','david.ramirez@mail.com'),('11440029','Wyatt Lewis','wyatt.lewis@mail.com'),('11440030','Matthew Robinson','matthew.robinson@mail.com'),('11440031','John Doe','john.doe@mail.com'),('11440032','John','johnsssss.doe@mail.com'),('11446086','chuWei','11446086@ntub.com');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-30  7:07:15
