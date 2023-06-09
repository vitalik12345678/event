CREATE TABLE IF NOT EXISTS post
(
    post_id            SERIAL PRIMARY KEY,
    title              VARCHAR(255)                         NOT NULL,
    content            TEXT,
    creation_date      TIMESTAMP(0)    DEFAULT NOW(),
    last_modified_date TIMESTAMP(0)    DEFAULT NOW(),
    status             status_enum     DEFAULT 'WAITING',
    event              event_type_enum DEFAULT 'OTHER',
    format             format_enum     DEFAULT 'UNSPECIFIED',
    created_by         BIGINT REFERENCES users (user_id),
    approved_by        BIGINT REFERENCES users (user_id),
    branch_id          BIGINT REFERENCES branch (branch_id) NULL

);