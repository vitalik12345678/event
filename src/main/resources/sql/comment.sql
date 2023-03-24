CREATE TABLE comments (
comment_id BIGINT PRIMARY KEY,
message VARCHAR(1000),
created_by BIGINT,
created_at TIMESTAMP,
updated_at TIMESTAMP,
deleted_at TIMESTAMP
);