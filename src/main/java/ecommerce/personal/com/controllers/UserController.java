package ecommerce.personal.com.controllers;

import ecommerce.com.lib.annotations.SearchAttributes;
import ecommerce.personal.com.models.entities.User;
import ecommerce.personal.com.enums.Gender;
import ecommerce.personal.com.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = "User Controller")
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/hihi")
    public ResponseEntity<?> testController(
            @RequestParam(value = "attributeName", required = false) String attributeName,
            @RequestParam(value = "attributeValue", required = false) String attributeValue,
            @SearchAttributes(exclude = {"attributeName", "attributeValue"})
//            @RequestParam
            Map<String, Object> attributes) {
        log.info("attributes: {}", attributes);
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
