package com.mdc.multipleDatabaseconnect.productRepo;

import com.mdc.multipleDatabaseconnect.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
