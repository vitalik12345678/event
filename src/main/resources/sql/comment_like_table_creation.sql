CREATE TABLE IF NOT EXISTS comment_like
(
    user_id    BIGINT REFERENCES users (user_id),
    comment_id BIGINT REFERENCES comment (comment_id),
    post_id    BIGINT REFERENCES post (post_id),
    PRIMARY KEY (post_id, user_id, comment_id)
)