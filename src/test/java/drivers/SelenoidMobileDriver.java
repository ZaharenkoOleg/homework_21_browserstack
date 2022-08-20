package drivers;


import com.codeborne.selenide.WebDriverProvider;
import configs.SelenoidMobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class SelenoidMobileDriver implements WebDriverProvider {


    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        SelenoidMobileConfig driverConfig = ConfigFactory.create(SelenoidMobileConfig.class, System.getProperties());

        File app = getApp();
        DesiredCapabilities options = new DesiredCapabilities();
        options.setBrowserName(driverConfig.selenoidDeviceName());
        options.setVersion(driverConfig.selenoidDeviceVersion());
        options.setCapability("app", app.getAbsolutePath());
        options.setCapability("appPackage",  "org.wikipedia.alpha");
        options.setCapability("appActivity", "org.wikipedia.main.MainActivity" );
        options.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        return new RemoteWebDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL("https://user1:1234@selenoid.autotests.cloud/wd/hub/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private File getApp() {
        String appUrl = "https://github.com/wikimedia/apps-android-wikipedia/" +
                "releases/download/latest/app-alpha-universal-release.apk";
        String appPath = "src/test/resources/apps/app-alpha-universal-release.apk";

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app;
    }
}

