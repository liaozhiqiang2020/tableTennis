/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : tabletennis

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-12-10 16:02:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('24281');
INSERT INTO `hibernate_sequence` VALUES ('24281');
INSERT INTO `hibernate_sequence` VALUES ('24281');
INSERT INTO `hibernate_sequence` VALUES ('24281');

-- ----------------------------
-- Table structure for mc_permission
-- ----------------------------
DROP TABLE IF EXISTS `mc_permission`;
CREATE TABLE `mc_permission` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `permissions_name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mc_permission
-- ----------------------------

-- ----------------------------
-- Table structure for mc_role
-- ----------------------------
DROP TABLE IF EXISTS `mc_role`;
CREATE TABLE `mc_role` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date_time` datetime NOT NULL COMMENT '创建时间，写入记录时的系统时间',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '组名称，唯一约束',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色具体权限描述',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE KEY `role_name` (`role_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=753 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of mc_role
-- ----------------------------
INSERT INTO `mc_role` VALUES ('1', '2018-09-18 00:00:00', '一级管理', '价格绑定 设备管理 用户信息管理 网关管理 分公司管理 角色管理 控制设备 销售报表 订单查询(管理员) 价格管理 场地方管理 总公司管理 代理商管理 行业分类管理 二维码生成 大区管理 订单查询');
INSERT INTO `mc_role` VALUES ('52', '2018-07-17 21:32:24', '二级管理', '');
INSERT INTO `mc_role` VALUES ('53', '2018-07-19 16:24:09', '三级管理', '');
INSERT INTO `mc_role` VALUES ('456', '2018-07-28 12:51:43', '分公司管理', '控制设备 价格管理 代理商管理 设备管理 价格绑定 订单查询 销售报表 场地方管理 网关管理');
INSERT INTO `mc_role` VALUES ('745', '2018-08-21 01:19:35', '二维码管理', '二维码生成');
INSERT INTO `mc_role` VALUES ('750', '2018-09-17 21:55:54', '代理商', '销售报表 订单查询');
INSERT INTO `mc_role` VALUES ('751', '2018-09-18 03:50:56', '场地方', '销售报表 订单查询');
INSERT INTO `mc_role` VALUES ('752', '2019-07-26 12:41:24', '测试角色', '销售报表 订单查询');

-- ----------------------------
-- Table structure for mc_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `mc_role_permission`;
CREATE TABLE `mc_role_permission` (
  `permission_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FKnp3ykasm0vtasnaefwsrlxebf` (`permission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mc_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for mc_user
-- ----------------------------
DROP TABLE IF EXISTS `mc_user`;
CREATE TABLE `mc_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '用户名称',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `authentication_string` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '验证信息',
  `create_datetime` datetime NOT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `cellphone_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号',
  `fixed_phone_number` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '座机',
  `latest_login_datetime` datetime DEFAULT NULL,
  `latest_login_ip` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '最后登录ip',
  `status` int(10) NOT NULL DEFAULT '0' COMMENT '用户状态,0启用，1停用',
  `p_id` int(11) DEFAULT NULL COMMENT '隶属单位id',
  `grade_id` int(11) DEFAULT NULL COMMENT '1：总公司  2：分公司 3：代理商 4：场地方',
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE KEY `userName` (`user_name`) USING BTREE COMMENT '唯一索引'
) ENGINE=InnoDB AUTO_INCREMENT=964 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of mc_user
-- ----------------------------
INSERT INTO `mc_user` VALUES ('32', 'admin', '超级管理员', '123456', '2018-07-17 19:32:05', '89895414@qq.com', '19922992299', '85913412', '2020-09-28 09:04:52', '123.113.110.197', '1', '1', '1', '0');
INSERT INTO `mc_user` VALUES ('821', '596800226', '刘子谦', '123456', '2020-10-13 02:43:52', null, '17805421508', null, null, null, '0', null, null, '0');

-- ----------------------------
-- Table structure for mc_user_role
-- ----------------------------
DROP TABLE IF EXISTS `mc_user_role`;
CREATE TABLE `mc_user_role` (
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `FKa8l37r6qschfbmcdemqe9akb4` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mc_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for tt_choose_class
-- ----------------------------
DROP TABLE IF EXISTS `tt_choose_class`;
CREATE TABLE `tt_choose_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `end_time` varchar(255) DEFAULT NULL,
  `place_id` varchar(255) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `week` varchar(255) DEFAULT NULL,
  `course_id` varchar(255) DEFAULT NULL,
  `coach_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_choose_class
-- ----------------------------
INSERT INTO `tt_choose_class` VALUES ('2', '17:40:00', '1', '16:30:00', '周一', '1', '1');
INSERT INTO `tt_choose_class` VALUES ('3', '17:40:00', '1', '16:30:00', '周二', '1', '2');
INSERT INTO `tt_choose_class` VALUES ('4', '17:40:00', '1', '16:30:00', '周一', '1', '3');
INSERT INTO `tt_choose_class` VALUES ('5', '17:40:00', '1', '16:30:00', '周四', '1', '1');
INSERT INTO `tt_choose_class` VALUES ('6', '19:00:00', '1', '18:00:00', '周二', '1', '3');
INSERT INTO `tt_choose_class` VALUES ('7', '10:40:00', '1', '09:00:00', '周六', '1', '1');
INSERT INTO `tt_choose_class` VALUES ('8', '15:40:00', '1', '14:00:00', '周三', '1', '3');
INSERT INTO `tt_choose_class` VALUES ('9', '17:40:00', '1', '16:00:00', '周六', '1', '2');
INSERT INTO `tt_choose_class` VALUES ('10', '10:40:00', '1', '09:00:00', '周日', '1', '1');
INSERT INTO `tt_choose_class` VALUES ('11', '15:40:00', '1', '14:00:00', '周日', '1', '2');
INSERT INTO `tt_choose_class` VALUES ('12', '17:40:00', '1', '16:00:00', '周日', '1', '2');
INSERT INTO `tt_choose_class` VALUES ('13', '15:00:00', '1', '05:00:00', '周一', '1', '2');
INSERT INTO `tt_choose_class` VALUES ('14', '04:00:00', '1', '03:00:00', '周二', '1', '2');
INSERT INTO `tt_choose_class` VALUES ('15', '05:00:00', '1', '03:00:00', '周二', '1', '1');
INSERT INTO `tt_choose_class` VALUES ('16', '07:00:00', '1', '05:00:00', '周四', '1', '3');
INSERT INTO `tt_choose_class` VALUES ('17', '05:00:00', '1', '04:00:00', '周一', '1', '2');
INSERT INTO `tt_choose_class` VALUES ('18', '17:00:00', '1', '14:04:00', '周五', '1', '3');
INSERT INTO `tt_choose_class` VALUES ('19', '22:00:00', '1', '21:00:00', '周六', '1', '3');

-- ----------------------------
-- Table structure for tt_choose_class_record
-- ----------------------------
DROP TABLE IF EXISTS `tt_choose_class_record`;
CREATE TABLE `tt_choose_class_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_content` varchar(255) DEFAULT NULL,
  `expect_count` int(11) DEFAULT NULL,
  `place_id` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_choose_class_record
-- ----------------------------
INSERT INTO `tt_choose_class_record` VALUES ('16', '周三16:30:00-17:40:00	周五16:30:00-17:40:00	周六14:00:00-15:40:00	', '3', '1', '43');
INSERT INTO `tt_choose_class_record` VALUES ('13', '周五16:30:00-17:40:00	周六09:00:00-10:40:00	', '2', '1', '27');
INSERT INTO `tt_choose_class_record` VALUES ('14', '周五16:30:00-17:40:00	周六09:00:00-10:40:00	', '2', '1', '22');
INSERT INTO `tt_choose_class_record` VALUES ('15', '周六09:00:00-10:40:00	', '1', '1', '31');
INSERT INTO `tt_choose_class_record` VALUES ('12', '周一16:30:00-17:40:00	周三16:30:00-17:40:00	周五16:30:00-17:40:00	', '3', '1', '17');
INSERT INTO `tt_choose_class_record` VALUES ('11', '周五16:30:00-17:40:00	周六09:00:00-10:40:00	', '2', '1', '18');
INSERT INTO `tt_choose_class_record` VALUES ('9', '周一16:30:00-17:40:00	周三16:30:00-17:40:00	周五16:30:00-17:40:00	', '3', '1', '15');
INSERT INTO `tt_choose_class_record` VALUES ('10', '周五16:30:00-17:40:00	周六09:00:00-10:40:00	', '2', '1', '19');
INSERT INTO `tt_choose_class_record` VALUES ('8', '周五16:30:00-17:40:00	周六09:00:00-10:40:00	周日16:00:00-17:40:00	', '3', '1', '23');
INSERT INTO `tt_choose_class_record` VALUES ('17', '周六09:00:00-10:40:00	周日09:00:00-10:40:00	', '2', '1', '37');

-- ----------------------------
-- Table structure for tt_coach
-- ----------------------------
DROP TABLE IF EXISTS `tt_coach`;
CREATE TABLE `tt_coach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `entry_date` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `is_full_time` varchar(255) DEFAULT NULL,
  `leave_date` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `on_leave` varchar(255) DEFAULT NULL,
  `on_work` varchar(255) DEFAULT NULL,
  `place_id` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_coach
-- ----------------------------
INSERT INTO `tt_coach` VALUES ('1', '2020-11-01', '111113123123', 'E:/upload/20201101204140.png', '0', null, '刘子谦', '0', '0', '1', '', '17805421508');
INSERT INTO `tt_coach` VALUES ('2', '2020-11-01', '1312412312', 'E:/upload/20201101204154.jpg', '0', null, '廖志强', '0', '0', '1', '', '13311085109');
INSERT INTO `tt_coach` VALUES ('3', '2020-12-01', '370321199603253932', 'E:/upload/20201202124349.jpg', '0', null, '刘源', '0', '0', '1', '', '17854222344');

-- ----------------------------
-- Table structure for tt_course
-- ----------------------------
DROP TABLE IF EXISTS `tt_course`;
CREATE TABLE `tt_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_hours` int(11) DEFAULT NULL,
  `in_school` int(11) DEFAULT NULL,
  `money` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `place_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_course
-- ----------------------------
INSERT INTO `tt_course` VALUES ('1', '1', '1', '79', '启蒙课1v6', '3', '1');
INSERT INTO `tt_course` VALUES ('9', '1', null, '199', '启蒙课1v1', null, '1');

-- ----------------------------
-- Table structure for tt_place
-- ----------------------------
DROP TABLE IF EXISTS `tt_place`;
CREATE TABLE `tt_place` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `commission` varchar(255) DEFAULT NULL,
  `contacts` varchar(255) DEFAULT NULL,
  `contacts_tel` varchar(255) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rent` varchar(255) DEFAULT NULL,
  `rent_type` int(11) DEFAULT NULL,
  `sign_time` varchar(255) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_place
-- ----------------------------
INSERT INTO `tt_place` VALUES ('1', '青岛市黄岛区星光岛玫瑰园218-2', '0', '廖志强', '13311085109', '2021-12-01', '零之启-星光岛店', '55000', '2', '2020-12-01', '2020-12-01', '2');

-- ----------------------------
-- Table structure for tt_student
-- ----------------------------
DROP TABLE IF EXISTS `tt_student`;
CREATE TABLE `tt_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `class_hours` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_name` varchar(255) DEFAULT NULL,
  `parent_tel` varchar(255) DEFAULT NULL,
  `place_id` varchar(255) DEFAULT NULL,
  `registr_time` varchar(255) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `money` varchar(255) DEFAULT NULL,
  `sale_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_student
-- ----------------------------
INSERT INTO `tt_student` VALUES ('108', '', null, '', '刘冠吾', '刘峰', '', '', '', null, '13070767600', '', '', null);
INSERT INTO `tt_student` VALUES ('109', '', null, '0', '刘冠吾', '刘峰', '13070767600', '1', '2020-12-9', null, '', '', '0', null);

-- ----------------------------
-- Table structure for tt_student_sign
-- ----------------------------
DROP TABLE IF EXISTS `tt_student_sign`;
CREATE TABLE `tt_student_sign` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `place_id` int(11) DEFAULT NULL,
  `sign_time` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_student_sign
-- ----------------------------

-- ----------------------------
-- Table structure for tt_tuition
-- ----------------------------
DROP TABLE IF EXISTS `tt_tuition`;
CREATE TABLE `tt_tuition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `billing_type` int(11) DEFAULT NULL,
  `charge_type` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `invoice` int(11) DEFAULT NULL,
  `pay_money` varchar(255) DEFAULT NULL,
  `pay_time` varchar(255) DEFAULT NULL,
  `place_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_tuition
-- ----------------------------

-- ----------------------------
-- Table structure for tt_wx_user_info
-- ----------------------------
DROP TABLE IF EXISTS `tt_wx_user_info`;
CREATE TABLE `tt_wx_user_info` (
  `id` int(11) NOT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `country_code` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `open_code` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `pure_phone_number` varchar(255) DEFAULT NULL,
  `update_date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_wx_user_info
-- ----------------------------
INSERT INTO `tt_wx_user_info` VALUES ('24280', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKILsf01ibBCFUwENd2oJQic7xfdRwicYpIpV3VsmTbVRqH4ZYFujpqX4TwicnMiadNunoPC90NibcnYIiaQ/132', '兰州市', '中国', null, '1', 'zh_CN', 'future', 'o9Evp5Z5CsVt18LXKKnTFATBVd4g', null, '甘肃', null, '2020-12-02 04:58:56');
