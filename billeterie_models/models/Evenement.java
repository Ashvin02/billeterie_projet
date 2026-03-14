package billeterie_models.models;

import java.time.LocalDateTime;

public class Evenement {

    private int id;
    private String title;
    private String city;
    private LocalDateTime startDate;
    private int capacity;
    private double price;

    public Evenement(int id, String title, String city, LocalDateTime startDate, int capacity, double price) {
        this.id = id;
        this.title = title;
        this.city = city;
        this.startDate = startDate;
        this.capacity = capacity;
        this.price = price;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCity() { return city; }
    public LocalDateTime getStartDate() { return startDate; }
    public int getCapacity() { return capacity; }
    public double getPrice() { return price; }
}