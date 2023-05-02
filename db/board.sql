create table post(
    `id`    BIGINT    NOT NULL AUTO_INCREMENT,
    `member_id`    BIGINT    NOT NULL,
    `subject`    VARCHAR(255)    NULL DEFAULT NULL,
    `content`    VARCHAR(2000)    NULL DEFAULT NULL,
    `hit`    INT NULL DEFAULT 0,
    PRIMARY KEY (`id`),
);


