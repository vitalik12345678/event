CREATE TABLE grade (
  post_id BIGINT NOT NULL,
  user_id BIGINT NOT NULL,
  grade_value SMALLINT CHECK (grade_value >= 0 AND grade_value <= 5),
  PRIMARY KEY (post_id, user_id)
);