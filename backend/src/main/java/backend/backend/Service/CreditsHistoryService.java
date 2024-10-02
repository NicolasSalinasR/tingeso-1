package backend.backend.Service;

import backend.backend.Entity.ClientEntity;
import backend.backend.Entity.CreditsHistoryEntity;
import backend.backend.Repository.ClientRepository;
import backend.backend.Repository.CreditsHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service


public class CreditsHistoryService {
    @Autowired
    CreditsHistoryRepository creditsHistoryRepository;


    @Autowired
    private ClientRepository clientRepository;

    private CreditsHistoryEntity add (int clientId, int deudaTotal, int deudaActual, LocalDate CreditsHistoryDate, boolean State ) {
        CreditsHistoryEntity creditsHistory = new CreditsHistoryEntity(clientId, deudaTotal, deudaActual , CreditsHistoryDate, State);
       return creditsHistoryRepository.save(creditsHistory);
    }

    //historial crediticio cliente

    private boolean R2 (long ClienteId){
        List<CreditsHistoryEntity> creditos = creditsHistoryRepository.findAllByClientId(ClienteId);


        for (CreditsHistoryEntity credit : creditos) {
            // Comprobar el estado del crédito
            if (credit.isState()) { // Si state es true

            } else { // Si state es false
               return false;
            }
        }
        return true;

    }

    //relacion deuda ingreso
    public boolean R4 (long clientId, int newCredit){
        List <CreditsHistoryEntity> credits = creditsHistoryRepository.findAllByClientId(clientId);
        int suma = newCredit;
        for(CreditsHistoryEntity credit : credits) {
            int valor = credit.getDeudaActual();
            suma = suma + valor;
        }
        ClientEntity client = clientRepository.findById(clientId);
        int salary = client.getSalary();

        double condicion =  salary /suma;

        if (condicion < 0.5) {
            return false;
        }
        return true;

    }


    }


