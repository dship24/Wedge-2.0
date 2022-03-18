package com.example.ShipatonRemastered.Orders;

import com.example.ShipatonRemastered.Orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT s FROM Orders s WHERE s.customer = ?1")
    Optional<Orders> findOrdersByCustomer(String customer);
}
