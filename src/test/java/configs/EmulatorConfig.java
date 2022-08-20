package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:{host}.properties"
})
public interface EmulatorConfig extends Config {
    @Config.Key("platformNameEm")
    String platformNameEm();

    @Config.Key("deviceNameEm")
    String deviceNameEm();

    @Config.Key("osVersionEm")
    String osVersionEm();

}
