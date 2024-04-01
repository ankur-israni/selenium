package com.shop.tests.htmlelements;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.shop.tests.base.BaseTests;

public class ButtonTests extends BaseTests {

	private static final String BACK_BUTTON_ID="htmlBackId";
	
	@Test
	public void clear(){
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		seleniumUtil.findById("htmlNameId").sendKeys("selenium is great");
		assertEquals("selenium is great",seleniumUtil.findById("htmlNameId").getAttribute("value"));
		seleniumUtil.findById("htmlNameId").clear();
		assertNull(StringUtils.trimToNull(seleniumUtil.findById("htmlNameId").getAttribute("value")));
		
	}
	
	@Test
	public void buttonClick() throws InterruptedException{
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		seleniumUtil.findById(BACK_BUTTON_ID).click();
		Thread.sleep(2000);
		assertEquals("Items",seleniumUtil.getTitle());
	}
	
	@Test
	public void isButtonEnabled() throws InterruptedException{
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		assertTrue(seleniumUtil.findById(BACK_BUTTON_ID).isDisplayed());
	}
	
	@Test
	public void isButtonSelected() throws InterruptedException{
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		assertFalse(seleniumUtil.findById(BACK_BUTTON_ID).isSelected());
	}

	@Test
	public void isButtonDisplayed() throws InterruptedException{
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		assertTrue(seleniumUtil.findById(BACK_BUTTON_ID).isDisplayed());
	}
	
	@Test
	public void buttonAttributes() throws InterruptedException{
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		WebElement backButton=seleniumUtil.findById(BACK_BUTTON_ID);
		assertEquals(BACK_BUTTON_ID,backButton.getAttribute("id"));
		assertEquals("action",backButton.getAttribute("name"));
		assertEquals("submit",backButton.getAttribute("type"));
	}
	
	
}
