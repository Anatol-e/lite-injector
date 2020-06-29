package configurer;

import ank.inj.annotation.FromContainer;

import static configurer.TestConstants.KEY_STRING;

public class SameLogicalObject {

    @FromContainer
    private TestEntity testEntity;

    @FromContainer(name = KEY_STRING)
    private String branchId;

    public TestEntity getTestEntity() {
        return testEntity;
    }

    public String getBranchId() {
        return branchId;
    }
}
