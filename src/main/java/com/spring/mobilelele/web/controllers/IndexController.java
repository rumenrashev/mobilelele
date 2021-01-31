package com.spring.mobilelele.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.spring.mobilelele.common.GlobalConstants.INDEX_PATH;

@Controller
public class IndexController extends BaseController {

    @GetMapping(INDEX_PATH)
    public String index() {
        return "index";
    }

}
