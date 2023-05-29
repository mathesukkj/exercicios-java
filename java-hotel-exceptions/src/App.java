import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import models.entities.Reservation;
import models.exceptions.DomainException;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        try {
            System.out.print("What is the room number? ");
            int roomNumber = s.nextInt();

            System.out.print("What is the checkin date? ");
            LocalDate checkIn = LocalDate.parse(s.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.print("What is the checkout date? ");
            LocalDate checkOut = LocalDate.parse(s.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println("\nEnter data to update the reservation: ");
            System.out.print("What is the checkin date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(s.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.print("What is the checkout date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(s.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            reservation.updateDates(checkIn, checkOut);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Type a number instead");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date! Type a valid date following the pattern (dd/MM/yyyy)");
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error! " + e);
        } finally {
            s.close();
        }
    }
}
