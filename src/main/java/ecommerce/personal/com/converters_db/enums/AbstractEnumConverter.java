package ecommerce.personal.com.converters_db.enums;

import ecommerce.com.lib.constants.CommonMessages;
import ecommerce.com.lib.exceptions.EcBadRequestException;
import ecommerce.personal.com.enums.EnumValue;
import jakarta.persistence.AttributeConverter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@NoArgsConstructor
public abstract class AbstractEnumConverter<T extends EnumValue> implements AttributeConverter<T, String> {
    protected abstract T[] getValues();

    @Override
    public String convertToDatabaseColumn(EnumValue enumValue){
        if (Objects.isNull(enumValue)){
            return null;
        }
        return enumValue.getValue();
    }

    @Override
    public T convertToEntityAttribute(String enumData){
        if (Objects.isNull(enumData)){
            return null;
        }
        return Arrays.stream(getValues())
                .filter(enumValue -> enumData.equals(enumValue.getValue()))
                .findFirst()
                .orElseThrow(() -> new EcBadRequestException(CommonMessages.INVALID_ENUM_VALUE));
    }
}
