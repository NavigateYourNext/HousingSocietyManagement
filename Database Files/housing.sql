-- MySQL dump 10.13  Distrib 5.5.29, for Win32 (x86)
--
-- Host: localhost    Database: house
-- ------------------------------------------------------
-- Server version	5.5.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `bill_id` int(11) NOT NULL AUTO_INCREMENT,
  `mem_id` int(11) DEFAULT NULL,
  `mem_name` varchar(30) DEFAULT NULL,
  `date_of_complain` varchar(30) DEFAULT NULL,
  `date_of_handle` varchar(30) DEFAULT NULL,
  `room_type` varchar(10) DEFAULT NULL,
  `bill_amt` double DEFAULT NULL,
  PRIMARY KEY (`bill_id`),
  KEY `mem_id` (`mem_id`),
  CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`mem_id`) REFERENCES `member` (`mem_id`)
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*INSERT INTO `bill` VALUES (201,101,'Dipak','23-1-2012','25-2-2013','1bhk',75000);*/
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `userid` varchar(20) NOT NULL,
  `pass` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
/*INSERT INTO `login` VALUES ('dipak','dipak');*/
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material` (
  `mate_name` varchar(30) DEFAULT NULL,
  `mate_type` varchar(30) DEFAULT NULL,
  `company` varchar(30) DEFAULT NULL,
  `mfg_date` varchar(30) DEFAULT NULL,
  `exp_date` varchar(30) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
/*INSERT INTO `material` VALUES ('as','sa','sa','13','12',90,123);*/
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `mem_id` int(11) NOT NULL AUTO_INCREMENT,
  `mem_name` varchar(30) DEFAULT NULL,
  `mem_address` varchar(50) DEFAULT NULL,
  `mem_contact` varchar(10) DEFAULT NULL,
  `mem_blood` varchar(10) DEFAULT NULL,
  `mem_history` varchar(50) DEFAULT NULL,
  `mem_dob` varchar(30) DEFAULT NULL,
  `mem_current` varchar(30) DEFAULT NULL,
  `mem_roomno` varchar(10) DEFAULT NULL,
  `mem_adddate` varchar(30) DEFAULT NULL,
  `mem_rtype` varchar(20) DEFAULT NULL,
  `mem_gender` varchar(10) DEFAULT NULL,
  `mem_docname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`mem_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
/*INSERT INTO `member` VALUES (101,'Dipak','Shivajinagar','4567891213','A +ve','asdf','10-06-1993','asdfghjl','s1','12-02-2011','DUPLEX','male','Rajendra'),(102,'Dipendra','Dighi		','4561234781','O +ve','abc	','08-10-1995','xyz','s2','11-02-2015','2BHK','male','Devikesh');*/
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker`
--

DROP TABLE IF EXISTS `worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `worker` (
  `wor_id` int(11) NOT NULL AUTO_INCREMENT,
  `wor_name` varchar(30) DEFAULT NULL,
  `wor_address` varchar(50) DEFAULT NULL,
  `wor_contact` varchar(12) DEFAULT NULL,
  `wor_specialization` varchar(30) DEFAULT NULL,
  `wor_workfrom` varchar(30) DEFAULT NULL,
  `wor_workto` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`wor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=403 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker`
--

LOCK TABLES `worker` WRITE;
/*!40000 ALTER TABLE `worker` DISABLE KEYS */;
/*INSERT INTO `worker` VALUES (401,'Shamitabh','Dighi','7894561230','Building','09:00','6:00'),(402,'Anna','Vishrantwadi	','4581345890','painting','06:00','04:00');*/
/*!40000 ALTER TABLE `worker` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-12  8:43:20
