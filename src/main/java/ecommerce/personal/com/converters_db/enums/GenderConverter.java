package ecommerce.personal.com.converters_db.enums;

import ecommerce.personal.com.enums.Gender;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter extends AbstractEnumConverter<Gender> {
    @Override
    protected Gender[] getValues() {
        return Gender.values();
    }
}
