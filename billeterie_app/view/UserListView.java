package billeterie_app.view;

import billeterie_app.controller.UserController;
import billeterie_models.models.User;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserListView extends JFrame {

    public UserListView(){

        setTitle("Clients");
        setSize(400,300);
        setLocationRelativeTo(null);

        UserController controller = new UserController();

        String[] columns = {"ID","Nom","Prénom","Email","Téléphone"};
        DefaultTableModel model = new DefaultTableModel(columns,0);

        JTable table = new JTable(model);
        JButton addButton = new JButton("Ajouter client");
        JButton deleteButton = new JButton("Supprimer client");
        JButton updateButton = new JButton("Modifier client");

        List<User> users = controller.loadUsers();

        for(User u : users){

            model.addRow(new Object[]{
                    u.getId(),
                    u.getNom(),
                    u.getPrenom(),
                    u.getEmail(),
                    u.getPhone(),
            });

        }

        add(new JScrollPane(table));
        JPanel panel = new JPanel();

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        add(panel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {

    String nom = JOptionPane.showInputDialog("Nom");
    String prenom = JOptionPane.showInputDialog("Prénom");
    String email = JOptionPane.showInputDialog("Email");
    String phone = JOptionPane.showInputDialog("Téléphone");

    controller.addClient(nom, prenom, email, phone);

    JOptionPane.showMessageDialog(null,"Client créé !");
});

    updateButton.addActionListener(e -> {

    int row = table.getSelectedRow();

    if(row >= 0){

        int id = (int) model.getValueAt(row,0);

        String nom = JOptionPane.showInputDialog("Nom");
        String prenom = JOptionPane.showInputDialog("Prénom");
        String email = JOptionPane.showInputDialog("Email");
        String phone = JOptionPane.showInputDialog("Téléphone");

        controller.updateClient(id, nom, prenom, email, phone);

        JOptionPane.showMessageDialog(null,"Client modifié !");
    }
});

    deleteButton.addActionListener(e -> {

    int row = table.getSelectedRow();

    if(row >= 0){

        int id = (int) model.getValueAt(row,0);

        controller.deleteClient(id);

        model.removeRow(row);

        JOptionPane.showMessageDialog(null,"Client supprimé !");
    }
});

        setVisible(true);
    }
}