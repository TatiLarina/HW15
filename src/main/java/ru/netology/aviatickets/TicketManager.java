package ru.netology.aviatickets;

import java.util.Arrays;

import static java.util.regex.Pattern.matches;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] getTickets() {
        Arrays.sort(repo.getTickets());
        return repo.getTickets();
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket.getDeparture(), from)) {
                if (matches(ticket.getArrival(), to)) {
                    Ticket[] tmp = new Ticket[result.length + 1];
                    for (int i = 0; i < result.length; i++) {
                        tmp[i] = result[i];
                    }
                    tmp[tmp.length - 1] = ticket;
                    result = tmp;
                }
            }
        }

        if (result.length == 0) {
            throw new NegativeIdException(
                    "Билеты по данному направлению отсутствуют"
            );
        }

        Arrays.sort(result);
        return result;
    }
}
