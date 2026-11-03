package backend.training_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import backend.training_app.domain.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;


@Controller 
public class CategoryController {

    private CategoryRepository cRepository;

    public CategoryController(CategoryRepository cRepository) {
        this.cRepository = cRepository;
    }

    @GetMapping("/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", cRepository.findAll());
        return "categories";
    }
    

}
