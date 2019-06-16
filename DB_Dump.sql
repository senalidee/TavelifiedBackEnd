CREATE DATABASE  IF NOT EXISTS `tourism_app` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `tourism_app`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tourism_app
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `chat_group`
--

DROP TABLE IF EXISTS `chat_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat_group` (
  `chat_group_id` int(11) NOT NULL,
  `group_title` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  PRIMARY KEY (`chat_group_id`),
  KEY `created_user_user_idx` (`created_by`),
  CONSTRAINT `created_user_user` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_group`
--

LOCK TABLES `chat_group` WRITE;
/*!40000 ALTER TABLE `chat_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_participation`
--

DROP TABLE IF EXISTS `event_participation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_participation` (
  `participation_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `event_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`participation_id`),
  KEY `event_user_idx` (`username`),
  KEY `event_event_idx` (`event_id`),
  CONSTRAINT `event_event` FOREIGN KEY (`event_id`) REFERENCES `tourist_event` (`event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `event_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_participation`
--

LOCK TABLES `event_participation` WRITE;
/*!40000 ALTER TABLE `event_participation` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_participation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_participant`
--

DROP TABLE IF EXISTS `group_participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_participant` (
  `participation_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `chat_group_id` int(11) DEFAULT NULL,
  `added_by` varchar(20) DEFAULT NULL,
  `is_admin` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`participation_id`),
  KEY `user_user_idx` (`username`,`added_by`),
  KEY `added)by_user_idx` (`added_by`),
  KEY `group_group_idx` (`chat_group_id`),
  CONSTRAINT `added_by_user` FOREIGN KEY (`added_by`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `group_group` FOREIGN KEY (`chat_group_id`) REFERENCES `chat_group` (`chat_group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_participant`
--

LOCK TABLES `group_participant` WRITE;
/*!40000 ALTER TABLE `group_participant` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_participant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `msgid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `timestamp` varchar(45) DEFAULT NULL,
  `is_direct_msg` tinyint(4) DEFAULT NULL,
  `chat_group_id` int(11) DEFAULT NULL,
  `message` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`msgid`),
  KEY `chat_user_user_idx` (`username`),
  KEY `chat_group_group_idx` (`chat_group_id`),
  CONSTRAINT `chat_group_group` FOREIGN KEY (`chat_group_id`) REFERENCES `chat_group` (`chat_group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `chat_user_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_rating_profile`
--

DROP TABLE IF EXISTS `service_rating_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_rating_profile` (
  `profile_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` int(11) DEFAULT NULL,
  `rating` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`profile_id`),
  KEY `rating_service_service_idx` (`service_id`),
  CONSTRAINT `rating_service_service` FOREIGN KEY (`service_id`) REFERENCES `tourist_service` (`service_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_rating_profile`
--

LOCK TABLES `service_rating_profile` WRITE;
/*!40000 ALTER TABLE `service_rating_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_rating_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_subscription`
--

DROP TABLE IF EXISTS `service_subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_subscription` (
  `subscription_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `service_id` int(11) DEFAULT NULL,
  `start_timestamp` int(11) DEFAULT NULL,
  `end_timestamp` int(11) DEFAULT NULL,
  `fee` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`subscription_id`),
  KEY `sub_service_service_idx` (`service_id`),
  KEY `sub_user_user_idx` (`username`),
  CONSTRAINT `sub_service_service` FOREIGN KEY (`service_id`) REFERENCES `tourist_service` (`service_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sub_user_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_subscription`
--

LOCK TABLES `service_subscription` WRITE;
/*!40000 ALTER TABLE `service_subscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourist_attaraction`
--

DROP TABLE IF EXISTS `tourist_attaraction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tourist_attaraction` (
  `attaraction_id` int(11) NOT NULL AUTO_INCREMENT,
  `attraction_name` varchar(1000) DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `rating_profile_id` varchar(100) DEFAULT NULL,
  `location_url` varchar(500) DEFAULT NULL,
  `title_photo_url` varchar(100) DEFAULT NULL,
  `photo_collection_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`attaraction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourist_attaraction`
--

LOCK TABLES `tourist_attaraction` WRITE;
/*!40000 ALTER TABLE `tourist_attaraction` DISABLE KEYS */;
/*!40000 ALTER TABLE `tourist_attaraction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourist_event`
--

DROP TABLE IF EXISTS `tourist_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tourist_event` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_title` varchar(1000) DEFAULT NULL,
  `event_description` varchar(5000) DEFAULT NULL,
  `location_url` varchar(45) DEFAULT NULL,
  `event_type` varchar(45) DEFAULT NULL,
  `title_photo_url` varchar(500) DEFAULT NULL,
  `photo_collection_id` varchar(100) DEFAULT NULL,
  `rating_profile_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourist_event`
--

LOCK TABLES `tourist_event` WRITE;
/*!40000 ALTER TABLE `tourist_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `tourist_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourist_service`
--

DROP TABLE IF EXISTS `tourist_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tourist_service` (
  `service_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_title` varchar(1000) DEFAULT NULL,
  `service_description` varchar(5000) DEFAULT NULL,
  `owner_uname` varchar(45) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  `title_photo_url` varchar(500) DEFAULT NULL,
  `photo_collection_id` varchar(100) DEFAULT NULL,
  `rating_profile_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourist_service`
--

LOCK TABLES `tourist_service` WRITE;
/*!40000 ALTER TABLE `tourist_service` DISABLE KEYS */;
/*!40000 ALTER TABLE `tourist_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourist_transport`
--

DROP TABLE IF EXISTS `tourist_transport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tourist_transport` (
  `service_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_title` varchar(1000) DEFAULT NULL,
  `from_url` varchar(500) DEFAULT NULL,
  `to_url` varchar(500) DEFAULT NULL,
  `per_km_fee` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourist_transport`
--

LOCK TABLES `tourist_transport` WRITE;
/*!40000 ALTER TABLE `tourist_transport` DISABLE KEYS */;
/*!40000 ALTER TABLE `tourist_transport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport_subscription`
--

DROP TABLE IF EXISTS `transport_subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transport_subscription` (
  `subscription_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` int(11) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `from_url` varchar(500) DEFAULT NULL,
  `to_url` varchar(500) DEFAULT NULL,
  `fee` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`subscription_id`),
  KEY `sub_transport_service_idx` (`service_id`),
  KEY `transport_user_idx` (`username`),
  CONSTRAINT `sub_transport_service` FOREIGN KEY (`service_id`) REFERENCES `tourist_transport` (`service_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `transport_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transport_subscription`
--

LOCK TABLES `transport_subscription` WRITE;
/*!40000 ALTER TABLE `transport_subscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `transport_subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `country` varchar(45) NOT NULL,
  `contact_number` varchar(45) NOT NULL,
  `email_address` varchar(45) NOT NULL,
  `birthday` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `rating_profile_id` varchar(100) DEFAULT NULL,
  `picture_link` varchar(500) DEFAULT NULL,
  `fb_token` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('10216489463407145','Isuru','Tharanga','male','Sri Lanka','','isuru.trgz@gmail.com','01/09/1993','10216489463407145','https://platform-lookaside.fbsbx.com/platform/profilepic/?asid=10216489463407145&height=50&width=50&ext=1556640515&hash=AeQtcX5c_k63oBlf','EAAgfglcdEMMBAEhJGU8BMN7sZAd74YoOTAu3RfoZBgPltUgCCzOwga3JWFdAtQeVBNhEOBo2Tb1uHA8SjxPvkFK7p3kBmtOpWZAgZBNvhI442v0UcckSAqx5zwsM8paSEQycQibjA7VAxZB9hWI1DITgwmlYqCNVY8SziEEF3C5ZC7lNvYVf2IRnWGI8sBiCOFReRFOQ2eZCVY9d7JvMhVImfcJ58bpRP0ZD');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_rating_profile`
--

DROP TABLE IF EXISTS `user_rating_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_rating_profile` (
  `rating_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `rated_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`rating_id`),
  KEY `rating_user_idx` (`username`),
  CONSTRAINT `rated_by_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `rating_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_rating_profile`
--

LOCK TABLES `user_rating_profile` WRITE;
/*!40000 ALTER TABLE `user_rating_profile` DISABLE KEYS */;
INSERT INTO `user_rating_profile` VALUES (2,'10216489463407145','A',3,NULL),(3,'10216489463407145','B',2,NULL),(4,'10216489463407145','A',5,NULL),(5,'10216489463407145','C',3,NULL),(6,'10216489463407145','B',2,NULL),(7,'10216489463407145','A',4,NULL),(8,'10216489463407145','B',5,NULL),(9,'10216489463407145','B',5,NULL),(10,'10216489463407145','B',5,NULL),(11,'10216489463407145','D',2,'10216489463407145'),(12,'10216489463407145','New',3,'10216489463407145'),(13,'10216489463407145','New',5,'10216489463407145'),(14,'10216489463407145','D',1,'10216489463407145'),(15,'10216489463407145','D',1,'10216489463407145'),(16,'10216489463407145','Killer',3,'10216489463407145'),(17,'10216489463407145','Matta',2,'10216489463407145');
/*!40000 ALTER TABLE `user_rating_profile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-05  1:42:47
