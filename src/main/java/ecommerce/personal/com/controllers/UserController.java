package ecommerce.personal.com.controllers;

import ecommerce.personal.com.models.entities.User;
import ecommerce.personal.com.models.enums.Gender;
import ecommerce.personal.com.services.UserService;
import ecommerce.personal.com.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/hihi")
    public ResponseEntity<?> testController() {
        User user = User.builder().userId("1").age(12).dateOfBirth(LocalDate.now()).gender(Gender.NOT_APPLICABLE).build();
        userService.saveUser(user);
        return ResponseEntity.ok().body("hello world");
    }
}
