-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: employee
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company_details`
--

DROP TABLE IF EXISTS `company_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_details` (
  `id` int NOT NULL,
  `file_link` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_details`
--

LOCK TABLES `company_details` WRITE;
/*!40000 ALTER TABLE `company_details` DISABLE KEYS */;
INSERT INTO `company_details` VALUES (3,'file-link','file-name','file-type');
/*!40000 ALTER TABLE `company_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_details_questionnaire`
--

DROP TABLE IF EXISTS `company_details_questionnaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_details_questionnaire` (
  `id` int NOT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_details_questionnaire`
--

LOCK TABLES `company_details_questionnaire` WRITE;
/*!40000 ALTER TABLE `company_details_questionnaire` DISABLE KEYS */;
INSERT INTO `company_details_questionnaire` VALUES (1,'manager','who is my manager?');
/*!40000 ALTER TABLE `company_details_questionnaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_info_questionnaire`
--

DROP TABLE IF EXISTS `emp_info_questionnaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_info_questionnaire` (
  `id` int NOT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_info_questionnaire`
--

LOCK TABLES `emp_info_questionnaire` WRITE;
/*!40000 ALTER TABLE `emp_info_questionnaire` DISABLE KEYS */;
INSERT INTO `emp_info_questionnaire` VALUES (1,'manager','who is my manager'),(2,'role','what is my role'),(3,'chapter','what is my chapter'),(4,'manager','who are my managers ?'),(5,'manager','who is my managers ?'),(6,'manager','who is my manager ?'),(7,'location','which is my location ?'),(8,'location','which is my office location ?'),(9,'location','where is my office location ?'),(10,'chapter','which is my chapter ?'),(11,'chapter','what is my chapter name ?'),(12,'chapter','which is my chapter ?'),(13,'chapter','at which chapter do i belong ?'),(14,'manager','what is my manager name ?'),(15,'manager','manager'),(16,'manager','who is my manager?'),(17,'manager','can you please say who is my manager?'),(18,'manager','can you please say who is my manager ?'),(19,'manager','can you please say who is my managers ?'),(20,'manager','who manager'),(21,'manager','my manager'),(22,'manager','my manager who'),(23,'manager','my manager who?'),(24,'manager','who manager ?'),(25,'manager','manager?'),(26,'manager','manager ?'),(27,'location','location ?'),(28,'location','my location ?'),(29,'location','location?'),(30,'location','my location?');
/*!40000 ALTER TABLE `emp_info_questionnaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_information`
--

DROP TABLE IF EXISTS `emp_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_information` (
  `emp_id` varchar(255) NOT NULL,
  `chapter_name` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `emp_name` varchar(255) DEFAULT NULL,
  `emp_role` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `manager_name` varchar(255) DEFAULT NULL,
  `nwa_code` varchar(255) DEFAULT NULL,
  `onboarding_status` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_information`
--

LOCK TABLES `emp_information` WRITE;
/*!40000 ALTER TABLE `emp_information` DISABLE KEYS */;
INSERT INTO `emp_information` VALUES ('E001','Chapter 1','john.doe@example.com','John Doe','Software Engineer','Office A','Manager A','NWA123','Onboarding','1234567890'),('EMP001','Chapter A','john.doe@example.com','John Doe','Manager','Location X','Manager1','NWA001','Active','+123456789'),('EMP002','Chapter B','jane.smith@example.com','Jane Smith','Employee','Location Y','Manager1','NWA002','Active','+987654321'),('EMP003','Chapter A','robert.johnson@example.com','Robert Johnson','Employee','Location Z','Manager2','NWA003','Inactive','+111222333'),('EMP014','Microservices','aish3546@gmail.com','Aishwarya','softwareengineer','mysore','thanu','NWA007','completed','9876543210'),('EMP015','Microservices','aishwarya.satish@team.telstra.com','Aishwarya','softwareengineer','mysore','thanu','NWA007','completed','9876543210'),('EMP016','Microservices','thanushreenagraj18@gmail.com','Thanushree MN','softwareengineer','mysore','thanu','NWA007','completed','9876543210'),('EMP018','Chapter B','thanushreeyadav2001@gmail.com','thanu','softwareengineer','mysore','venkatesh','NWA008','completed','9876543210');
/*!40000 ALTER TABLE `emp_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (6);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-03  9:32:42
