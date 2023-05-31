BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, profiles CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE profiles (
    profile_id serial,
    user_id int,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    age int NOT NULL,
    height int NOT NULL,
    current_weight numeric(6,2) NOT NULL,
    goal_weight numeric(6,2) NOT NULL,
    calorie_limit int NOT NULL,
    mindful_goal int NOT NULL,
    CONSTRAINT PK_profile_id PRIMARY KEY (profile_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

COMMIT TRANSACTION;
