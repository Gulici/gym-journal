CREATE TABLE bodyparts (
                           id   INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                           name varchar(255) NOT NULL UNIQUE);
CREATE TABLE exercise_detail (
                                 id         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                                 start_time time,
                                 rate       integer(10),
                                 comment    varchar(255));
CREATE TABLE exercise_types (
                                id    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                                bp_id integer(10) NOT NULL,
                                name  varchar(255) NOT NULL UNIQUE,
                                FOREIGN KEY(bp_id) REFERENCES bodyparts(id));
CREATE TABLE exercises (
                           id           INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                           ex_type_id   integer(10) NOT NULL,
                           ex_detail_id integer(10) UNIQUE,
                           FOREIGN KEY(ex_detail_id) REFERENCES exercise_detail(id),
                           FOREIGN KEY(ex_type_id) REFERENCES exercise_types(id));
CREATE TABLE exercises_workout_plans (
                                         ex_id   integer(10) NOT NULL,
                                         plan_id integer(10) NOT NULL,
                                         PRIMARY KEY (ex_id,
                                                      plan_id),
                                         FOREIGN KEY(ex_id) REFERENCES exercises(id),
                                         FOREIGN KEY(plan_id) REFERENCES workout_plans(id));
CREATE TABLE sets (
                      id         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                      ex_id      integer(10) NOT NULL,
                      reps       integer(10) NOT NULL,
                      weight     integer(10),
                      start_time time,
                      end_time   time,
                      FOREIGN KEY(ex_id) REFERENCES exercises(id));
CREATE TABLE user_stats (
                            id          INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                            user_id     integer(10) NOT NULL,
                            weight      integer(10) NOT NULL,
                            height      integer(10) NOT NULL,
                            date_create date NOT NULL,
                            FOREIGN KEY(user_id) REFERENCES users(id));
CREATE TABLE users (
                       id       INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                       username varchar(255) NOT NULL UNIQUE);
CREATE TABLE workout_plans (
                               id      INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                               us_id   integer(10) NOT NULL,
                               name    varchar(255) NOT NULL UNIQUE,
                               comment varchar(255),
                               FOREIGN KEY(us_id) REFERENCES users(id));
CREATE TABLE workouts (
                          id         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                          user_id    integer(10) NOT NULL,
                          start_date date NOT NULL,
                          end_time   time NOT NULL,
                          FOREIGN KEY(user_id) REFERENCES users(id));
CREATE TABLE workouts_exercises (
                                    workout_id integer(10) NOT NULL,
                                    ex_id      integer(10) NOT NULL,
                                    PRIMARY KEY (workout_id,
                                                 ex_id),
                                    FOREIGN KEY(workout_id) REFERENCES workouts(id),
                                    FOREIGN KEY(ex_id) REFERENCES exercises(id));

