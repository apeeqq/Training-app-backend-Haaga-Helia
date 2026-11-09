package backend.training_app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import backend.training_app.domain.CategoryRepository;
import backend.training_app.domain.Program;
import backend.training_app.domain.ProgramRepository;

@DataJpaTest 
public class ProgramRepositoryTests {

    @Autowired 
    private ProgramRepository programRepository;

    @Autowired 
    private CategoryRepository categoryRepository;

    @Test 
    public void createNewProgram() {
        Program program = new Program("Crosstraining", "Functional training program with skill, strength and cardio blocks", categoryRepository.findByCategory("Street lifting").get(0));
        programRepository.save(program);
        assertThat(program.getProgramId()).isNotNull();
    }

    @Test 
    public void deleteProgram() {
        Program program = new Program("Crosstraining", "Functional training program with skill, strength and cardio blocks", categoryRepository.findByCategory("Street lifting").get(0));
        programRepository.save(program);
        assertThat(program.getProgramId()).isNotNull();
        programRepository.deleteById(program.getProgramId());
        assertThat(programRepository.findById(program.getProgramId())).isEmpty();
    }

    @Test 
    public void searchProgram() {
        List<Program> programs = programRepository.findByName("Meta 5/3/1");
        
        assertThat(programs).hasSize(1);
        assertThat(programs.get(0).getName()).isEqualTo("Meta 5/3/1");
    }

}
