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

 Date: 05/06/2023 01:26:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for driver_user
-- ----------------------------
DROP TABLE IF EXISTS `taxi_driver`.`driver_user`;
CREATE TABLE `driver_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `vehicle_no` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '车牌',
  `tid` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '高德terrminal id',
  `address` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '注册地行政区划代码',
  `driver_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `driver_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `driver_gender` tinyint(0) NULL DEFAULT NULL,
  `license_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contract_company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `get_driver_license_date` datetime(0) NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `work_state` tinyint(0) NULL DEFAULT NULL COMMENT '{0收车 1出车 2暂停}',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
