package ecommerce.personal.com.controllers;

import ecommerce.personal.com.models.entities.User;
import ecommerce.personal.com.enums.Gender;
import ecommerce.personal.com.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/hihi")
    public ResponseEntity<?> testController(
            @RequestParam(value = "attributeName") String attributeName,
            @RequestParam(value = "attributeValue") String attributeValue) {
        User user = User.builder().userId(UUID.randomUUID().toString()).age(12).dateOfBirth(LocalDate.now()).gender(Gender.NOT_APPLICABLE).build();
        userService.saveUser(user, attributeName, attributeValue);
        return ResponseEntity.ok().body("hello world");
    }

    @PostMapping("/hihi")
    public ResponseEntity<?> testPostController(@RequestBody User user){
        userService.saveUser(user, null, null);
        return ResponseEntity.ok().body("hello world");
    }
}
