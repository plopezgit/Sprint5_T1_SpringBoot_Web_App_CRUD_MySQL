package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class BranchDTO {
    private Integer id;
    @NotEmpty
    String name;
    @NotEmpty
    String country;
    String type;
    private final List<String> EUROPEAN_COUNTRIES_REFERENCE = List.of("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus",
            "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany",
            "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg",
            "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia",
            "Slovenia", "Spain and Sweden");

    public BranchDTO(String name, String country, String type) {
        this.name = name;
        this.country = country;
        this.type = type;
    }

    private void setBranchType() {
        this.type = EUROPEAN_COUNTRIES_REFERENCE.stream().anyMatch(country -> country
                .equalsIgnoreCase(this.country))? "Euro" : "Not Euro";
    }
}
