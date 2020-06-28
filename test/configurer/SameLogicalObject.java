package configurer;

import ank.inj.annotation.FromContainer;

public class SameLogicalObject {

    @FromContainer
    private TestEntity testEntity;

    public TestEntity getTestEntity() {
        return testEntity;
    }
}
