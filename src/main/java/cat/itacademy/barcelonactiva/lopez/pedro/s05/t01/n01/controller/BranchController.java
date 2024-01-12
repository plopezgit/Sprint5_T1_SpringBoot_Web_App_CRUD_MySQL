package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.controller;

import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.service.BranchServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/views/branch")
public class BranchController {

    @Autowired
    private BranchServiceInterface branchService;

    @GetMapping("/")
    public String insertBranches (Model model) {
        Branch branch = new Branch();
        List<Branch> branches = branchService.getAllBranches();
        model.addAttribute("title", "Insert branch");
        model.addAttribute("branch", branch);
        model.addAttribute("branches", branches);
        return "/views/branch/insert";
    }

    @PostMapping("/insert")
    public String insert(@Valid @ModelAttribute Branch branch, BindingResult result, Model model) {
        List<Branch> branches = branchService.getAllBranches();
        if (result.hasErrors()) {
            model.addAttribute("title", "Insert branch");
            model.addAttribute("branch", branch);
            model.addAttribute("branches", branches);

            return "/views/branch/insert";
        } else {
            branchService.createBranch(branch);
            return "redirect:/views/branch/";

        }
    }

    @GetMapping("/edit/{id}")
    public String editBranches (@PathVariable("id") Integer id, Model model) {
        Branch branch = branchService.getOneBranchById(id);
        model.addAttribute("title", "Edit branch");
        model.addAttribute("branch", branch);
        return "/views/branch/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute Branch branch,
                       BindingResult result, Model model, RedirectAttributes attributeMessage) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Insert branch");
            model.addAttribute("branch", branch);
            return "/views/branch/edit";
        } else {
            branchService.createBranch(branch);
            attributeMessage.addFlashAttribute("success",
                    "Branch has been edited.");
            return "redirect:/views/branch/";

        }
    }

    @GetMapping("/delete/{id}")
    public String deleteBranches (@PathVariable("id") Integer id, Model model) {
        branchService.deleteBranch(id);
        return "redirect:/views/branch/";
    }

}