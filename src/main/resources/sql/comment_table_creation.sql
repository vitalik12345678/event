CREATE TABLE IF NOT EXiSTS comment
(
    comment_id         SERIAL PRIMARY KEY,
    message            TEXT,
    post_id            BIGINT REFERENCES post (post_id),
    parent_comment_id  BIGINT REFERENCES comment (comment_id),
    created_by         BIGINT REFERENCES users (user_id),
    creation_date      TIMESTAMP(0) DEFAULT NOW(),
    last_modified_date TIMESTAMP(0),
    deleted_date       TIMESTAMP(0)
);