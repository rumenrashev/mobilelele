package com.spring.mobilelele.web.controllers.users;

import com.spring.mobilelele.service.models.UserRegisterServiceModel;
import com.spring.mobilelele.service.services.UserRegisterService;
import com.spring.mobilelele.web.controllers.base.BaseController;
import com.spring.mobilelele.service.models.UserRegisterBindingModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import static com.spring.mobilelele.common.GlobalConstants.LOGIN_URL;
import static com.spring.mobilelele.common.GlobalConstants.REGISTER_URL;

@Controller
public class UserRegisterController extends BaseController {

    private final ModelMapper modelMapper;
    private final UserRegisterService userRegisterService;

    @Autowired
    public UserRegisterController(ModelMapper modelMapper, UserRegisterService userRegisterService) {
        this.modelMapper = modelMapper;
        this.userRegisterService = userRegisterService;
    }

    @GetMapping(REGISTER_URL)
    public String registerGet(Model model) {
        if (model.getAttribute("user") == null) {
            model.addAttribute("user", new UserRegisterBindingModel());
        }
        return REGISTER_URL;
    }

    @PostMapping(REGISTER_URL)
    public String registerPost(@Valid @ModelAttribute("user") UserRegisterBindingModel user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("user",user);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user",bindingResult);
            return redirect(REGISTER_URL);
        }
        UserRegisterServiceModel userRegisterServiceModel =
                this.modelMapper.map(user, UserRegisterServiceModel.class);
        this.userRegisterService.registerUser(userRegisterServiceModel);
        return redirect(LOGIN_URL);
    }
}
