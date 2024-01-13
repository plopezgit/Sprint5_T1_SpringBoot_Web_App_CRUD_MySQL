package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="branches")
public class Branch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "country")
    String country;

    public Branch(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
