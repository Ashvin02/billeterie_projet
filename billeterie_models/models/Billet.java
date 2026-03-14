package billeterie_models.models;

public class Billet {

    private int id;
    private int eventId;
    private int clientId;
    private double pricePaid;
    private String seat;
    private String status;

    public Billet(int id, int eventId, int clientId, double pricePaid, String seat, String status) {
        this.id = id;
        this.eventId = eventId;
        this.clientId = clientId;
        this.pricePaid = pricePaid;
        this.seat = seat;
        this.status = status;
    }

}