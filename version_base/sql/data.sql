-- data.sql
USE billeterie;

-- 1) Catégories
INSERT INTO categories (name, description) VALUES
('Musique', 'Concerts et festivals'),
('Théâtre', 'Pièces et spectacles'),
('Conférence', 'Talks et conférences'),
('Sport', 'Événements sportifs'),
('Famille', 'Activités familiales');

-- 2) 10 événements
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

-- 3) 10 clients
INSERT INTO clients (nom, prenom, email, phone) VALUES
('Dupont', 'Jean', 'jean.dupont@example.com', '0600000001'),
('Martin', 'Lucie', 'lucie.martin@example.com', '0600000002'),
('Durand', 'Pierre', 'pierre.durand@example.com', '0600000003'),
('Bernard', 'Sophie', 'sophie.bernard@example.com', '0600000004'),
('Petit', 'Julien', 'julien.petit@example.com', '0600000005'),
('Leroy', 'Camille', 'camille.leroy@example.com', '0600000006'),
('Moreau', 'Nicolas', 'nicolas.moreau@example.com', '0600000007'),
('Fournier', 'Emma', 'emma.fournier@example.com', '0600000008'),
('Girard', 'Lucas', 'lucas.girard@example.com', '0600000009'),
('Mercier', 'Léa', 'lea.mercier@example.com', '0600000010');


-- 4) 20 billets simples (remplace la génération automatique)
INSERT INTO billets (event_id, client_id, purchase_date, price_paid, seat, status, qr_code) VALUES
(1, 1, '2025-09-01 10:00:00', 35.00, 'R01S01', 'valid', 'QR-0001'),
(1, 2, '2025-09-01 10:15:00', 35.00, 'R01S02', 'valid', 'QR-0002'),
(2, 3, '2025-09-01 11:00:00', 22.50, 'R01S01', 'valid', 'QR-0003'),
(2, 4, '2025-09-01 11:20:00', 22.50, 'R01S02', 'valid', 'QR-0004'),
(3, 5, '2025-09-02 14:00:00', 15.00, 'R01S01', 'valid', 'QR-0005'),
(3, 6, '2025-09-02 14:05:00', 15.00, 'R01S02', 'valid', 'QR-0006'),
(4, 7, '2025-09-03 09:30:00', 120.00, 'R01S01', 'valid', 'QR-0007'),
(4, 8, '2025-09-03 09:45:00', 120.00, 'R01S02', 'valid', 'QR-0008'),
(5, 9, '2025-09-04 18:00:00', 10.00, 'R01S01', 'valid', 'QR-0009'),
(5, 10, '2025-09-04 18:10:00', 10.00, 'R01S02', 'valid', 'QR-0010'),
(6, 1, '2025-09-05 10:00:00', 8.50, 'R01S01', 'valid', 'QR-0011'),
(7, 2, '2025-09-05 15:00:00', 6.00, 'R01S01', 'valid', 'QR-0012'),
(8, 3, '2025-09-06 09:00:00', 90.00, 'R01S01', 'valid', 'QR-0013'),
(9, 4, '2025-09-06 21:00:00', 18.00, 'R01S01', 'valid', 'QR-0014'),
(10, 5, '2025-09-07 11:00:00', 5.00, 'R01S01', 'valid', 'QR-0015'),
(1, 6, '2025-09-08 19:00:00', 35.00, 'R02S01', 'valid', 'QR-0016'),
(2, 7, '2025-09-09 20:00:00', 22.50, 'R02S01', 'valid', 'QR-0017'),
(3, 8, '2025-09-10 20:00:00', 15.00, 'R02S01', 'valid', 'QR-0018'),
(4, 9, '2025-09-11 09:00:00', 120.00, 'R02S01', 'valid', 'QR-0019'),
(5, 10, '2025-09-12 18:00:00', 10.00, 'R02S01', 'valid', 'QR-0020');
