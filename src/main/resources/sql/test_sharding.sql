/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.11.121
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : 192.168.11.121:3306
 Source Schema         : test_sharding

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 16/10/2020 16:55:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house`  (
  `house_id` int(11) NOT NULL,
  `house_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `house_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`house_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_age` tinyint(4) NULL DEFAULT NULL,
  `house_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_1
-- ----------------------------
DROP TABLE IF EXISTS `user_1`;
CREATE TABLE `user_1`  (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_age` tinyint(4) NULL DEFAULT NULL,
  `house_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_10
-- ----------------------------
DROP TABLE IF EXISTS `user_10`;
CREATE TABLE `user_10`  (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_age` tinyint(4) NULL DEFAULT NULL,
  `house_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_11
-- ----------------------------
DROP TABLE IF EXISTS `user_11`;
CREATE TABLE `user_11`  (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_age` tinyint(4) NULL DEFAULT NULL,
  `house_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_12
-- ----------------------------
DROP TABLE IF EXISTS `user_12`;
CREATE TABLE `user_12`  (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_age` tinyint(4) NULL DEFAULT NULL,
  `house_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_2
-- ----------------------------
DROP TABLE IF EXISTS `user_2`;
CREATE TABLE `user_2`  (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_age` tinyint(4) NULL DEFAULT NULL,
  `house_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_3
-- ----------------------------
DROP TABLE IF EXISTS `user_3`;
CREATE TABLE `user_3`  (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_age` tinyint(4) NULL DEFAULT NULL,
  `house_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_4
-- ----------------------------
DROP TABLE IF EXISTS `user_4`;
CREATE TABLE `user_4`  (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_age` tinyint(4) NULL DEFAULT NULL,
  `house_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_5
-- ----------------------------
DROP TABLE IF EXISTS `user_5`;
CREATE TABLE `user_5`  (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_age` tinyint(4) NULL DEFAULT NULL,
  `house_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_6
-- ----------------------------
DROP TABLE IF EXISTS `user_6`;
CREATE TABLE `user_6`  (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_age` tinyint(4) NULL DEFAULT NULL,
  `house_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_7
-- ----------------------------
DROP TABLE IF EXISTS `user_7`;
CREATE TABLE `user_7`  (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_age` tinyint(4) NULL DEFAULT NULL,
  `house_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_8
-- ----------------------------
DROP TABLE IF EXISTS `user_8`;
CREATE TABLE `user_8`  (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_age` tinyint(4) NULL DEFAULT NULL,
  `house_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_9
-- ----------------------------
DROP TABLE IF EXISTS `user_9`;
CREATE TABLE `user_9`  (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_age` tinyint(4) NULL DEFAULT NULL,
  `house_id` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
