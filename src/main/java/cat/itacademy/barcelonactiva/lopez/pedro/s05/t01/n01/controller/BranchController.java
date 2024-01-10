package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.controller;

import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.service.BranchServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/views/branch")
public class BranchController {

    @Autowired
    private BranchServiceInterface branchService;
    @GetMapping("/")
    public String toListBranches (Model model) {
        List<Branch> branches = branchService.getAllBranches();
        model.addAttribute("title", "Branches");
        model.addAttribute("branches", branches);
        return "/views/branch/list";
    }
}
