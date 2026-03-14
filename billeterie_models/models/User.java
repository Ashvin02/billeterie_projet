package billeterie_models.models;

public class User {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String phone;

    public User(int id, String nom, String prenom, String email, String phone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}