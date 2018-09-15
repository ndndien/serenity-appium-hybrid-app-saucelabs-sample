package com.appium.serenirybdd.appium;

import com.appium.serenirybdd.configs.MyConfigs;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsDriver implements DriverSource {

    private static final String URL = "http://" + MyConfigs.SAUCELABS_USERNAME + ":" + MyConfigs.SAUCELABS_ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    @Override
    public WebDriver newDriver() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
            capabilities.setCapability("deviceOrientation", "portrait");
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
            capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.8.1");
            capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD,true);
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
            capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
            capabilities.setCapability(MobileCapabilityType.NO_RESET,true);
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");
            capabilities.setCapability("name",MyConfigs.SAUCELABS_TEST_NAME);
            return new AndroidDriver(new URL(URL), capabilities);
        } catch (MalformedURLException e) {
            throw new Error(e);
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }

}
