package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.service;

import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService  implements BranchServiceInterface{

    @Autowired
    private BranchRepository branchRepository;

    public Branch createBranch(Branch branch) {
        return null;
    }

    @Override
    public Branch updateBranch(Branch branch) {
        return null;
    }

    @Override
    public void deleteBranch(Integer id) {

    }

    @Override
    public Branch getOneBranchById(Integer id) {
        return null;
    }

    @Override
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }
}
