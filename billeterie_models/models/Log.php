<?php
require_once __DIR__ . '/../Database.php';

class LogModel {
    private $pdo;
    private $table;

    public function __construct() {
        $this->pdo = Database::getConnection();
        $this->table = 'logs';
    }

    public function getAll() {
        $stmt = $this->pdo->query("SELECT * FROM " . $this->table);
        return $stmt->fetchAll();
    }

    public function getById($id) {
        $stmt = $this->pdo->prepare("SELECT * FROM " . $this->table . " WHERE log_id = ?");
        $stmt->execute([$id]);
        return $stmt->fetch();
    }

    public function insert($data) {
        $fields = array_keys($data);
        $placeholders = array_fill(0, count($fields), '?');
        $sql = "INSERT INTO " . $this->table . " (" . implode(',', $fields) . ") VALUES (" . implode(',', $placeholders) . ")";
        $stmt = $this->pdo->prepare($sql);
        return $stmt->execute(array_values($data));
    }

    public function update($id, $data) {
        $fields = array_keys($data);
        $setParts = array_map(function($f) { return "$f = ?"; }, $fields);
        $set = implode(', ', $setParts);
        $sql = "UPDATE " . $this->table . " SET " . $set . " WHERE log_id = ?";
        $stmt = $this->pdo->prepare($sql);
        $params = array_values($data);
        $params[] = $id;
        return $stmt->execute($params);
    }

    public function delete($id) {
        $stmt = $this->pdo->prepare("DELETE FROM " . $this->table . " WHERE log_id = ?");
        return $stmt->execute([$id]);
    }
}
?>
