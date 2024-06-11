create database newszilla;

use newszilla;


CREATE TABLE video (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       description TEXT,
                       url VARCHAR(255) NOT NULL,
                       duration INT, -- Duration in seconds
                       uploaded_by VARCHAR(255),
                       views INT DEFAULT 0,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE news (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      content TEXT,
                      author VARCHAR(255),
                      published_date DATE,
                      source VARCHAR(255),
                      category VARCHAR(255),
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);




