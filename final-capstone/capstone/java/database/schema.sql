BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, profiles, foods, meal_history, mindful_history, meal_history_foods CASCADE;

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
    initial_weight numeric(6,2) NOT NULL,
    current_weight numeric(6,2) NOT NULL,
    goal_weight numeric(6,2) NOT NULL,
    calorie_limit int NOT NULL,
    mindful_goal int NOT NULL,
    profile_picture varchar(500),
    CONSTRAINT PK_profile_id PRIMARY KEY (profile_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE foods (
    food_id serial,
    food_name varchar(50) NOT NULL,
    calories int NOT NULL,
    serving_size varchar(50) NOT NULL,
    number_of_servings int NOT NULL,
    CONSTRAINT PK_food_id PRIMARY KEY (food_id)
);

CREATE TABLE meal_history (
    meal_history_id serial,
    user_id int NOT NULL,
    meal_date date NOT NULL,
    type varchar(50) NOT NULL,
    total_calories int NOT NULL,
    CONSTRAINT PK_meal_history_id PRIMARY KEY (meal_history_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE meal_history_foods (
    meal_history_id int NOT NULL,
    food_id int NOT NULL,
    CONSTRAINT PK_meal_history_id_foods PRIMARY KEY (meal_history_id, food_id),
    CONSTRAINT FK_meal_history_id FOREIGN KEY (meal_history_id) REFERENCES meal_history (meal_history_id),
    CONSTRAINT FK_food_id FOREIGN KEY (food_id) REFERENCES foods (food_id)
);

CREATE TABLE mindful_history (
    mindful_id serial,
    activity varchar(50) NOT NULL,
    user_id int NOT NULL,
    mindful_date date NOT NULL,
    length_minutes int NOT NULL,
    CONSTRAINT PK_mindful_id PRIMARY KEY (mindful_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

COMMIT TRANSACTION;
