package billeterie_models.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Index {
    public static void main(String[] args) {
        try (Connection conn = Database.getConnection()) {
            System.out.println("Connexion réussie à la base de données !");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nom: " + rs.getString("nom"));
            }

        } catch (Exception e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
        }
    }
}