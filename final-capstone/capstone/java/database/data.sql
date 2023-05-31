BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO profiles (user_id, first_name, last_name, age, height, current_weight, goal_weight, calorie_limit, mindful_goal)
VALUES (1, 'Test', 'User', 25, 72, 180.74, 170.00, 1500, 10);

COMMIT TRANSACTION;
