CREATE TABLE IF NOT EXISTS grade_post (
  post_id BIGINT NOT NULL REFERENCES post(post_id),
  user_id BIGINT NOT NULL REFERENCES users(user_id),
  grade_value SMALLINT CHECK (grade_value >= 0 AND grade_value <= 5),
  PRIMARY KEY (post_id, user_id)
);