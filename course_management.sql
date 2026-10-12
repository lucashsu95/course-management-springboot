-- 學生課程管理系統 資料庫結構 (MySQL 8)
CREATE DATABASE IF NOT EXISTS `course_management`
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE `course_management`;

DROP TABLE IF EXISTS `student_course_relation`;
DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `course`;

-- 學生
CREATE TABLE `student`
(
    `id`    VARCHAR(20)  NOT NULL COMMENT '學號',
    `name`  VARCHAR(50)  NOT NULL COMMENT '姓名',
    `email` VARCHAR(100) NOT NULL COMMENT '電子信箱',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT '學生';

-- 課程
CREATE TABLE `course`
(
    `id`     VARCHAR(20)      NOT NULL COMMENT '課程代碼',
    `name`   VARCHAR(100)     NOT NULL COMMENT '課程名稱',
    `credit` TINYINT UNSIGNED NOT NULL COMMENT '學分數',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT '課程';

-- 學生選課關聯 (複合主鍵: student_id + course_id)
CREATE TABLE `student_course_relation`
(
    `student_id`  VARCHAR(20)  NOT NULL COMMENT '學號',
    `course_id`   VARCHAR(20)  NOT NULL COMMENT '課程代碼',
    `grade`       INT          NULL COMMENT '成績，尚未評分為 NULL',
    `remark`      VARCHAR(255) NULL COMMENT '評語備註',
    `create_date` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '選課時間 (Asia/Taipei)',
    PRIMARY KEY (`student_id`, `course_id`),
    INDEX `idx_student_course_relation_course_id` (`course_id`),
    CONSTRAINT `fk_student_course_relation_student`
        FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
            ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT `fk_student_course_relation_course`
        FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
            ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT `chk_student_course_relation_grade` CHECK (`grade` IS NULL OR `grade` BETWEEN 0 AND 100)
) ENGINE = InnoDB COMMENT '學生選課關聯';

-- 範例資料
INSERT INTO `student` (`id`, `name`, `email`)
VALUES ('11046001', '王小明', 'xiaoming@example.com'),
       ('11046002', '甲小明', 'apple@example.com');

INSERT INTO `course` (`id`, `name`, `credit`)
VALUES ('CS101', '計算機概論', 3),
       ('CS202', '資料結構', 3);

INSERT INTO `student_course_relation` (`student_id`, `course_id`, `grade`, `remark`, `create_date`)
VALUES ('11046001', 'CS101', NULL, NULL, '2026-01-28 23:30:32'),
       ('11046001', 'CS202', NULL, NULL, '2026-01-28 23:30:32');
