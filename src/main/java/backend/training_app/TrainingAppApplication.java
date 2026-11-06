package backend.training_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.training_app.domain.Category;
import backend.training_app.domain.CategoryRepository;
import backend.training_app.domain.Program;
import backend.training_app.domain.ProgramRepository;

@SpringBootApplication
public class TrainingAppApplication {

	private static final Logger log = LoggerFactory.getLogger(TrainingAppApplication.class);
	private final ProgramRepository pRepository;
	private final CategoryRepository cRepository;

	

	public TrainingAppApplication(ProgramRepository pRepository, CategoryRepository cRepository) {
		this.pRepository = pRepository;
		this.cRepository = cRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TrainingAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner programs(ProgramRepository pRepository, CategoryRepository cRepository) {
		return (args) -> {

			log.info("Save some sample categories");
			Category category1 = new Category("Powerlifting");
			Category category2 = new Category("Street lifting");

			cRepository.save(category1);
			cRepository.save(category2);

			log.info("Fetch all the categories");
			for (Category category : cRepository.findAll()) {
				log.info(category.toString());
			}

			log.info("save some sample programs");
			Program sampleProgram1 = new Program("Meta 5/3/1", "Modified version from the most popular strength program of the world. Heavy focus on deadlift, bench press and barbell back squat", cRepository.findByCategory("Powerlifting").get(0));
			Program sampleProgram2 = new Program("Street Beast", "Beginner/intermediate plan for streetlifting. Heavy focus on dips, pull-ups and barbell back squat.", cRepository.findByCategory("Street lifting").get(0));

			pRepository.save(sampleProgram1);
			pRepository.save(sampleProgram2);

			log.info("Fetch all the programs");
			for (Program program : pRepository.findAll()) {
				log.info(program.toString());
			}

		};
	}

}
