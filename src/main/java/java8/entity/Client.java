package java8.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Shabdanov Ilim
 **/
@Entity
@Table(name = "clients")
@Setter
@Getter
@ToString(exclude = {"passport","banks"})
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "clients_id_generation")
    @SequenceGenerator(
            name = "clients_id_generation",
            sequenceName = "clients_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @OneToOne(cascade = {CascadeType.REFRESH,
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REMOVE})
    private Passport passport;
    @ManyToMany(cascade = {CascadeType.REFRESH,
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable
    private List<Bank> banks;

    public Client(String fullName, String phoneNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }
}
