-- Dodanie użytkowników
INSERT INTO users (username) VALUES
                                 ('john_doe'),
                                 ('jane_smith');

-- Dodanie partii ciała
INSERT INTO bodyparts (name) VALUES
                                 ('Chest'),
                                 ('Back'),
                                 ('Legs'),
                                 ('Arms'),
                                 ('Shoulders');

-- Dodanie typów ćwiczeń
INSERT INTO exercise_types (bp_id, name) VALUES
                                             (1, 'Bench Press'),
                                             (2, 'Deadlift'),
                                             (3, 'Squat'),
                                             (4, 'Bicep Curl'),
                                             (5, 'Shoulder Press');

-- Dodanie szczegółów ćwiczeń
INSERT INTO exercise_detail (start_time, rate, comment) VALUES
                                                            ('08:00:00', 8, 'Good session'),
                                                            ('09:15:00', 7, 'Felt strong'),
                                                            ('10:30:00', 6, 'Tired today');

-- Powiązanie ćwiczeń z typami i szczegółami
INSERT INTO exercises (ex_type_id, ex_detail_id) VALUES
                                                     (1, 1),
                                                     (2, 2),
                                                     (3, 3);

-- Dodanie planów treningowych
INSERT INTO workout_plans (us_id, name, comment) VALUES
                                                     (1, 'Strength Training', 'Heavy lifts, low reps'),
                                                     (2, 'Endurance Workout', 'High reps, moderate weight');

-- Powiązanie ćwiczeń z planami treningowymi
INSERT INTO exercises_workout_plans (ex_id, plan_id) VALUES
                                                         (1, 1),
                                                         (2, 1),
                                                         (3, 2);

-- Dodanie zestawów ćwiczeń
INSERT INTO sets (ex_id, reps, weight, start_time, end_time) VALUES
                                                                 (1, 5, 100, '08:05:00', '08:15:00'),
                                                                 (2, 3, 150, '09:20:00', '09:35:00'),
                                                                 (3, 10, 80, '10:40:00', '10:50:00');

-- Dodanie statystyk użytkowników
INSERT INTO user_stats (user_id, weight, height, date_create) VALUES
                                                                  (1, 80, 180, '2025-02-13'),
                                                                  (2, 65, 170, '2025-02-13');

-- Dodanie treningów
INSERT INTO workouts (user_id, start_date, end_time) VALUES
                                                         (1, '2025-02-13', '09:00:00'),
                                                         (2, '2025-02-13', '11:00:00');

-- Powiązanie treningów z ćwiczeniami
INSERT INTO workouts_exercises (workout_id, ex_id) VALUES
                                                       (1, 1),
                                                       (1, 2),
                                                       (2, 3);
