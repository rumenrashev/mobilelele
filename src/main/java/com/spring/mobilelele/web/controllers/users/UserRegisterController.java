package com.spring.mobilelele.web.controllers.users;

import com.spring.mobilelele.web.controllers.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.spring.mobilelele.common.GlobalConstants.REGISTER_URL;

@Controller
public class UserRegisterController extends BaseController {

    @GetMapping(REGISTER_URL)
    public ModelAndView register(){
        return super.view("auth-register");
    }
}
