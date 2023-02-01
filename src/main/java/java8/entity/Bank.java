package java8.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Shabdanov Ilim
 **/
@Entity
@Table(name = "banks")
@Setter
@Getter
@ToString(exclude = {"region","clients"})
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "banks_id_generation")
    @SequenceGenerator(
            name = "banks_id_generation",
            sequenceName = "banks_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    @ManyToOne(cascade = {
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST})
    private Region region;
    @ManyToMany(mappedBy = "banks",cascade =
            {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    private List<Client> clients;

    public Bank(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
