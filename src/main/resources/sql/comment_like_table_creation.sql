CREATE TABLE IF NOT EXISTS comment_like
(
    user_id    BIGINT REFERENCES users (user_id),
    comment_id BIGINT REFERENCES comment (comment_id),
    PRIMARY KEY (user_id, comment_id)
)