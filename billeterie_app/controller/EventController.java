package billeterie_app.controller;

import billeterie_app.dao.EventDAO;
import billeterie_models.models.Evenement;
import java.util.List;

public class EventController {

    private EventDAO eventDAO;

    public EventController() {
        eventDAO = new EventDAO();
    }

    public List<Evenement> loadEvents() {
        return eventDAO.getAllEvents();
    }

    public void addEvent(String title,String city,String date,int capacity,double price){
    eventDAO.addEvent(title,city,date,capacity,price);
}
}