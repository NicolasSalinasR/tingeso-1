package backend.backend.Repository;

import backend.backend.Entity.CountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CountRepository extends JpaRepository<CountEntity, Long> {

    CountEntity getClientCountEntitiesById(Long id);

}
