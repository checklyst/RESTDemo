-- --------------------------------------------------------
-- Host:                         103.127.146.94
-- Server version:               10.1.40-MariaDB - MariaDB Server
-- Server OS:                    Linux
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for procedure TrainingDB.P_addUserRecord
DROP PROCEDURE IF EXISTS `P_addUserRecord`;
DELIMITER //
CREATE PROCEDURE `P_addUserRecord`(
	IN `p_fname` CHAR(50),
	IN `p_lname` CHAR(50),
	IN `p_email` CHAR(50),
	OUT `o_user_id` INT
)
BEGIN

INSERT INTO `sys_user_m` (`first_name`, `last_name`, `email`) VALUES (p_fname, p_lname, p_email);

SET o_user_id = LAST_INSERT_ID();

SELECT o_user_id;

END//
DELIMITER ;

-- Dumping structure for procedure TrainingDB.P_getUserRecord
DROP PROCEDURE IF EXISTS `P_getUserRecord`;
DELIMITER //
CREATE PROCEDURE `P_getUserRecord`(
	IN `p_user_id` INT
)
BEGIN
SELECT user_id, first_name, last_name FROM sys_user_m WHERE user_id = p_user_id;
END//
DELIMITER ;

-- Dumping structure for table TrainingDB.sys_user_m
DROP TABLE IF EXISTS `sys_user_m`;
CREATE TABLE IF NOT EXISTS `sys_user_m` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` char(50) DEFAULT NULL,
  `last_name` char(50) DEFAULT NULL,
  `email` char(50) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  PRIMARY KEY (`user_id`),
  KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table TrainingDB.sys_user_m: ~0 rows (approximately)
DELETE FROM `sys_user_m`;
/*!40000 ALTER TABLE `sys_user_m` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user_m` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
