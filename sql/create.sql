-- CREATE DATABASE spring_boot;

CREATE TABLE IF NOT EXISTS user_role (
  id   SERIAL PRIMARY KEY,
  role VARCHAR(10)
);

INSERT INTO user_role (role) VALUES ('USER');
INSERT INTO user_role (role) VALUES ('ADMIN');

CREATE TABLE IF NOT EXISTS users (
  id       SERIAL PRIMARY KEY,
  username VARCHAR(20) UNIQUE NOT NULL,
  password VARCHAR(20) UNIQUE NOT NULL,
  role     INTEGER     NOT NULL,
  FOREIGN KEY (role) REFERENCES user_role (id)
);

INSERT INTO users (username, password, role) VALUES ('u', 'u', '1');
INSERT INTO users (username, password, role) VALUES ('a', 'a', '1');

CREATE TABLE IF NOT EXISTS items (
  id      SERIAL PRIMARY KEY,
  name    TEXT    NOT NULL,
  authtor INTEGER NOT NULL,
  FOREIGN KEY (authtor) REFERENCES users (id)
);

INSERT INTO items (name, authtor) VALUES ('description1', '1');
INSERT INTO items (name, authtor) VALUES ('description2', '1');
INSERT INTO items (name, authtor) VALUES ('description3', '1');