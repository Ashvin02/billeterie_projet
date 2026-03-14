package billeterie_app.view;

import billeterie_app.controller.LoginController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginView extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private LoginController loginController;

    public LoginView() {
        setTitle("Login");
        setSize(350, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centre la fenêtre

        loginController = new LoginController();

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // marge entre les composants
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Mot de passe:");
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Se connecter");

        // Ligne 1 - Email
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(emailLabel, gbc);

        gbc.gridx = 1;
        panel.add(emailField, gbc);

        // Ligne 2 - Mot de passe
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        // Ligne 3 - Bouton
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        add(panel);

        // Action sur le bouton
        loginButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Récupère l'email et le mot de passe saisis
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        loginController.debugPrintUsers();
        boolean isLogged = loginController.authenticateUser(email, password);

        if (isLogged) {
            JOptionPane.showMessageDialog(null, "Connexion réussie !");
            new DashboardView();
            dispose(); // Ferme la fenêtre de login
        } else {
            JOptionPane.showMessageDialog(null, "Email ou mot de passe incorrect.");
        }
    }
});
        
        setVisible(true);
    }
}
