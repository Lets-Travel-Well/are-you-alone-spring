create table post(
                     `id`    BIGINT    NOT NULL AUTO_INCREMENT,
                     `subject`    VARCHAR(100)    NULL DEFAULT NULL,
                     `content`    VARCHAR(2000)    NULL DEFAULT NULL,
                     `hit`    INT NULL DEFAULT 0,
                     `member_id`    BIGINT    NOT NULL,
                     `created_date`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                     `modified_date`    TIMESTAMP    NULL DEFAULT NULL,
                     PRIMARY KEY (`id`),
                     FOREIGN KEY (member_id) REFERENCES Member(id)
                         `id`    BIGINT    NOT NULL AUTO_INCREMENT,
);


