package ecommerce.personal.com.startup;

import ecommerce.com.lib.exceptions.EcException;
import ecommerce.personal.com.enums.ConfigurableModel;
import ecommerce.personal.com.services.ModelConfigManager;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@Component
@Slf4j
@RequiredArgsConstructor
public class ModelConfigStartupLoader implements ApplicationListener<ApplicationReadyEvent> {
    private static final String ATTRIBUTES_CONFIG_PATH = "classpath:attributes.xml";

    private final ModelConfigManager modelConfigManager;

    @Override
    public void onApplicationEvent(@NonNull ApplicationReadyEvent event) {
        try {
            log.info("ModelConfigStartupLoader | onApplicationEvent | Load attributes configuration from attribute.xml");
            File attributeConfigFile = ResourceUtils.getFile(ATTRIBUTES_CONFIG_PATH);
            modelConfigManager.loadConfig(attributeConfigFile);
        } catch (FileNotFoundException ex) {
            throw new EcException("Failed to load attributes.xml from classpath:", ex);
        }
    }
}
