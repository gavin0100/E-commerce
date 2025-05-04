package ecommerce.personal.com.converters_db.jsons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ecommerce.com.lib.constants.CommonMessages;
import ecommerce.com.lib.exceptions.EcException;
import jakarta.persistence.AttributeConverter;
import lombok.RequiredArgsConstructor;

import java.text.MessageFormat;

@RequiredArgsConstructor
public abstract class AbstractJsonConverter<T> implements AttributeConverter<T, String> {
    private final ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(T object) throws EcException {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            String errorMessage = MessageFormat.format(CommonMessages.FAIL_CONVERT_OBJECT_JSON, object.getClass().getSimpleName());
            throw new EcException(errorMessage);
        }
    }

    @Override
    public T convertToEntityAttribute(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, new TypeReference<>() {
            });
        } catch (JsonProcessingException ex) {
            throw new EcException(CommonMessages.FAIL_CONVERT_JSON_OBJECT);
        }
    }
}
