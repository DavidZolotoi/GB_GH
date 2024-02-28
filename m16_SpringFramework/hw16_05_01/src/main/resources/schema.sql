create table sometasks (
        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        description VARCHAR(150) NOT NULL,
        status INT NOT NULL --VARCHAR(50) NOT NULL
        -- date_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);