package backend.backend.Repository;

import backend.backend.Entity.CreditsHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditsHistoryRepository extends JpaRepository<CreditsHistoryEntity, Long> {
   List<CreditsHistoryEntity> findAllByClientId(long clientId);
}
