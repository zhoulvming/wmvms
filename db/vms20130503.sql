/*
Navicat MySQL Data Transfer

Source Server         : vms_local
Source Server Version : 50511
Source Host           : localhost:3306
Source Database       : vms

Target Server Type    : MYSQL
Target Server Version : 50511
File Encoding         : 65001

Date: 2013-05-03 15:37:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `apply`
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply` (
  `ID` char(75) NOT NULL,
  `SerialID` varchar(50) DEFAULT NULL,
  `ApplyType` int(11) DEFAULT NULL,
  `TaskID` int(11) DEFAULT NULL,
  `Applykind` int(11) DEFAULT NULL,
  `Starttime` varchar(30) DEFAULT NULL,
  `Endtime` varchar(30) DEFAULT NULL,
  `DestType` int(11) DEFAULT NULL,
  `Destination` varchar(80) DEFAULT NULL,
  `UsualAddrID` int(11) DEFAULT NULL,
  `StartAddre` varchar(80) DEFAULT NULL,
  `IsReturn` int(11) DEFAULT NULL,
  `ContactPerson` varchar(20) DEFAULT NULL,
  `ContactMobile` float DEFAULT NULL,
  `Addition` varchar(140) DEFAULT NULL,
  `Buildtime` int(11) DEFAULT NULL,
  `Modifytime` int(11) DEFAULT NULL,
  `ModifierID` int(11) DEFAULT NULL,
  `ApplierID` int(11) DEFAULT NULL,
  `Status` int(11) DEFAULT NULL,
  `DealpersonID` int(11) DEFAULT NULL,
  `AssignedDriverID` int(11) DEFAULT NULL,
  `CouserID` int(11) DEFAULT NULL,
  `Appstatus` int(11) DEFAULT NULL,
  `Apptype` int(11) DEFAULT NULL,
  `CarTypeID` int(11) DEFAULT NULL,
  `Isover` int(11) DEFAULT NULL,
  `Changeable` int(11) DEFAULT NULL,
  `Realpeoplenum` int(11) DEFAULT NULL,
  `IsUnion` int(11) DEFAULT NULL,
  `IsOutProvince` int(11) DEFAULT NULL,
  `AssignedCarID` int(11) DEFAULT NULL,
  `PassAddr` varchar(280) DEFAULT NULL,
  `IsDelayed` int(11) DEFAULT NULL,
  `DelayToTime` int(11) DEFAULT NULL,
  `IsValid` int(11) DEFAULT NULL,
  `DealType` int(11) DEFAULT NULL,
  `IsDocument` int(11) DEFAULT NULL,
  `Reason` varchar(50) DEFAULT NULL,
  `DepartMentID` char(75) DEFAULT NULL,
  `IsLock` int(11) DEFAULT NULL,
  `locktime` datetime DEFAULT NULL,
  `IsAlreadyDel` int(11) DEFAULT NULL,
  `creatorId` char(36) DEFAULT NULL,
  `creatorCode` varchar(75) DEFAULT NULL,
  `createTime` datetime DEFAULT '1901-01-01 00:00:00',
  `updatorId` char(36) DEFAULT NULL,
  `updatorCode` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT '1901-01-01 00:00:00',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apply
-- ----------------------------
INSERT INTO `apply` VALUES ('1', '20130416-001', '1', '1', '1', '2013-04-30 09:30', '2013-04-30 11:30', '1', '康城', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '备注1111', '38878a96-2971-4eea-8143-bba89a9cbd56', '1', '1901-01-01 00:00:00', '1', '1', '张三', '2013-01-01 10:00:00', '1', '1', '1901-01-01 00:00:00', '0');
INSERT INTO `apply` VALUES ('2', '20130418-001', '1', '1', '1', '2013-04-29 09:30', '2013-04-29 12:30', '1', '康城', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '2', '1', '1', '1', '1', '1', '1', '备注2222', '38878a96-2971-4eea-8143-bba89a9cbd56', '1', '1901-01-01 00:00:00', '1', '1', '李四', '2013-02-01 09:00:00', '1', '1', '1901-01-01 00:00:00', '0');

-- ----------------------------
-- Table structure for `assign`
-- ----------------------------
DROP TABLE IF EXISTS `assign`;
CREATE TABLE `assign` (
  `ID` char(75) NOT NULL,
  `SerialID` varchar(50) DEFAULT NULL,
  `AssignPlaceID` int(11) DEFAULT NULL,
  `ApplyID` char(75) DEFAULT NULL,
  `TaskID` int(11) DEFAULT NULL,
  `CarID` char(75) DEFAULT NULL,
  `DriverID` char(75) DEFAULT NULL,
  `DriverIDEx` int(11) DEFAULT NULL,
  `Starttime` datetime DEFAULT NULL,
  `Endtime` datetime DEFAULT NULL,
  `Status` int(11) DEFAULT NULL,
  `AssignerID` int(11) DEFAULT NULL,
  `Modifytime` int(11) DEFAULT NULL,
  `modifierID` int(11) DEFAULT NULL,
  `IsDisp` int(11) DEFAULT NULL,
  `CheckStatus` int(11) DEFAULT NULL,
  `CheckContents` varchar(50) DEFAULT NULL,
  `IsConfirm` int(11) DEFAULT NULL,
  `IsFinished` int(11) DEFAULT NULL,
  `IsCombined` int(11) DEFAULT NULL,
  `CombinedID` varchar(100) DEFAULT NULL,
  `AbnormalType` int(11) DEFAULT NULL,
  `AbnormalReason` varchar(50) DEFAULT NULL,
  `IsGroupAssign` int(11) DEFAULT NULL,
  `ObserveContens` varchar(50) DEFAULT NULL,
  `ObserverID` int(11) DEFAULT NULL,
  `IsSingle` int(11) DEFAULT NULL,
  `AssignDealType` int(11) DEFAULT NULL,
  `StartCarTime` datetime DEFAULT NULL,
  `EndCarTime` datetime DEFAULT NULL,
  `UserStatus` int(11) DEFAULT NULL,
  `StartUserTime` datetime DEFAULT NULL,
  `EndUserTime` datetime DEFAULT NULL,
  `StartCarDistance` float DEFAULT NULL,
  `EndCarDistance` float DEFAULT NULL,
  `StartUserDistance` float DEFAULT NULL,
  `EndUserDistance` float DEFAULT NULL,
  `EndCarOverTime` float DEFAULT NULL,
  `EndCarCharge` float DEFAULT NULL,
  `IsDocument` int(11) DEFAULT NULL,
  `IsPrinted` int(11) DEFAULT NULL,
  `CurrentState` int(11) DEFAULT NULL,
  `creatorId` char(36) DEFAULT NULL,
  `creatorCode` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT '1901-01-01 00:00:00',
  `updatorId` char(36) DEFAULT NULL,
  `updatorCode` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT '1901-01-01 00:00:00',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assign
-- ----------------------------
INSERT INTO `assign` VALUES ('4f9dfe9d-80b2-41a0-8bcd-4995c5f2059a', 'PC201305020007', '0', '0', '0', '0', '0', '0', null, null, '1', '0', '0', '0', '0', '0', null, '0', '0', '0', null, '0', null, '0', null, '0', '0', '0', null, null, '0', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', null, null, null, null, null, null, '0');
INSERT INTO `assign` VALUES ('645b9c3a-896c-495c-8ba1-caae313407a4', 'PC201305020003', '0', '0', '0', '0', '0', '0', null, null, '1', '0', '0', '0', '0', '0', null, '0', '0', '0', null, '0', null, '0', null, '0', '0', '0', null, null, '0', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', null, null, null, null, null, null, '0');
INSERT INTO `assign` VALUES ('65f68b57-2ea3-4c9f-bd76-41728c261b21', 'PC201305020008', '0', '0', '0', '0', '0', '0', null, null, '1', '0', '0', '0', '0', '0', null, '0', '0', '0', null, '0', null, '0', null, '0', '0', '0', null, null, '0', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', null, null, null, null, null, null, '0');
INSERT INTO `assign` VALUES ('99dad24e-ea91-423e-9c13-b40ee5586421', 'PC201305020001', '0', '0', '0', '0', '0', '0', null, null, '1', '0', '0', '0', '0', '0', null, '0', '0', '0', null, '0', null, '0', null, '0', '0', '0', null, null, '0', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', null, null, null, null, null, null, '0');
INSERT INTO `assign` VALUES ('9f7af1ab-5f9b-4466-84a4-365b3b36c840', 'PC201305020004', '0', '0', '0', '0', '0', '0', null, null, '1', '0', '0', '0', '0', '0', null, '0', '0', '0', null, '0', null, '0', null, '0', '0', '0', null, null, '0', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', null, null, null, null, null, null, '0');
INSERT INTO `assign` VALUES ('acd45198-e041-4521-8e3e-62d94d24aeb3', 'PC201305010001', '0', '0', '0', '0', '0', '0', null, null, '1', '0', '0', '0', '0', '0', null, '0', '0', '0', null, '0', null, '0', null, '0', '0', '0', null, null, '0', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', null, null, null, null, null, null, '0');
INSERT INTO `assign` VALUES ('bca09c08-9255-4a8d-a15d-98b93374df62', 'PC201305020006', '0', '0', '0', '0', '0', '0', null, null, '1', '0', '0', '0', '0', '0', null, '0', '0', '0', null, '0', null, '0', null, '0', '0', '0', null, null, '0', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', null, null, null, null, null, null, '0');
INSERT INTO `assign` VALUES ('c94d2fb5-0d0a-4e0d-9dcb-0fd610f85b51', 'PC201305020002', '0', '0', '0', '0', '0', '0', null, null, '1', '0', '0', '0', '0', '0', null, '0', '0', '0', null, '0', null, '0', null, '0', '0', '0', null, null, '0', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', null, null, null, null, null, null, '0');
INSERT INTO `assign` VALUES ('e659dd44-1226-4bef-8c71-dcfa35515171', 'PC201305020005', '0', '0', '0', '0', '0', '0', null, null, '1', '0', '0', '0', '0', '0', null, '0', '0', '0', null, '0', null, '0', null, '0', '0', '0', null, null, '0', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for `car_info`
-- ----------------------------
DROP TABLE IF EXISTS `car_info`;
CREATE TABLE `car_info` (
  `ID` char(75) NOT NULL,
  `CarNum` varchar(20) DEFAULT NULL,
  `ModelID` char(75) DEFAULT NULL,
  `Carry` float DEFAULT NULL,
  `PersonCarry` int(11) DEFAULT NULL,
  `GroupID` int(11) DEFAULT NULL,
  `GasTypeID` int(11) DEFAULT NULL,
  `GasCostPerMile` float DEFAULT NULL,
  `GasTankContains` float DEFAULT NULL,
  `Starttime` int(11) DEFAULT NULL,
  `endtime` int(11) DEFAULT NULL,
  `Papers` varchar(50) DEFAULT NULL,
  `DepartmentID` int(11) DEFAULT NULL,
  `DriverID` int(11) DEFAULT NULL,
  `Kilometers` int(11) DEFAULT NULL,
  `Status` int(11) DEFAULT NULL,
  `AssignPlaceID` int(11) DEFAULT NULL,
  `PhoneNum` varchar(30) DEFAULT NULL,
  `SimNum` float DEFAULT NULL,
  `IsChecked` int(11) DEFAULT NULL,
  `CheckTime` int(11) DEFAULT NULL,
  `WorkCharacter` int(11) DEFAULT NULL,
  `CarBrandID` int(11) DEFAULT NULL,
  `Remark` varchar(100) DEFAULT NULL,
  `DeviceID` int(11) DEFAULT NULL,
  `AssetsTypeID` int(11) DEFAULT NULL,
  `Isvalid` int(11) DEFAULT NULL,
  `UnValidDes` varchar(100) DEFAULT NULL,
  `UnValidTime` int(11) DEFAULT NULL,
  `RepairNum` int(11) DEFAULT NULL,
  `MaintainPerTimes` int(11) DEFAULT NULL,
  `TyreDate` int(11) DEFAULT NULL,
  `Owner` varchar(50) DEFAULT NULL,
  `ParkPlace` varchar(50) DEFAULT NULL,
  `TyreType` varchar(50) DEFAULT NULL,
  `creatorId` char(36) DEFAULT NULL,
  `creatorCode` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT '1901-01-01 00:00:00',
  `updatorId` char(36) DEFAULT NULL,
  `updatorCode` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT '1901-01-01 00:00:00',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car_info
-- ----------------------------
INSERT INTO `car_info` VALUES ('1', 'KS6216', '1', '1', '5', '3', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1901-01-01 00:00:00', '1', '1', '1901-01-01 00:00:00', '0');
INSERT INTO `car_info` VALUES ('2', 'KS6217', '1', '1', '6', '3', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1901-01-01 00:00:00', '1', '1', '1901-01-01 00:00:00', '0');
INSERT INTO `car_info` VALUES ('3', 'ZS0001', '1', '1', '1', '4', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1901-01-01 00:00:00', '1', '1', '1901-01-01 00:00:00', '0');
INSERT INTO `car_info` VALUES ('4', 'ZS0002', '1', '1', '2', '4', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1901-01-01 00:00:00', '1', '1', '1901-01-01 00:00:00', '0');
INSERT INTO `car_info` VALUES ('5', 'ZS0002', '1', '1', '2', '4', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1901-01-01 00:00:00', '1', '1', '1901-01-01 00:00:00', '0');
INSERT INTO `car_info` VALUES ('6', 'ZS0002', '1', '1', '2', '4', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1901-01-01 00:00:00', '1', '1', '1901-01-01 00:00:00', '0');
INSERT INTO `car_info` VALUES ('7', 'ZS0002', '1', '1', '2', '4', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1901-01-01 00:00:00', '1', '1', '1901-01-01 00:00:00', '0');
INSERT INTO `car_info` VALUES ('8', 'ZS0002', '1', '1', '2', '4', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1901-01-01 00:00:00', '1', '1', '1901-01-01 00:00:00', '0');

-- ----------------------------
-- Table structure for `car_model`
-- ----------------------------
DROP TABLE IF EXISTS `car_model`;
CREATE TABLE `car_model` (
  `ID` char(75) NOT NULL,
  `CarModel` varchar(25) DEFAULT NULL,
  `Type_` int(11) DEFAULT NULL,
  `CheckTime` int(11) DEFAULT NULL,
  `Carry` int(11) DEFAULT NULL,
  `creatorId` char(36) DEFAULT NULL,
  `creatorCode` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT '1901-01-01 00:00:00',
  `updatorId` char(36) DEFAULT NULL,
  `updatorCode` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT '1901-01-01 00:00:00',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car_model
-- ----------------------------
INSERT INTO `car_model` VALUES ('1', '小轿车', '1', '1', '4', null, null, '1901-01-01 00:00:00', null, null, '1901-01-01 00:00:00', '0');
INSERT INTO `car_model` VALUES ('2', '商务车', '1', '1', '6', null, null, '1901-01-01 00:00:00', null, null, '1901-01-01 00:00:00', '0');
INSERT INTO `car_model` VALUES ('3', '面包车', '1', '1', '10', null, null, '1901-01-01 00:00:00', null, null, '1901-01-01 00:00:00', '0');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `ID` char(75) NOT NULL,
  `Des` varchar(50) DEFAULT NULL,
  `DepartLevel` int(11) DEFAULT NULL,
  `DepartType` int(11) DEFAULT NULL,
  `ParentID` int(11) DEFAULT NULL,
  `creatorId` char(36) DEFAULT NULL,
  `creatorCode` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT '1901-01-01 00:00:00',
  `updatorId` char(36) DEFAULT NULL,
  `updatorCode` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT '1901-01-01 00:00:00',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'zongbu', '0', '1', '0', '1', '1', '1901-01-01 00:00:00', '1', '1', '1901-01-01 00:00:00', '0');
INSERT INTO `department` VALUES ('2', 'xingzhenbu', '1', '1', '0', '1', '1', '1901-01-01 00:00:00', '1', '1', '1901-01-01 00:00:00', '0');
INSERT INTO `department` VALUES ('3', 'Dispatch1', '1', '2', null, null, null, '1901-01-01 00:00:00', null, null, '1901-01-01 00:00:00', '0');
INSERT INTO `department` VALUES ('4', 'Dispatch2', '1', '2', null, null, null, '1901-01-01 00:00:00', null, null, '1901-01-01 00:00:00', '0');

-- ----------------------------
-- Table structure for `department_struc`
-- ----------------------------
DROP TABLE IF EXISTS `department_struc`;
CREATE TABLE `department_struc` (
  `ID` char(75) NOT NULL,
  `ApplyDepartID` char(75) DEFAULT NULL,
  `DispatchDepartID` char(75) DEFAULT NULL,
  `creatorId` char(36) DEFAULT NULL,
  `creatorCode` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT '1901-01-01 00:00:00',
  `updatorId` char(36) DEFAULT NULL,
  `updatorCode` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT '1901-01-01 00:00:00',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department_struc
-- ----------------------------

-- ----------------------------
-- Table structure for `driver_info`
-- ----------------------------
DROP TABLE IF EXISTS `driver_info`;
CREATE TABLE `driver_info` (
  `ID` char(75) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `TypeID` int(11) DEFAULT NULL,
  `VehicleType` varchar(50) DEFAULT NULL,
  `MotoType` varchar(50) DEFAULT NULL,
  `Maincard` varchar(50) DEFAULT NULL,
  `secondCard` varchar(50) DEFAULT NULL,
  `Validdate` int(11) DEFAULT NULL,
  `GetCardDate` int(11) DEFAULT NULL,
  `CheckCardDate` int(11) DEFAULT NULL,
  `RecordID` int(11) DEFAULT NULL,
  `Kilometers` int(11) DEFAULT NULL,
  `DepaetmentID` int(11) DEFAULT NULL,
  `AssignPlaceID` int(11) DEFAULT NULL,
  `BelongsID` int(11) DEFAULT NULL,
  `AttrID` int(11) DEFAULT NULL,
  `Status` int(11) DEFAULT NULL,
  `PhoneNum` varchar(30) DEFAULT NULL,
  `Remark` varchar(500) DEFAULT NULL,
  `IsImportant` int(11) DEFAULT NULL,
  `Stations` varchar(50) DEFAULT NULL,
  `Papers` varchar(100) DEFAULT NULL,
  `IsValid` int(11) DEFAULT NULL,
  `UnValidDes` varchar(100) DEFAULT NULL,
  `UnValidTime` int(11) DEFAULT NULL,
  `IsChecked` int(11) DEFAULT NULL,
  `IsMarriage` int(11) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `EducationTypeID` int(11) DEFAULT NULL,
  `ContractTime` int(11) DEFAULT NULL,
  `WorkRelation` int(11) DEFAULT NULL,
  `StarLevel` int(11) DEFAULT NULL,
  `IDNum` varchar(50) DEFAULT NULL,
  `FamilyAddr` varchar(50) DEFAULT NULL,
  `Demmision` varchar(50) DEFAULT NULL,
  `creatorId` char(36) DEFAULT NULL,
  `creatorCode` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT '1901-01-01 00:00:00',
  `updatorId` char(36) DEFAULT NULL,
  `updatorCode` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT '1901-01-01 00:00:00',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of driver_info
-- ----------------------------
INSERT INTO `driver_info` VALUES ('1', 'micheal', '0', null, '1', null, null, null, null, null, null, null, null, null, null, null, '0', null, '', null, null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1901-01-01 00:00:00', null, null, '1901-01-01 00:00:00', '0');
INSERT INTO `driver_info` VALUES ('2', 'jacob', '1', null, '2', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1901-01-01 00:00:00', null, null, '1901-01-01 00:00:00', '0');

-- ----------------------------
-- Table structure for `master_data`
-- ----------------------------
DROP TABLE IF EXISTS `master_data`;
CREATE TABLE `master_data` (
  `ID` char(75) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Type_` int(11) DEFAULT NULL,
  `creatorId` char(36) DEFAULT NULL,
  `creatorCode` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT '1901-01-01 00:00:00',
  `updatorId` char(36) DEFAULT NULL,
  `updatorCode` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT '1901-01-01 00:00:00',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master_data
-- ----------------------------

-- ----------------------------
-- Table structure for `master_type`
-- ----------------------------
DROP TABLE IF EXISTS `master_type`;
CREATE TABLE `master_type` (
  `ID` char(75) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `creatorId` char(36) DEFAULT NULL,
  `creatorCode` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT '1901-01-01 00:00:00',
  `updatorId` char(36) DEFAULT NULL,
  `updatorCode` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT '1901-01-01 00:00:00',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master_type
-- ----------------------------

-- ----------------------------
-- Table structure for `organization_`
-- ----------------------------
DROP TABLE IF EXISTS `organization_`;
CREATE TABLE `organization_` (
  `id` char(75) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `parentOrganizationId` char(75) DEFAULT NULL,
  `treePath` longtext,
  `name` varchar(100) DEFAULT NULL,
  `type_` varchar(75) DEFAULT NULL,
  `recursable` tinyint(4) DEFAULT NULL,
  `regionId` bigint(20) DEFAULT NULL,
  `countryId` bigint(20) DEFAULT NULL,
  `statusId` int(11) DEFAULT NULL,
  `comments` longtext,
  `creatorId` char(36) DEFAULT NULL,
  `creatorCode` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT '1901-01-01 00:00:00',
  `updatorId` char(36) DEFAULT NULL,
  `updatorCode` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT '1901-01-01 00:00:00',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `IX_E301BDF5` (`companyId`,`name`),
  KEY `IX_834BCEB6` (`companyId`),
  KEY `IX_418E4522` (`companyId`,`parentOrganizationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of organization_
-- ----------------------------
INSERT INTO `organization_` VALUES ('351d0efd-5265-4581-8726-a03712cdc54b', null, null, null, '机管办', '2', '0', null, null, '0', '', 'abc', 'abc', '2013-05-02 15:16:40', 'abc', 'abc', '2013-05-02 15:16:40', '0');
INSERT INTO `organization_` VALUES ('38878a96-2971-4eea-8143-bba89a9cbd56', null, 'f8a0bfd7-e43e-4d4b-96de-e3d1467dccdb', null, '县府办', '1', '0', null, null, '0', '', null, null, null, null, null, null, '0');
INSERT INTO `organization_` VALUES ('39493947-b8b8-4551-bba6-ee7faa72b3b8', null, 'f8a0bfd7-e43e-4d4b-96de-e3d1467dccdb', null, '政协', '1', '0', null, null, '0', '', null, null, null, null, null, null, '0');
INSERT INTO `organization_` VALUES ('4537affd-1d4a-404d-bd40-d5de3fb14355', null, '351d0efd-5265-4581-8726-a03712cdc54b', null, '驾驶队1', '2', '0', null, null, '0', '', null, null, null, null, null, null, '0');
INSERT INTO `organization_` VALUES ('7e695919-df7b-47b3-94c7-bd2ede00f5f4', null, 'f8a0bfd7-e43e-4d4b-96de-e3d1467dccdb', null, '财政局', '1', '0', null, null, '0', '', null, null, null, null, null, null, '0');
INSERT INTO `organization_` VALUES ('8ebd2cd0-3d1b-4f11-a63c-b39a91435bec', null, 'f8a0bfd7-e43e-4d4b-96de-e3d1467dccdb', null, '机管局', '1', '0', null, null, '0', '', null, null, null, null, null, null, '0');
INSERT INTO `organization_` VALUES ('8ecf61e8-5316-41c8-b51c-2368b1ff15a0', null, 'f8a0bfd7-e43e-4d4b-96de-e3d1467dccdb', null, '人大', '1', '0', null, null, '0', '', null, null, null, null, null, null, '0');
INSERT INTO `organization_` VALUES ('f8a0bfd7-e43e-4d4b-96de-e3d1467dccdb', null, null, null, '崇明机管办', '1', '0', null, null, '0', '', 'abc', 'abc', '2013-05-02 11:15:07', 'abc', 'abc', '2013-05-02 11:15:07', '0');

-- ----------------------------
-- Table structure for `role_`
-- ----------------------------
DROP TABLE IF EXISTS `role_`;
CREATE TABLE `role_` (
  `id` char(75) NOT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `title` longtext,
  `description` longtext,
  `type_` int(11) DEFAULT NULL,
  `subtype` varchar(75) DEFAULT NULL,
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `IX_A88E424E` (`companyId`,`classNameId`,`classPK`),
  UNIQUE KEY `IX_EBC931B8` (`companyId`,`name`),
  KEY `IX_449A10B9` (`companyId`),
  KEY `IX_F436EC8E` (`name`),
  KEY `IX_5EB4E2FB` (`subtype`),
  KEY `IX_CBE204` (`type_`,`subtype`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_
-- ----------------------------
INSERT INTO `role_` VALUES ('10161', '10154', '10004', '10161', 'Administrator', '', '<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Administrators are super users who can do anything.</Description></root>', '1', '', '0');
INSERT INTO `role_` VALUES ('10162', '10154', '10004', '10162', 'Guest', '', '<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Unauthenticated users always have this role.</Description></root>', '1', '', '0');
INSERT INTO `role_` VALUES ('10163', '10154', '10004', '10163', 'Owner', '', '<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">This is an implied role with respect to the objects users create.</Description></root>', '1', '', '0');
INSERT INTO `role_` VALUES ('10164', '10154', '10004', '10164', 'Power User', '', '<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Power Users have their own personal site.</Description></root>', '1', '', '0');
INSERT INTO `role_` VALUES ('10165', '10154', '10004', '10165', 'User', '', '<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Authenticated users should be assigned this role.</Description></root>', '1', '', '0');
INSERT INTO `role_` VALUES ('10166', '10154', '10004', '10166', 'Organization Administrator', '', '<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Organization Administrators are super users of their organization but cannot make other users into Organization Administrators.</Description></root>', '3', '', '0');
INSERT INTO `role_` VALUES ('10167', '10154', '10004', '10167', 'Organization Owner', '', '<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Organization Owners are super users of their organization and can assign organization roles to users.</Description></root>', '3', '', '0');
INSERT INTO `role_` VALUES ('10168', '10154', '10004', '10168', 'Organization User', '', '<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">All users who belong to an organization have this role within that organization.</Description></root>', '3', '', '0');
INSERT INTO `role_` VALUES ('10169', '10154', '10004', '10169', 'Site Administrator', '', '<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Site Administrators are super users of their site but cannot make other users into Site Administrators.</Description></root>', '2', '', '0');
INSERT INTO `role_` VALUES ('10170', '10154', '10004', '10170', 'Site Member', '', '<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">All users who belong to a site have this role within that site.</Description></root>', '2', '', '0');
INSERT INTO `role_` VALUES ('10171', '10154', '10004', '10171', 'Site Owner', '', '<?xml version=\'1.0\' encoding=\'UTF-8\'?><root available-locales=\"en_US\" default-locale=\"en_US\"><Description language-id=\"en_US\">Site Owners are super users of their site and can assign site roles to users.</Description></root>', '2', '', '0');
INSERT INTO `role_` VALUES ('17118d01-92c0-4bb7-a73a-eb9d8e114076', null, null, null, '用车申请人', null, '', '0', null, '0');
INSERT INTO `role_` VALUES ('3c1b5a49-f71a-43ca-9ecc-4abcea1a44f6', null, null, null, '车队长', null, '', '0', null, '0');
INSERT INTO `role_` VALUES ('6c2a5cb0-589d-442e-82df-90d7fe0af0be', null, null, null, '系统管理员', null, '系统管理员', '0', null, '0');
INSERT INTO `role_` VALUES ('72a94d44-4ab6-4593-9e16-0486dc35ccab', null, null, null, '调度员', null, '', '0', null, '0');
INSERT INTO `role_` VALUES ('747bb387-d4f8-483c-98d1-21c1c679577a', null, null, null, '???', null, '2', '0', null, '0');
INSERT INTO `role_` VALUES ('9102ddc9-c245-458d-a7dd-f38bc793396b', null, null, null, '4', null, '4', '0', null, '0');
INSERT INTO `role_` VALUES ('d2ad63e7-9cae-4363-ac5c-3f8710bca1fa', null, null, null, '1', null, '1', '0', null, '1');

-- ----------------------------
-- Table structure for `task_type`
-- ----------------------------
DROP TABLE IF EXISTS `task_type`;
CREATE TABLE `task_type` (
  `ID` char(75) NOT NULL,
  `Reason` varchar(50) DEFAULT NULL,
  `creatorId` char(36) DEFAULT NULL,
  `creatorCode` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT '1901-01-01 00:00:00',
  `updatorId` char(36) DEFAULT NULL,
  `updatorCode` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT '1901-01-01 00:00:00',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_type
-- ----------------------------

-- ----------------------------
-- Table structure for `users_roles`
-- ----------------------------
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `userId` varchar(75) NOT NULL,
  `roleId` varchar(75) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`),
  KEY `IX_C19E5F31` (`roleId`),
  KEY `IX_C1A01806` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_roles
-- ----------------------------
INSERT INTO `users_roles` VALUES ('10196', '10161');
INSERT INTO `users_roles` VALUES ('9443a262-0c1d-4414-bdb5-f4179ad122d9', '10161');
INSERT INTO `users_roles` VALUES ('987dc0be-c984-4015-8203-d0d9047bfcd2', '10161');
INSERT INTO `users_roles` VALUES ('c4c0a525-5e22-4a90-98d2-421a73bda195', '10161');
INSERT INTO `users_roles` VALUES ('f57caac3-a76c-4e80-971f-4a28ff7839b2', '10161');
INSERT INTO `users_roles` VALUES ('10158', '10162');
INSERT INTO `users_roles` VALUES ('9443a262-0c1d-4414-bdb5-f4179ad122d9', '10162');
INSERT INTO `users_roles` VALUES ('987dc0be-c984-4015-8203-d0d9047bfcd2', '10162');
INSERT INTO `users_roles` VALUES ('c4c0a525-5e22-4a90-98d2-421a73bda195', '10162');
INSERT INTO `users_roles` VALUES ('f57caac3-a76c-4e80-971f-4a28ff7839b2', '10162');
INSERT INTO `users_roles` VALUES ('9443a262-0c1d-4414-bdb5-f4179ad122d9', '10163');
INSERT INTO `users_roles` VALUES ('987dc0be-c984-4015-8203-d0d9047bfcd2', '10163');
INSERT INTO `users_roles` VALUES ('c4c0a525-5e22-4a90-98d2-421a73bda195', '10163');
INSERT INTO `users_roles` VALUES ('f57caac3-a76c-4e80-971f-4a28ff7839b2', '10163');
INSERT INTO `users_roles` VALUES ('10196', '10164');
INSERT INTO `users_roles` VALUES ('10196', '10165');
INSERT INTO `users_roles` VALUES ('10161', '9443a262-0c1d-4414-bdb5-f4179ad122d9');
INSERT INTO `users_roles` VALUES ('10162', '9443a262-0c1d-4414-bdb5-f4179ad122d9');

-- ----------------------------
-- Table structure for `user_`
-- ----------------------------
DROP TABLE IF EXISTS `user_`;
CREATE TABLE `user_` (
  `id` varchar(75) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `defaultUser` tinyint(4) DEFAULT NULL,
  `contactId` bigint(20) DEFAULT NULL,
  `password_` varchar(75) DEFAULT NULL,
  `passwordEncrypted` tinyint(4) DEFAULT NULL,
  `passwordReset` tinyint(4) DEFAULT NULL,
  `passwordModifiedDate` datetime DEFAULT NULL,
  `digest` varchar(255) DEFAULT NULL,
  `reminderQueryQuestion` varchar(75) DEFAULT NULL,
  `reminderQueryAnswer` varchar(75) DEFAULT NULL,
  `graceLoginCount` int(11) DEFAULT NULL,
  `screenName` varchar(75) DEFAULT NULL,
  `emailAddress` varchar(75) DEFAULT NULL,
  `facebookId` bigint(20) DEFAULT NULL,
  `openId` varchar(1024) DEFAULT NULL,
  `portraitId` bigint(20) DEFAULT NULL,
  `languageId` varchar(75) DEFAULT NULL,
  `timeZoneId` varchar(75) DEFAULT NULL,
  `greeting` varchar(255) DEFAULT NULL,
  `comments` longtext,
  `firstName` varchar(75) DEFAULT NULL,
  `middleName` varchar(75) DEFAULT NULL,
  `lastName` varchar(75) DEFAULT NULL,
  `jobTitle` varchar(100) DEFAULT NULL,
  `loginDate` datetime DEFAULT NULL,
  `loginIP` varchar(75) DEFAULT NULL,
  `lastLoginDate` datetime DEFAULT NULL,
  `lastLoginIP` varchar(75) DEFAULT NULL,
  `lastFailedLoginDate` datetime DEFAULT NULL,
  `failedLoginAttempts` int(11) DEFAULT NULL,
  `lockout` tinyint(4) DEFAULT NULL,
  `lockoutDate` datetime DEFAULT NULL,
  `agreedToTermsOfUse` tinyint(4) DEFAULT NULL,
  `emailAddressVerified` tinyint(4) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `creatorId` char(36) DEFAULT NULL,
  `creatorCode` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT '1901-01-01 00:00:00',
  `updatorId` char(36) DEFAULT NULL,
  `updatorCode` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT '1901-01-01 00:00:00',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0',
  UNIQUE KEY `IX_615E9F7A` (`companyId`,`emailAddress`),
  UNIQUE KEY `IX_C5806019` (`companyId`,`screenName`),
  UNIQUE KEY `IX_9782AD88` (`companyId`,`userId`),
  UNIQUE KEY `IX_5ADBE171` (`contactId`),
  KEY `IX_3A1E834E` (`companyId`),
  KEY `IX_6EF03E4E` (`companyId`,`defaultUser`),
  KEY `IX_1D731F03` (`companyId`,`facebookId`),
  KEY `IX_89509087` (`companyId`,`openId`(255)),
  KEY `IX_F6039434` (`companyId`,`status`),
  KEY `IX_762F63C6` (`emailAddress`),
  KEY `IX_A18034A4` (`portraitId`),
  KEY `IX_E0422BDA` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_
-- ----------------------------
INSERT INTO `user_` VALUES ('9443a262-0c1d-4414-bdb5-f4179ad122d9', '10158', '10154', '2013-03-27 16:43:31', '2013-03-27 16:43:31', '1', '10159', 'password', '0', '0', null, '5533ed38b5e33c076a804bb4bca644f9,528f53719430814f22dbf509e0faa0c4,528f53719430814f22dbf509e0faa0c4', '', '', '0', '10158', 'default@liferay.com', '0', '', '0', 'en_US', 'GMT', 'Welcome!', '', '', '', '', '', '2013-03-27 16:43:31', '', null, '', null, '0', '0', null, '1', '0', '0', null, null, '1901-01-01 00:00:00', null, null, '1901-01-01 00:00:00', '0');
INSERT INTO `user_` VALUES ('c4c0a525-5e22-4a90-98d2-421a73bda195', '10196', '10154', '2013-03-27 16:43:33', '2013-03-27 16:44:31', '0', '10197', '96e79218965eb72c92a549dd5a330112', '1', '0', '2013-03-27 16:45:04', '', 'what-is-your-father\'s-middle-name', 'chang', '0', 'test', 'test@liferay.com', '0', '', '0', 'en_US', 'GMT', 'Welcome Test Test!', '', 'Test', '', 'Test', '', '2013-03-27 16:43:33', '', '2013-03-27 16:43:33', '', null, '0', '0', null, '1', '1', '0', null, null, '1901-01-01 00:00:00', null, null, '1901-01-01 00:00:00', '0');
INSERT INTO `user_` VALUES ('987dc0be-c984-4015-8203-d0d9047bfcd2', null, null, null, null, '0', null, '96e79218965eb72c92a549dd5a330112', '0', '0', null, null, null, null, '0', '', '1', null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '0', '0', null, '0', '0', '0', 'abc', 'abc', '2013-04-10 12:26:22', 'abc', 'abc', '2013-04-10 12:26:22', '0');
INSERT INTO `user_` VALUES ('f57caac3-a76c-4e80-971f-4a28ff7839b2', null, null, null, null, '0', null, '96e79218965eb72c92a549dd5a330112', '0', '0', null, null, null, null, '0', '', '2', null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '0', '0', null, '0', '0', '0', 'abc', 'abc', '2013-04-10 15:11:36', 'abc', 'abc', '2013-04-10 15:11:36', '0');
INSERT INTO `user_` VALUES ('44a60b09-0588-4ed1-a6ce-75c141b1899a', null, null, null, null, '0', null, null, '0', '0', null, null, null, null, '0', '', '2', null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '0', '0', null, '0', '0', '0', 'abc', 'abc', '2013-04-10 15:19:25', 'abc', 'abc', '2013-04-10 15:19:25', '0');
INSERT INTO `user_` VALUES ('1067b2fa-dfc6-44bb-9371-313d93a7e18a', null, null, null, null, '0', null, null, '0', '0', null, null, null, null, '0', '', '1', null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '0', '0', null, '0', '0', '0', 'abc', 'abc', '2013-04-10 15:20:39', 'abc', 'abc', '2013-04-10 15:20:39', '0');
INSERT INTO `user_` VALUES ('fae69582-e450-4985-b638-8216f9ad80f6', null, null, null, null, '0', null, null, '0', '0', null, null, null, null, '0', '', '2', null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '0', '0', null, '0', '0', '0', 'abc', 'abc', '2013-04-10 15:24:52', 'abc', 'abc', '2013-04-10 15:24:52', '0');
INSERT INTO `user_` VALUES ('97e24266-6446-4f11-89bc-e76b552b4f5e', null, null, null, null, '0', null, null, '0', '0', null, null, null, null, '0', '1', '1', null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '0', '0', null, '0', '0', '0', 'abc', 'abc', '2013-04-10 15:26:36', 'abc', 'abc', '2013-04-10 15:26:36', '0');
INSERT INTO `user_` VALUES ('925adb1e-23ee-43ab-a925-751a68bfa036', null, null, null, null, '0', null, null, '0', '0', null, null, null, null, '0', 'zxx', 'c2', null, null, null, null, null, null, null, 'zxx', null, null, null, null, null, null, null, null, '0', '0', null, '0', '0', '0', 'abc', 'abc', '2013-04-12 00:45:30', 'abc', 'abc', '2013-04-12 00:45:30', '0');
INSERT INTO `user_` VALUES ('c845981a-8b28-4843-a9ea-ead70b4dbf52', null, null, null, null, '0', null, null, '0', '0', null, null, null, null, '0', 't', '1', null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '0', '0', null, '0', '0', '0', 'abc', 'abc', '2013-04-12 01:00:14', 'abc', 'abc', '2013-04-12 01:00:14', '0');
INSERT INTO `user_` VALUES ('71928005-a53e-4889-8a32-a621573ae7b7', null, null, null, null, '0', null, '96e79218965eb72c92a549dd5a330112', '0', '0', null, null, null, null, '0', '7', '7', null, null, null, null, null, null, null, '7', null, null, null, null, null, null, null, null, '0', '0', null, '0', '0', '0', 'abc', 'abc', '2013-04-12 01:18:21', 'abc', 'abc', '2013-04-12 01:18:21', '0');
INSERT INTO `user_` VALUES ('27506b2a-335c-47a9-8a24-c826dce801fd', null, null, null, null, '0', null, '96e79218965eb72c92a549dd5a330112', '0', '0', null, null, null, null, '0', 'admin', 'test@163.com', null, null, null, null, null, null, null, '系统管理员', null, null, null, null, null, null, null, null, '0', '0', null, '0', '0', '0', 'abc', 'abc', '2013-04-30 15:33:32', 'abc', 'abc', '2013-04-30 15:33:32', '0');

-- ----------------------------
-- Table structure for `usual_place`
-- ----------------------------
DROP TABLE IF EXISTS `usual_place`;
CREATE TABLE `usual_place` (
  `ID` char(75) NOT NULL,
  `Des` varchar(50) DEFAULT NULL,
  `creatorId` char(36) DEFAULT NULL,
  `creatorCode` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT '1901-01-01 00:00:00',
  `updatorId` char(36) DEFAULT NULL,
  `updatorCode` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT '1901-01-01 00:00:00',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usual_place
-- ----------------------------
