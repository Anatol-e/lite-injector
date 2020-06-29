# lite-injector
This is simple library for containing objects and then use them in an easy way.
###How to use
* Creating configuration object (Configurer)
```
@Configurer
public class TestConfigurer implements ContainerConfigurer {

    @Override
    public Configurator configuration(Configurator configurator) {
        return configurator.getConfigurator()
                .put(value) 
                //Or if we need contatin object with the special key
                .put(key, value)
                .configure();
    }
}
```
Configurer will save inserted objects to the container;
Object could be saved by the special key. By default, key value is the Full Object Name (but not instance name);

* Mark inserted object in the target class (by using FromContainer annotation)
```
public class TargetObject {

    @FromContainer
    private YourObject yourObject;
}
``` 

* Init target class with Inj.class wrapper
```
  TargetObject target = new Inj<TargetObject>().init(new TargetObject());
```