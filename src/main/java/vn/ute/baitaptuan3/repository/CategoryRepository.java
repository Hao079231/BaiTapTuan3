package vn.ute.baitaptuan3.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.ute.baitaptuan3.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  Optional<Category> findByName(String categoryName);
}
