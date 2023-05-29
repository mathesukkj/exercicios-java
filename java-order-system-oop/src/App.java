import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String clientName = s.nextLine();
        System.out.print("Email: ");
        String clientEmail = s.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate clientBirthDate = LocalDate.parse(s.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Client client = new Client(clientName, clientEmail, clientBirthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(s.next());
        Order order = new Order(LocalDateTime.now(), orderStatus, client);

        System.out.print("How many items to this order? ");
        int itemsNumber = s.nextInt();

        for (int i = 0; i < itemsNumber; i++) {
            System.out.println("Enter #" + (i + 1) + " item data:");
            System.out.print("Product name: ");
            String productName = s.next();
            System.out.print("Product price: ");
            double productPrice = s.nextDouble();
            System.out.print("Quantity: ");
            int productQty = s.nextInt();

            Product product = new Product(productName, productPrice);
            OrderItem item = new OrderItem(productQty, productPrice, product);
            order.addItem(item);
        }
        s.close();

        System.out.println();
        System.out.println(order);
    }
}
