package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BranchDTO {
    private Integer id;
    String name;
    String country;
    String type;
    private final List<String> EUROPEAN_COUNTRIES_REFERENCE;

    public BranchDTO () {
        EUROPEAN_COUNTRIES_REFERENCE = new ArrayList<>(Arrays
                .asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus",
                        "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany",
                        "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg",
                        "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia",
                        "Slovenia", "Spain and Sweden"));
    }
}
