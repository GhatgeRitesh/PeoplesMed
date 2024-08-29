--schema for testing services .
CREATE DATABASE peoplesMed1;

USE peoplesMed1;

CREATE TABLE Doctor (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200),
    email VARCHAR(200),
    contact VARCHAR(15),
    degree VARCHAR(200),
    specialization VARCHAR(200),
    city VARCHAR(200),
    password VARCHAR(200)
);