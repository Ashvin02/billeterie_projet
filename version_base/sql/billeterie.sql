-- billeterie.sql
DROP DATABASE IF EXISTS billeterie;
CREATE DATABASE billeterie CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE billeterie;

-- Table clients
CREATE TABLE clients (
  client_id INT AUTO_INCREMENT PRIMARY KEY,
  nom VARCHAR(100),
  prenom VARCHAR(100),
  email VARCHAR(150) NOT NULL UNIQUE,
  phone VARCHAR(20),
  city VARCHAR(100),
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- Table categories
CREATE TABLE categories (
  category_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80) NOT NULL,
  description VARCHAR(255)
) ENGINE=InnoDB;

-- Table events
CREATE TABLE events (
  event_id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(150) NOT NULL,
  description TEXT,
  venue VARCHAR(150),
  city VARCHAR(100),
  start_date DATETIME NOT NULL,
  end_date DATETIME,
  capacity INT DEFAULT 0,
  base_price DECIMAL(8,2) DEFAULT 0.00,
  poster_url VARCHAR(300),
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- Association events <-> categories (many-to-many)
CREATE TABLE event_category (
  event_id INT NOT NULL,
  category_id INT NOT NULL,
  PRIMARY KEY (event_id, category_id),
  FOREIGN KEY (event_id) REFERENCES events(event_id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (category_id) REFERENCES categories(category_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

-- Table billets (tickets)
CREATE TABLE billets (
  billet_id INT AUTO_INCREMENT PRIMARY KEY,
  event_id INT NOT NULL,
  client_id INT NOT NULL,
  purchase_date DATETIME DEFAULT CURRENT_TIMESTAMP,
  price_paid DECIMAL(8,2) NOT NULL,
  seat VARCHAR(20),
  status ENUM('valid','cancelled','refunded') DEFAULT 'valid',
  qr_code VARCHAR(300),
  FOREIGN KEY (event_id) REFERENCES events(event_id) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (client_id) REFERENCES clients(client_id) ON DELETE CASCADE ON UPDATE CASCADE,
  INDEX (event_id),
  INDEX (client_id)
) ENGINE=InnoDB;
