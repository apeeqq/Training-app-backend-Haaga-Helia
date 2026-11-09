package backend.training_app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import backend.training_app.domain.Category;
import backend.training_app.domain.CategoryRepository;

@DataJpaTest 
public class CategoryRepositoryTests {

    @Autowired 
    private CategoryRepository categoryRepository;

    @Test 
    public void createNewCategory() {
        Category category = new Category("Crosstraining");
        categoryRepository.save(category);
        assertThat(category.getCategoryId()).isNotNull();
    }

    @Test 
    public void deleteCategory() {
        Category category = new Category("Crosstraining");
        categoryRepository.save(category);
        assertThat(category.getCategoryId()).isNotNull();
        categoryRepository.deleteById(category.getCategoryId());
        assertThat(categoryRepository.findById(category.getCategoryId())).isEmpty();
    }

    @Test 
    public void searchCategory() {
        List<Category> categories = categoryRepository.findByCategory("Powerlifting");

        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getCategory()).isEqualTo("Powerlifting");
    }

}
