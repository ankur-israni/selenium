package com.shop.tests.htmlelements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.shop.tests.base.BaseTests;

public class LinkTests extends BaseTests {
	
	private static final String LINK_ID="htmlResumeId";
	
	@Test
	public void linkClick(){
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		seleniumUtil.findById(LINK_ID).click();
		assertEquals("Selenium",seleniumUtil.getTitle());
		
	}
	
	@Test
	public void isLinkEnabled() throws InterruptedException{
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		assertTrue(seleniumUtil.findById(LINK_ID).isDisplayed());
	}
	
	@Test
	public void isLinkSelected() throws InterruptedException{
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		assertFalse(seleniumUtil.findById(LINK_ID).isSelected());
	}
	
	@Test
	public void linkAttributes() throws InterruptedException{
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		WebElement link=seleniumUtil.findById(LINK_ID);
		assertEquals("http://www.google.com/",link.getAttribute("href"));
	}
	

}
