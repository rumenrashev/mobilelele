package com.spring.mobilelele.web.controllers;

import com.spring.mobilelele.web.controllers.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.spring.mobilelele.common.GlobalConstants.INDEX_URL;

@Controller
public class IndexController extends BaseController {

    @GetMapping(INDEX_URL)
    public ModelAndView index(){
        return super.view("index");
    }
}
