-- billeterie_extension.sql (à exécuter après billeterie.sql et data.sql)
USE billeterie;

-- Table roles
CREATE TABLE roles (
  role_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL
) ENGINE=InnoDB;

-- Table users
CREATE TABLE users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) NOT NULL UNIQUE,
  password_hash VARCHAR(255) NOT NULL,
  email VARCHAR(150) NOT NULL UNIQUE,
  role_id INT,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (role_id) REFERENCES roles(role_id)
) ENGINE=InnoDB;

-- Table payments
CREATE TABLE payments (
  payment_id INT AUTO_INCREMENT PRIMARY KEY,
  billet_id INT NOT NULL,
  amount DECIMAL(8,2) NOT NULL,
  payment_date DATETIME DEFAULT CURRENT_TIMESTAMP,
  method ENUM('cb','paypal','virement'),
  status ENUM('paid','pending','failed') DEFAULT 'paid',
  FOREIGN KEY (billet_id) REFERENCES billets(billet_id)
) ENGINE=InnoDB;

-- Table logs
CREATE TABLE logs (
  log_id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  action VARCHAR(255),
  log_date DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(user_id)
) ENGINE=InnoDB;

-- Données initiales roles + users
INSERT INTO roles (name) VALUES ('admin'), ('client');
INSERT INTO users (username, password_hash, email, role_id) VALUES
('admin', 'hash_mdp_admin', 'admin@billeterie.com', 1),
('client1', 'hash_mdp_client', 'client1@billeterie.com', 2);
