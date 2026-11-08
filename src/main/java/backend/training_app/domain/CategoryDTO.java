package backend.training_app.domain;

public record CategoryDTO(String category) {

    public static CategoryDTO from(Category category) {
        return new CategoryDTO(category.getCategory());
    }

}
