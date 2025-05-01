package ecommerce.personal.com.services;

import ecommerce.personal.com.enums.ConfiguredModel;
import ecommerce.com.lib.models.dtos.ConfiguredAttribute;

import java.io.File;
import java.util.Set;

public interface ModelConfigManager {
    void loadConfig(File fileConfig);
    Set<ConfiguredAttribute> getAllEntityAttributes(ConfiguredModel entity);
}
