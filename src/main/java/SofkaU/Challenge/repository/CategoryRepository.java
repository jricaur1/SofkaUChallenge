package SofkaU.Challenge.repository;

import SofkaU.Challenge.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
