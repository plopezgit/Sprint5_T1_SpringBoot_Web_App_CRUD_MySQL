package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BranchDoesNotExist extends Exception {
    private String message;
}
