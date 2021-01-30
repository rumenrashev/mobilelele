package com.spring.mobilelele.web.controllers.users;

import com.spring.mobilelele.web.controllers.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.spring.mobilelele.common.GlobalConstants.LOGIN_URL;

@Controller
public class UserLoginController extends BaseController {

    @GetMapping(LOGIN_URL)
    public ModelAndView login(){
        return super.view("auth-login");
    }
}