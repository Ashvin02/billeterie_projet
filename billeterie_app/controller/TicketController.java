package billeterie_app.controller;

import billeterie_app.dao.BilletDAO;

public class TicketController {

    private BilletDAO billetDAO = new BilletDAO();

    public void acheterTicket(int eventId,int clientId,double price){
        billetDAO.buyTicket(eventId,clientId,price);
    }
}