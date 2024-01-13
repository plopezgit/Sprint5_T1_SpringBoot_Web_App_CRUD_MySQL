package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.service;

import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.exception.BranchDoesNotExistException;
import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.repository.BranchRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchService  implements BranchServiceInterface{

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ModelMapper branchModelMapper;


    @Override
    public void createBranch(BranchDTO branchDTO) {
        Branch branch = getBranchEntityOf(branchDTO);
        branchRepository.save(branch);
    }

    @Override
    public void updateBranch(int id, BranchDTO branchDTO) throws BranchDoesNotExistException {
        BranchDTO branch = getBranchById(id);
        branch.setName(branchDTO.getName());
        branch.setCountry(branchDTO.getCountry());
        branchRepository.save(getBranchEntityOf(branch));
    }

    @Override
    public void deleteBranch(int id) throws BranchDoesNotExistException {
        BranchDTO branchDTO = getBranchById(id);
        branchRepository.delete(getBranchEntityOf(branchDTO));
    }

    @Override
    public BranchDTO getBranchById(int id) throws BranchDoesNotExistException {
        return branchRepository.findById(id).map(this::getBranchDTOOf)
                .orElseThrow(() -> new BranchDoesNotExistException("The branch does not exist"));
    }

    @Override
    public List<BranchDTO> getBranches() {
        List<Branch> branches = branchRepository.findAll();
        return branches.stream().map(this::getBranchDTOOf).collect(Collectors.toList());
    }

    private BranchDTO getBranchDTOOf (Branch branch) {
        return branchModelMapper.map(branch, BranchDTO.class);
    }

    private Branch getBranchEntityOf (BranchDTO branchDTO) {
        return branchModelMapper.map(branchDTO, Branch.class);
    }
}
