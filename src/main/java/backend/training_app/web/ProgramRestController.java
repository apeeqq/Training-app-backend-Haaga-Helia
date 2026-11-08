package backend.training_app.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.training_app.domain.ProgramDTO;
import backend.training_app.domain.ProgramRepository;

@RestController 
@RequestMapping("/rest")
public class ProgramRestController {

    private final ProgramRepository pRepository;

    public ProgramRestController(ProgramRepository pRepository) {
        this.pRepository = pRepository;
    }

    @GetMapping("/programs")
    public List<ProgramDTO> findAllProgramsRest() {
        return pRepository.findAll().stream().map(ProgramDTO::from).toList();
    }

}
