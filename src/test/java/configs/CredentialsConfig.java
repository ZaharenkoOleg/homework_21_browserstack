package configs;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:browserstack.properties")
public interface CredentialsConfig extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("app")
    String app();

    @Key("deviceName")
    String deviceName();

    @Key("osVersion")
    String osVersion();

}
