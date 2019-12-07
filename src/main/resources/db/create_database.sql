DROP DATABASE IF EXISTS travel_agency;
DROP USER IF EXISTS travel_user;

USE mysql;
CREATE DATABASE travel_agency DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
CREATE USER 'travel_user'@'%' IDENTIFIED BY 'pass';
GRANT ALL ON travel_agency.* TO 'travel_user'@'%';
FLUSH PRIVILEGES;
