/*
 Navicat Premium Data Transfer

 Source Server         : 121.37.71.228
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : 121.37.71.228:3308
 Source Schema         : taxi_driver

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 05/06/2023 01:31:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tid_trid_rel
-- ----------------------------
DROP TABLE IF EXISTS `taxi_driver`.`tid_trid_rel`;
CREATE TABLE `tid_trid_rel`  (
  `tid` int(0) NOT NULL,
  `tname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `trid` int(0) NULL DEFAULT NULL,
  `trname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
