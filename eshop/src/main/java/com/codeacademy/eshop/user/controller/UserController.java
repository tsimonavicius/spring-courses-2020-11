package com.codeacademy.eshop.user.controller;

import com.codeacademy.eshop.user.model.User;
import com.codeacademy.eshop.user.service.UserService;
import com.codeacademy.eshop.user.service.validator.UserExtraValidator;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private UserExtraValidator userExtraValidator;

    public UserController(UserService userService, UserExtraValidator userExtraValidator) {
        this.userService = userService;
        this.userExtraValidator = userExtraValidator;
    }

    @GetMapping
    public String getAll(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("usersPage", userService.getAllUsers(pageable));
        return "user/user-list";
    }

    @GetMapping("/new")
    public String getNewUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/new-user";
    }

    @PostMapping
    public String addNewUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/new-user";
        }
        userService.addUser(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}")
    public String getUserProfile(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/user-profile";
    }

    @GetMapping("/update/{id}")
    public String getUpdateUserForm(Model model, @PathVariable long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/edit-user";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, BindingResult bindingResult, @ModelAttribute("user") User user) {
        userExtraValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "user/edit-user";
        }
        userService.updateUser(id, user);
        return "redirect:/user/" + id;
    }

}