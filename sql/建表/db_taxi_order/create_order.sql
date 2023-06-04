/*
 Navicat Premium Data Transfer

 Source Server         : 121.37.71.228
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : 121.37.71.228:3308
 Source Schema         : taxi_order

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 05/06/2023 01:34:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `address` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发起地行政区划代码',
  `passenger_id` bigint(0) NULL DEFAULT NULL,
  `passenger_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `driver_id` bigint(0) NULL DEFAULT NULL,
  `driver_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `order_time` datetime(0) NULL DEFAULT NULL,
  `dep_lng` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `dep_lat` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `dest_lng` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `dest_lat` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cancel_type_code` int(0) NULL DEFAULT NULL COMMENT '取消类型',
  `state` int(0) NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12345682 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
