package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:realDevice.properties"
})
public interface RealDeviceConfig extends Config {

    @Config.Key("realPlatformName")
    String realPlatformName();

    @Config.Key("realDeviceName")
    String realDeviceName();

    @Config.Key("realDeviceVersion")
    String realDeviceVersion();

}
