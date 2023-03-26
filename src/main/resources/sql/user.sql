CREATE TABLE IF NOT EXISTS users (
user_id SERIAL PRIMARY KEY,
first_name VARCHAR(25),
last_name VARCHAR(25),
email VARCHAR(70),
phone VARCHAR(15),
role roles_enum,
created_at TIMESTAMP(0) DEFAULT NOW(),
last_visited_at TIMESTAMP(0) DEFAULT NOW(),
deleted_at TIMESTAMP(0) DEFAULT NOW()
);