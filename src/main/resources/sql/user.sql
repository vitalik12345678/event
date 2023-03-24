CREATE TABLE users (
user_id SERIAL PRIMARY KEY,
first_name VARCHAR(25),
last_name VARCHAR(25),
email VARCHAR(30),
phone VARCHAR(15),
role roles_enum,
created_at TIMESTAMP,
last_visited_at TIMESTAMP,
deleted_at TIMESTAMP
);