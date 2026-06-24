package billeterie_app.controller;

import billeterie_app.dao.Database;
import billeterie_app.dao.UserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {
public LoginController() {
    UserDAO userDAO = new UserDAO();
    debugPrintUsers();
    }  
    
    public boolean authenticateUser(String email, String password) {
    String sql = "SELECT * FROM users WHERE LOWER(email) = LOWER(?) AND password = ?";

    try (Connection conn = Database.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        System.out.println("Tentative de connexion...");
        System.out.println("Email saisi     : [" + email + "]");
        System.out.println("Mot de passe saisi : [" + password + "]");

        stmt.setString(1, email.trim());
        stmt.setString(2, password.trim());

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println("Connexion réussie pour : " + rs.getString("email"));
            return true;
        } else {
            System.out.println("Échec de la connexion : utilisateur non trouvé.");
            return false;
        }

    } catch (Exception e) {
        System.err.println("Erreur de connexion à la base de données !");
        e.printStackTrace();
        return false;
    }
}


    public void debugPrintUsers() {
    try (Connection conn = Database.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
         ResultSet rs = stmt.executeQuery()) {

        System.out.println("Utilisateurs trouvés en base :");
        while (rs.next()) {
            System.out.println("- " + rs.getString("email") + " / " + rs.getString("password"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
