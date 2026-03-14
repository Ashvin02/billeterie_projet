package billeterie_app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BilletDAO {

    private int eventId;
    private int clientId;
    private double price;
    private String status;
    private int billet_id;

    public ResultSet getAllBillets(){

    String sql = "SELECT billet_id, event_id, client_id, purchase_date, price_paid, status, seat, qr_code FROM billets order by billet_id";

    try{
        Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        return stmt.executeQuery();
    }catch(Exception e){
        e.printStackTrace();
    }

    return null;
}

    public void buyTicket(int eventId, int clientId, double price) {

    String sql = "INSERT INTO billets (event_id, client_id, price_paid) VALUES (?, ?, ?)";

    try {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, eventId);
        stmt.setInt(2, clientId);
        stmt.setDouble(3, price);

        stmt.executeUpdate();

        System.out.println("Ticket acheté avec succès");

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}