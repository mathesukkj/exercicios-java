package com.mathesukkj.springcourse.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mathesukkj.springcourse.entities.Category;
import com.mathesukkj.springcourse.entities.Order;
import com.mathesukkj.springcourse.entities.OrderItem;
import com.mathesukkj.springcourse.entities.Payment;
import com.mathesukkj.springcourse.entities.Product;
import com.mathesukkj.springcourse.entities.User;
import com.mathesukkj.springcourse.entities.enums.OrderStatus;
import com.mathesukkj.springcourse.repositories.CategoryRepository;
import com.mathesukkj.springcourse.repositories.OrderItemRepository;
import com.mathesukkj.springcourse.repositories.OrderRepository;
import com.mathesukkj.springcourse.repositories.ProductRepository;
import com.mathesukkj.springcourse.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
        @Autowired
        private UserRepository userRepository;

        @Autowired
        private OrderRepository orderRepository;

        @Autowired
        private CategoryRepository categoryRepository;

        @Autowired
        private ProductRepository productRepository;

        @Autowired
        private OrderItemRepository orderItemRepository;

        @Override
        public void run(String... args) throws Exception {
                User u1 = new User(null, "Cole McCassidy", "highnoon@bang.com", "(55) 95555-1234", "mysecretpassword");
                User u2 = new User(null, "Lena Oxton", "tracer@overwatch.com", "(11) 95555-6789", "p@ssw0rd123");
                User u3 = new User(null, "Hanzo Shimada", "hanzo@shimadaclan.com", "(21) 95555-4321", "MyPa55w0rd");
                User u4 = new User(null, "Tekhartha Zenyatta", "zenyatta@shambali.com", "(61) 95555-8642",
                                "HarmonyP@ssword");
                User u5 = new User(null, "Hana Song", "dva@overwatch.com", "(51) 95555-1357", "GG@EZ4DVawrd");
                User u6 = new User(null, "Amélie Lacroix", "widowmaker@talon.com", "(41) 95555-2468", "NoirP@ssword");
                User u7 = new User(null, "Gabriel Reyes", "reaper@overwatch.com", "(31) 95555-8765", "DarkP@ssword");
                userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7));

                Order o1 = new Order(null, Instant.parse("2023-08-12T01:29:18Z"), OrderStatus.WAITING_PAYMENT, u1);
                Order o2 = new Order(null, Instant.parse("2023-03-17T04:48:52Z"), OrderStatus.PAID, u2);
                Order o3 = new Order(null, Instant.parse("2023-02-08T09:10:36Z"), OrderStatus.SHIPPED, u3);
                Order o4 = new Order(null, Instant.parse("2023-04-02T11:51:08Z"), OrderStatus.DELIVERED, u4);
                Order o5 = new Order(null, Instant.parse("2023-12-23T15:22:47Z"), OrderStatus.CANCELLED, u5);
                Order o6 = new Order(null, Instant.parse("2023-09-26T20:01:19Z"), OrderStatus.PAID, u6);
                Order o7 = new Order(null, Instant.parse("2023-10-30T22:44:09Z"), OrderStatus.SHIPPED, u7);
                Order o8 = new Order(null, Instant.parse("2023-01-03T03:16:55Z"), OrderStatus.WAITING_PAYMENT, u1);
                Order o9 = new Order(null, Instant.parse("2023-11-07T06:57:23Z"), OrderStatus.DELIVERED, u2);
                Order o10 = new Order(null, Instant.parse("2023-05-26T12:33:14Z"), OrderStatus.PAID, u3);
                Order o11 = new Order(null, Instant.parse("2023-07-15T17:19:01Z"), OrderStatus.SHIPPED, u4);
                Order o12 = new Order(null, Instant.parse("2023-06-18T19:49:42Z"), OrderStatus.DELIVERED, u5);
                orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5, o6, o7, o8, o9, o10, o11, o12));

                List<Category> categoryList = new ArrayList<>();
                categoryList.add(new Category(null, "Albums"));
                categoryList.add(new Category(null, "Music Videos"));
                categoryList.add(new Category(null, "Photocards"));
                categoryList.add(new Category(null, "Fashion"));
                categoryList.add(new Category(null, "Fan Merchandise"));

                Product p1 = new Product(null, "LOONA Album Vol. 1 - [++]",
                                "Experience the debut album of LOONA, featuring the hit single 'Hi High'", 24.99, "");
                Product p2 = new Product(null, "LOONA Album Vol. 2 - [12:00]",
                                "Get the latest album from LOONA, featuring the hit single 'Why Not?'", 27.99, "");
                Product p3 = new Product(null, "LOONA Album Vol. 3 - [&]",
                                "Complete your collection with LOONA's fifth album, featuring the hit single 'PTT (Paint The Town)'",
                                29.99, "");
                Product p4 = new Product(null, "LOONA - [12:00] Concept Film",
                                "Get a sneak peek at the concept and style of LOONA's second full-length album in this stunning music video",
                                4.99, "");
                Product p5 = new Product(null, "LOONA Photocard Set - Vol. 2",
                                "Complete your collection of LOONA photocards with this set of 12 cards from their second full-length album",
                                14.99, "");
                Product p6 = new Product(null, "LOONA Photocard Set - Limited Edition",
                                "Get your hands on this rare and limited edition set of LOONA photocards featuring exclusive photos",
                                99.99, "");
                Product p7 = new Product(null, "LOONA Logo Hoodie",
                                "Stay warm and stylish with this comfortable hoodie featuring the LOONA logo", 34.99,
                                "");
                Product p8 = new Product(null, "LOONA Crop Top",
                                "Show off your love for LOONA and stay cool in this trendy crop top featuring their names and logo",
                                19.99, "");
                Product p9 = new Product(null, "LOONA Lightstick",
                                "Illuminate your love for LOONA with this official lightstick, perfect for concerts and events",
                                39.99,
                                "");
                Product p10 = new Product(null, "LOONA Phone Case",
                                "Protect your phone and show off your love for LOONA with this stylish phone case, available for various models",
                                19.99, "");
                categoryRepository.saveAll(categoryList);
                productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));

                p1.getCategories().add(categoryList.get(0));
                p2.getCategories().add(categoryList.get(0));
                p3.getCategories().add(categoryList.get(0));
                p4.getCategories().add(categoryList.get(1));
                p5.getCategories().add(categoryList.get(2));
                p6.getCategories().add(categoryList.get(2));
                p7.getCategories().add(categoryList.get(3));
                p8.getCategories().add(categoryList.get(3));
                p9.getCategories().add(categoryList.get(4));
                p10.getCategories().add(categoryList.get(4));
                productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));

                OrderItem oi1 = new OrderItem(o1, p3, 1, p1.getPrice());
                OrderItem oi2 = new OrderItem(o2, p2, 1, p2.getPrice());
                OrderItem oi3 = new OrderItem(o2, p7, 1, p7.getPrice());
                OrderItem oi4 = new OrderItem(o3, p6, 2, p6.getPrice());
                OrderItem oi5 = new OrderItem(o4, p5, 1, p5.getPrice());
                OrderItem oi6 = new OrderItem(o5, p8, 3, p8.getPrice());
                OrderItem oi7 = new OrderItem(o5, p1, 1, p1.getPrice());
                OrderItem oi8 = new OrderItem(o5, p10, 2, p10.getPrice());
                OrderItem oi9 = new OrderItem(o6, p4, 2, p4.getPrice());
                OrderItem oi10 = new OrderItem(o7, p9, 4, p9.getPrice());
                OrderItem oi11 = new OrderItem(o8, p5, 1, p5.getPrice());
                OrderItem oi12 = new OrderItem(o9, p1, 2, p1.getPrice());
                OrderItem oi13 = new OrderItem(o10, p2, 2, p2.getPrice());
                OrderItem oi14 = new OrderItem(o11, p8, 2, p8.getPrice());
                OrderItem oi15 = new OrderItem(o12, p6, 2, p6.getPrice());
                orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5, oi6, oi7, oi8, oi9, oi10, oi11, oi12,
                                oi13, oi14, oi15));

                Payment pay1 = new Payment(null, Instant.parse("2023-03-17T06:48:52Z"), o2);
                Payment pay2 = new Payment(null, Instant.parse("2023-09-26T20:01:19Z"), o6);
                Payment pay3 = new Payment(null, Instant.parse("2023-05-26T14:31:14Z"), o10);
                o2.setPayment(pay1);
                o6.setPayment(pay2);
                o10.setPayment(pay3);
                orderRepository.saveAll(Arrays.asList(o2, o6, o10));
        }
}
