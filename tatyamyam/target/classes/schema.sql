CREATE TABLE IF NOT EXISTS account (
     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     email VARCHAR(255),
     password VARCHAR(255),
     created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
     updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
 
CREATE TABLE IF NOT EXISTS health (
     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     user_id INT NOT NULL,
     FOREIGN KEY(user_id) REFERENCES account(id),
     created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
     updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     comment VARCHAR(255),
     status enum('Green', 'Yellow', 'Red')
);

CREATE TABLE IF NOT EXISTS profile (
     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     user_id INT NOT NULL,
     FOREIGN KEY(user_id) REFERENCES account(id),
     created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
     updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     age INT NOT NULL,
     gender INT NOT NULL,
     name VARCHAR(255),
     goal_comment VARCHAR(255),
     height DECIMAL(5, 1)
);

CREATE TABLE IF NOT EXISTS blood_pressure (
     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     health_id INT NOT NULL,
     FOREIGN KEY(health_id) REFERENCES health(id),
     s_bp INT NOT NULL,
     d_bp INT NOT NULL,
     puls INT NOT NULL,
     created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
     updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP     
);

CREATE TABLE IF NOT EXISTS weight (
     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     health_id INT NOT NULL,
     FOREIGN KEY(health_id) REFERENCES health(id),
     weight INT NOT NULL,
     created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
     updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP     
);


