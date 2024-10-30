package com.mdc.multipleDatabaseconnect;

import com.mdc.multipleDatabaseconnect.order.Order;
import com.mdc.multipleDatabaseconnect.orderRepo.OrderRepository;
import com.mdc.multipleDatabaseconnect.product.Product;
import com.mdc.multipleDatabaseconnect.productRepo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultipleDatabaseconnectApplication implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    public static void main(String[] args) {

        SpringApplication.run(MultipleDatabaseconnectApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        Product product1 = new Product(3, "mouse", 4000);
        System.out.println(product1);
        this.productRepository.save(product1);
        Order order = new Order(2, "222", "10");
        this.orderRepository.save(order);
    }
}
