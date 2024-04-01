package com.shop.tests.htmlelements;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.shop.tests.base.BaseTests;

public class RadioButtonTests extends BaseTests {

	@Test
	public void isDisplayed() throws Exception {
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		List<WebElement> radioButtons = seleniumUtil.getDriver().findElements(By.name("htmlRadioSex"));
		for (WebElement radio : radioButtons) {
			assertTrue(radio.isDisplayed());
		}
	}

	@Test
	public void isSelected() {
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		List<WebElement> radioButtons = seleniumUtil.getDriver().findElements(By.name("htmlRadioSex"));
		for (WebElement radio : radioButtons) {
			assertFalse(radio.isSelected());
		}
	}

	@Test
	public void isEnabled() {
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		List<WebElement> radioButtons = seleniumUtil.getDriver().findElements(By.name("htmlRadioSex"));
		for (WebElement radio : radioButtons) {
			assertTrue(radio.isEnabled());
		}
	}

	@Test
	public void selectOne() {
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		List<WebElement> radioButtons = seleniumUtil.getDriver().findElements(By.name("htmlRadioSex"));

		radioButtons.get(0).click();
		assertTrue(radioButtons.get(0).isSelected());
		assertFalse(radioButtons.get(1).isSelected());

		radioButtons.get(1).click();
		assertFalse(radioButtons.get(0).isSelected());
		assertTrue(radioButtons.get(1).isSelected());

	}
	
	@Test
	public void size(){
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		List<WebElement> radioButtons = seleniumUtil.getDriver().findElements(By.name("htmlRadioSex"));
		assertEquals(2,radioButtons.size());
	}



	@Test
	public void getAttributes() {
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		List<WebElement> radioButtons = seleniumUtil.getDriver().findElements(By.name("htmlRadioSex"));
		assertEquals("male",radioButtons.get(0).getAttribute("value"));
		assertEquals("htmlSex1",radioButtons.get(0).getAttribute("id"));
		assertEquals("htmlRadioSex",radioButtons.get(0).getAttribute("class"));
		assertEquals("radio",radioButtons.get(0).getAttribute("type"));
		
		assertEquals("female",radioButtons.get(1).getAttribute("value"));
		assertEquals("htmlSex2",radioButtons.get(1).getAttribute("id"));
		assertEquals("htmlRadioSex",radioButtons.get(1).getAttribute("class"));
		assertEquals("radio",radioButtons.get(1).getAttribute("type"));
	}

}
