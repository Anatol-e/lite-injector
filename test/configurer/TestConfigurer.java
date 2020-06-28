package configurer;

import ank.inj.configurator.Configurator;
import ank.inj.annotation.Configurer;
import ank.inj.configurator.ContainerConfigurer;

import static configurer.TestConstants.KEY_NAME;
import static configurer.TestConstants.TEST_ENTITY;
import static configurer.TestConstants.TEST_ENTITY_BY_NAME;

@Configurer
public class TestConfigurer implements ContainerConfigurer {

    @Override
    public Configurator configuration(Configurator configurator) {
        return configurator.getConfigurator()
                .setObject(TEST_ENTITY)
                .setObject(KEY_NAME, TEST_ENTITY_BY_NAME)
                .configure();
    }
}
