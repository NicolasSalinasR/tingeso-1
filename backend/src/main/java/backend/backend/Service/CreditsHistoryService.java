package backend.backend.Service;

import backend.backend.Entity.CreditsHistoryEntity;
import backend.backend.Repository.CreditsHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service


public class CreditsHistoryService {
    @Autowired
    CreditsHistoryRepository creditsHistoryrepository;

    private CreditsHistoryEntity add (long clientId, int credits, LocalDate CreditsHistoryDate, boolean State ) {
        CreditsHistoryEntity creditsHistory = new CreditsHistoryEntity();
       return creditsHistoryrepository.save(creditsHistory);
    }

    private boolean R2 (long clienteId){
        List<CreditsHistoryEntity> creditos = creditsHistoryrepository.findAllByClientId(clienteId);


        for (CreditsHistoryEntity credit : creditos) {
            // Comprobar el estado del crédito
            if (credit.isState()) { // Si state es true

            } else { // Si state es false
               return false;
            }
        }
        return true;

    }


    }


