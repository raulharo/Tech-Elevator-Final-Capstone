BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username, password_hash, role) VALUES ('TestingAccount', '$2a$10$3nKljvR0YWzj51pwZpe9/epA/VoRWRlDot0Z8ybD1vHjOdZiFXMeK', 'ROLE_USER');

INSERT INTO profiles (user_id, first_name, last_name, age, height, current_weight, goal_weight, calorie_limit, mindful_goal)
VALUES (1, 'Test', 'User', 25, 72, 180.74, 170.00, 1500, 10);
INSERT INTO profiles (user_id, first_name, last_name, age, height, current_weight, goal_weight, calorie_limit, mindful_goal)
VALUES (3, 'Testing', 'Account', 24, 70, 170, 160, 1800, 30);

INSERT INTO foods (food_name, calories, serving_size, number_of_servings)
VALUES ('Banana', 120, '1 banana', 1);
INSERT INTO foods (food_name, calories, serving_size, number_of_servings)
VALUES ('Bacon', 200, '1 piece', 2);
INSERT INTO foods (food_name, calories, serving_size, number_of_servings)
VALUES ('Cheese', 300, '20g', 3);
INSERT INTO foods (food_name, calories, serving_size, number_of_servings)
VALUES ('Milk', 180, '1 cup', 1);
INSERT INTO foods (food_name, calories, serving_size, number_of_servings)
VALUES ('Pepsi', 150, '1 can', 1);
INSERT INTO foods (food_name, calories, serving_size, number_of_servings)
VALUES ('Bowl of Cereal', 120, '1 banana', 1);
INSERT INTO foods (food_name, calories, serving_size, number_of_servings)
VALUES ('Mango', 100, '1 mango', 1);
INSERT INTO foods (food_name, calories, serving_size, number_of_servings)
VALUES ('Pasta', 300, '5 oz', 1);
INSERT INTO foods (food_name, calories, serving_size, number_of_servings)
VALUES ('Steak', 400, '3 oz', 1);
INSERT INTO foods (food_name, calories, serving_size, number_of_servings)
VALUES ('Cake', 600, '1 slice', 2);

INSERT INTO meal_history (user_id, meal_date, type, total_calories)
VALUES (3, '2023-06-06', 'Breakfast', 320);
INSERT INTO meal_history (user_id, meal_date, type, total_calories)
VALUES (3, '2023-06-06', 'Lunch', 630);
INSERT INTO meal_history (user_id, meal_date, type, total_calories)
VALUES (3, '2023-06-06', 'Dinner', 800);
INSERT INTO meal_history (user_id, meal_date, type, total_calories)
VALUES (3, '2023-06-06', 'Snack', 720);

INSERT INTO meal_history_foods (meal_history_id, food_id)
VALUES (1, 1);
INSERT INTO meal_history_foods (meal_history_id, food_id)
VALUES (1, 2);
INSERT INTO meal_history_foods (meal_history_id, food_id)
VALUES (2, 3);
INSERT INTO meal_history_foods (meal_history_id, food_id)
VALUES (2, 4);
INSERT INTO meal_history_foods (meal_history_id, food_id)
VALUES (2, 5);
INSERT INTO meal_history_foods (meal_history_id, food_id)
VALUES (3, 7);
INSERT INTO meal_history_foods (meal_history_id, food_id)
VALUES (3, 8);
INSERT INTO meal_history_foods (meal_history_id, food_id)
VALUES (3, 9);
INSERT INTO meal_history_foods (meal_history_id, food_id)
VALUES (4, 6);
INSERT INTO meal_history_foods (meal_history_id, food_id)
VALUES (4, 10);

COMMIT TRANSACTION;
