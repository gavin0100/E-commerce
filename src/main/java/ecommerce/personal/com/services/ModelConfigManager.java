package ecommerce.personal.com.services;

import ecommerce.personal.com.enums.ConfigurableModel;
import ecommerce.personal.com.models.dtos.ConfiguredAttribute;

import java.io.File;
import java.util.Set;

public interface ModelConfigManager {
    void loadConfig(File fileConfig);
    Set<ConfiguredAttribute> getAllEntityAttributes(ConfigurableModel entity);
}
