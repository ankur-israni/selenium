package com.shop.util;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtil {

	private static final String EMPTY_ID = "id cannot be null";
	private static final String EMPTY_NAME = "name cannot be null";
	private static final String EMPTY_URL = "url cannot be null";
	private static final String WINDOWS_DRIVER_DIRECTORY = ".\\resources\\windows\\";

	private static final String WINDOWS_FIREFOX_DRIVER = WINDOWS_DRIVER_DIRECTORY + "geckodriver_win64.exe";
	private static final String WINDOWS_CHROME_DRIVER = WINDOWS_DRIVER_DIRECTORY + "chromedriver.exe";
	private static final String WINDOWS_INTERNET_EXPLORER_DRIVER = WINDOWS_DRIVER_DIRECTORY
			+ "IEDriverServer_win64.exe";
	private static final String WINDOWS_PHANTOM_JS_DRIVER = WINDOWS_DRIVER_DIRECTORY + "phantomjs.exe";

//	private static final String MAC_DRIVER_DIRECTORY="/backup/S_N/testing/selenium/workspace/shopTest/resources/";
//	private static final String MAC_DRIVER_DIRECTORY = "/usr/local/bin/";
	private static final String MAC_DRIVER_DIRECTORY = "/backup/S_N/testing/test/selenium/workspace/shopTest/resources/mac/";

	private static final String MAC_CHROME_DRIVER = MAC_DRIVER_DIRECTORY + "chromedriver";
	private static final String MAC_FIREFOX_DRIVER = MAC_DRIVER_DIRECTORY + "geckodriver";

	private static WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public SeleniumUtil(OSType osType, BrowserType browserType) {
		this.driver = loadDriver(osType, browserType);
	}

	public static WebDriver loadDriver(OSType osType, BrowserType browserType) {
		if (browserType == BrowserType.CHROME)
			return loadChromeDriver(osType);
		if (browserType == BrowserType.IE)
			return InternetExplorerDriver(osType);
		if (browserType == BrowserType.FIREFOX)
			return loadFirefoxDriver(osType);
		if (browserType == BrowserType.PHANTOMJS)
			return loadPhantomJSDriver(osType);
		return loadFirefoxDriver(osType);
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public void closeAll() {
		driver.quit();
	}

	public void close() {
		driver.close();
	}

	public void back() {
		driver.navigate().back();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void navigate(String url) {
		if (url == null)
			throw new IllegalArgumentException(EMPTY_URL);
		driver.navigate().to(url);
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void forward() {
		driver.navigate().forward();
	}

	public List<WebElement> findElementsByTagName(String tagName) {
		if (StringUtils.trimToNull(tagName) == null)
			throw new IllegalArgumentException(EMPTY_NAME);
		return driver.findElements(By.tagName(tagName));
	}

	public WebElement findByTagName(String tagName) {
		if (StringUtils.trimToNull(tagName) == null)
			throw new IllegalArgumentException(EMPTY_NAME);
		return driver.findElement(By.tagName(tagName));
	}

	public WebElement findByXpath(String xPath) {
		if (StringUtils.trimToNull(xPath) == null)
			throw new IllegalArgumentException(EMPTY_NAME);
		return driver.findElement(By.xpath(xPath));
	}

	public WebElement findByCssSelector(String cssSelector) {
		if (StringUtils.trimToNull(cssSelector) == null)
			throw new IllegalArgumentException(EMPTY_NAME);
		return driver.findElement(By.cssSelector(cssSelector));
	}

	public WebElement findByPartialLinkText(String partialText) {
		if (StringUtils.trimToNull(partialText) == null)
			throw new IllegalArgumentException(EMPTY_NAME);
		return driver.findElement(By.partialLinkText(partialText));
	}

	public WebElement findByLinkText(String text) {
		if (StringUtils.trimToNull(text) == null)
			throw new IllegalArgumentException(EMPTY_NAME);
		return driver.findElement(By.linkText(text));
	}

	public WebElement findByName(String name) {
		if (name == null)
			throw new IllegalArgumentException(EMPTY_NAME);
		return driver.findElement(By.name(name));
	}

//	public WebElement findById(String id) {
//		if (id == null)
//			throw new IllegalArgumentException(EMPTY_ID);
//		WebElement shadowHost = driver.findElement(By.cssSelector("#shadowrootcontainer"));
//		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//		SearchContext shadowRoot = (SearchContext) javascriptExecutor.executeScript("return arguments[0].shadowRoot",
//				shadowHost);
//		return  shadowRoot.findElement(By.id(id));
//
//	}

	public WebElement findById(String id) {

		if (id == null)
			throw new IllegalArgumentException(EMPTY_ID);
		return driver.findElement(By.id(id));
	}

	public void get(String url) {
		if (url == null)
			throw new IllegalArgumentException(EMPTY_URL);
		driver.get(url);
	}

	public static WebDriver loadFirefoxDriver(OSType osType) {
		if (osType == OSType.WINDOWS) {
			System.setProperty("webdriver.gecko.driver", WINDOWS_FIREFOX_DRIVER);
		} else if (osType == OSType.MAC) {
			System.setProperty("webdriver.gecko.driver", MAC_FIREFOX_DRIVER);
		}

		return new FirefoxDriver();
	}

	public static WebDriver loadPhantomJSDriver(OSType osType) {
//		System.setProperty("webdriver.gecko.driver", PHANTOM_JS_DRIVER);

		Capabilities caps = new DesiredCapabilities();
		if (osType == OSType.WINDOWS) {

			((DesiredCapabilities) caps).setJavascriptEnabled(true);

			((DesiredCapabilities) caps).setCapability("takesScreenshot", true);

			((DesiredCapabilities) caps).setCapability(

					PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, WINDOWS_PHANTOM_JS_DRIVER);
		}

		return new PhantomJSDriver(caps);

	}

//	public static WebDriver loadChromeDriver(OSType osType) {
//		if(osType==OSType.MAC) {
//			System.setProperty("webdriver.chrome.driver", MAC_CHROME_DRIVER);
//		}else if(osType==OSType.WINDOWS) {
//			System.setProperty("webdriver.chrome.driver", WINDOWS_CHROME_DRIVER);
//		}
//		
//		return new ChromeDriver();
//	}

	public static WebDriver loadChromeDriver(OSType osType) {
		if (osType == OSType.MAC) {
			System.setProperty("webdriver.chrome.driver", MAC_CHROME_DRIVER);
		} else if (osType == OSType.WINDOWS) {
			System.setProperty("webdriver.chrome.driver", WINDOWS_CHROME_DRIVER);
		}

		return new ChromeDriver();
	}

	public static WebDriver InternetExplorerDriver(OSType osType) {
		if (osType == OSType.WINDOWS) {
			System.setProperty("webdriver.ie.driver", WINDOWS_INTERNET_EXPLORER_DRIVER);
		} else if (osType == OSType.MAC) {
			throw new RuntimeException("Internet Explorer is not supported on Macs");
		}
		return new InternetExplorerDriver();
	}

	public Select getSelectBox(WebElement element) {
		return new Select(element);
	}

	public void quit() {
		driver.quit();
	}

}
