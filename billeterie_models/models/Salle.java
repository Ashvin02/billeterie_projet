package billeterie_models.models;

public class Salle {
    private int id;
    private String nom;
    private int capacite;
    private String localisation;

    public Salle(int id, String nom, int capacite, String localisation) {
        this.id = id;
        this.nom = nom;
        this.capacite = capacite;
        this.localisation = localisation;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public int getCapacite() { return capacite; }
    public String getLocalisation() { return localisation; }

    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setCapacite(int capacite) { this.capacite = capacite; }
    public void setLocalisation(String localisation) { this.localisation = localisation; }
}
