package billeterie_app.controller;

import billeterie_app.dao.UserDAO;
import billeterie_models.models.User;
import java.util.List;

public class UserController {

    private UserDAO userDAO = new UserDAO();

    public List<User> loadUsers(){
        return userDAO.getAllClients();
    }

    public void addClient(String nom, String prenom, String email, String phone){
    userDAO.addClient(nom, prenom, email, phone);
    }

    public void deleteClient(int id){
    userDAO.deleteClient(id);
}

public void updateClient(int id,String nom,String prenom,String email,String phone){
    userDAO.updateClient(id,nom,prenom,email,phone);
}
}