package entities;

public class OrderItem {
    private Integer quantity;
    private double price;
    private Product product;

    public double subTotal() {
        return price * quantity;
    }

    public OrderItem(Integer quantity, double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return product.getName() + ", " + price + ", Quantity: " + quantity + ", Subtotal: $" + subTotal();
    }
}
