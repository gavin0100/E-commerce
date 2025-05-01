package ecommerce.personal.com.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ecommerce.com.lib.exceptions.EcException;
import ecommerce.personal.com.enums.ConfiguredModel;
import ecommerce.com.lib.models.dtos.ConfiguredAttribute;
import ecommerce.com.lib.models.dtos.ConfiguredEntity;
import ecommerce.personal.com.services.ModelConfigManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@Slf4j
public class ModelConfigManagerImpl implements ModelConfigManager {
    private static final XmlMapper XML_MAPPER = new XmlMapper();

    private Set<ConfiguredEntity> configuredEntities = new HashSet<>();

    @Override
    public void loadConfig(File configFile) {
        try {
            configuredEntities = XML_MAPPER.readValue(configFile, new TypeReference<>() {});
        } catch (IOException ex) {
            log.error("AttributesConfigManagerService | LoadConfig | Can't load configured entities: ", ex);
            throw new EcException(ex);
        }
    }

    @Override
    public Set<ConfiguredAttribute> getAllEntityAttributes(ConfiguredModel entity) {
        if (Objects.isNull(entity)) {
            return Collections.emptySet();
        }

        return configuredEntities.stream()
                .filter(config -> entity.getValue().equals(config.getId()))
                .findFirst()
                .map(ConfiguredEntity::getAttributes)
                .orElse(Collections.emptySet());
    }
}
