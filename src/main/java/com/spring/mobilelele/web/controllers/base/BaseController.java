package com.spring.mobilelele.web.controllers.base;

public abstract class BaseController {

    protected String redirect(String url) {
        return "redirect:" + url;
    }
}
