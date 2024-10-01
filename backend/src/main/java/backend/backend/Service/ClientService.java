package backend.backend.Service;

import backend.backend.Entity.ClientEntity;
import backend.backend.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ClientService {


    @Autowired
    private ClientRepository clientRepository;
    /**
     * Creates a new client entity with the provided details and saves it in the database.
     *
     * @param rut       The client's RUT (unique identifier).
     * @param username  The client's username.
     * @param password  The client's password.
     * @param email     The client's email.
     * @param firstName The client's first name.
     * @param lastName  The client's last name.
     * @param age       The client's age.
     * @param salary    The client's salary.
     * @return The saved ClientEntity object.
     */
    public ClientEntity createClient(String rut, String username, String password, String email, String firstName, String lastName, int age, int salary) {
        ClientEntity client = new ClientEntity(rut, username, password, email, firstName, lastName, age, salary);
        return clientRepository.save(client);
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
        ClientEntity client = getClient(rut);
        int salary = client.getSalary();

        double result = (M/salary)*100;

        return !(result < 35);
    }


}


