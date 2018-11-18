/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : usertest

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-11-19 01:14:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `empId` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(25) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `deptId` int(11) NOT NULL,
  `empType` varchar(20) DEFAULT NULL,
  `employeeType` varchar(11) DEFAULT NULL,
  `age` varchar(20) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=28271 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1000', 'zhangpingyang', '285442936@qq.com', '男', '1', null, null, null, '2018-11-18 21:38:29', '2018-11-18 21:38:29');
INSERT INTO `employee` VALUES ('1001', '张琳', '123456@qq.com', '男', '1', null, null, null, '2018-11-18 21:38:29', '2018-11-18 21:38:29');
INSERT INTO `employee` VALUES ('1002', 'xxx', '12345@sina.com', '男', '1', null, null, null, '2018-11-18 21:38:29', '2018-11-18 21:38:29');
INSERT INTO `employee` VALUES ('1003', 'xxxyyy', '12345@sina.com', '男', '1', null, null, null, '2018-11-18 21:38:29', '2018-11-18 21:38:29');
INSERT INTO `employee` VALUES ('3128', 'xxxyyy', '12345@sina.com', '男', '1', null, null, null, '2018-11-18 21:38:29', '2018-11-18 21:38:29');
INSERT INTO `employee` VALUES ('3267', 'xxxyyy', '12345@sina.com', '男', '1', 'VIP', '1', 'Old', '2018-11-18 21:38:29', '2018-11-18 21:38:29');
INSERT INTO `employee` VALUES ('3268', 'xxxyyy', '12345@sina.com', '男', '1', 'VIP', '1', 'Old', '2018-11-18 21:38:29', '2018-11-18 21:38:29');
INSERT INTO `employee` VALUES ('3269', 'xxxyyy', '12345@sina.com', '男', '1', 'VIP', '1', 'Old', '2018-11-18 21:38:29', '2018-11-18 21:38:29');
INSERT INTO `employee` VALUES ('3270', 'xxxyyy', '12345@sina.com', '男', '1', 'VIP', '1', 'Old', '2018-11-18 21:40:02', '2018-11-18 21:40:02');
