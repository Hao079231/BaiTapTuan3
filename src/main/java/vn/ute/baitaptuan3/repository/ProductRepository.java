package vn.ute.baitaptuan3.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.ute.baitaptuan3.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

  Optional<Product> findByName(String productName);

  List<Product> findByCategoryId(Long categoryId);

  List<Product> findByProductDateAfter(Date date);
}
