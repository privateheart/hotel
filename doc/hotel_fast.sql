/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : hotel_fast

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-03-26 07:35:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for h_dic
-- ----------------------------
DROP TABLE IF EXISTS `h_dic`;
CREATE TABLE `h_dic` (
  `dic_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dic_type` int(5) NOT NULL COMMENT '类别id',
  `dic_name` varchar(20) NOT NULL COMMENT '名称',
  `remark` varchar(20) DEFAULT NULL COMMENT '备注',
  `sort` tinyint(2) DEFAULT NULL COMMENT '排序',
  `value` tinyint(2) DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`dic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h_dic
-- ----------------------------
INSERT INTO `h_dic` VALUES ('1', '1', '是', null, null, null);
INSERT INTO `h_dic` VALUES ('2', '1', '否', null, null, null);
INSERT INTO `h_dic` VALUES ('3', '2', '酒', null, null, null);
INSERT INTO `h_dic` VALUES ('4', '2', '饮料', null, null, null);

-- ----------------------------
-- Table structure for h_dic_type
-- ----------------------------
DROP TABLE IF EXISTS `h_dic_type`;
CREATE TABLE `h_dic_type` (
  `dic_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `category_name` varchar(20) NOT NULL COMMENT '类别名称',
  `remark` varchar(20) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dic_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h_dic_type
-- ----------------------------
INSERT INTO `h_dic_type` VALUES ('1', '是否', null);
INSERT INTO `h_dic_type` VALUES ('2', '物品类型', null);

-- ----------------------------
-- Table structure for h_goods
-- ----------------------------
DROP TABLE IF EXISTS `h_goods`;
CREATE TABLE `h_goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_name` varchar(50) DEFAULT NULL COMMENT '物品名称',
  `goods_type` int(5) DEFAULT NULL COMMENT '物品类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_valid` int(1) DEFAULT NULL COMMENT '是否有效',
  `modifier` int(11) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='物品表';

-- ----------------------------
-- Records of h_goods
-- ----------------------------
INSERT INTO `h_goods` VALUES ('1', '小劲酒', '3', '2018-03-04 12:18:35', '2', '2018-03-04 20:26:56', '1', '2');
INSERT INTO `h_goods` VALUES ('2', '测试饮料', '4', '2018-03-04 20:26:20', '2', null, '2', null);

-- ----------------------------
-- Table structure for h_goods_stock
-- ----------------------------
DROP TABLE IF EXISTS `h_goods_stock`;
CREATE TABLE `h_goods_stock` (
  `goods_stock_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL COMMENT '物品id',
  `qty` decimal(10,2) DEFAULT NULL COMMENT '数量(原子)',
  PRIMARY KEY (`goods_stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存表';

-- ----------------------------
-- Records of h_goods_stock
-- ----------------------------

-- ----------------------------
-- Table structure for h_goods_unit
-- ----------------------------
DROP TABLE IF EXISTS `h_goods_unit`;
CREATE TABLE `h_goods_unit` (
  `goods_unit_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL COMMENT '物品Id',
  `unit` varchar(50) DEFAULT NULL COMMENT '单位',
  `conversion_rate` int(11) DEFAULT NULL COMMENT '换算率 {箱 x 换算率 = 瓶（标准单位）}',
  `unit_price` decimal(10,2) DEFAULT NULL COMMENT '该单位下的 价格',
  `is_atomic` int(1) DEFAULT NULL COMMENT '是否原子单位',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `modifier` int(11) DEFAULT NULL,
  `is_valid` int(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`goods_unit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='物品--单位表  一个物品可以有多个单位';

-- ----------------------------
-- Records of h_goods_unit
-- ----------------------------
INSERT INTO `h_goods_unit` VALUES ('1', '1', '瓶', '1', '80.00', '1', '2018-03-22 20:48:04', '2018-03-22 21:10:27', '2', '2', '2');
INSERT INTO `h_goods_unit` VALUES ('2', '1', '箱', '12', '960.00', '2', '2018-03-23 07:10:36', '2018-03-23 07:15:49', '2', '2', '1');

-- ----------------------------
-- Table structure for h_room
-- ----------------------------
DROP TABLE IF EXISTS `h_room`;
CREATE TABLE `h_room` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '注解',
  `room_name` varchar(50) DEFAULT NULL COMMENT '厅名字',
  `seating_capacity` int(11) DEFAULT NULL COMMENT '最大容纳人数',
  `custodian` int(11) DEFAULT NULL COMMENT '厅管理人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  `modifier` int(11) DEFAULT NULL COMMENT '修改者',
  `is_valid` int(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='厅房表';

-- ----------------------------
-- Records of h_room
-- ----------------------------
INSERT INTO `h_room` VALUES ('1', '测试厅', '15', '2', '2018-03-07 20:35:46', null, '2', null, '2');
INSERT INTO `h_room` VALUES ('2', '百合厅', '7', '2', '2018-03-07 21:12:09', '2018-03-07 21:13:49', '2', '2', '1');
INSERT INTO `h_room` VALUES ('3', '库存', '1', '2', '2018-03-25 15:35:31', null, '2', null, '1');

-- ----------------------------
-- Table structure for h_stock_flow
-- ----------------------------
DROP TABLE IF EXISTS `h_stock_flow`;
CREATE TABLE `h_stock_flow` (
  `stock_flow_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` int(11) DEFAULT NULL COMMENT '物品id',
  `room_id` int(11) DEFAULT NULL COMMENT '厅号id',
  `qty` decimal(10,2) DEFAULT NULL COMMENT '进出数量',
  `goods_unit_id` int(11) DEFAULT NULL COMMENT '录入库存时的单位',
  `atomic_qty` decimal(10,2) DEFAULT NULL COMMENT '原子数量',
  `create_time` datetime DEFAULT NULL COMMENT '操作时间',
  `creator` int(11) DEFAULT NULL COMMENT '操作人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modifier` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`stock_flow_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存流动记录表';

-- ----------------------------
-- Records of h_stock_flow
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_2', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', null, 'io.renren.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597400B67B226A6F624964223A312C226265616E4E616D65223A22746573745461736B222C226D6574686F644E616D65223A2274657374222C22706172616D73223A2272656E72656E222C2263726F6E45787072657373696F6E223A223020302F3330202A202A202A203F222C22737461747573223A302C2272656D61726B223A22E69C89E58F82E695B0E6B58BE8AF95222C2263726561746554696D65223A2244656320312C20323031362031313A31363A343620504D227D7800);
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_2', 'DEFAULT', null, 'io.renren.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597400A47B226A6F624964223A322C226265616E4E616D65223A22746573745461736B222C226D6574686F644E616D65223A227465737432222C2263726F6E45787072657373696F6E223A223020302F3330202A202A202A203F222C22737461747573223A312C2272656D61726B223A22E697A0E58F82E695B0E6B58BE8AF95222C2263726561746554696D65223A2244656320332C203230313620323A35353A353620504D227D7800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', null, '1521966600000', '-1', '5', 'WAITING', 'CRON', '1519535222000', '0', null, '2', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597400B67B226A6F624964223A312C226265616E4E616D65223A22746573745461736B222C226D6574686F644E616D65223A2274657374222C22706172616D73223A2272656E72656E222C2263726F6E45787072657373696F6E223A223020302F3330202A202A202A203F222C22737461747573223A302C2272656D61726B223A22E69C89E58F82E695B0E6B58BE8AF95222C2263726561746554696D65223A2244656320312C20323031362031313A31363A343620504D227D7800);
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_2', 'DEFAULT', 'TASK_2', 'DEFAULT', null, '1519536600000', '-1', '5', 'PAUSED', 'CRON', '1519535222000', '0', null, '2', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597400A47B226A6F624964223A322C226265616E4E616D65223A22746573745461736B222C226D6574686F644E616D65223A227465737432222C2263726F6E45787072657373696F6E223A223020302F3330202A202A202A203F222C22737461747573223A312C2272656D61726B223A22E697A0E58F82E695B0E6B58BE8AF95222C2263726561746554696D65223A2244656320332C203230313620323A35353A353620504D227D7800);

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='定时任务';

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('1', 'testTask', 'test', 'renren', '0 0/30 * * * ?', '0', '有参数测试', '2016-12-01 23:16:46');
INSERT INTO `schedule_job` VALUES ('2', 'testTask', 'test2', null, '0 0/30 * * * ?', '1', '无参数测试', '2016-12-03 14:55:56');

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  KEY `job_id` (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='定时任务日志';

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log` VALUES ('1', '1', 'testTask', 'test', 'renren', '0', null, '1009', '2018-02-25 17:00:00');
INSERT INTO `schedule_job_log` VALUES ('2', '1', 'testTask', 'test', 'renren', '0', null, '1003', '2018-02-25 17:30:00');
INSERT INTO `schedule_job_log` VALUES ('3', '1', 'testTask', 'test', 'renren', '0', null, '1043', '2018-02-26 20:30:00');
INSERT INTO `schedule_job_log` VALUES ('4', '1', 'testTask', 'test', 'renren', '0', null, '1016', '2018-02-26 21:00:00');
INSERT INTO `schedule_job_log` VALUES ('5', '1', 'testTask', 'test', 'renren', '0', null, '1021', '2018-02-27 20:00:00');
INSERT INTO `schedule_job_log` VALUES ('6', '1', 'testTask', 'test', 'renren', '0', null, '1010', '2018-02-27 20:30:00');
INSERT INTO `schedule_job_log` VALUES ('7', '1', 'testTask', 'test', 'renren', '0', null, '1014', '2018-02-27 21:00:00');
INSERT INTO `schedule_job_log` VALUES ('8', '1', 'testTask', 'test', 'renren', '0', null, '1007', '2018-02-27 21:30:00');
INSERT INTO `schedule_job_log` VALUES ('9', '1', 'testTask', 'test', 'renren', '0', null, '1019', '2018-03-01 20:00:00');
INSERT INTO `schedule_job_log` VALUES ('10', '1', 'testTask', 'test', 'renren', '0', null, '1010', '2018-03-04 09:00:00');
INSERT INTO `schedule_job_log` VALUES ('11', '1', 'testTask', 'test', 'renren', '0', null, '1037', '2018-03-04 09:30:00');
INSERT INTO `schedule_job_log` VALUES ('12', '1', 'testTask', 'test', 'renren', '0', null, '1012', '2018-03-04 11:30:00');
INSERT INTO `schedule_job_log` VALUES ('13', '1', 'testTask', 'test', 'renren', '0', null, '1010', '2018-03-04 19:30:00');
INSERT INTO `schedule_job_log` VALUES ('14', '1', 'testTask', 'test', 'renren', '0', null, '1010', '2018-03-07 20:00:00');
INSERT INTO `schedule_job_log` VALUES ('15', '1', 'testTask', 'test', 'renren', '0', null, '1018', '2018-03-07 20:30:00');
INSERT INTO `schedule_job_log` VALUES ('16', '1', 'testTask', 'test', 'renren', '0', null, '1011', '2018-03-07 21:00:00');
INSERT INTO `schedule_job_log` VALUES ('17', '1', 'testTask', 'test', 'renren', '0', null, '1013', '2018-03-07 21:30:00');
INSERT INTO `schedule_job_log` VALUES ('18', '1', 'testTask', 'test', 'renren', '0', null, '1015', '2018-03-17 18:30:00');
INSERT INTO `schedule_job_log` VALUES ('19', '1', 'testTask', 'test', 'renren', '0', null, '1025', '2018-03-19 07:00:00');
INSERT INTO `schedule_job_log` VALUES ('20', '1', 'testTask', 'test', 'renren', '0', null, '1019', '2018-03-19 07:30:00');
INSERT INTO `schedule_job_log` VALUES ('21', '1', 'testTask', 'test', 'renren', '0', null, '1023', '2018-03-19 08:00:00');
INSERT INTO `schedule_job_log` VALUES ('22', '1', 'testTask', 'test', 'renren', '0', null, '1020', '2018-03-22 07:30:00');
INSERT INTO `schedule_job_log` VALUES ('23', '1', 'testTask', 'test', 'renren', '0', null, '1013', '2018-03-22 08:00:00');
INSERT INTO `schedule_job_log` VALUES ('24', '1', 'testTask', 'test', 'renren', '0', null, '1016', '2018-03-22 19:30:00');
INSERT INTO `schedule_job_log` VALUES ('25', '1', 'testTask', 'test', 'renren', '0', null, '1017', '2018-03-22 21:00:00');
INSERT INTO `schedule_job_log` VALUES ('26', '1', 'testTask', 'test', 'renren', '0', null, '1019', '2018-03-22 21:30:00');
INSERT INTO `schedule_job_log` VALUES ('27', '1', 'testTask', 'test', 'renren', '0', null, '1016', '2018-03-23 07:30:00');
INSERT INTO `schedule_job_log` VALUES ('28', '1', 'testTask', 'test', 'renren', '0', null, '1017', '2018-03-24 09:30:00');
INSERT INTO `schedule_job_log` VALUES ('29', '1', 'testTask', 'test', 'renren', '0', null, '1017', '2018-03-24 10:00:00');
INSERT INTO `schedule_job_log` VALUES ('30', '1', 'testTask', 'test', 'renren', '0', null, '1008', '2018-03-24 10:30:00');
INSERT INTO `schedule_job_log` VALUES ('31', '1', 'testTask', 'test', 'renren', '0', null, '1023', '2018-03-24 11:00:00');
INSERT INTO `schedule_job_log` VALUES ('32', '1', 'testTask', 'test', 'renren', '0', null, '1014', '2018-03-24 11:30:00');
INSERT INTO `schedule_job_log` VALUES ('33', '1', 'testTask', 'test', 'renren', '0', null, '1009', '2018-03-24 12:00:00');
INSERT INTO `schedule_job_log` VALUES ('34', '1', 'testTask', 'test', 'renren', '0', null, '1034', '2018-03-24 15:30:00');
INSERT INTO `schedule_job_log` VALUES ('35', '1', 'testTask', 'test', 'renren', '0', null, '1005', '2018-03-24 17:00:00');
INSERT INTO `schedule_job_log` VALUES ('36', '1', 'testTask', 'test', 'renren', '0', null, '1018', '2018-03-24 17:30:00');
INSERT INTO `schedule_job_log` VALUES ('37', '1', 'testTask', 'test', 'renren', '0', null, '1016', '2018-03-25 08:30:00');
INSERT INTO `schedule_job_log` VALUES ('38', '1', 'testTask', 'test', 'renren', '0', null, '1000', '2018-03-25 15:30:00');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', '0', '云存储配置信息');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"字典管理\",\"url\":\"modules/sys/hdic.html\",\"perms\":\"hdic:list,hdic:save,hdic:update,hdic:delete\",\"type\":1,\"icon\":\"fa fa-book\",\"orderNum\":8}', '7', '0:0:0:0:0:0:0:1', '2018-02-25 16:57:55');
INSERT INTO `sys_log` VALUES ('2', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":31,\"parentName\":\"字典管理\",\"name\":\"新增\",\"perms\":\"hdic:list,hdic:save\",\"type\":2,\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2018-02-25 17:00:31');
INSERT INTO `sys_log` VALUES ('3', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":31,\"parentName\":\"字典管理\",\"name\":\"修改\",\"perms\":\"hdic:update\",\"type\":2,\"orderNum\":0}', '7', '0:0:0:0:0:0:0:1', '2018-02-26 20:25:37');
INSERT INTO `sys_log` VALUES ('4', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":31,\"parentName\":\"字典管理\",\"name\":\"删除\",\"perms\":\"hdic:delete\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-02-26 20:26:07');
INSERT INTO `sys_log` VALUES ('5', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":31,\"parentName\":\"字典管理\",\"name\":\"查看\",\"perms\":\"hdic:list\",\"type\":2,\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2018-02-26 20:28:34');
INSERT INTO `sys_log` VALUES ('6', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":32,\"parentId\":31,\"parentName\":\"字典管理\",\"name\":\"新增\",\"perms\":\"hdic:save\",\"type\":2,\"orderNum\":0}', '6', '0:0:0:0:0:0:0:1', '2018-02-26 20:28:52');
INSERT INTO `sys_log` VALUES ('7', 'admin', '保存角色', 'io.renren.modules.sys.controller.SysRoleController.save()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,32,33,34,35],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '74', '0:0:0:0:0:0:0:1', '2018-02-27 20:20:38');
INSERT INTO `sys_log` VALUES ('8', 'admin', '修改用户', 'io.renren.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@renren.io\",\"mobile\":\"13612345678\",\"status\":1,\"roleIdList\":[1],\"createUserId\":1,\"createTime\":\"Nov 11, 2016 11:11:11 AM\"}', '23', '0:0:0:0:0:0:0:1', '2018-02-27 20:20:46');
INSERT INTO `sys_log` VALUES ('9', 'admin', '保存用户', 'io.renren.modules.sys.controller.SysUserController.save()', '{\"userId\":2,\"username\":\"test\",\"password\":\"2224deb1bb2c021da15d0e2b1cd45c943b0609ab658fb127dc531e97d0d42ca1\",\"salt\":\"Jo9n3mR72ROmZqjsleLn\",\"email\":\"123456@qq.com\",\"mobile\":\"18986718488\",\"status\":1,\"roleIdList\":[1],\"createUserId\":1,\"createTime\":\"Feb 27, 2018 8:26:16 PM\"}', '60', '0:0:0:0:0:0:0:1', '2018-02-27 20:26:16');
INSERT INTO `sys_log` VALUES ('10', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,33,34,35],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '10', '0:0:0:0:0:0:0:1', '2018-02-27 21:10:43');
INSERT INTO `sys_log` VALUES ('11', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,10,11,12,13,14,27,30,29,31,33,34,35],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '46', '0:0:0:0:0:0:0:1', '2018-02-27 21:17:47');
INSERT INTO `sys_log` VALUES ('12', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,33,34,35],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '14', '0:0:0:0:0:0:0:1', '2018-02-27 21:18:31');
INSERT INTO `sys_log` VALUES ('13', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":35,\"parentId\":31,\"parentName\":\"字典管理\",\"name\":\"查看\",\"perms\":\"hdic:list,hdic:info\",\"type\":2,\"orderNum\":0}', '6', '0:0:0:0:0:0:0:1', '2018-02-27 21:20:28');
INSERT INTO `sys_log` VALUES ('14', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,32,33,34,35],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '7', '0:0:0:0:0:0:0:1', '2018-02-27 21:20:51');
INSERT INTO `sys_log` VALUES ('15', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,32,33,34,35],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '7', '0:0:0:0:0:0:0:1', '2018-02-27 21:21:23');
INSERT INTO `sys_log` VALUES ('16', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,32,33,35],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '8', '0:0:0:0:0:0:0:1', '2018-02-27 21:23:17');
INSERT INTO `sys_log` VALUES ('17', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":31,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"字典管理\",\"url\":\"modules/sys/hdic.html\",\"perms\":\"\",\"type\":1,\"icon\":\"fa fa-book\",\"orderNum\":8}', '3', '0:0:0:0:0:0:0:1', '2018-02-27 21:27:32');
INSERT INTO `sys_log` VALUES ('18', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,32,33,34,35],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '6', '0:0:0:0:0:0:0:1', '2018-02-27 21:28:08');
INSERT INTO `sys_log` VALUES ('19', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"字典类型管理\",\"url\":\"modules/sys/hdictype.html\",\"type\":1,\"icon\":\"fa fa-book\",\"orderNum\":9}', '8', '0:0:0:0:0:0:0:1', '2018-03-01 19:56:59');
INSERT INTO `sys_log` VALUES ('20', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":36,\"parentName\":\"字典类型管理\",\"name\":\"新增\",\"perms\":\"hdictype:list,hdictype:save\",\"type\":2,\"orderNum\":0}', '3', '0:0:0:0:0:0:0:1', '2018-03-01 19:58:09');
INSERT INTO `sys_log` VALUES ('21', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":36,\"parentName\":\"字典类型管理\",\"name\":\"查看\",\"perms\":\"hdictype:info\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-01 19:58:41');
INSERT INTO `sys_log` VALUES ('22', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":37,\"parentId\":36,\"parentName\":\"字典类型管理\",\"name\":\"新增\",\"perms\":\"hdictype:save\",\"type\":2,\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2018-03-01 19:59:10');
INSERT INTO `sys_log` VALUES ('23', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":36,\"parentName\":\"字典类型管理\",\"name\":\"修改\",\"perms\":\"hdictype:list,hdictype:update\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-01 20:00:10');
INSERT INTO `sys_log` VALUES ('24', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":39,\"parentId\":36,\"parentName\":\"字典类型管理\",\"name\":\"修改\",\"perms\":\"hdictype:update,hdictype:info\",\"type\":2,\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2018-03-01 20:01:05');
INSERT INTO `sys_log` VALUES ('25', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":36,\"parentName\":\"字典类型管理\",\"name\":\"查看\",\"perms\":\"hdictype:list,hdictype:info\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-01 20:01:42');
INSERT INTO `sys_log` VALUES ('26', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":33,\"parentId\":31,\"parentName\":\"字典管理\",\"name\":\"修改\",\"perms\":\"hdic:update,hdic:info\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-01 20:02:11');
INSERT INTO `sys_log` VALUES ('27', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":33,\"parentId\":31,\"parentName\":\"字典管理\",\"name\":\"修改\",\"perms\":\"hdic:update\",\"type\":2,\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2018-03-01 20:02:37');
INSERT INTO `sys_log` VALUES ('28', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":40,\"parentId\":36,\"parentName\":\"字典类型管理\",\"name\":\"查看\",\"perms\":\"hdictype:delete\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-01 20:02:52');
INSERT INTO `sys_log` VALUES ('29', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":39,\"parentId\":36,\"parentName\":\"字典类型管理\",\"name\":\"修改\",\"perms\":\"hdictype:update\",\"type\":2,\"orderNum\":0}', '6', '0:0:0:0:0:0:0:1', '2018-03-01 20:03:09');
INSERT INTO `sys_log` VALUES ('30', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":38,\"parentId\":36,\"parentName\":\"字典类型管理\",\"name\":\"查看\",\"perms\":\"hdictype:info,hdictype:list\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-01 20:03:32');
INSERT INTO `sys_log` VALUES ('31', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":40,\"parentId\":36,\"parentName\":\"字典类型管理\",\"name\":\"删除\",\"perms\":\"hdictype:delete\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-01 20:03:43');
INSERT INTO `sys_log` VALUES ('32', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,32,33,34,35,36,37,38,39,40],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '76', '0:0:0:0:0:0:0:1', '2018-03-01 20:04:09');
INSERT INTO `sys_log` VALUES ('33', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"酒店库存管理\",\"type\":0,\"icon\":\"fas fa-home\",\"orderNum\":1}', '6', '0:0:0:0:0:0:0:1', '2018-03-04 09:12:14');
INSERT INTO `sys_log` VALUES ('34', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":41,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"酒店库存管理\",\"type\":0,\"icon\":\"fa fa-home\",\"orderNum\":1}', '5', '0:0:0:0:0:0:0:1', '2018-03-04 09:12:23');
INSERT INTO `sys_log` VALUES ('35', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,32,33,34,35,36,37,38,39,40,41],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '79', '0:0:0:0:0:0:0:1', '2018-03-04 09:12:46');
INSERT INTO `sys_log` VALUES ('36', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":41,\"parentName\":\"酒店库存管理\",\"name\":\"物品种类管理\",\"url\":\"modules/stock/hgoods.html\",\"type\":1,\"icon\":\"fa fa-archive\",\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-04 09:22:34');
INSERT INTO `sys_log` VALUES ('37', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,32,33,34,35,36,37,38,39,40,41,42],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '9', '0:0:0:0:0:0:0:1', '2018-03-04 09:22:53');
INSERT INTO `sys_log` VALUES ('38', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":42,\"parentId\":41,\"parentName\":\"酒店库存管理\",\"name\":\"物品种类管理\",\"url\":\"modules/stock/hgoods.html\",\"type\":1,\"icon\":\"fa fa-archive\",\"orderNum\":0}', '6', '0:0:0:0:0:0:0:1', '2018-03-04 09:23:27');
INSERT INTO `sys_log` VALUES ('39', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":42,\"parentName\":\"物品种类管理\",\"name\":\"查看\",\"perms\":\"hgoods:info\",\"type\":2,\"orderNum\":0}', '7', '0:0:0:0:0:0:0:1', '2018-03-04 09:39:02');
INSERT INTO `sys_log` VALUES ('40', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":43,\"parentId\":42,\"parentName\":\"物品种类管理\",\"name\":\"查看\",\"perms\":\"hgoods:info,hgoods:list\",\"type\":2,\"orderNum\":0}', '6', '0:0:0:0:0:0:0:1', '2018-03-04 09:39:30');
INSERT INTO `sys_log` VALUES ('41', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":42,\"parentName\":\"物品种类管理\",\"name\":\"新增\",\"perms\":\"hgoods:save\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-04 09:40:02');
INSERT INTO `sys_log` VALUES ('42', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":42,\"parentName\":\"物品种类管理\",\"name\":\"修改\",\"perms\":\"hgoods:update\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-04 09:40:22');
INSERT INTO `sys_log` VALUES ('43', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":42,\"parentName\":\"物品种类管理\",\"name\":\"删除\",\"perms\":\"hgoods:delete\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-04 09:40:40');
INSERT INTO `sys_log` VALUES ('44', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '50', '0:0:0:0:0:0:0:1', '2018-03-04 09:40:51');
INSERT INTO `sys_log` VALUES ('45', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":41,\"parentName\":\"酒店库存管理\",\"name\":\"厅房管理\",\"url\":\"modules/stock/hroom.html\",\"type\":1,\"icon\":\"fa fa-building\",\"orderNum\":1}', '9', '0:0:0:0:0:0:0:1', '2018-03-07 20:01:14');
INSERT INTO `sys_log` VALUES ('46', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '77', '0:0:0:0:0:0:0:1', '2018-03-07 20:02:04');
INSERT INTO `sys_log` VALUES ('47', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":47,\"parentName\":\"厅房管理\",\"name\":\"新增\",\"perms\":\"hgoods:save\",\"type\":2,\"orderNum\":0}', '7', '0:0:0:0:0:0:0:1', '2018-03-07 20:05:46');
INSERT INTO `sys_log` VALUES ('48', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":47,\"parentName\":\"厅房管理\",\"name\":\"查看\",\"perms\":\"hgoods:info,hgoods:list\",\"type\":2,\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2018-03-07 20:06:06');
INSERT INTO `sys_log` VALUES ('49', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":47,\"parentName\":\"厅房管理\",\"name\":\"修改\",\"perms\":\"hgoods:update\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-07 20:06:23');
INSERT INTO `sys_log` VALUES ('50', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":47,\"parentName\":\"厅房管理\",\"name\":\"删除\",\"perms\":\"hgoods:delete\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-07 20:06:38');
INSERT INTO `sys_log` VALUES ('51', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '52', '0:0:0:0:0:0:0:1', '2018-03-07 20:06:51');
INSERT INTO `sys_log` VALUES ('52', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":48,\"parentId\":47,\"parentName\":\"厅房管理\",\"name\":\"新增\",\"perms\":\"hroom:save\",\"type\":2,\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2018-03-07 20:10:11');
INSERT INTO `sys_log` VALUES ('53', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":49,\"parentId\":47,\"parentName\":\"厅房管理\",\"name\":\"查看\",\"perms\":\"hroom:info,hroom:list\",\"type\":2,\"orderNum\":0}', '3', '0:0:0:0:0:0:0:1', '2018-03-07 20:10:27');
INSERT INTO `sys_log` VALUES ('54', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":50,\"parentId\":47,\"parentName\":\"厅房管理\",\"name\":\"修改\",\"perms\":\"hroom:update\",\"type\":2,\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2018-03-07 20:10:38');
INSERT INTO `sys_log` VALUES ('55', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":51,\"parentId\":47,\"parentName\":\"厅房管理\",\"name\":\"删除\",\"perms\":\"hroom:delete\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-07 20:10:50');
INSERT INTO `sys_log` VALUES ('56', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":41,\"parentName\":\"酒店库存管理\",\"name\":\"物品单位管理\",\"url\":\"modules/stock/hgoodsunit.html\",\"perms\":\"hgoodsunit:info,hgoodsunit:List\",\"type\":1,\"icon\":\"查看\",\"orderNum\":0}', '8', '0:0:0:0:0:0:0:1', '2018-03-19 07:44:13');
INSERT INTO `sys_log` VALUES ('57', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":52,\"parentId\":41,\"parentName\":\"酒店库存管理\",\"name\":\"物品单位管理\",\"url\":\"modules/stock/hgoodsunit.html\",\"perms\":\"\",\"type\":1,\"icon\":\"fa fa-sort-numeric-down\",\"orderNum\":0}', '7', '0:0:0:0:0:0:0:1', '2018-03-19 07:47:38');
INSERT INTO `sys_log` VALUES ('58', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":52,\"parentId\":41,\"parentName\":\"酒店库存管理\",\"name\":\"物品单位管理\",\"url\":\"modules/stock/hgoodsunit.html\",\"perms\":\"\",\"type\":1,\"icon\":\"fa fa-balance-scale\",\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-19 07:51:46');
INSERT INTO `sys_log` VALUES ('59', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":52,\"parentId\":52,\"parentName\":\"物品单位管理\",\"name\":\"新增\",\"url\":\"modules/stock/hgoodsunit.html\",\"perms\":\"hgoodsunit:save\",\"type\":2,\"icon\":\"fa fa-balance-scale\",\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-19 07:53:28');
INSERT INTO `sys_log` VALUES ('60', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":52,\"parentId\":41,\"parentName\":\"酒店库存管理\",\"name\":\"物品单位管理\",\"url\":\"modules/stock/hgoodsunit.html\",\"perms\":\"\",\"type\":1,\"icon\":\"fa fa-balance-scale\",\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-19 07:54:22');
INSERT INTO `sys_log` VALUES ('61', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":52,\"parentName\":\"物品单位管理\",\"name\":\"新增\",\"perms\":\"hgoodsunit:save\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-19 07:54:39');
INSERT INTO `sys_log` VALUES ('62', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":52,\"parentName\":\"物品单位管理\",\"name\":\"查看\",\"perms\":\"hgoodsunit:save\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-19 07:57:19');
INSERT INTO `sys_log` VALUES ('63', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":54,\"parentId\":52,\"parentName\":\"物品单位管理\",\"name\":\"查看\",\"perms\":\"hgoodsunit:list,hgoodsunit:info\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-19 07:57:33');
INSERT INTO `sys_log` VALUES ('64', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":52,\"parentName\":\"物品单位管理\",\"name\":\"删除\",\"perms\":\"hgoodsunit:delete\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-19 07:58:08');
INSERT INTO `sys_log` VALUES ('65', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":52,\"parentName\":\"物品单位管理\",\"name\":\"更新\",\"perms\":\"hgoodsunit:update\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-19 08:00:44');
INSERT INTO `sys_log` VALUES ('66', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,52,53,54,55,56,47,48,49,50,51],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '74', '0:0:0:0:0:0:0:1', '2018-03-22 07:28:35');
INSERT INTO `sys_log` VALUES ('67', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":41,\"parentName\":\"酒店库存管理\",\"name\":\"库存维护查询\",\"url\":\"modules/stock/hgoodsstock.html\",\"type\":1,\"icon\":\"fa fa-database\",\"orderNum\":0}', '6', '0:0:0:0:0:0:0:1', '2018-03-24 10:50:42');
INSERT INTO `sys_log` VALUES ('68', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,52,53,54,55,56,57,47,48,49,50,51],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '92', '0:0:0:0:0:0:0:1', '2018-03-24 10:50:59');
INSERT INTO `sys_log` VALUES ('69', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":57,\"parentName\":\"库存维护查询\",\"name\":\"查询\",\"perms\":\"hgoodsstock:list,hgoodsstock:info\",\"type\":2,\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2018-03-24 10:52:07');
INSERT INTO `sys_log` VALUES ('70', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":57,\"parentName\":\"库存维护查询\",\"name\":\"新增\",\"perms\":\"hgoodsstock:save\",\"type\":2,\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2018-03-24 10:52:30');
INSERT INTO `sys_log` VALUES ('71', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":57,\"parentName\":\"库存维护查询\",\"name\":\"修改\",\"perms\":\"hgoodsstock:update\",\"type\":2,\"orderNum\":0}', '4', '0:0:0:0:0:0:0:1', '2018-03-24 10:52:51');
INSERT INTO `sys_log` VALUES ('72', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":57,\"parentName\":\"库存维护查询\",\"name\":\"删除\",\"perms\":\"hgoodsstock:delete\",\"type\":2,\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2018-03-24 10:53:07');
INSERT INTO `sys_log` VALUES ('73', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,52,53,54,55,56,57,58,59,60,61,47,48,49,50,51],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '11', '0:0:0:0:0:0:0:1', '2018-03-24 10:53:48');
INSERT INTO `sys_log` VALUES ('74', 'test', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":41,\"parentName\":\"酒店库存管理\",\"name\":\"进出货物管理\",\"url\":\"modules/stock/hgoodsstock.html\",\"type\":1,\"icon\":\" \",\"orderNum\":0}', '6', '0:0:0:0:0:0:0:1', '2018-03-24 15:39:04');
INSERT INTO `sys_log` VALUES ('75', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":62,\"parentId\":41,\"parentName\":\"酒店库存管理\",\"name\":\"进出货物管理\",\"url\":\"modules/stock/hgoodsstock.html\",\"type\":1,\"icon\":\" fa fa-exchange-alt\",\"orderNum\":0}', '13', '0:0:0:0:0:0:0:1', '2018-03-24 17:05:12');
INSERT INTO `sys_log` VALUES ('76', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":62,\"parentId\":41,\"parentName\":\"酒店库存管理\",\"name\":\"进出货物管理\",\"url\":\"modules/stock/hgoodsstock.html\",\"type\":1,\"icon\":\"fa fa-exchange\",\"orderNum\":0}', '12', '0:0:0:0:0:0:0:1', '2018-03-24 17:09:25');
INSERT INTO `sys_log` VALUES ('77', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":62,\"parentName\":\"进出货物管理\",\"name\":\"查看\",\"perms\":\"hstockflow:list,hstockflow:info\",\"type\":2,\"orderNum\":0}', '6', '0:0:0:0:0:0:0:1', '2018-03-24 17:24:12');
INSERT INTO `sys_log` VALUES ('78', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":62,\"parentName\":\"进出货物管理\",\"name\":\"新增\",\"perms\":\"hstockflow:save\",\"type\":2,\"orderNum\":0}', '3', '0:0:0:0:0:0:0:1', '2018-03-24 17:24:34');
INSERT INTO `sys_log` VALUES ('79', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":62,\"parentName\":\"进出货物管理\",\"name\":\"修改\",\"perms\":\"hstockflow:update\",\"type\":2,\"orderNum\":0}', '3', '0:0:0:0:0:0:0:1', '2018-03-24 17:25:10');
INSERT INTO `sys_log` VALUES ('80', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":62,\"parentName\":\"进出货物管理\",\"name\":\"删除\",\"perms\":\"hstockflow:delete\",\"type\":2,\"orderNum\":0}', '15', '0:0:0:0:0:0:0:1', '2018-03-24 17:25:35');
INSERT INTO `sys_log` VALUES ('81', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"remark\":\"具备所有权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,52,53,54,55,56,57,58,59,60,61,62,63,64,65,47,48,49,50,51],\"createTime\":\"Feb 27, 2018 8:20:38 PM\"}', '60', '0:0:0:0:0:0:0:1', '2018-03-24 17:26:06');
INSERT INTO `sys_log` VALUES ('82', 'test', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":62,\"parentId\":41,\"parentName\":\"酒店库存管理\",\"name\":\"进出货物管理\",\"url\":\"modules/stock/hstockflow.html\",\"type\":1,\"icon\":\"fa fa-exchange\",\"orderNum\":0}', '11', '0:0:0:0:0:0:0:1', '2018-03-24 17:26:56');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'fa fa-cog', '0');
INSERT INTO `sys_menu` VALUES ('2', '1', '管理员列表', 'modules/sys/user.html', null, '1', 'fa fa-user', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'modules/sys/role.html', null, '1', 'fa fa-user-secret', '2');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'modules/sys/menu.html', null, '1', 'fa fa-th-list', '3');
INSERT INTO `sys_menu` VALUES ('5', '1', 'SQL监控', 'druid/sql.html', null, '1', 'fa fa-bug', '4');
INSERT INTO `sys_menu` VALUES ('6', '1', '定时任务', 'modules/job/schedule.html', null, '1', 'fa fa-tasks', '5');
INSERT INTO `sys_menu` VALUES ('7', '6', '查看', null, 'sys:schedule:list,sys:schedule:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('8', '6', '新增', null, 'sys:schedule:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('9', '6', '修改', null, 'sys:schedule:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('10', '6', '删除', null, 'sys:schedule:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('11', '6', '暂停', null, 'sys:schedule:pause', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('12', '6', '恢复', null, 'sys:schedule:resume', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('13', '6', '立即执行', null, 'sys:schedule:run', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('14', '6', '日志列表', null, 'sys:schedule:log', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('27', '1', '参数管理', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6');
INSERT INTO `sys_menu` VALUES ('29', '1', '系统日志', 'modules/sys/log.html', 'sys:log:list', '1', 'fa fa-file-text-o', '7');
INSERT INTO `sys_menu` VALUES ('30', '1', '文件上传', 'modules/oss/oss.html', 'sys:oss:all', '1', 'fa fa-file-image-o', '6');
INSERT INTO `sys_menu` VALUES ('31', '1', '字典管理', 'modules/sys/hdic.html', '', '1', 'fa fa-book', '8');
INSERT INTO `sys_menu` VALUES ('32', '31', '新增', null, 'hdic:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('33', '31', '修改', null, 'hdic:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('34', '31', '删除', null, 'hdic:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('35', '31', '查看', null, 'hdic:list,hdic:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('36', '1', '字典类型管理', 'modules/sys/hdictype.html', null, '1', 'fa fa-book', '9');
INSERT INTO `sys_menu` VALUES ('37', '36', '新增', null, 'hdictype:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('38', '36', '查看', null, 'hdictype:info,hdictype:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('39', '36', '修改', null, 'hdictype:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('40', '36', '删除', null, 'hdictype:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('41', '0', '酒店库存管理', null, null, '0', 'fa fa-home', '1');
INSERT INTO `sys_menu` VALUES ('42', '41', '物品种类管理', 'modules/stock/hgoods.html', null, '1', 'fa fa-archive', '0');
INSERT INTO `sys_menu` VALUES ('43', '42', '查看', null, 'hgoods:info,hgoods:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('44', '42', '新增', null, 'hgoods:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('45', '42', '修改', null, 'hgoods:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('46', '42', '删除', null, 'hgoods:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('47', '41', '厅房管理', 'modules/stock/hroom.html', null, '1', 'fa fa-building', '1');
INSERT INTO `sys_menu` VALUES ('48', '47', '新增', null, 'hroom:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('49', '47', '查看', null, 'hroom:info,hroom:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('50', '47', '修改', null, 'hroom:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('51', '47', '删除', null, 'hroom:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('52', '41', '物品单位管理', 'modules/stock/hgoodsunit.html', '', '1', 'fa fa-balance-scale', '0');
INSERT INTO `sys_menu` VALUES ('53', '52', '新增', null, 'hgoodsunit:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('54', '52', '查看', null, 'hgoodsunit:list,hgoodsunit:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('55', '52', '删除', null, 'hgoodsunit:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('56', '52', '更新', null, 'hgoodsunit:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('57', '41', '库存维护查询', 'modules/stock/hgoodsstock.html', null, '1', 'fa fa-database', '0');
INSERT INTO `sys_menu` VALUES ('58', '57', '查询', null, 'hgoodsstock:list,hgoodsstock:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('59', '57', '新增', null, 'hgoodsstock:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('60', '57', '修改', null, 'hgoodsstock:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('61', '57', '删除', null, 'hgoodsstock:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('62', '41', '进出货物管理', 'modules/stock/hstockflow.html', null, '1', 'fa fa-exchange', '0');
INSERT INTO `sys_menu` VALUES ('63', '62', '查看', null, 'hstockflow:list,hstockflow:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('64', '62', '新增', null, 'hstockflow:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('65', '62', '修改', null, 'hstockflow:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('66', '62', '删除', null, 'hstockflow:delete', '2', null, '0');

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件上传';

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '具备所有权限', '1', '2018-02-27 20:20:38');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=763 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('699', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('700', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('701', '1', '15');
INSERT INTO `sys_role_menu` VALUES ('702', '1', '16');
INSERT INTO `sys_role_menu` VALUES ('703', '1', '17');
INSERT INTO `sys_role_menu` VALUES ('704', '1', '18');
INSERT INTO `sys_role_menu` VALUES ('705', '1', '3');
INSERT INTO `sys_role_menu` VALUES ('706', '1', '19');
INSERT INTO `sys_role_menu` VALUES ('707', '1', '20');
INSERT INTO `sys_role_menu` VALUES ('708', '1', '21');
INSERT INTO `sys_role_menu` VALUES ('709', '1', '22');
INSERT INTO `sys_role_menu` VALUES ('710', '1', '4');
INSERT INTO `sys_role_menu` VALUES ('711', '1', '23');
INSERT INTO `sys_role_menu` VALUES ('712', '1', '24');
INSERT INTO `sys_role_menu` VALUES ('713', '1', '25');
INSERT INTO `sys_role_menu` VALUES ('714', '1', '26');
INSERT INTO `sys_role_menu` VALUES ('715', '1', '5');
INSERT INTO `sys_role_menu` VALUES ('716', '1', '6');
INSERT INTO `sys_role_menu` VALUES ('717', '1', '7');
INSERT INTO `sys_role_menu` VALUES ('718', '1', '8');
INSERT INTO `sys_role_menu` VALUES ('719', '1', '9');
INSERT INTO `sys_role_menu` VALUES ('720', '1', '10');
INSERT INTO `sys_role_menu` VALUES ('721', '1', '11');
INSERT INTO `sys_role_menu` VALUES ('722', '1', '12');
INSERT INTO `sys_role_menu` VALUES ('723', '1', '13');
INSERT INTO `sys_role_menu` VALUES ('724', '1', '14');
INSERT INTO `sys_role_menu` VALUES ('725', '1', '27');
INSERT INTO `sys_role_menu` VALUES ('726', '1', '30');
INSERT INTO `sys_role_menu` VALUES ('727', '1', '29');
INSERT INTO `sys_role_menu` VALUES ('728', '1', '31');
INSERT INTO `sys_role_menu` VALUES ('729', '1', '32');
INSERT INTO `sys_role_menu` VALUES ('730', '1', '33');
INSERT INTO `sys_role_menu` VALUES ('731', '1', '34');
INSERT INTO `sys_role_menu` VALUES ('732', '1', '35');
INSERT INTO `sys_role_menu` VALUES ('733', '1', '36');
INSERT INTO `sys_role_menu` VALUES ('734', '1', '37');
INSERT INTO `sys_role_menu` VALUES ('735', '1', '38');
INSERT INTO `sys_role_menu` VALUES ('736', '1', '39');
INSERT INTO `sys_role_menu` VALUES ('737', '1', '40');
INSERT INTO `sys_role_menu` VALUES ('738', '1', '41');
INSERT INTO `sys_role_menu` VALUES ('739', '1', '42');
INSERT INTO `sys_role_menu` VALUES ('740', '1', '43');
INSERT INTO `sys_role_menu` VALUES ('741', '1', '44');
INSERT INTO `sys_role_menu` VALUES ('742', '1', '45');
INSERT INTO `sys_role_menu` VALUES ('743', '1', '46');
INSERT INTO `sys_role_menu` VALUES ('744', '1', '52');
INSERT INTO `sys_role_menu` VALUES ('745', '1', '53');
INSERT INTO `sys_role_menu` VALUES ('746', '1', '54');
INSERT INTO `sys_role_menu` VALUES ('747', '1', '55');
INSERT INTO `sys_role_menu` VALUES ('748', '1', '56');
INSERT INTO `sys_role_menu` VALUES ('749', '1', '57');
INSERT INTO `sys_role_menu` VALUES ('750', '1', '58');
INSERT INTO `sys_role_menu` VALUES ('751', '1', '59');
INSERT INTO `sys_role_menu` VALUES ('752', '1', '60');
INSERT INTO `sys_role_menu` VALUES ('753', '1', '61');
INSERT INTO `sys_role_menu` VALUES ('754', '1', '62');
INSERT INTO `sys_role_menu` VALUES ('755', '1', '63');
INSERT INTO `sys_role_menu` VALUES ('756', '1', '64');
INSERT INTO `sys_role_menu` VALUES ('757', '1', '65');
INSERT INTO `sys_role_menu` VALUES ('758', '1', '47');
INSERT INTO `sys_role_menu` VALUES ('759', '1', '48');
INSERT INTO `sys_role_menu` VALUES ('760', '1', '49');
INSERT INTO `sys_role_menu` VALUES ('761', '1', '50');
INSERT INTO `sys_role_menu` VALUES ('762', '1', '51');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', '1', '1', '2016-11-11 11:11:11');
INSERT INTO `sys_user` VALUES ('2', 'test', '2224deb1bb2c021da15d0e2b1cd45c943b0609ab658fb127dc531e97d0d42ca1', 'Jo9n3mR72ROmZqjsleLn', '123456@qq.com', '18986718488', '1', '1', '2018-02-27 20:26:16');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2', '1');

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户Token';

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES ('1', '6d895e249c2ba81221bee351c094e437', '2018-03-25 05:27:04', '2018-03-24 17:27:04');
INSERT INTO `sys_user_token` VALUES ('2', '74181dfa7ed95dbd075243b5b2692937', '2018-03-26 03:34:57', '2018-03-25 15:34:57');

-- ----------------------------
-- Table structure for tb_token
-- ----------------------------
DROP TABLE IF EXISTS `tb_token`;
CREATE TABLE `tb_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';

-- ----------------------------
-- Records of tb_token
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');
