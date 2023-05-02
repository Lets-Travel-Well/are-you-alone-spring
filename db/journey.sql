CREATE TABLE journey (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `leader_id` BIGINT UNSIGNED NOT NULL,
    `subject` VARCHAR(255) NOT NULL,
    `content` TEXT,
    `visibility` BOOLEAN NOT NULL,
    `travelers_cnt` INT NULL DEFAULT 1,
    `dead_line` DATE,
    `start_day` DATE NOT NULL,
    PRIMARY KEY (id)
)