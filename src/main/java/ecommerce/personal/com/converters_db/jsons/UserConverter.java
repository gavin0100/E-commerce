package ecommerce.personal.com.converters_db.jsons;

import com.fasterxml.jackson.databind.ObjectMapper;
import ecommerce.personal.com.models.entities.User;
import jakarta.persistence.Converter;

@Converter
public class UserConverter extends AbstractJsonConverter<User> {
    public UserConverter(ObjectMapper objectMapper) {
        super(objectMapper);
    }
}
