package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class BranchDTO {
    Integer id;
    String name;
    String country;
    String type;
    private List<String> europeanUnionCountriesReference;
}
