package ank.inj.configurator;

import java.util.HashMap;
import java.util.Map;

public class Configurator {

    private Map<String, Object> objects;

    public Configurator() {
        this.objects = new HashMap<>();
    }

    public Map<String, Object> getObjects() {
        return objects;
    }

    public ContainerConfigurator getConfigurator() {
        return new ContainerConfigurator();
    }

    public class ContainerConfigurator {

        public ContainerConfigurator setObject(String name, Object object) {
            Configurator.this.objects.put(name, object);
            return this;
        }

        public ContainerConfigurator setObject(Object object) {
            Configurator.this.objects.put(object.getClass().getName(), object);
            return this;
        }

        public Configurator configure() {
            return Configurator.this;
        }

    }

}
