package br.com.ufrn.imd.securityexample;
import br.com.ufrn.imd.securityexample.domain.Users;
import br.com.ufrn.imd.securityexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user") @Validated Users user,
                                      BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        try {
            userService.save(user);
        } catch (RuntimeException e) {
            result.rejectValue("username", "user.username", e.getMessage());
            return "register";
        }

        return "redirect:/login";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
