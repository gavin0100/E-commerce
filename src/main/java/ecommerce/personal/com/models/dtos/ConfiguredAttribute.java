package ecommerce.personal.com.models.dtos;

import ecommerce.personal.com.enums.AttributeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfiguredAttribute {
    private String id;
    private String name;
    private AttributeType type;
    private boolean required;
    private String regex;
    private Integer minLength;
    private Integer maxLength;
    private String enumValue;
    private String inList;
}