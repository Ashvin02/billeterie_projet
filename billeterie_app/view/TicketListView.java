package billeterie_app.view;

import billeterie_app.controller.TicketController;
import billeterie_app.dao.BilletDAO;
import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TicketListView extends JFrame {

    public TicketListView(){

        setTitle("Tickets");
        setSize(400,300);
        setLocationRelativeTo(null);

        String[] columns = {"Billet ID","Event","Client","Date","Prix","Siège","Status","QR Code"};
        DefaultTableModel model = new DefaultTableModel(columns,0);

        try {

    BilletDAO dao = new BilletDAO();
    ResultSet rs = dao.getAllBillets();

    while(rs.next()){
        model.addRow(new Object[]{
            rs.getInt("billet_id"),
            rs.getInt("event_id"),
            rs.getInt("client_id"),
            rs.getTimestamp("purchase_date"),
            rs.getDouble("price_paid"),
            rs.getString("seat"),
            rs.getString("status"),
            rs.getString("qr_code")
        });
    }

} catch(Exception e){
    e.printStackTrace();
}

        JTable table = new JTable(model);

        JButton buyButton = new JButton("Acheter ticket");

        buyButton.addActionListener(e -> {

            TicketController controller = new TicketController();

            int eventId = 1;
            int clientId = 1;
            double price = 25;

            controller.acheterTicket(eventId,clientId,price);

            JOptionPane.showMessageDialog(null,"Ticket acheté !");
        });

        add(buyButton,BorderLayout.SOUTH);

        add(new JScrollPane(table));

        setVisible(true);
    }
}