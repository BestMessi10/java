/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost:3306
 Source Schema         : crow

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 09/10/2018 11:04:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (1, '系统菜单', 0, '', 'glyphicon glyphicon-th-list');
INSERT INTO `t_permission` VALUES (2, '控制面板', 1, NULL, 'glyphicon glyphicon-dashboard');
INSERT INTO `t_permission` VALUES (3, '权限管理', 1, NULL, 'glyphicon glyphicon glyphicon-tasks');
INSERT INTO `t_permission` VALUES (4, '用户维护', 3, '/user/index', 'glyphicon glyphicon-user');
INSERT INTO `t_permission` VALUES (5, '角色维护', 3, '/role/index', 'glyphicon glyphicon-king');
INSERT INTO `t_permission` VALUES (6, '许可维护', 3, '/permission/index', 'glyphicon glyphicon-lock');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'PM-项目经理');
INSERT INTO `t_role` VALUES (2, 'SE-软件工程师');
INSERT INTO `t_role` VALUES (3, 'PG-程序员');
INSERT INTO `t_role` VALUES (4, 'TL-组长');
INSERT INTO `t_role` VALUES (5, 'GL-组长');
INSERT INTO `t_role` VALUES (7, 'OC-品质控制');
INSERT INTO `t_role` VALUES (8, 'SA-软件架构师');
INSERT INTO `t_role` VALUES (9, 'CMO/CMS-配置管理');
INSERT INTO `t_role` VALUES (10, 'SYSTEM-系统管理');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) NULL DEFAULT NULL,
  `permissionid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES (4, 1, 1);
INSERT INTO `t_role_permission` VALUES (5, 1, 3);
INSERT INTO `t_role_permission` VALUES (6, 1, 4);
INSERT INTO `t_role_permission` VALUES (7, 1, 5);
INSERT INTO `t_role_permission` VALUES (8, 3, 1);
INSERT INTO `t_role_permission` VALUES (9, 3, 3);
INSERT INTO `t_role_permission` VALUES (10, 3, 5);
INSERT INTO `t_role_permission` VALUES (11, 3, 6);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `loginacct` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userpswd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'username', 'zhangsan', 'zhangsan', '57261523@qq.com', NULL);
INSERT INTO `t_user` VALUES (3, 'wangwu', 'wangwu', 'wangwu', '3333@qq.com', NULL);
INSERT INTO `t_user` VALUES (4, 'messi', 'messi', '123456', 'messi@qq.com', NULL);
INSERT INTO `t_user` VALUES (5, 'ss', '22', '22', '22', NULL);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NULL DEFAULT NULL,
  `roleid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (2, 4, 1);
INSERT INTO `t_user_role` VALUES (5, 1, 3);
INSERT INTO `t_user_role` VALUES (7, 4, 3);

SET FOREIGN_KEY_CHECKS = 1;
