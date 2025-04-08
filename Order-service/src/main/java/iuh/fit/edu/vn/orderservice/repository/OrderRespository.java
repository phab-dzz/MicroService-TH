package iuh.fit.edu.vn.orderservice.repository;

import iuh.fit.edu.vn.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRespository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);
}
