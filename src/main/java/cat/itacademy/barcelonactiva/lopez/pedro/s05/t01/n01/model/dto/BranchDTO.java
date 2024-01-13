package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchDTO {
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String country;
    private String type;
    private final List<String> EUROPEAN_COUNTRIES_REFERENCE = List.of("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus",
            "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany",
            "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg",
            "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia",
            "Slovenia", "Spain and Sweden");

    public BranchDTO(String name, String country) {
        this.name = name;
        this.country = country;

    }

    public void setCountry (String country) {
        this.country = country;
        setType(country);
    }

    public void setType (String country) {
        if (EUROPEAN_COUNTRIES_REFERENCE.stream().anyMatch(c -> c.equalsIgnoreCase(country))) this.type = "Euro";
        else this.type = "Not Euro";
    }
}
