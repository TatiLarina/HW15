package ru.netology.aviatickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 4231, "ARH", "SVO", 115);
    Ticket ticket2 = new Ticket(2, 2820, "ARH", "SVO", 130);
    Ticket ticket3 = new Ticket(3, 5666, "ARH", "SVO", 130);
    Ticket ticket4 = new Ticket(4, 2820, "SVO", "ARH", 110);
    Ticket ticket5 = new Ticket(5, 1895, "VKO", "LED", 80);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    public void getTickets() {
        Ticket[] expected = {ticket5, ticket2, ticket4, ticket1, ticket3};
        Ticket[] actual = manager.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAll() {

        Ticket[] expected = {ticket2, ticket1, ticket3};
        Ticket[] actual = manager.findAll("ARH", "SVO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void NoFind() {

        Assertions.assertThrows(NegativeIdException.class, () -> {
            manager.findAll("LED", "ARH");
        });

    }

}
