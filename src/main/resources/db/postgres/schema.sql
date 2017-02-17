DROP TABLE book;
DROP TABLE book_store;
DROP TABLE user;

CREATE TABLE book (
  id            serial PRIMARY KEY,
  book_store_id BIGINT,
  name          VARCHAR(80),
  author        VARCHAR(80),
  price         DECIMAL(10,2),
  topic         VARCHAR(80),
  publish_date  DATE
);

CREATE TABLE book_store (
  id           serial PRIMARY KEY,
  name         VARCHAR(80),
  address      VARCHAR(80)
);

CREATE TABLE "user" (
  id            serial PRIMARY KEY,
  username      VARCHAR(80),
  password      VARCHAR(80)
);