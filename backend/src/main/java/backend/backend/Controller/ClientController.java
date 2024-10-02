package backend.backend.Controller;


import backend.backend.Entity.ClientEntity;
import backend.backend.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Client")
@CrossOrigin(origins = "*")

public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public ClientEntity getClienteyId(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/add")
    public ClientEntity addClient(@RequestBody Map<String, String> body) {
        String rut = body.get("rut");
        String email = body.get("email");
        String password = body.get("password");
        String firstName = body.get("firstName");
        String lastName = body.get("lastname");
        int age = Integer.parseInt(body.get("age"));
        int salary = Integer.parseInt(body.get("salary"));
        int antiguedad = Integer.parseInt(body.get("antiguedad"));
        ClientEntity client = new ClientEntity(rut, password, email, firstName, lastName, age, salary, antiguedad);

        return clientService.createClient(client);
    }

    @GetMapping("/simulateLoadAmount")
    public double simulateLoadAmount(@RequestParam Map<String, String> body) {
        int amount = Integer.parseInt(body.get("amount"));
        int termYears = Integer.parseInt(body.get("termYears"));
        double annualInterest = Double.parseDouble(body.get("annualInterest"));
        return clientService.simulateLoanAmount(amount, termYears, annualInterest);
    }

    @GetMapping("/totalCost")
    public double totalCost(@RequestParam Map<String, String> body) {
        int amount = Integer.parseInt(body.get("amount"));
        int termYears = Integer.parseInt(body.get("termYears"));
        double annualInterest = Double.parseDouble(body.get("annualInterest"));
        double seguroDegrabacion = Double.parseDouble(body.get("seguroDegrabacion"));
        double seguroIncendio = Double.parseDouble(body.get("seguroIncendio"));
        double comision = Double.parseDouble(body.get("comision"));
        return clientService.totalCostP6(amount,termYears,annualInterest,seguroDegrabacion,seguroIncendio,comision);

    }


}