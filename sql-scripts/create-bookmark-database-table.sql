DROP DATABASE IF EXISTS bookmark_database;

CREATE DATABASE bookmark_database;

USE bookmark_database;

CREATE TABLE bookmark(
id INT NOT NULL AUTO_INCREMENT,
song_name VARCHAR(50) NOT NULL,
artist_name VARCHAR(50) NOT NULL,
link VARCHAR(200) NOT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;