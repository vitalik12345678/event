CREATE TABLE IF NOT EXiSTS comments (
comment_id SERIAL PRIMARY KEY,
message TEXT,
post_id BIGINT REFERENCES post(post_id),
parent_comment_id BIGINT REFERENCES comments(comment_id),
created_by BIGINT REFERENCES users(user_id),
created_at TIMESTAMP(0) DEFAULT NOW(),
updated_at TIMESTAMP(0),
deleted_at TIMESTAMP(0),
is_deleted BOOLEAN
);