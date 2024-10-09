package backend.backend.TestService;

import backend.backend.Entity.ClientEntity;
import backend.backend.Service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")



public class ClientServiceTest {
    @Autowired
    private ClientService clientService;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void getClientByIdTest() {
        // Crea y persiste un nuevo cliente
        ClientEntity newClient = new ClientEntity(
                "98765432-1",          // rut
                "securePassword123",   // password
                "client@example.com",  // email
                "John",                // firstName
                "Doe",                 // lastName
                25,                    // age
                1200,                  // salary
                1,                     // JobTenure
                false                  // Dicom
        );

        // Persiste y sincroniza el cliente en la base de datos
        entityManager.persistAndFlush(newClient);

        // Recupera el cliente por ID usando el método del servicio
        ClientEntity found = clientService.getClientById(newClient.getId());

        // Verifica que el cliente encontrado es igual al cliente creado
        assertThat(found).isEqualTo(newClient); // Asegúrate de que equals() esté sobrescrito en ClientEntity
    }


    }



