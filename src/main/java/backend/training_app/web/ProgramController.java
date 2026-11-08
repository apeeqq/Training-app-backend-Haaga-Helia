package backend.training_app.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import backend.training_app.domain.CategoryRepository;
import backend.training_app.domain.Program;
import backend.training_app.domain.ProgramRepository;
import jakarta.validation.Valid;

@Controller 
public class ProgramController {

    private ProgramRepository pRepository;
    private CategoryRepository cRepository;

    public ProgramController(ProgramRepository pRepository, CategoryRepository cRepository) {
        this.pRepository = pRepository;
        this.cRepository = cRepository;
    }

    @GetMapping("/index")
        public String getHome() {
            return "index";
        }

    @GetMapping("/programs")
        public String getPrograms(Model model) {
            model.addAttribute("programs", pRepository.findAll());
            return "programs";
        }

    //Get Mapping for adding program
    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addProgram(Model model) {
        model.addAttribute("program", new Program());
        model.addAttribute("categories", cRepository.findAll());
        return "addprograms";
    }

    //Save and validation of adding program
    @PostMapping("/add/post")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addProgramPost(@Valid Program program, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", cRepository.findAll());
            return "addprograms";
        }
        pRepository.save(program);
        return "redirect:/programs";
    }

    //Save and validation of editing program
    @PostMapping("/edit/post")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveProgram(@Valid Program program, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", cRepository.findAll());
            return "editprogram";
        }
        pRepository.save(program);
        return "redirect:/programs";
    }

    @GetMapping("/delete/{programId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteProgram(@PathVariable("programId") Long programId, Model model) {
        pRepository.deleteById(programId);
        return "redirect:/programs";
    }

    //Get Mapping for editing program
    @GetMapping("/edit/{programId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editProgram(@PathVariable("programId") Long programId, Model model) {
        model.addAttribute("program", pRepository.findById(programId));
        model.addAttribute("categories", cRepository.findAll());
        return "/editprogram";
    }

}
