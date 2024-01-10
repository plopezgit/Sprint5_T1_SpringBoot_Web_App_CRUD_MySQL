package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.service;

import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.domain.Branch;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BranchServiceInterface {
    Branch createBranch(Branch branch);
    Branch updateBranch(Branch branch);
    void deleteBranch(Integer id);
    Branch getOneBranchById(Integer id);
    List<Branch> getAllBranches();
}
