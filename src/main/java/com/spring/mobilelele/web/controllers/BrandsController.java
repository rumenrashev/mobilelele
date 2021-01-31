package com.spring.mobilelele.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandsController {

    private static final String ALL_BRANDS_PATH = "/brands/all";

    @GetMapping(ALL_BRANDS_PATH)
    public String allBrands(){
        return ALL_BRANDS_PATH;
    }

}
