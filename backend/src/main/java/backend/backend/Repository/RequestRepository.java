package backend.backend.Repository;

import backend.backend.Entity.HistoryCountEntity;
import backend.backend.Entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface RequestRepository extends JpaRepository<RequestEntity, Long> {
   // List<RequestEntity> findAllByClientId(Long clientId);
}
