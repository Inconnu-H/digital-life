/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80037 (8.0.37)
 Source Host           : localhost:3306
 Source Schema         : digital_life

 Target Server Type    : MySQL
 Target Server Version : 80037 (8.0.37)
 File Encoding         : 65001

 Date: 25/08/2024 09:18:07
*/

SET NAMES utf8mb4;
SET
    FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exercise_action
-- ----------------------------
DROP TABLE IF EXISTS `exercise_action`;
CREATE TABLE `exercise_action`
(
    `id`             varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    `name`           varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '动作名称',
    `category`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '动作分类（如力量、心肺、柔韧性）',
    `target_muscles` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '目标肌肉群（如胸部、腿部、背部）',
    `difficulty`     tinyint                                                       NOT NULL COMMENT '难度级别（1：初级，2：中级，3：高级）',
    `equipment`      varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所需器材（如哑铃、杠铃、自重）',
    `description`    text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci         NULL COMMENT '动作描述',
    `video_url`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '教学视频链接（可选）',
    `status`         tinyint(1)                                                    NULL DEFAULT 1 COMMENT '状态（1：启用，0：禁用）',
    `create_time`    timestamp                                                     NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`    timestamp                                                     NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '锻炼动作表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exercise_action
-- ----------------------------
INSERT INTO `exercise_action`
VALUES ('5200212208543744', '哑铃卧推', '力量', '胸部, 三头肌', 2, '哑铃',
        '平躺在卧推凳上，双手握哑铃在胸部上方，推起至手臂伸直，再缓慢下降回到起始位置。', 'http://example.com/video1', 1,
        '2024-08-22 21:17:21', '2024-08-22 21:22:24');
INSERT INTO `exercise_action`
VALUES ('5200212208543745', '俯身哑铃飞鸟', '力量', '肩部, 胸部', 2, '哑铃',
        '俯身姿势，双手各持一个哑铃，手臂自然下垂，双臂打开至两侧，感受肩部和胸部的拉伸，然后收回。',
        'http://example.com/video10', 1, '2024-08-22 21:17:21', '2024-08-22 21:22:24');
INSERT INTO `exercise_action`
VALUES ('5200212208543746', '单臂哑铃弯举', '力量', '二头肌', 2, '哑铃',
        '单手握哑铃，手臂自然垂下，肘部固定，将哑铃向上弯曲至肩部位置，然后缓慢放下。', 'http://example.com/video11', 1,
        '2024-08-22 21:17:21', '2024-08-22 21:22:24');
INSERT INTO `exercise_action`
VALUES ('5200212208543747', '前平举', '力量', '肩部', 2, '哑铃',
        '站立姿势，双手握哑铃在大腿前方，保持手臂伸直，向前抬高至与地面平行，然后缓慢放下。', 'http://example.com/video2', 1,
        '2024-08-22 21:17:21', '2024-08-22 21:22:24');
INSERT INTO `exercise_action`
VALUES ('5200212208543748', '侧平举', '力量', '肩部', 2, '哑铃',
        '双手持哑铃自然下垂，手臂微曲，侧向抬起至与地面平行，然后缓慢放下。', 'http://example.com/video3', 1,
        '2024-08-22 21:17:21', '2024-08-22 21:22:24');
INSERT INTO `exercise_action`
VALUES ('5200212208543749', '俯身臂屈伸', '力量', '三头肌', 2, '哑铃',
        '俯身姿势，双手各持一哑铃，手臂伸直于身体两侧，弯曲手肘将哑铃向肩部方向移动，然后缓慢放下。',
        'http://example.com/video4', 1, '2024-08-22 21:17:21', '2024-08-22 21:22:24');
INSERT INTO `exercise_action`
VALUES ('5200212208543750', '哑铃深蹲', '力量', '腿部, 臀部', 2, '哑铃',
        '双手持哑铃放于肩膀上方，双脚与肩同宽，缓慢下蹲至大腿与地面平行，然后站起恢复起始位置。',
        'http://example.com/video5', 1, '2024-08-22 21:17:21', '2024-08-22 21:22:24');
INSERT INTO `exercise_action`
VALUES ('5200212208543751', '哑铃硬拉', '力量', '背部, 腿部', 2, '哑铃',
        '双手各持一个哑铃，站立姿势，双脚与肩同宽，膝盖微曲，保持背部直立，向下弯腰并伸展手臂，再站起恢复。',
        'http://example.com/video6', 1, '2024-08-22 21:17:21', '2024-08-22 21:22:24');
INSERT INTO `exercise_action`
VALUES ('5200212208543752', '卷腹', '力量', '腹部', 1, '自重',
        '仰卧，双手放在头部后面或交叉于胸前，双腿抬起，利用腹部力量将上半身卷起，然后慢慢放下。',
        'http://example.com/video7', 1, '2024-08-22 21:17:21', '2024-08-22 21:22:24');
INSERT INTO `exercise_action`
VALUES ('5200212208543753', '悬垂举腿', '力量', '腹部, 胳膊', 2, '自重',
        '悬挂在横杠上，双腿伸直，利用腹部力量将双腿抬高至与地面平行，然后缓慢放下。', 'http://example.com/video8', 1,
        '2024-08-22 21:17:21', '2024-08-22 21:22:24');
INSERT INTO `exercise_action`
VALUES ('5200212208543754', '哑铃划船', '力量', '背部, 二头肌', 2, '哑铃',
        '双手各持一个哑铃，前倾姿势，肘部弯曲将哑铃向上拉至胸部位置，然后慢慢放下。', 'http://example.com/video9', 1,
        '2024-08-22 21:17:21', '2024-08-22 21:22:24');

-- ----------------------------
-- Table structure for exercise_record
-- ----------------------------
DROP TABLE IF EXISTS `exercise_record`;
CREATE TABLE `exercise_record`
(
    `id`          varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `user_id`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID（外键，关联用户表）',
    `action_id`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '锻炼动作ID（外键，关联锻炼动作表）',
    `time`        datetime                                                     NOT NULL COMMENT '锻炼日期',
    `duration`    int                                                          NULL DEFAULT NULL COMMENT '锻炼持续时间（以分钟为单位）',
    `sets`        int                                                          NULL DEFAULT NULL COMMENT '完成的组数',
    `repetitions` int                                                          NULL DEFAULT NULL COMMENT '每组的重复次数',
    `weight`      decimal(10, 2)                                               NULL DEFAULT NULL COMMENT '使用的重量（如果适用）',
    `notes`       text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci        NULL COMMENT '额外的备注信息',
    `create_time` timestamp                                                    NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp                                                    NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `user_id` (`user_id` ASC) USING BTREE,
    INDEX `exercise_id` (`action_id` ASC) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '锻炼记录表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exercise_record
-- ----------------------------
INSERT INTO `exercise_record`
VALUES ('1826485875493806082', 'Karen', '5200212208543748', '2024-08-22 00:00:00', 150, 11, 9, 7.86,
        '次六委证做率叫率而活里队青持。应被而资参天具通边亲小持资族改。角算此史布把把求你总组表计最完易。们走局入么表状活海界律土即。',
        '2024-08-22 13:05:41', '2024-08-22 21:22:38');
INSERT INTO `exercise_record`
VALUES ('1826485887162359809', 'Karen', '5200212208543749', '2024-08-22 00:00:00', 150, 11, 9, 7.86,
        '次六委证做率叫率而活里队青持。应被而资参天具通边亲小持资族改。角算此史布把把求你总组表计最完易。们走局入么表状活海界律土即。',
        '2024-08-22 13:05:44', '2024-08-22 21:22:38');
INSERT INTO `exercise_record`
VALUES ('1826485895387389953', 'Patricia', '5200212208543750', '2024-08-22 00:00:00', 886, 6, 10, 10.16,
        '连工给但基问体半米众全风层社技图。带规时压马包没据白价于权长指心。解安没适市动好值易深线条被。意因样你增高指场备青过面年好任。千们心就物说准省然即战保调。立们常反影车装式业商下数度。后实机区革形布成表油格八第感。',
        '2024-08-22 13:05:46', '2024-08-22 21:22:38');
INSERT INTO `exercise_record`
VALUES ('1826485901817257985', 'Robert', '5200212208543751', '2024-08-22 00:00:00', 877, 6, 10, 9.29,
        '选九打青万话引合志争具高月声。和导亲百接外外在片东共府关。且年力标系温题共型温明合。', '2024-08-22 13:05:48',
        '2024-08-22 21:22:38');
INSERT INTO `exercise_record`
VALUES ('1826596939405389826', 'Richard', '5200212208543753', '2024-08-22 00:00:00', 761, 10, 11, 9.14,
        '它中那华生相情满件照证你金层红走运易。又者样是元名压近气资六为常素期通山结。和为社影状直层周目了法北他合族对采。几深此现候今于由业已则后般过效率月。',
        '2024-08-22 20:27:01', '2024-08-22 21:22:38');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT,
    `type_code`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '字典类型编码',
    `dict_key`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '字典项的键',
    `dict_value`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字典项的值',
    `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典项的描述',
    `status`      tinyint(1)                                                    NULL DEFAULT 1 COMMENT '状态（1：启用，0：禁用）',
    `create_time` timestamp                                                     NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp                                                     NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uk_type_code_key` (`type_code` ASC, `dict_key` ASC) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统字典表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict`
VALUES (1, 'exercise_type', '1', '有氧运动', NULL, 1, '2024-08-21 22:13:04', '2024-08-21 22:15:39');
INSERT INTO `sys_dict`
VALUES (2, 'exercise_type', '2', '无氧运动', NULL, 1, '2024-08-21 22:15:56', '2024-08-21 22:15:56');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT,
    `type_code`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '字典类型编码，唯一',
    `type_name`   varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字典类型名称',
    `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典类型描述',
    `status`      tinyint(1)                                                    NULL DEFAULT 1 COMMENT '状态（1：启用，0：禁用）',
    `create_time` timestamp                                                     NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp                                                     NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uk_type_code` (`type_code` ASC) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统字典分类表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type`
VALUES (1, 'exercise_type', '锻炼类型', NULL, 1, '2024-08-21 22:11:39', '2024-08-21 22:11:39');
INSERT INTO `sys_dict_type`
VALUES (2, 'exercise_action', '锻炼动作', NULL, 1, '2024-08-21 22:12:29', '2024-08-21 22:12:29');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`          bigint                                                                          NOT NULL AUTO_INCREMENT,
    `username`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                    NOT NULL COMMENT '用户名，唯一',
    `password`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                   NULL DEFAULT NULL COMMENT '密码（加密存储）',
    `email`       varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                   NULL DEFAULT NULL COMMENT '用户邮箱，唯一',
    `full_name`   varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                   NULL DEFAULT NULL COMMENT '用户全名',
    `nick_name`   varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                   NULL DEFAULT NULL COMMENT '用户昵称',
    `phone`       varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                    NULL DEFAULT NULL COMMENT '用户电话号码（可选）',
    `birthdate`   date                                                                            NULL DEFAULT NULL COMMENT '出生日期（可选）',
    `gender`      enum ('Male','Female','Other') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别（可选）',
    `status`      tinyint(1)                                                                      NULL DEFAULT 1 COMMENT '状态（1：激活，0：禁用）',
    `create_time` timestamp                                                                       NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp                                                                       NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `username` (`username` ASC) USING BTREE,
    UNIQUE INDEX `email` (`email` ASC) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user`
VALUES (1, 'ping', '123456', '111', '黄继平', '小瓶', NULL, NULL, NULL, 1, '2024-08-21 22:49:03',
        '2024-08-21 22:49:42');

SET
    FOREIGN_KEY_CHECKS = 1;
