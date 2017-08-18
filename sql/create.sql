-- CREATE DATABASE spring_boot;

CREATE TABLE IF NOT EXISTS users (
  id       SERIAL PRIMARY KEY,
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  role     INTEGER     NOT NULL,
  FOREIGN KEY (role) REFERENCES user_role (id)
);

CREATE TABLE IF NOT EXISTS user_role (
  id   SERIAL PRIMARY KEY,
  role VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS items (
  id      SERIAL PRIMARY KEY,
  name    TEXT    NOT NULL,
  authtor INTEGER NOT NULL,
  FOREIGN KEY (authtor) REFERENCES users (id)
);