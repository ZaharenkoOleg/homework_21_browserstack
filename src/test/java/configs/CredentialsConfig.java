package configs;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:browserstack.properties")
public interface CredentialsConfig extends Config {

    @Key("browserstackLogin")
    String browserstackLogin();

    @Key("browserstackPassword")
    String browserstackPassword();

    @Key("browserstackApp")
    String browserstackApp();

    @Key("browserstackDeviceName")
    String browserstackDeviceName();

    @Key("browserstackVersion")
    String browserstackVersion();



}
