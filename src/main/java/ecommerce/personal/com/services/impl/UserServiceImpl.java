package ecommerce.personal.com.services.impl;

import ecommerce.personal.com.models.entities.User;
import ecommerce.personal.com.repositories.UserRepository;
import ecommerce.personal.com.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
