-- data.sql
USE billeterie;

-- 1) categories sample
INSERT INTO categories (name, description) VALUES
('Musique', 'Concerts et festivals'),
('Théâtre', 'Pièces et spectacles'),
('Conférence', 'Talks et conférences'),
('Sport', 'Événements sportifs'),
('Famille', 'Activités familiales');

-- 2) 10 events
INSERT INTO events (title, description, venue, city, start_date, end_date, capacity, base_price, poster_url) VALUES
('Festival Electro Vibes', 'Soirée électro avec artistes internationaux', 'Le Dôme', 'Paris', '2026-05-10 19:00:00', '2026-05-11 03:00:00', 2000, 35.00, 'https://images.unsplash.com/event1'),
('Jazz Nights', 'Quatre soirs de jazz', 'Club du Canal', 'Lyon', '2026-06-01 20:30:00', '2026-06-04 23:00:00', 500, 22.50, 'https://images.unsplash.com/event2'),
('Théâtre: Le Souffle', 'Pièce contemporaine', 'Théâtre Central', 'Marseille', '2026-04-15 20:00:00', '2026-04-15 22:00:00', 250, 15.00, 'https://images.unsplash.com/event3'),
('Conférence IA et Société', 'Table ronde sur l IA', 'Centre des Congrès', 'Paris', '2026-07-12 09:00:00', '2026-07-12 17:00:00', 800, 120.00, 'https://images.unsplash.com/event4'),
('Match Amical FC Metro', 'Match de préparation', 'Stade Municipal', 'Lille', '2026-03-20 18:00:00', '2026-03-20 20:00:00', 15000, 10.00, 'https://images.unsplash.com/event5'),
('Salon Gastronomie', 'Dégustations & ateliers', 'Parc Expo', 'Bordeaux', '2026-09-05 10:00:00', '2026-09-07 19:00:00', 5000, 8.50, 'https://images.unsplash.com/event6'),
('Spectacle Enfants', 'Jeu musical pour enfants', 'Salle des Fêtes', 'Toulouse', '2026-02-14 15:00:00', '2026-02-14 16:30:00', 300, 6.00, 'https://images.unsplash.com/event7'),
('Conférence DevOps', 'Journée technique DevOps', 'Hôtel de Ville', 'Nantes', '2026-11-20 09:00:00', '2026-11-20 17:00:00', 400, 90.00, 'https://images.unsplash.com/event8'),
('Stand-up Comedy Night', 'Soirée humour', 'La Comédie', 'Nice', '2026-08-21 21:00:00', '2026-08-21 23:30:00', 350, 18.00, 'https://images.unsplash.com/event9'),
('Expo Photo Urbaine', 'Exposition de photographies', 'Galerie d''Art', 'Strasbourg', '2026-10-01 11:00:00', '2026-10-31 18:00:00', 1000, 5.00, 'https://images.unsplash.com/event10');

-- 3) Générer 75 clients (MySQL 8+ recursive CTE)
WITH RECURSIVE seq AS (
  SELECT 1 AS n
  UNION ALL
  SELECT n+1 FROM seq WHERE n < 75
)
INSERT INTO clients (full_name, email, phone, city, created_at)
SELECT
  CONCAT('Client ', LPAD(n,2,'0')) AS full_name,
  CONCAT('client',n,'@example.com') AS email,
  CONCAT('+33', LPAD(600000000 + n,9,'0')) AS phone,
  ELT(1 + (n % 10), 'Paris','Lyon','Marseille','Lille','Bordeaux','Toulouse','Nantes','Nice','Strasbourg','Rennes') AS city,
  DATE_ADD('2025-01-01', INTERVAL (n-1) DAY) AS created_at
FROM seq;

-- 4) Générer 100 billets en distribuant clients sur events
WITH RECURSIVE s AS (
  SELECT 1 AS i
  UNION ALL SELECT i+1 FROM s WHERE i < 100
)
INSERT INTO billets (event_id, client_id, purchase_date, price_paid, seat, status, qr_code)
SELECT
  ((i-1) % 10) + 1 AS event_id,
  ((i * 7) % 75) + 1 AS client_id,
  DATE_ADD('2025-09-01 10:00:00', INTERVAL i HOUR) AS purchase_date,
  ROUND((10 + (i % 5) * 5) + (RAND() * 5), 2) AS price_paid,
  CONCAT('R', LPAD(((i % 30)+1),2,'0'), 'S', LPAD(((i % 20)+1),2,'0')) AS seat,
  'valid' AS status,
  CONCAT('QR-', LPAD(i,4,'0')) AS qr_code
FROM s;
