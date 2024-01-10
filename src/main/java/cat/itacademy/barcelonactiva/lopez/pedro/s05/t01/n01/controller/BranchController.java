package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BranchController {

    @GetMapping({"/index","/home","/"})
    public String index () {
        return "index";
    }
}
