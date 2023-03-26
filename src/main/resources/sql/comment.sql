CREATE TABLE IF NOT EXiSTS comments (
comment_id SERIAL PRIMARY KEY,
message TEXT(1000),
parent_comment_id BIGINT,
created_by BIGINT,
created_at TIMESTAMP(0) DEFAULT NOW(),
updated_at TIMESTAMP(0) DEFAULT NOW(),
deleted_at TIMESTAMP(0) DEFAULT NOW()
);