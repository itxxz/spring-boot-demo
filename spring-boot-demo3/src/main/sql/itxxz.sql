/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50634
Source Host           : localhost:3306
Source Database       : itxxz

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-03-20 09:28:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for itxxz_site
-- ----------------------------
DROP TABLE IF EXISTS `itxxz_site`;
CREATE TABLE `itxxz_site` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of itxxz_site
-- ----------------------------
INSERT INTO `itxxz_site` VALUES ('1', 'IT学习者', '关注程序员的就业工作及生活', 'www.itxxz.com');
INSERT INTO `itxxz_site` VALUES ('2', '螃蟹', '喝咖啡的螃蟹', null);
INSERT INTO `itxxz_site` VALUES ('3', '青鸟', '来螃蟹的思念', null);


