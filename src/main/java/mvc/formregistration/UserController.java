package mvc.formregistration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    private static final String[] countries={"Vietnam", "United States", "Germany"};

//    @GetMapping("/register")
    @RequestMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("countries", countries);
        return "formregistration/userForm";
    }

//    @PostMapping("/result")
@RequestMapping("/result")
    public String processUser(User user){
        // Handle user here
        return "formregistration/userResult";
    }
}
