package com.spring.mobilelele.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfferController {

    public static final String ADD_OFFER_PATH = "/offers/add";
    public static final String ALL_OFFERS_PATH ="/offers/all";

    @GetMapping(ADD_OFFER_PATH)
    public String addOffer(){
        return ADD_OFFER_PATH;
    }

    @GetMapping(ALL_OFFERS_PATH)
    public String allOffers(){
        return ALL_OFFERS_PATH;
    }

}
