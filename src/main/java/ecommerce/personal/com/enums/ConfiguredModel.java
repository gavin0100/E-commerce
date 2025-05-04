package ecommerce.personal.com.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ConfiguredModel implements EnumValue {
    USER("userModel");

    private final String value;
}
