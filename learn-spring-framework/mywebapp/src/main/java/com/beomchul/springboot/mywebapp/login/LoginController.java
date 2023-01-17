package com.beomchul.springboot.mywebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String gotoLoginPage(){
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(
            @RequestParam String name,
            @RequestParam String password,
            ModelMap model){
        if (authenticationService.authenticate(name, password)) {
            model.put("name", name);
            model.put("password", password);
            return "welcome";
        }

        model.put("errorMessage", "인증되지 않는 사용자");
        return "login";
    }
}
