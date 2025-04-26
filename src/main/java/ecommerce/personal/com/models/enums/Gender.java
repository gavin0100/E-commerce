package ecommerce.personal.com.models.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Gender implements EnumValue{
    NOT_KNOWN("0"),
    MALE("1"),
    FEMALE("2"),
    NOT_APPLICABLE("9");
    private final String value;

    @Override
    public String getValue() {
        return this.value;
    }
}
