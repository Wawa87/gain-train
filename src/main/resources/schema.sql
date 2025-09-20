DROP TABLE IF EXISTS exercises;
DROP TABLE IF EXISTS sets;
DROP TABLE IF EXISTS workouts;
DROP TABLE IF EXISTS programs;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
    user_id INTEGER PRIMARY KEY AUTOINCREMENT,
    email TEXT UNIQUE NOT NULL,
    nickname TEXT,
    password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS programs (
    program_id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    name TEXT,
    start_at TEXT,
    end_at TEXT,
    FOREIGN KEY (user_id)
    REFERENCES users (user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS workouts (
    workout_id INTEGER PRIMARY KEY AUTOINCREMENT,
    program_id INTEGER NOT NULL,
    start_at TEXT,
    end_at TEXT,
    FOREIGN KEY (program_id)
    REFERENCES programs (program_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS exercises (
    exercise_id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT
);

CREATE TABLE IF NOT EXISTS sets (
    set_id INTEGER PRIMARY KEY AUTOINCREMENT,
    workout_id INTEGER NOT NULL,
    exercise_id INTEGER NOT NULL,
    set_label TEXT NOT NULL,
    weight INTEGER NOT NULL,
    reps INTEGER NOT NULL,
    notes TEXT,
    FOREIGN KEY (exercise_id)
    REFERENCES exercises (exercise_id)
        ON DELETE NO ACTION
        ON UPDATE CASCADE,
    FOREIGN KEY (workout_id)
    REFERENCES workouts (workout_id)
        ON DELETE NO ACTION
        ON UPDATE CASCADE
);