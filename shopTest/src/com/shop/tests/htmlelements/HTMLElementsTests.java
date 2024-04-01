package com.shop.tests.htmlelements;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.shop.tests.base.BaseTests;

public class HTMLElementsTests extends BaseTests {
	
	

	
	@Test
	public void getText() {
		shopUtil.gotoLoginPage(seleniumUtil);
		WebElement usernameDiv=seleniumUtil.findById("pageHeader");
		assertTrue(StringUtils.equalsAnyIgnoreCase("Login", usernameDiv.getText()));
	}
	
	@Test
	public void sendKeys() throws InterruptedException{
		shopUtil.gotoLoginPage(seleniumUtil);
		WebElement username=seleniumUtil.findByName("username");
		WebElement password=seleniumUtil.findByName("password");
		username.clear();
		username.sendKeys("java");
		password.clear();
		password.sendKeys("java");
		WebElement submitButton=seleniumUtil.findByName("action");
		submitButton.click();
		Thread.sleep(2000);
		assertEquals("Items",seleniumUtil.getTitle());
	}
	
	
	@Test
	public void isDisplayed(){
		shopUtil.gotoLoginPage(seleniumUtil);
		WebElement username=seleniumUtil.findByName("username");
		WebElement password=seleniumUtil.findByName("password");
		assertTrue(username.isDisplayed());
		assertTrue(password.isDisplayed());
	}
	
	@Test
	public void isEnabled(){
		shopUtil.gotoLoginPage(seleniumUtil);
		WebElement username=seleniumUtil.findByName("username");
		WebElement password=seleniumUtil.findByName("password");
		assertTrue(username.isEnabled());
		assertTrue(password.isEnabled());
	}
	
	@Test
	public void isSelected(){
		shopUtil.gotoLoginPage(seleniumUtil);
		WebElement username=seleniumUtil.findByName("username");
		WebElement password=seleniumUtil.findByName("password");
		assertFalse(username.isSelected());
		assertFalse(password.isSelected());
	}
	

	
	@Test
	public void clear(){
		shopUtil.gotoLoginPage(seleniumUtil);
		WebElement username=seleniumUtil.findByName("username");
		WebElement password=seleniumUtil.findByName("password");
		username.clear();
		password.clear();
		assertNull(StringUtils.trimToNull(username.getText()));
		assertNull(StringUtils.trimToNull(password.getText()));
	}
	
	@Test
	public void click() throws InterruptedException{
		shopUtil.gotoLoginPage(seleniumUtil);
		WebElement username=seleniumUtil.findByName("username");
		WebElement password=seleniumUtil.findByName("password");
		WebElement submitButton=seleniumUtil.findByName("action");
		username.clear();
		username.sendKeys("java");
		password.clear();
		password.sendKeys("java");
		submitButton.click();
		Thread.sleep(2000);
		assertEquals("Items",seleniumUtil.getTitle());
	}
	


	
}
