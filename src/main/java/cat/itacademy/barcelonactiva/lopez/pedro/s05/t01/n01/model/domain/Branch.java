package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name="branches")
public class Branch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String country;

    public Branch(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
