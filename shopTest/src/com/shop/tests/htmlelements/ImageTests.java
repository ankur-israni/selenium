package com.shop.tests.htmlelements;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.shop.tests.base.BaseTests;

public class ImageTests extends BaseTests {
	
	private static final String IMAGE_ID="htmlImageId";

	@Test
	public void isImageDisplayed() throws InterruptedException{
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		WebElement image=seleniumUtil.findById(IMAGE_ID);
		assertTrue(image.isDisplayed());
	}
	
	@Test
	public void isImageSelected(){
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		WebElement image=seleniumUtil.findById(IMAGE_ID);
		assertFalse(image.isSelected());
	}
	
	@Test
	public void imageAttributes(){
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		WebElement image=seleniumUtil.findById(IMAGE_ID);
		assertEquals("Employee Image",image.getAttribute("alt"));
		assertTrue(StringUtils.containsIgnoreCase(image.getAttribute("src"),"images/employee.png" ));
	}
	
}
