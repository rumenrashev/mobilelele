package com.spring.mobilelele.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.spring.mobilelele.common.GlobalConstants.*;

@Controller
public class UserLoginController extends BaseController {

    @GetMapping(LOGIN_PATH)
    public String login() {
        return LOGIN_PATH;
    }

    @GetMapping(LOGIN_ERROR_PATH)
    public String loginError(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("hasLoginError",true);
        return redirect(LOGIN_PATH);
    }
}
