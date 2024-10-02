package backend.backend.Service;

import backend.backend.Entity.ClientEntity;
import backend.backend.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClientService {


    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity createClient(ClientEntity client) {
        return clientRepository.save(client);
    }

    public ClientEntity getClientById(long id) {
        return clientRepository.findById(id);
    }

    /**
     * Retrieves a client entity from the database using the RUT.
     *
     * @param rut The RUT of the client to be retrieved.
     * @return The ClientEntity object if found, otherwise null.
     */
    public ClientEntity getClient(String rut) {
        return clientRepository.findByRut(rut);
    }

    /**
     * Calculates the monthly payment (installment) for a simulated loan using the formula for an amortizing loan.
     *
     * @param amount       The loan amount.
     * @param termYears    The term of the loan in years.
     * @param annualInterest The annual interest rate as a decimal (e.g., 0.05 for 5%).
     * @return The monthly payment amount.
     */
    public double simulateLoanAmount(int amount, int termYears, double annualInterest) {
        double monthlyRate = annualInterest / 12;
        int totalMonths = termYears * 12;
        double monthlyRatePlusOne = monthlyRate + 1;

        double powerTerm = Math.pow(monthlyRatePlusOne, totalMonths);
        double numerator = monthlyRate * powerTerm;
        double denominator = powerTerm - 1;

        return amount * (numerator / denominator);
    }

    //condicion for credits
    public boolean R1 (String rut, double M){
        ClientEntity client = clientRepository.findByRut(rut);
        int salary = client.getSalary();

        double result = (M/salary)*100;

        return !(result < 35);
    }

    public boolean R6 (long id){
        ClientEntity client = clientRepository.findById(id);
        int age = client.getAge();
        if(age > 70) {
            return false;
        }
    
        return true;
    }


        //P6
    public Double totalCostP6 (int amount, int termYears, double annualInterest, double seguroDegrabacion, double seguroIncendio, double comisionAdministracion) {
        int termMeses = termYears * 12;
        double prestamomensual =  simulateLoanAmount(amount, termYears, annualInterest);
        double seguroD =  seguroDegrabacion * amount;
        double comision = comisionAdministracion * amount;
        double totalCostMensual = prestamomensual + seguroIncendio + seguroD;
        return (totalCostMensual * termMeses )+ comision;

    }
}


