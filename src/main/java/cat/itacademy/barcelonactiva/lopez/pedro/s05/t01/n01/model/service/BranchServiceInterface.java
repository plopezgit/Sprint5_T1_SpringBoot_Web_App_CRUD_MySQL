package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.service;

import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.exception.BranchDoesNotExistException;

import java.util.List;

public interface BranchServiceInterface {
    void createBranch(BranchDTO branchDTO);
    void updateBranch(int id, BranchDTO branchDTO) throws BranchDoesNotExistException;
    void deleteBranch(int id) throws BranchDoesNotExistException;
    BranchDTO getBranchById(int id) throws BranchDoesNotExistException;
    List<BranchDTO> getBranches();
}
