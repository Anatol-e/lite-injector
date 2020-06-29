package ank.inj.configurator;

import ank.inj.annotation.Configurer;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigurerUtil {

    private static final String CONFIGURATION_METHOD = "configuration";

    private static ConfigurerUtil instance;
    private static Reflections reflections;

    private ConfigurerUtil() {
        initConfigurator();
    }

    public static ConfigurerUtil getInstance() {
        if (instance == null) {
            instance = new ConfigurerUtil();
        }
        return instance;
    }

    public void initConfigurator() {
        reflections = new Reflections();
    }

    public void initConfigurator(String path) {
        reflections = new Reflections(path);
    }

    public List<Configurator> getConfigurationList()
            throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchMethodException,
            InvocationTargetException {
        List<Configurator> configurations = new ArrayList<>();
        for (Class<?> cl : reflections.getTypesAnnotatedWith(Configurer.class)) {
            Class<?> clazz = Class.forName(cl.getName());
            Object config = clazz.newInstance();
            Method configMethod = clazz.getMethod(CONFIGURATION_METHOD, Configurator.class);
            Configurator configurator = (Configurator) configMethod.invoke(config, new Configurator());
            configurations.add(configurator);
        }
        return configurations;
    }

    public Map<String, Object> getConfigObjectsMap()
            throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException,
            IllegalAccessException {
        Map<String, Object> allObjects = new HashMap<>();
        for (Configurator config : getConfigurationList()) {
            Map<String, Object> configMap = config.getObjects();
            allObjects.putAll(configMap);
        }
        return allObjects;
    }

}
