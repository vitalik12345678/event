CREATE TABLE IF NOT EXISTS post (
  post_id SERIAL PRIMARY KEY,
  title VARCHAR(255),
  content TEXT,
  creation_date TIMESTAMP(0) DEFAULT NOW(),
  last_modified_date TIMESTAMP(0) DEFAULT NOW(),
  status status_enum,
  created_by BIGINT,
  approved_by BIGINT,
  event event_enum,
  format format_enum,
  branch_id BIGINT
);