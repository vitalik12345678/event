CREATE TABLE password_reset_token (
    token VARCHAR(255) NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    creation_time TIMESTAMPTZ NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT UC_PasswordResetToken UNIQUE (token, user_id)
);