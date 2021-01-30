package com.spring.mobilelele.web.controllers.users;

import com.spring.mobilelele.web.controllers.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.spring.mobilelele.common.GlobalConstants.*;

@Controller
public class UserController extends BaseController {


    @GetMapping(LOGIN_URL)
    public ModelAndView login(){
       return super.view("auth-login");
    }

    @GetMapping(REGISTER_URL)
    public ModelAndView register(){
        return super.view("auth-register");
    }
}
