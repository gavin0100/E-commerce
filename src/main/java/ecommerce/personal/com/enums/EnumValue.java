package ecommerce.personal.com.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public interface EnumValue {
    @JsonValue
    String getValue();
}
