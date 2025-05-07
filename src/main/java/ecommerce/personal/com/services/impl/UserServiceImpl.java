package ecommerce.personal.com.services.impl;

import ecommerce.com.lib.exceptions.EcException;
import ecommerce.com.lib.models.dtos.ConfiguredAttribute;
import ecommerce.com.lib.utils.validators.AttributeValidator;
import ecommerce.personal.com.enums.ConfiguredModel;
import ecommerce.personal.com.models.entities.Product;
import ecommerce.personal.com.models.entities.User;
import ecommerce.personal.com.repositories.ProductRepository;
import ecommerce.personal.com.repositories.UserRepository;
import ecommerce.personal.com.services.ModelConfigManager;
import ecommerce.personal.com.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelConfigManager modelConfigManager;
    private final ProductRepository productRepository;

    @Override
    public void saveUser(User user, String attributeName, String attributeValue) throws NullPointerException{
        try {
            userRepository.save(user);
            Set<ConfiguredAttribute> configuredAttributes = modelConfigManager.getAllEntityAttributes(ConfiguredModel.USER);
            AttributeValidator attributeValidator = AttributeValidator.Factory.getDefaultValidator();
            String errorMessage = configuredAttributes.stream()
                    .filter(config -> attributeName.equals(config.getName()))
                    .map(config -> attributeValidator.validate(config, attributeValue))
                    .filter(Objects::nonNull)
                    .findFirst()
                    .orElse("Valid value");
            log.info(errorMessage);

            Product product = Product.builder()
                    .productId(UUID.randomUUID().toString())
                    .name(RandomStringUtils.randomAlphanumeric(10))
                    .user(user)
                    .build();
            productRepository.save(product);

            if (attributeName.equals("!") && attributeValue.equals("!")){
                throw new EcException("This is test EcException for audit");
            }
        } catch (SQLGrammarException ex){
            log.error("",ex);
        }
    }
}
