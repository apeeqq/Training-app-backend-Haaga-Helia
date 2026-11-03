package backend.training_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import backend.training_app.domain.CategoryRepository;
import backend.training_app.domain.ProgramRepository;

@Controller 
public class ProgramController {

    private ProgramRepository pRepository;
    private CategoryRepository cRepository;

    public ProgramController(ProgramRepository pRepository, CategoryRepository cRepository) {
        this.pRepository = pRepository;
        this.cRepository = cRepository;
    }

    @GetMapping("/index")
        public String getPrograms() {
            return "index";
        }

    @GetMapping("/programs")
        public String getPrograms(Model model) {
            model.addAttribute("programs", pRepository.findAll());
            return "programs";
        }

}
