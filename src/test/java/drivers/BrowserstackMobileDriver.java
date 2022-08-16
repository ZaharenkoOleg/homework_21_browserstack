package drivers;

import com.codeborne.selenide.WebDriverProvider;
import configs.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class, System.getProperties());
        String login = config.login();
        String password = config.password();
        String app = config.app();

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set access credentials
        mutableCapabilities.setCapability("browserstack.user", login);
        mutableCapabilities.setCapability("browserstack.key", password);

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", app);

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", "Google Pixel 3");
        mutableCapabilities.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
