package pl.andrzejjozefow.schooldiary.system;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

  @RequestMapping("/")
  public String welcome() {
    return "welcome";
  }

}
