package backend.training_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import backend.training_app.domain.CategoryRepository;
import backend.training_app.domain.Program;
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

    @GetMapping("/add")
    public String addProgram(Model model) {
        model.addAttribute("program", new Program());
        model.addAttribute("categories", cRepository.findAll());
        return "addprograms";
    }

    @PostMapping("/save")
    public String save(Program program) {
        pRepository.save(program);
        return "redirect:/programs";
    }

    @GetMapping("/delete/{programId}")
    public String deleteProgram(@PathVariable("programId") Long programId, Model model) {
        pRepository.deleteById(programId);
        return "redirect:/programs";
    }

}
