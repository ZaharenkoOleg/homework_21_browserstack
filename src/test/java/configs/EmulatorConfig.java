package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:emulator.properties"
})
public interface EmulatorConfig extends Config {
    @Config.Key("emulatorPlatformName")
    String emulatorPlatformName();

    @Config.Key("emulatorDeviceName")
    String emulatorDeviceName();

    @Config.Key("emulatorDeviceVersion")
    String emulatorDeviceVersion();

}
