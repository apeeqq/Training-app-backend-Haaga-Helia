package backend.training_app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long programId;
    private String name;
    private String info;

    @ManyToOne
    @JsonIgnoreProperties("programs")
    @JoinColumn(name = "categoryId")
    private Category category;

    public Program() {
    }

    public Program(String name, String info, Category category) {
        this.name = name;
        this.info = info;
        this.category = category;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Program [programId=" + programId + ", name=" + name + ", info=" + info + ", category=" + category + "]";
    }

    

}
