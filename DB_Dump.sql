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
  `is_active` int(11) DEFAULT '1',
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
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `location_id` varchar(50) NOT NULL,
  `lng` double DEFAULT NULL,
  `lat` double DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
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
  `location_id` varchar(500) DEFAULT NULL,
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
  `username` varchar(100) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `country` varchar(45) NOT NULL,
  `contact_number` varchar(45) NOT NULL,
  `pwd_salt` varchar(500) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `picture_link` varchar(150) DEFAULT NULL,
  `location_id` varchar(45) DEFAULT NULL,
  `is_admin` int(11) DEFAULT NULL,
  `is_active` int(11) DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin1@travelified.com','Senali','Devindi','Female','Sri Lanka','0777123456','8a415ddf','31a5745564c4ee1cc003abbfa021987e1446faf9cdb7f21a1938f56fa70c7044','17becd8e-1466-4d97-89c1-756bfa0f71b5','40926730-5d5f-4dc5-a3fa-e7ca12a947aa',1,1),('user1@travelified.com','Senali','Devindi','Female','Sri Lanka','0777123456','b34ebeac','67773f197dfd5229775942ead3b64a7d73e1c11102fdbe582d0c3b555c5b4edd','96d99648-75df-4ef7-8025-57cd0e4a666b','fc3d523a-b6c4-4f7b-af23-d17bc42ce6ea',NULL,1);
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_rating_profile`
--

LOCK TABLES `user_rating_profile` WRITE;
/*!40000 ALTER TABLE `user_rating_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_rating_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tourism_app'
--

--
-- Dumping routines for database 'tourism_app'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-24 12:14:08
