package com.hotel;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

    public Hotel() {

        rooms = new ArrayList<>();
        bookings = new ArrayList<>();

        rooms.add(new Room(101, "Standard", 2000));
        rooms.add(new Room(102, "Standard", 2000));
        rooms.add(new Room(201, "Deluxe", 3500));
        rooms.add(new Room(202, "Deluxe", 3500));
        rooms.add(new Room(301, "Suite", 5000));
    }

    // Display Rooms
    public void displayRooms() {

        System.out.println("\nAvailable Rooms");
        System.out.println("--------------------------------------------");

        for (Room room : rooms) {

            System.out.println(
                    "Room : " + room.getRoomNumber()
                            + " | Type : " + room.getRoomType()
                            + " | Price : ₹" + room.getPrice()
                            + " | Available : " + room.isAvailable());
        }
    }

    // Book Room
    public void bookRoom(String customerName, int roomNumber) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {

                Customer customer = new Customer(customerName);

                room.bookRoom();

                bookings.add(new Booking(customer, room));

                System.out.println("\nRoom Booked Successfully!");
                return;
            }
        }

        System.out.println("\nRoom not available.");
    }

    // Cancel Booking
    public void cancelBooking(int roomNumber) {

        for (Booking booking : bookings) {

            if (booking.getRoom().getRoomNumber() == roomNumber) {

                booking.getRoom().cancelBooking();

                bookings.remove(booking);

                System.out.println("\nBooking Cancelled.");

                return;
            }
        }

        System.out.println("\nBooking not found.");
    }

    // View Bookings
    public void displayBookings() {

        System.out.println("\nCurrent Bookings");
        System.out.println("-------------------------------------");

        if (bookings.isEmpty()) {

            System.out.println("No bookings found.");
            return;
        }

        for (Booking booking : bookings) {

            System.out.println(
                    booking.getCustomer().getName()
                            + " -> Room "
                            + booking.getRoom().getRoomNumber()
                            + " ("
                            + booking.getRoom().getRoomType()
                            + ")");
        }
    }

    // Payment
    public void makePayment(int roomNumber) {

        for (Booking booking : bookings) {

            if (booking.getRoom().getRoomNumber() == roomNumber) {

                Payment payment = new Payment();

                payment.makePayment(booking.getRoom().getPrice());

                return;
            }
        }

        System.out.println("\nBooking not found.");
    }
}