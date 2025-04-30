package ecommerce.personal.com.models.dtos;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguredEntity {
    private String id;

    @JacksonXmlProperty(localName = "attribute")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Set<ConfiguredAttribute> attributes;
}