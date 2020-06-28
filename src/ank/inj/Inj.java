package ank.inj;

import ank.inj.annotation.FromContainer;
import ank.inj.exception.ApplicationContainerInitializationException;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;

import java.lang.reflect.Field;

public class Inj<T> {

    private ApplicationContainer container;

    public Inj() throws ApplicationContainerInitializationException {
        container = new ApplicationContainer();
    }

    public T init(T object) throws IllegalAccessException {
        Reflections reflections = new Reflections(new FieldAnnotationsScanner());
        for (Field field : reflections.getFieldsAnnotatedWith(FromContainer.class)) {
            field.setAccessible(true);
            field.set(object, container.getObjectFromContainer(field.getType().getName()));
        }
        return object;
    }

}
