package backend.training_app.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface ProgramRepository extends CrudRepository<Program, Long>{

    List<Program> findByName(String name);

}
