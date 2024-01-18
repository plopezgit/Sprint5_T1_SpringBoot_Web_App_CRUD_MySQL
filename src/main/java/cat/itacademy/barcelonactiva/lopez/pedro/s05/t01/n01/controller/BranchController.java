package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.controller;

import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.model.exception.BranchDoesNotExistException;
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
@RequestMapping("/branch")
public class BranchController {


    private final BranchServiceInterface branchService;

    @Autowired
    public BranchController(BranchServiceInterface branchService) {
        super();
        this.branchService = branchService;
    }

    @GetMapping("/add")
    public String insertBranches (Model model) {
        BranchDTO newBranch = new BranchDTO();
        model.addAttribute("title", "Insert branch");
        model.addAttribute("branch", newBranch);
        model.addAttribute("branches", branchService.getBranches());
        return "/branch/insert";
    }

    @PostMapping("/insert")
    public String insert(@Valid @ModelAttribute("branch") BranchDTO branchDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Insert branch");
            model.addAttribute("branch", branchDTO);
            model.addAttribute("branches", branchService.getBranches());
            return "/branch/insert";
        } else {
            branchService.createBranch(branchDTO);
            return "redirect:/branch/add";

        }
    }

    @GetMapping("/edit/{id}")
    public String editBranches (@PathVariable("id") Integer id, Model model) {
        try {
            model.addAttribute("title", "Edit branch");
            model.addAttribute("branch", branchService.getBranchById(id));
        } catch (BranchDoesNotExistException e) {
            return "redirect:/branch/add";
        }
        return "/branch/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute BranchDTO branchDTO,
                       BindingResult result, Model model, RedirectAttributes attributeMessage) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Insert branch");
            model.addAttribute("branch", branchDTO);
            return "/branch/edit";
        } else {
            try {
                branchService.updateBranch(branchDTO.getId(), branchDTO);
            } catch (BranchDoesNotExistException e) {
                return "redirect:/branch/add";
            }
            attributeMessage.addFlashAttribute("success",
                    "Branch has been edited.");
            return "redirect:/branch/add";

        }
    }

    @GetMapping("/delete/{id}")
    public String deleteBranches (@PathVariable("id") Integer id, Model model) {
        try {
            branchService.deleteBranch(id);
        } catch (BranchDoesNotExistException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/branch/add";
    }

    @GetMapping("/getAll")
    public String viewBranches (Model model) {
        model.addAttribute("title", "Branch list");
        model.addAttribute("branches", branchService.getBranches());
        return "branch/branches";
    }

    @GetMapping("/getOne/{id}")
    public String viewBranch (@PathVariable("id") Integer id, Model model) {
        BranchDTO branchDTO = null;
        try {
            branchDTO = branchService.getBranchById(id);
        } catch (BranchDoesNotExistException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("title", "Branch detail");
        model.addAttribute("branch", branchDTO);
        return "/branch/viewDetail";
    }

}