package backend.training_app.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProgramRepository extends JpaRepository<Program, Long>{

    List<Program> findByName(String name);

}
