package backend.training_app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import backend.training_app.web.CategoryController;
import backend.training_app.web.LoginController;
import backend.training_app.web.ProgramController;
import backend.training_app.web.ProgramRestController;

@SpringBootTest
class TrainingAppApplicationTests {

	@Autowired 
	private ProgramController programController;

	@Autowired 
	private ProgramRestController programRestController;

	@Autowired 
	private CategoryController categoryController;

	@Autowired 
	private LoginController loginController;


	@Test
	void contextLoads() {

		assertThat(programController).isNotNull();

		assertThat(programRestController).isNotNull();

		assertThat(categoryController).isNotNull();

		assertThat(loginController).isNotNull();

	}

}
