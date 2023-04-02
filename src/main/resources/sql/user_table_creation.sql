CREATE TABLE IF NOT EXISTS users
(
    user_id           SERIAL PRIMARY KEY,
    first_name        VARCHAR(25)        NOT NULL,
    last_name         VARCHAR(25)        NOT NULL,
    email             VARCHAR(70)        NOT NULL,
    phone             VARCHAR(15) UNIQUE NOT NULL,
    password          VARCHAR(300)       NOT NULL,
    role              roles_enum,
    created_date      TIMESTAMP(0) DEFAULT NOW(),
    last_visited_date TIMESTAMP(0) DEFAULT NOW(),
    blocked_date      TIMESTAMP(0)
);