import ank.inj.ApplicationContainer;
import ank.inj.Inj;
import ank.inj.configurator.ConfigurerUtil;
import ank.inj.exception.ApplicationContainerInitializationException;
import configurer.SameLogicalObject;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static configurer.TestConstants.KEY_NAME;
import static configurer.TestConstants.TEST_ENTITY;
import static configurer.TestConstants.TEST_ENTITY_BY_NAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MainTest {

    @Before
    public void setUp() {
        ConfigurerUtil.getInstance();
    }

    @Test
    public void Should_ReturnConfigurations_WithExistedTestEntity()
            throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException,
            InvocationTargetException {
        Map<String, Object> allObjects = ConfigurerUtil.getInstance().getConfigObjectsMap();
        assertTrue(allObjects.containsValue(TEST_ENTITY));
    }

    @Test
    public void Should_ReturnCorrectEntityByNameTag()
            throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException,
            InvocationTargetException {
        Map<String, Object> allObjects = ConfigurerUtil.getInstance().getConfigObjectsMap();
        assertEquals(allObjects.get(KEY_NAME), TEST_ENTITY_BY_NAME);
    }

    @Test
    public void Should_ReturnNotEmptyContainer() throws ApplicationContainerInitializationException {
        ApplicationContainer container = new ApplicationContainer();
        assertTrue(container.getContainer().size() > 0);
    }

    @Test
    public void Should_ReturnCorrectObjectByKey() throws ApplicationContainerInitializationException {
        ApplicationContainer container = new ApplicationContainer();
        assertEquals(container.getObjectFromContainer(KEY_NAME), TEST_ENTITY_BY_NAME);
    }

    @Test
    public void Should_ReturnCorrectObjectFromInjector() throws ApplicationContainerInitializationException, IllegalAccessException {
        SameLogicalObject sameLogicalObject = new Inj<SameLogicalObject>().init(new SameLogicalObject());
        assertEquals(sameLogicalObject.getTestEntity(), TEST_ENTITY);
    }

    @Test
    public void Should_ReturnCorrectObjectFromInjector_WithKeyParameter() throws ApplicationContainerInitializationException, IllegalAccessException {
        SameLogicalObject sameLogicalObject = new Inj<SameLogicalObject>().init(new SameLogicalObject());
        assertEquals(sameLogicalObject.getTestEntity(), TEST_ENTITY);
    }


}