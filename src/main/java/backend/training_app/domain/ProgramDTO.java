package backend.training_app.domain;

public record ProgramDTO(String name, String info, CategoryDTO category) {

    public static ProgramDTO from(Program program) {
        return new ProgramDTO(program.getName(), program.getInfo(), CategoryDTO.from(program.getCategory()));
    }

}
