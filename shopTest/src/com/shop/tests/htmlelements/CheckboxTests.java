package com.shop.tests.htmlelements;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.shop.tests.base.BaseTests;

public class CheckboxTests extends BaseTests {

	@Test
	public void isDisplayed() throws Exception {
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		List<WebElement> checkBoxes = seleniumUtil.getDriver().findElements(By.name("htmlCheckboxHobby"));
		for (WebElement checkbox : checkBoxes) {
			assertTrue(checkbox.isDisplayed());
		}
	}

	@Test
	public void isSelected() {
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		List<WebElement> checkBoxes = seleniumUtil.getDriver().findElements(By.name("htmlCheckboxHobby"));
		for (WebElement checkbox : checkBoxes) {
			assertFalse(checkbox.isSelected());
		}
	}

	@Test
	public void isEnabled() {
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		List<WebElement> checkBoxes = seleniumUtil.getDriver().findElements(By.name("htmlCheckboxHobby"));
		for (WebElement checkbox : checkBoxes) {
			assertTrue(checkbox.isEnabled());
		}
	}
	
	@Test
	public void size(){
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		List<WebElement> checkBoxes = seleniumUtil.getDriver().findElements(By.name("htmlCheckboxHobby"));
		assertEquals(4, checkBoxes.size());
	}

	@Test
	public void select() {
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		List<WebElement> checkBoxes = seleniumUtil.getDriver().findElements(By.name("htmlCheckboxHobby"));
		

		checkBoxes.get(0).click();
		assertTrue(checkBoxes.get(0).isSelected());
		assertFalse(checkBoxes.get(1).isSelected());
		assertFalse(checkBoxes.get(2).isSelected());
		assertFalse(checkBoxes.get(3).isSelected());

		checkBoxes.get(1).click();
		assertTrue(checkBoxes.get(0).isSelected());
		assertTrue(checkBoxes.get(1).isSelected());
		assertFalse(checkBoxes.get(2).isSelected());
		assertFalse(checkBoxes.get(3).isSelected());

		checkBoxes.get(2).click();
		assertTrue(checkBoxes.get(0).isSelected());
		assertTrue(checkBoxes.get(1).isSelected());
		assertTrue(checkBoxes.get(2).isSelected());
		assertFalse(checkBoxes.get(3).isSelected());

		checkBoxes.get(3).click();
		assertTrue(checkBoxes.get(0).isSelected());
		assertTrue(checkBoxes.get(1).isSelected());
		assertTrue(checkBoxes.get(2).isSelected());
		assertTrue(checkBoxes.get(3).isSelected());
	}

	@Test
	public void getAttributes() {
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		List<WebElement> radioButtons = seleniumUtil.getDriver().findElements(By.name("htmlCheckboxHobby"));
		assertEquals("tennis", radioButtons.get(0).getAttribute("value"));
		assertEquals("cricket", radioButtons.get(1).getAttribute("value"));
		assertEquals("football", radioButtons.get(2).getAttribute("value"));
		assertEquals("sleeping", radioButtons.get(3).getAttribute("value"));

		assertEquals("htmlHobby1", radioButtons.get(0).getAttribute("id"));
		assertEquals("htmlHobby2", radioButtons.get(1).getAttribute("id"));
		assertEquals("htmlHobby3", radioButtons.get(2).getAttribute("id"));
		assertEquals("htmlHobby4", radioButtons.get(3).getAttribute("id"));

		assertEquals("chkboxHobby", radioButtons.get(0).getAttribute("class"));
		assertEquals("chkboxHobby", radioButtons.get(1).getAttribute("class"));
		assertEquals("chkboxHobby", radioButtons.get(2).getAttribute("class"));
		assertEquals("chkboxHobby", radioButtons.get(3).getAttribute("class"));

		assertEquals("checkbox", radioButtons.get(0).getAttribute("type"));
		assertEquals("checkbox", radioButtons.get(1).getAttribute("type"));
		assertEquals("checkbox", radioButtons.get(2).getAttribute("type"));
		assertEquals("checkbox", radioButtons.get(3).getAttribute("type"));

	}

}
