package iuh.fit.edu.vn.productservice.Repository;

import iuh.fit.edu.vn.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
