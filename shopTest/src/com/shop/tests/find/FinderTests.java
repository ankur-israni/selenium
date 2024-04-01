package com.shop.tests.find;

import static com.shop.util.Constants.ITEMS_PAGE_TITLE;
import static com.shop.util.Constants.ITEMS_PAGE_URL;
import static com.shop.util.Constants.VALID_PASSWORD;
import static com.shop.util.Constants.VALID_USERNAME;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.shop.tests.base.BaseTests;

public class FinderTests extends BaseTests {

	@Test
	public void findById() throws InterruptedException {
		shopUtil.login(seleniumUtil);
		Thread.sleep(2000);
		assertEquals(ITEMS_PAGE_TITLE, seleniumUtil.getTitle());
		assertEquals(ITEMS_PAGE_URL, seleniumUtil.getCurrentUrl());
	}

	@Test
	public void findByName() throws InterruptedException {
		shopUtil.gotoLoginPage(seleniumUtil);
		WebElement username = seleniumUtil.findByName("username");
		WebElement password = seleniumUtil.findByName("password");
		WebElement submitButton = seleniumUtil.findByName("action");
		username.clear();
		username.sendKeys(VALID_USERNAME);
		password.clear();
		password.sendKeys(VALID_PASSWORD);
		submitButton.click();
		Thread.sleep(2000);
		
		assertEquals(ITEMS_PAGE_TITLE, seleniumUtil.getTitle());
	}

	@Test
	public void findElementsByTagName() {
		shopUtil.gotoLoginPage(seleniumUtil);
		List<WebElement> imgTags = seleniumUtil.findElementsByTagName("img");
		assertEquals(2, imgTags.size());
		assertEquals("login_username_image", imgTags.get(0).getAttribute("id"));
		assertEquals("login_password_image", imgTags.get(1).getAttribute("id"));
	}

	@Test
	public void findByLinkText() {
		shopUtil.gotoLoginPage(seleniumUtil);
		WebElement forgotYourPassword = seleniumUtil.findByLinkText("Forgot your Password?");
		assertEquals("http://localhost:3080/shop/#", forgotYourPassword.getAttribute("href"));
	}

	//TODO: incomplete
	@Test
	public void findByPartialLinkText() {

	}

	@Test
	public void findByCssSelector() throws InterruptedException {
		shopUtil.gotoLoginPage(seleniumUtil);
		seleniumUtil.findByCssSelector("input[id='uid']").clear();
		seleniumUtil.findByCssSelector("input[name='password']").clear();
		seleniumUtil.findByCssSelector("input[id='uid']").sendKeys("java");
		seleniumUtil.findByCssSelector("input[name='password']").sendKeys("java");
		seleniumUtil.findByCssSelector("input.submitClass").click();
		Thread.sleep(2000);
		assertEquals("Items", seleniumUtil.getTitle());
	}

	//TODO: incomplete
	@Test
	public void findByElementLocator() {

	}

	@Test
	public void findByXPath() throws InterruptedException {
		shopUtil.gotoLoginPage(seleniumUtil);
		WebElement username = seleniumUtil.findByXpath(".//*[@id='uid']");
		WebElement password = seleniumUtil.findByXpath(".//*[@id='pid']");
		WebElement loginButton = seleniumUtil.findByXpath(".//*[@id='loginId']");
		username.clear();
		password.clear();
		username.sendKeys("java");
		password.sendKeys("java");
		loginButton.click();
		Thread.sleep(2000);
		assertEquals("Items", seleniumUtil.getTitle());
	}

	// TODO: incomplete
	@Test
	public void findElements() {

	}

}
