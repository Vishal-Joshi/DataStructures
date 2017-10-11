package com.example;

import java.util.List;

public class TicketSort {

    public static void main(String[] args) {
        Ticket puneToNewDelhi = new TicketSort.Ticket("pune", "delhi");
        Ticket delhiToShanghai = new TicketSort.Ticket("delhi", "shanghai");
        Ticket shanghaiToBangkok = new TicketSort.Ticket("shanghai", "bangkok");
        Ticket bangkokToTokyo = new TicketSort.Ticket("bangkok", "tokyo");


    }

    public Node findRoute(List<Ticket> listOfTickets) {
        Node node = new Node(listOfTickets.get(0));
        for (int index = 1; index < listOfTickets.size(); index++) {

        }
        return node;
    }


    static class Ticket {
        private String source;
        private String destination;

        public Ticket(String source, String destination) {
            this.source = source;
            this.destination = destination;
        }

        public String getDestination() {
            return destination;
        }

        public String getSource() {
            return source;
        }
    }

    static class Node {
        private Ticket ticket;

        public Node(Ticket ticket) {
            this.ticket = ticket;
        }

        public String getPrevious() {
            return ticket.getSource();
        }

        public String getNext() {
            return ticket.getDestination();
        }
    }
}

