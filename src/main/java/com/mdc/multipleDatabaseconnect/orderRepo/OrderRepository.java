package com.mdc.multipleDatabaseconnect.orderRepo;

import com.mdc.multipleDatabaseconnect.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
