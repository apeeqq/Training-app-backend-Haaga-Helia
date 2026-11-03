package backend.training_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.training_app.domain.CategoryRepository;
import backend.training_app.domain.Program;
import backend.training_app.domain.ProgramRepository;

@SpringBootApplication
public class TrainingAppApplication {

	private static final Logger log = LoggerFactory.getLogger(TrainingAppApplication.class);
	private final ProgramRepository pRepository;

	

	public TrainingAppApplication(ProgramRepository pRepository) {
		this.pRepository = pRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TrainingAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner programs(ProgramRepository pRepository, CategoryRepository cRepository) {
		return (args) -> {

			log.info("save some sample programs");
			Program sampleProgram1 = new Program("Meta 5/3/1", "Modified version from the most popular strength program of the world");

			log.info("save program");
			pRepository.save(sampleProgram1);

			log.info("Fetch all the programs");
			for (Program program : pRepository.findAll()) {
				log.info(program.toString());
			}

		};
	}

}
