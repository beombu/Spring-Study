package com.beomchul.springboot.mywebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("login")
    public String gotoLoginPage(@RequestParam String name, ModelMap model){
        model.put("name", name);
        logger.debug("이름은?? : {}", name);//디버그 수준에서 로그 출력
        logger.info("이름은 ???? : {} ", name);//info 수준에서 로그 출력
        logger.warn("워닝에서 출력 : {}", name);

        return "login";
    }
}
