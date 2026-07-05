package com.hotel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Hotel hotel = new Hotel();

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("    HOTEL RESERVATION SYSTEM");
            System.out.println("==================================");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Make Payment");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    hotel.displayRooms();
                    break;

                case 2:

                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Room Number: ");
                    int room = scanner.nextInt();

                    hotel.bookRoom(name, room);
                    break;

                case 3:

                    System.out.print("Enter Room Number: ");
                    room = scanner.nextInt();

                    hotel.cancelBooking(room);
                    break;

                case 4:

                    hotel.displayBookings();
                    break;

                case 5:

                    System.out.print("Enter Room Number: ");
                    room = scanner.nextInt();

                    hotel.makePayment(room);
                    break;

                case 6:

                    System.out.println("\nThank you for using Hotel Reservation System.");
                    break;

                default:

                    System.out.println("\nInvalid Choice!");
            }

        } while (choice != 6);

        scanner.close();
    }
}