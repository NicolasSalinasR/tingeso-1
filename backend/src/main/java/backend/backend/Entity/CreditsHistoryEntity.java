package backend.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "CreditsHistory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditsHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long ClientId;
    private int deudaTotal;
    private int deudaActual;
    private LocalDate CreditsHistoryDate;
    //if State = False the credit is not page.
    private boolean State;


}
