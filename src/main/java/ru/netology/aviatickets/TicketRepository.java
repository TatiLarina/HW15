package ru.netology.aviatickets;

public class TicketRepository {

    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void removeById(int id) {
        if (id < 0) {
            throw new NegativeIdException(
                    "ID не может быть отрицательным: " + id
            );
        }

        boolean right = false;
        for (Ticket ticket : tickets) {
            if (ticket.getID() == id) {
                right = true;
                break;
            }
        }

        if (right) {
            Ticket[] tmp = new Ticket[tickets.length - 1];
            int copyToIndex = 0;
            for (Ticket ticket : tickets) {
                if (ticket.getID() != id) {
                    tmp[copyToIndex] = ticket;
                    copyToIndex++;
                }
            }
            tickets = tmp;
        }
    }

    public Ticket[] getTickets() {
        return tickets;
    }
}
