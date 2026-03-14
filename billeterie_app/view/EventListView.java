package billeterie_app.view;

import billeterie_app.controller.EventController;
import billeterie_models.models.Evenement;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EventListView extends JFrame {

    private JTable table;
    private EventController controller;

    public EventListView() {

        controller = new EventController();

        setTitle("Liste des événements");
        setSize(500,400);
        setLocationRelativeTo(null);

        String[] columns = {"Id", "Titre", "Ville", "Date de début", "Capacité", "Prix"};
        DefaultTableModel model = new DefaultTableModel(columns,0);

        table = new JTable(model);
        JButton addEventButton = new JButton("Créer événement");

        List<Evenement> events = controller.loadEvents();

        for(Evenement e : events){

            model.addRow(new Object[]{
                e.getId(),
                e.getTitle(),
                e.getCity(),
                e.getStartDate(),
                e.getCapacity(),
                e.getPrice()
            });

        }

        add(new JScrollPane(table), BorderLayout.CENTER);
        addEventButton.addActionListener(e -> {

    String title = JOptionPane.showInputDialog("Titre événement");
    String city = JOptionPane.showInputDialog("Ville");
    String date = JOptionPane.showInputDialog("Date (YYYY-MM-DD HH:MM:SS)");
    int capacity = Integer.parseInt(JOptionPane.showInputDialog("Capacité"));
    double price = Double.parseDouble(JOptionPane.showInputDialog("Prix"));

    controller.addEvent(title,city,date,capacity,price);

    JOptionPane.showMessageDialog(null,"Evénement créé !");
});

        add(addEventButton, BorderLayout.SOUTH);
        setVisible(true);
    }
}