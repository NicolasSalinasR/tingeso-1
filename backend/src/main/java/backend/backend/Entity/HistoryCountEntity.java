package backend.backend.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "HistoryCount")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class HistoryCountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int clientCountid;
    // if is false is a retire of money and if is true is a deposit of money
    private boolean Type;
    private int Change;
    private LocalDate ChangeDate;


}
