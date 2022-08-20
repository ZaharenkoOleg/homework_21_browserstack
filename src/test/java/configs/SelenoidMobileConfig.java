package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:selenoid.properties"
})
public interface SelenoidMobileConfig extends Config {

    @Config.Key("selenoidDeviceVersion")
    String selenoidDeviceVersion();

    @Config.Key("selenoidDeviceName")
    String selenoidDeviceName();
}
