package com.spring.mobilelele.web.controllers;

import com.spring.mobilelele.service.models.BrandServiceModel;
import com.spring.mobilelele.service.services.BrandService;
import com.spring.mobilelele.web.models.bindings.BrandBindingModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BrandController extends BaseController {

    private static final String ALL_BRANDS_PATH = "/brands/all";
    private static final String ADD_BRAND_PATH = "/brands/add";

    private final ModelMapper modelMapper;
    private final BrandService brandService;

    @Autowired
    public BrandController(ModelMapper modelMapper, BrandService brandService) {
        this.modelMapper = modelMapper;
        this.brandService = brandService;
    }

    @GetMapping(ALL_BRANDS_PATH)
    public String allBrands() {
        return ALL_BRANDS_PATH;
    }

    @GetMapping(ADD_BRAND_PATH)
    public String addBrands() {
        return ADD_BRAND_PATH;
    }

    @PostMapping(ADD_BRAND_PATH)
    public String addBrandsConfirm(BrandBindingModel brandBindingModel, RedirectAttributes redirectAttributes) {
        BrandServiceModel brandServiceModel = this.modelMapper.map(brandBindingModel, BrandServiceModel.class);
        boolean isSuccessfully = this.brandService.addBrand(brandServiceModel);
        redirectAttributes.addFlashAttribute("brandName", brandBindingModel.getName());
        if (isSuccessfully){
            redirectAttributes.addFlashAttribute("isSuccessfully", true);
        }else {
            redirectAttributes.addFlashAttribute("alreadyExists", true);
        }
        return redirect(ADD_BRAND_PATH);
    }

}
