/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : live

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-22 17:21:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for anchor
-- ----------------------------
DROP TABLE IF EXISTS `anchor`;
CREATE TABLE `anchor` (
  `userId` int(11) NOT NULL COMMENT '主播id==用户id',
  `anchorCategory` varchar(20) DEFAULT NULL COMMENT '主播类别：分为组织，学院，学生，教师等等',
  `playTime` int(11) DEFAULT NULL COMMENT '播放总时长',
  `totalUpvoteNum` int(11) DEFAULT NULL COMMENT '总共被点赞个数',
  `followedNumber` int(11) DEFAULT NULL COMMENT '总共被关注个数',
  `applyAnchorTime` date DEFAULT NULL COMMENT '注册主播时间',
  `totalGiftsNumber` int(11) DEFAULT NULL COMMENT '获得礼物个数',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主播表';

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `userId` int(11) DEFAULT NULL,
  `anchorId` int(11) DEFAULT NULL,
  `followTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关注表(收藏表)';

-- ----------------------------
-- Table structure for live
-- ----------------------------
DROP TABLE IF EXISTS `live`;
CREATE TABLE `live` (
  `liveId` int(11) NOT NULL AUTO_INCREMENT COMMENT '直播id，自增长，主键，',
  `userId` int(11) NOT NULL COMMENT '用户id==主播id 外键',
  `liveName` varchar(20) DEFAULT NULL COMMENT '直播名称',
  `liveDescription` varchar(50) DEFAULT NULL COMMENT '直播描述',
  `liveType` varchar(20) DEFAULT NULL COMMENT '直播类型：体育，娱乐，官方',
  `livePwd` varchar(50) DEFAULT NULL COMMENT '直播密码',
  `liveStartTime` datetime DEFAULT NULL COMMENT '直播开始时间',
  `liveEndTime` date DEFAULT NULL COMMENT '直播结束时间',
  `audienceNum` int(11) DEFAULT NULL COMMENT '当前观众个数',
  `upvoteNum` int(11) DEFAULT NULL COMMENT '当前点赞个数',
  `giftNum` int(11) DEFAULT NULL COMMENT '当前礼物个数',
  `screenShot` varchar(50) DEFAULT NULL COMMENT '最新截图地址',
  `liveUrl` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`liveId`),
  UNIQUE KEY `live_liveId_uindex` (`liveId`),
  KEY `live_anchor_userId_fk` (`userId`),
  CONSTRAINT `live_anchor_userId_fk` FOREIGN KEY (`userId`) REFERENCES `anchor` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='直播表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `organizationName` varchar(50) DEFAULT NULL COMMENT '组织名称',
  `number` int(11) DEFAULT NULL COMMENT '学号或者编号',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `college` varchar(50) DEFAULT NULL COMMENT '学院',
  `nickName` varchar(50) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(50) DEFAULT NULL COMMENT '头像',
  `signature` varchar(100) DEFAULT NULL COMMENT '个性签名',
  `phoneNumber` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `whetherAnchor` int(11) DEFAULT NULL COMMENT '是否主播',
  `followNumber` int(11) DEFAULT NULL COMMENT '关注个数',
  `registrationTime` date DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `User_userId_uindex` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for view
-- ----------------------------
DROP TABLE IF EXISTS `view`;
CREATE TABLE `view` (
  `liveId` int(11) DEFAULT NULL COMMENT '直播id',
  `userId` int(11) DEFAULT NULL COMMENT '主播id==用户id',
  `viewDuration` int(11) DEFAULT NULL COMMENT '观看时长',
  `userUpvoteNum` int(11) DEFAULT NULL COMMENT '用户点赞个数',
  `sendGiftNum` int(11) DEFAULT NULL COMMENT '送礼物个数',
  `viewTime` date DEFAULT NULL COMMENT '开始观看时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='观看表';
