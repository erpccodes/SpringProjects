package app.contactManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout() {
        // Perform any additional logout tasks if needed

        // Redirect to the login page after logout
        return "redirect:/login?logout";
    }
}