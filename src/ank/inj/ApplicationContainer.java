package ank.inj;

import ank.inj.configurator.ConfigurerUtil;
import ank.inj.exception.ApplicationContainerInitializationException;

import java.util.Map;

public class ApplicationContainer {

    private Map<String, Object> container;

    public ApplicationContainer() throws ApplicationContainerInitializationException {
        try {
            ConfigurerUtil configurerUtil = ConfigurerUtil.getInstance();
            container = configurerUtil.getConfigObjectsMap();
        } catch (Exception ex) {
            throw new ApplicationContainerInitializationException(ex.getMessage(), ex);
        }
    }

    public Map<String, Object> getContainer() {
        return container;
    }

    public Object getObjectFromContainer(String key) {
        return container.get(key);
    }
}
