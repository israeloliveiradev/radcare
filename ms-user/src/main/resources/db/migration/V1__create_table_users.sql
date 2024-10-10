CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    gender VARCHAR(50),
    phone_number VARCHAR(50),
    birth_date DATE,
    zip_code VARCHAR(50),
    document_id VARCHAR(255) NOT NULL,
    administrator BOOLEAN
);