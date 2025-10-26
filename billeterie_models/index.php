<?php
require_once 'Database.php';
require_once 'models/User.php';
require_once 'models/Role.php';
require_once 'models/Payment.php';
require_once 'models/Log.php';
require_once 'models/Billet.php';
require_once 'models/Evenement.php';
require_once 'models/Salle.php';

echo "<h2>Connexion et tests PHP 7.4</h2>";

try {
    $pdo = Database::getConnection();
    echo "<p>Connexion OK</p>";
} catch (Exception $e) {
    echo "<p>Erreur de connexion: " . $e->getMessage() . "</p>";
    exit;
}

$userModel = new UserModel();
$users = $userModel->getAll();
echo "<h3>Users</h3><pre>" . print_r(array_slice($users,0,5), true) . "</pre>";
?>
