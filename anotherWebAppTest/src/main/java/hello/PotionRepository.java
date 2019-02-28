package hello;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PotionRepository extends CrudRepository<Potion, Long> {
    List<Potion> findById(String lastName);
}
