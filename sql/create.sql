-- CREATE DATABASE spring_boot;

CREATE TABLE IF NOT EXISTS user_role (
  id   SERIAL PRIMARY KEY,
  role VARCHAR(10) NOT NULL
);

INSERT INTO user_role (role) VALUES ('USER');
INSERT INTO user_role (role) VALUES ('ADMIN');

CREATE TABLE IF NOT EXISTS users (
  id                      SERIAL PRIMARY KEY,
  username                VARCHAR(20) UNIQUE NOT NULL,
  password                VARCHAR(20) UNIQUE NOT NULL,
  role_id                 INTEGER            NOT NULL,
  account_non_expired     BOOLEAN            NOT NULL DEFAULT TRUE,
  account_non_locked      BOOLEAN            NOT NULL DEFAULT TRUE,
  credentials_non_expired BOOLEAN            NOT NULL DEFAULT TRUE,
  enabled                 BOOLEAN            NOT NULL DEFAULT TRUE,
  FOREIGN KEY (role_id) REFERENCES user_role (id)
);

INSERT INTO users (username, password, role_id) VALUES ('u', 'u', '1');
INSERT INTO users (username, password, role_id) VALUES ('a', 'a', '1');



CREATE TABLE IF NOT EXISTS items (
  id     SERIAL PRIMARY KEY,
  name   TEXT    NOT NULL,
  author INTEGER NOT NULL,
  FOREIGN KEY (author) REFERENCES users (id)
);

INSERT INTO items (name, author) VALUES ('description1', '1');
INSERT INTO items (name, author) VALUES ('description2', '1');
INSERT INTO items (name, author) VALUES ('description3', '1');