package billeterie_app.view;

import java.awt.*;
import javax.swing.*;

public class DashboardView extends JFrame {

    public DashboardView() {

        setTitle("Ticket Master");
        setSize(400,300);
        setLocationRelativeTo(null);

        JButton eventButton = new JButton("Voir événements");
        JButton userButton = new JButton("Voir clients");
        JButton ticketButton = new JButton("Voir tickets");

        setLayout(new GridLayout(3,1));

        add(eventButton);
        add(userButton);
        add(ticketButton);

        eventButton.addActionListener(e -> new EventListView());
        userButton.addActionListener(e -> new UserListView());
        ticketButton.addActionListener(e -> new TicketListView());

        setVisible(true);
    }
}