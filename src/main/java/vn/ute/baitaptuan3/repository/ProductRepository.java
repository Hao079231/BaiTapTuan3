package vn.ute.baitaptuan3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.ute.baitaptuan3.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
