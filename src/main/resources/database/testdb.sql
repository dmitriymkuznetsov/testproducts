-- create database
DROP DATABASE IF EXISTS testdb;
CREATE DATABASE testdb;
CREATE USER testuser WITH password 'qwerty';
GRANT ALL privileges ON DATABASE testdb TO testuser;
\c testdb;

--create tables
CREATE TABLE cat (
    id SERIAL NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT cat_pkey PRIMARY KEY (id)
);

ALTER TABLE cat OWNER TO testuser;

CREATE TABLE prod (
    id SERIAL NOT NULL,
    name VARCHAR(255) NOT NULL,
    price NUMERIC(16,2) NOT NULL,
    cat_id INT,
    CONSTRAINT prod_pkey PRIMARY KEY (id),
    CONSTRAINT prod_cat_fkey FOREIGN KEY (cat_id) REFERENCES cat(id)
);

ALTER TABLE prod OWNER TO testuser;

--insert test data
INSERT INTO cat (id, name) VALUES (1, 'HTC');
INSERT INTO cat (id, name) VALUES (2, 'Samsung');
INSERT INTO cat (id, name) VALUES (3, 'Sony');
INSERT INTO cat (id, name) VALUES (4, 'Apple');

INSERT INTO prod (id, name, price, cat_id) VALUES (1, 'Desire 630 DS', 1234, 1);
INSERT INTO prod (id, name, price, cat_id) VALUES (3, 'A300F Galaxy', 7000.7, 2);
INSERT INTO prod (id, name, price, cat_id) VALUES (2, 'Galaxy S4', 1000.8, 2);
INSERT INTO prod (id, name, price, cat_id) VALUES (4, 'T328W Desire V', 12500.4, 1);
INSERT INTO prod (id, name, price, cat_id) VALUES (5, 'Topaz Gold 10', 25799, 1);
INSERT INTO prod (id, name, price, cat_id) VALUES (6, 'Xperia XA', 19999.99, 3);
INSERT INTO prod (id, name, price, cat_id) VALUES (7, 'iPhone 5s', 25999, 4);
INSERT INTO prod (id, name, price, cat_id) VALUES (8, 'iPad 2', 31990.9, 4);
INSERT INTO prod (id, name, price, cat_id) VALUES (9, 'E5533 Xperia C5', 13940, 3);
\c postgres;