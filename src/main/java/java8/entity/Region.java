package java8.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Shabdanov Ilim
 **/
@Entity
@Table(name = "regions")
@Setter
@Getter
@ToString(exclude = "banks")
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "clients_id_generation")
    @SequenceGenerator(
            name = "clients_id_generation",
            sequenceName = "clients_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "region_name")
    private String regionName;
    @OneToMany(mappedBy = "region",cascade = {CascadeType.REFRESH,
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    private List<Bank> banks;

    public Region(Long id, String regionName) {
        this.id = id;
        this.regionName = regionName;
    }

    public Region(String regionName) {
        this.regionName = regionName;
    }
}
