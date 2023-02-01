package java8.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Shabdanov Ilim
 **/
@Entity
@Table(name = "passports")
@Setter
@Getter
@ToString(exclude = "client")
@NoArgsConstructor
@AllArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "clients_id_generation")
    @SequenceGenerator(
            name = "clients_id_generation",
            sequenceName = "clients_seq",
            allocationSize = 1)
    private Long id;
    private int INN;
    @OneToOne(mappedBy = "passport",cascade = {CascadeType.REFRESH,
    CascadeType.DETACH,CascadeType.MERGE})
    private Client client;

    public Passport(int INN) {
        this.INN = INN;
    }
}
