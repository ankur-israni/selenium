package com.shop.tests.htmlelements;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.shop.tests.base.BaseTests;

public class TextFieldTests extends BaseTests{

	@Test
	public void read(){
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		getTextBox().sendKeys("java");
		assertEquals("java",getTextBox().getAttribute("value"));
	}
	
	@Test
	public void write(){
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		getTextBox().sendKeys("java");
		assertEquals("java",getTextBox().getAttribute("value"));
	}
	
	@Test
	public void clear(){
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		getTextBox().sendKeys("java");
		assertEquals("java",getTextBox().getAttribute("value"));
		getTextBox().clear();
		assertNull(StringUtils.trimToNull(getTextBox().getAttribute("value")));
	}
	
	@Test
	public void isSelected(){
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		assertFalse(getTextBox().isSelected());
	}
	
	@Test
	public void isDisplayed(){
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		assertTrue(getTextBox().isDisplayed());
	}
	
	@Test
	public void isEnabled(){
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		assertTrue(getTextBox().isEnabled());
	}
	
	private WebElement getTextBox(){
		return seleniumUtil.findById("htmlNameId");
	}
	
}
