CREATE TABLE IF NOT EXISTS users (
user_id SERIAL PRIMARY KEY,
first_name VARCHAR(25) NOT NULL ,
last_name VARCHAR(25) NOT NULL ,
email VARCHAR(70) NOT NULL ,
phone VARCHAR(15) UNIQUE NOT NULL ,
role roles_enum,
created_at TIMESTAMP(0) DEFAULT NOW(),
last_visited_at TIMESTAMP(0) DEFAULT NOW(),
blocked_at TIMESTAMP(0),
is_blocked BOOLEAN
);