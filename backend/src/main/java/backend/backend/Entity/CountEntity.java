package backend.backend.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "clientCount")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long clientId;
    private int Money;
    private LocalDate creationDate;


}
