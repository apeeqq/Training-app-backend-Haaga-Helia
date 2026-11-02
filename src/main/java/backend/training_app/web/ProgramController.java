package backend.training_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class ProgramController {

    @GetMapping ("/programs")
        public String getPrograms() {
            return "index";
        }

}
