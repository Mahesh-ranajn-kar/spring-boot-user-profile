package iasys.controllers;

import iasys.models.User;
import iasys.services.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomePageController {

    @Autowired
    private HomePageService homePageService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/signup")
    public String signupUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        boolean res = homePageService.saveUser(user);
        if (res) {
            return "login";
        } else {
            return "index";
        }

    }
}
