package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //    ADD USER -> user-add.jsp      ################################################################################
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("adduser", new User());
        return "user/user-add";
    }

    //    ADD NEW USER   ###############################################################################################
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String processNewUser(@Valid User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "user/user-add";
        }
        userService.saveUser(user);
        model.addAttribute("adduser", user);
        return "user/user-success";
    }

}
