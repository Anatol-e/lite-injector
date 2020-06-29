package configurer;

import ank.inj.annotation.Configurer;
import ank.inj.configurator.Configurator;
import ank.inj.configurator.ContainerConfigurer;

import static configurer.TestConstants.KEY_NAME;
import static configurer.TestConstants.KEY_STRING;
import static configurer.TestConstants.TEST_ENTITY;
import static configurer.TestConstants.TEST_ENTITY_BY_NAME;
import static configurer.TestConstants.TEST_VALUE_STRING;

@Configurer
public class TestConfigurer implements ContainerConfigurer {

    @Override
    public Configurator configuration(Configurator configurator) {
        return configurator.getConfigurator()
                .put(TEST_ENTITY)
                .put(KEY_NAME, TEST_ENTITY_BY_NAME)
                .put(KEY_STRING, TEST_VALUE_STRING)
                .configure();
    }
}
