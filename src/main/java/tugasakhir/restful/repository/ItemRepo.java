package tugasakhir.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tugasakhir.restful.entities.Item;
@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
}
