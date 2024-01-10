package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="branches")
public class Branch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String country;

    public Branch() {
    }

    public Branch(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
