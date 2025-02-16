-- Insert users
INSERT INTO users (username) VALUES ('JohnDoe');
INSERT INTO users (username) VALUES ('JaneSmith');

-- Insert user statistics
INSERT INTO user_stats (user_id, weight, height, date_create) VALUES (1, 80, 180, '2025-02-13');
INSERT INTO user_stats (user_id, weight, height, date_create) VALUES (2, 65, 170, '2025-02-13');

-- Insert workout plans
INSERT INTO workout_plans (us_id, name, comment) VALUES (1, 'Full Body', 'Full-body workout plan');

-- Insert body parts
INSERT INTO bodyparts (name) VALUES ('Legs');
INSERT INTO bodyparts (name) VALUES ('Chest');
INSERT INTO bodyparts (name) VALUES ('Back');
INSERT INTO bodyparts (name) VALUES ('Shoulders');
INSERT INTO bodyparts (name) VALUES ('Arms');

-- Insert exercise types
INSERT INTO exercise_types (bp_id, name) VALUES (1, 'Squats');
INSERT INTO exercise_types (bp_id, name) VALUES (2, 'Bench Press');
INSERT INTO exercise_types (bp_id, name) VALUES (3, 'Deadlift');
INSERT INTO exercise_types (bp_id, name) VALUES (4, 'Overhead Press');
INSERT INTO exercise_types (bp_id, name) VALUES (5, 'Bicep Curl');

-- Insert exercise details
INSERT INTO exercise_detail (start_time, rate, comment) VALUES ('10:00', 8, 'Good form');
INSERT INTO exercise_detail (start_time, rate, comment) VALUES ('10:30', 7, 'Could be better');

-- Insert workouts
INSERT INTO workouts (user_id, start_date, start_time, end_time) VALUES (1, '2025-02-13', '09:00', '10:30');
INSERT INTO workouts (user_id, start_date, start_time, end_time) VALUES (2, '2025-02-13', '11:00', '12:30');

-- Insert exercises
INSERT INTO exercises (ex_type_id, ex_detail_id, w_id, wp_id) VALUES (1, 1, 1, 1);
INSERT INTO exercises (ex_type_id, ex_detail_id, w_id, wp_id) VALUES (2, 2, 1, 1);
INSERT INTO exercises (ex_type_id, ex_detail_id, w_id, wp_id) VALUES (3, NULL, 2, 2);

-- Insert sets (reps and weights for each exercise)
INSERT INTO sets (ex_id, reps, weight, start_time, end_time) VALUES (1, 10, 100, '09:05', '09:10');
INSERT INTO sets (ex_id, reps, weight, start_time, end_time) VALUES (1, 8, 110, '09:12', '09:18');
INSERT INTO sets (ex_id, reps, weight, start_time, end_time) VALUES (2, 12, 80, '09:30', '09:35');
INSERT INTO sets (ex_id, reps, weight, start_time, end_time) VALUES (3, 10, 120, '11:10', '11:15');

-- Insert exercises into sample workout plan
INSERT INTO exercises (ex_type_id, wp_id) VALUES (1, 1);
INSERT INTO exercises (ex_type_id, wp_id) VALUES (2, 1);
INSERT INTO exercises (ex_type_id, wp_id) VALUES (3, 1);
INSERT INTO exercises (ex_type_id, wp_id) VALUES (4, 1);
INSERT INTO exercises (ex_type_id, wp_id) VALUES (5, 1);
INSERT INTO sets (ex_id, reps, weight) VALUES (4, 8, 100);
INSERT INTO sets (ex_id, reps, weight) VALUES (4, 8, 100);
INSERT INTO sets (ex_id, reps, weight) VALUES (4, 8, 100);
INSERT INTO sets (ex_id, reps, weight) VALUES (5, 12, 60);
INSERT INTO sets (ex_id, reps, weight) VALUES (5, 10, 65);
INSERT INTO sets (ex_id, reps, weight) VALUES (5, 8, 70);
INSERT INTO sets (ex_id, reps, weight) VALUES (6, 12, 80);
INSERT INTO sets (ex_id, reps, weight) VALUES (6, 10, 85);
INSERT INTO sets (ex_id, reps, weight) VALUES (6, 8, 90);
INSERT INTO sets (ex_id, reps, weight) VALUES (7, 15, 20);
INSERT INTO sets (ex_id, reps, weight) VALUES (7, 15, 20);
INSERT INTO sets (ex_id, reps, weight) VALUES (7, 15, 20);
INSERT INTO sets (ex_id, reps, weight) VALUES (8, 15, 17.5);
INSERT INTO sets (ex_id, reps, weight) VALUES (8, 15, 17.5);
INSERT INTO sets (ex_id, reps, weight) VALUES (8, 15, 17.5);
