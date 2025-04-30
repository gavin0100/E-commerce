package ecommerce.personal.com.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum AttributeType implements EnumValue {
    TEXT("text"),
    NUMBER("number"),
    DATE("date"),
    TIME("time"),
    TIMESTAMP("timestamp"),
    OBJECT("object"),
    ENUM("enum");

    private final String value;

}
