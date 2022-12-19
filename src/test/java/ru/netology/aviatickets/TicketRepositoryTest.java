package ru.netology.aviatickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {

    Ticket ticket1 = new Ticket(1, 4231, "ARH", "SVO", 115);
    Ticket ticket2 = new Ticket(2, 2820, "ARH", "SVO", 130);
    Ticket ticket3 = new Ticket(3, 5666, "ARH", "SVO", 130);

    @Test
    public void save() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void remove() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.removeById(2);

        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNonexistentID() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.removeById(10);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNegativeID() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);

        Assertions.assertThrows(NegativeIdException.class, () -> {
            repo.removeById(-100);
        });
    }

}
