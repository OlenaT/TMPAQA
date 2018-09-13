package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;


public class CustomWebDriverProvider {

    private static String browser = PropertiesFactory.getProperty("browser");

    public static WebDriver createDriver() {
        WebDriver webDriver;
        switch (browser) {
            case "FIREFOX":
                webDriver = new FirefoxDriver(getFirefoxProfile());
                webDriver.manage().window().maximize();
                break;
            case "CHROME":
                webDriver = new ChromeDriver(getChromeOptions());
                break;
            default:
                throw new IllegalArgumentException("Incorrect webdriver provided");
        }
        return webDriver;
    }

    private static FirefoxOptions getFirefoxProfile() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv, application/csv, text/comma-separated-values");
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting ", false);
        firefoxProfile.setPreference("browser. frames. enabled", false);
        firefoxProfile.setPreference("pdfjs.disabled", true);
        firefoxProfile.setPreference("plugin.scan.Acrobat", "99.0");
        firefoxProfile.setPreference("plugin.scan.plid.all", false);
        firefoxProfile.setAcceptUntrustedCertificates(true);
        firefoxOptions.setProfile(firefoxProfile);
        return firefoxOptions;
    }

    private static ChromeOptions getChromeOptions() {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("disable-popup-blocking", "true");
        chromePrefs.put("download.prompt_for_download", "false");
        chromePrefs.put("profile.default_content_setting_values.notifications", 2);
        chromePrefs.put("directory_upgrade", true);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("no-sandbox");
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-print-preview");
        return options;
    }
}
