/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : weibo

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 25/11/2018 16:36:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `counter` int(10) NOT NULL DEFAULT 0,
  `logger` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `logger`(`logger`) USING BTREE,
  CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`logger`) REFERENCES `logger` (`name_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, '天气晴朗', 'A', 5, 1);
INSERT INTO `blog` VALUES (2, '更新', 'B', 6, 1);
INSERT INTO `blog` VALUES (3, '天气晴朗', 'A', 0, 1);
INSERT INTO `blog` VALUES (4, '更新', 'B', 1, 1);
INSERT INTO `blog` VALUES (5, '天气晴朗', 'A', 1, 1);
INSERT INTO `blog` VALUES (6, '更新', 'B', 1, 1);
INSERT INTO `blog` VALUES (7, '天气晴朗', 'A', 30, 1);
INSERT INTO `blog` VALUES (8, '更新', 'B', 2, 1);
INSERT INTO `blog` VALUES (9, '天气晴朗', 'A', 1, 1);
INSERT INTO `blog` VALUES (10, '更新', 'B', 11, 1);
INSERT INTO `blog` VALUES (12, '天气晴朗', 'A', 3, 1);
INSERT INTO `blog` VALUES (13, '11', 'A', 2, 1);
INSERT INTO `blog` VALUES (16, '你好', 'aa', 0, 1);
INSERT INTO `blog` VALUES (17, '地方', 'b', 0, 1);
INSERT INTO `blog` VALUES (22, '你好', 'aa', 0, 1);
INSERT INTO `blog` VALUES (23, '地方', 'b', 0, 1);
INSERT INTO `blog` VALUES (24, '你好', 'aa', 0, 1);
INSERT INTO `blog` VALUES (25, '地方', 'b', 0, 1);

-- ----------------------------
-- Table structure for logger
-- ----------------------------
DROP TABLE IF EXISTS `logger`;
CREATE TABLE `logger`  (
  `name_id` int(11) NOT NULL,
  `fans` int(255) NOT NULL,
  PRIMARY KEY (`name_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of logger
-- ----------------------------
INSERT INTO `logger` VALUES (1, 20);

SET FOREIGN_KEY_CHECKS = 1;
