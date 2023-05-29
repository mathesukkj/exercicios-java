import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;

public class App {
    public static void main(String[] args) throws Exception {
        File in = new File("src\\in.csv");
        new File("src\\out").mkdirs();

        try (Scanner sc = new Scanner(in);
                BufferedWriter bw = new BufferedWriter(new FileWriter("src\\out\\summary.csv"))) {

            List<Product> products = new ArrayList<>();

            sc.nextLine();
            while (sc.hasNextLine()) {
                String[] props = sc.nextLine().split(",");
                Product product = new Product(props[0], Double.parseDouble(props[1]), Integer.parseInt(props[2]));
                products.add(product);
            }

            for (Product p : products) {
                bw.write(p.getName() + "," + p.getTotalValue());
                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
