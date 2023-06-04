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

 Date: 05/06/2023 01:31:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for trid_point_rel
-- ----------------------------
DROP TABLE IF EXISTS `taxi_driver`.`trid_point_rel`;
CREATE TABLE `trid_point_rel`  (
  `trid` int(0) NOT NULL,
  `point` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sid` int(0) NULL DEFAULT NULL,
  `tid` int(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
