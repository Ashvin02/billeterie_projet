package billeterie_app.dao;

import billeterie_models.models.Evenement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    public List<Evenement> getAllEvents() {

        List<Evenement> events = new ArrayList<>();

        String sql = "SELECT * FROM events";

        try(Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){

            while(rs.next()){

                Evenement e = new Evenement(
                        rs.getInt("event_id"),
                        rs.getString("title"),
                        rs.getString("city"),
                        rs.getTimestamp("start_date").toLocalDateTime(),
                        rs.getInt("capacity"),
                        rs.getDouble("base_price")
                );

                events.add(e);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return events;
    }
    public void addEvent(String title,String city,String date,int capacity,double price){

    String sql = "INSERT INTO events(title,city,start_date,capacity,base_price) VALUES(?,?,?,?,?)";

    try{
        Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1,title);
        stmt.setString(2,city);
        stmt.setString(3,date);
        stmt.setInt(4,capacity);
        stmt.setDouble(5,price);

        stmt.executeUpdate();

        System.out.println("Evénement créé");

    }catch(Exception e){
        e.printStackTrace();
    }
}
}