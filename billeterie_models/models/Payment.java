package billeterie_models.models;

public class Payment {
    private int id;
    private double montant;
    private String methode;
    private String statut;
    private int utilisateurId;

    public Payment(int id, double montant, String methode, String statut, int utilisateurId) {
        this.id = id;
        this.montant = montant;
        this.methode = methode;
        this.statut = statut;
        this.utilisateurId = utilisateurId;
    }

    public int getId() { return id; }
    public double getMontant() { return montant; }
    public String getMethode() { return methode; }
    public String getStatut() { return statut; }
    public int getUtilisateurId() { return utilisateurId; }

    public void setId(int id) { this.id = id; }
    public void setMontant(double montant) { this.montant = montant; }
    public void setMethode(String methode) { this.methode = methode; }
    public void setStatut(String statut) { this.statut = statut; }
    public void setUtilisateurId(int utilisateurId) { this.utilisateurId = utilisateurId; }
}
