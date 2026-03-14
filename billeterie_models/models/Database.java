package billeterie_models.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/billeterie";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            // OBLIGATOIRE : charger le driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connexion JDBC réussie !");
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Driver MySQL non trouvé !");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("❌ Erreur SQL lors de la connexion !");
            e.printStackTrace();
            return null;
        }
    }
}
