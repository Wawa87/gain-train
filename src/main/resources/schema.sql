DROP TABLE IF EXISTS exercises;
DROP TABLE IF EXISTS sets;
DROP TABLE IF EXISTS workouts;
DROP TABLE IF EXISTS programs;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
    user_id INT PRIMARY KEY,
    email TEXT UNIQUE NOT NULL,
    nickname TEXT,
    password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS programs (
    program_id INT PRIMARY KEY,
    user_id INT NOT NULL,
    name TEXT,
    startAt TEXT,
    endAt TEXT,
    FOREIGN KEY (user_id)
    REFERENCES users (user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS workouts (
    workout_id INT PRIMARY KEY,
    program_id INT NOT NULL,
    startAt TEXT,
    endAt TEXT,
    FOREIGN KEY (program_id)
    REFERENCES programs (program_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS exercises (
    exercise_id INT PRIMARY KEY,
    name TEXT
);

CREATE TABLE IF NOT EXISTS sets (
    set_id INT PRIMARY KEY,
    exercise_id INT NOT NULL,
    set_label TEXT NOT NULL,
    weight INT NOT NULL,
    reps INT NOT NULL,
    notes TEXT,
    FOREIGN KEY (exercise_id)
    REFERENCES exercises (exercise_id)
        ON DELETE NO ACTION
        ON UPDATE CASCADE
);