package ecommerce.personal.com.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ConfigurableModel implements EnumValue {
    USER("userModel");

    private final String value;
}
