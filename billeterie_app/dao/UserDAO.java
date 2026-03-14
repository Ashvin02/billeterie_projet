package billeterie_app.dao;

import billeterie_models.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public boolean checkCredentials(String email, String password) {
        String sql = "SELECT * FROM clients WHERE email = ? AND password = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<User> getAllClients(){

    List<User> clients = new ArrayList<>();

    String sql = "SELECT client_id, nom, prenom, email, phone FROM clients";

    try(Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()){

        while(rs.next()){

            User u = new User(
                rs.getInt("client_id"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getString("email"),
                rs.getString("phone")
            );

            clients.add(u);
        }

    }catch(Exception e){
        e.printStackTrace();
    }

    return clients;
}

public void addClient(String nom, String prenom, String email, String phone){

    String sql = "INSERT INTO clients(nom, prenom, email, phone) VALUES(?,?,?,?)";

    try{
        Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, nom);
        stmt.setString(2, prenom);
        stmt.setString(3, email);
        stmt.setString(4, phone);

        stmt.executeUpdate();

        System.out.println("Client ajouté");

    }catch(Exception e){
        e.printStackTrace();
    }
}

public void deleteClient(int id){

    String sql = "DELETE FROM clients WHERE client_id=?";

    try{
        Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1,id);
        stmt.executeUpdate();

    }catch(Exception e){
        e.printStackTrace();
    }
}

public void updateClient(int id,String nom,String prenom,String email,String phone){

    String sql = "UPDATE clients SET nom=?, prenom=?, email=?, phone=? WHERE client_id=?";

    try{
        Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1,nom);
        stmt.setString(2,prenom);
        stmt.setString(3,email);
        stmt.setString(4,phone);
        stmt.setInt(5,id);

        stmt.executeUpdate();

    }catch(Exception e){
        e.printStackTrace();
    }
}

}
