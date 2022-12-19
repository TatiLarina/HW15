package ru.netology.aviatickets;

public class Ticket implements Comparable<Ticket> {
    private int ID;
    private int cost;
    private String departure;
    private String arrival;
    private int time;

    public Ticket(int ID, int cost, String departure, String arrival, int time) {
        this.ID = ID;
        this.cost = cost;
        this.departure = departure;
        this.arrival = arrival;
        this.time = time;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.cost < o.cost) {
            return -1;
        } else if (this.cost > o.cost) {
            return 1;
        } else {
            return 0;
        }
    }
}
