package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
    private String moment;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public double total() {
        double total = 0;
        for (OrderItem orderItem : items) {
            total += orderItem.subTotal();
        }
        return total;
    }

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.status = status;
        this.client = client;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY: \n");
        sb.append("Order moment: " + moment);
        sb.append("\nOrder status: " + status);
        sb.append("\nClient: " + client);
        sb.append("\nOrder items: \n");
        for (OrderItem item : items) {
            sb.append(item + "\n");
        }
        sb.append("Total price: $" + total());
        return sb.toString();
    }
}
