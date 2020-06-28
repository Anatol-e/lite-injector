package configurer;

public class TestEntity {

    private String name;

    private String surname;

    public TestEntity(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
