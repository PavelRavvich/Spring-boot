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
  account_non_expired     BOOLEAN            NOT NULL DEFAULT TRUE,
  account_non_locked      BOOLEAN            NOT NULL DEFAULT TRUE,
  credentials_non_expired BOOLEAN            NOT NULL DEFAULT TRUE,
  enabled                 BOOLEAN            NOT NULL DEFAULT TRUE
);

INSERT INTO users (username, password) VALUES ('u', 'u');
INSERT INTO users (username, password) VALUES ('a', 'a');


CREATE TABLE user_id_role_id (
  id      SERIAL PRIMARY KEY,
  user_id INTEGER NOT NULL,
  role_id INTEGER NOT NULL,
  FOREIGN KEY (role_id) REFERENCES user_role (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO user_id_role_id (user_id, role_id) VALUES ('1', '1');
INSERT INTO user_id_role_id (user_id, role_id) VALUES ('2', '1');


CREATE TABLE IF NOT EXISTS items (
  id          SERIAL PRIMARY KEY,
  description TEXT    NOT NULL,
  author_id     INTEGER NOT NULL,
  FOREIGN KEY (author_id) REFERENCES users (id)
);

INSERT INTO items (description, author_id) VALUES ('description1', '1');
INSERT INTO items (description, author_id) VALUES ('description2', '1');
INSERT INTO items (description, author_id) VALUES ('description3', '1');