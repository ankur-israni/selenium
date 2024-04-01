package com.shop.tests.htmlelements;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.shop.tests.base.BaseTests;

public class DropdownTests extends BaseTests{

	private static final String DROP_DOWN_COUNTRIES_ID="htmlCountries";
	private static final int FIVE=4;
	
	@Test
	public void selectByVisibleText() throws InterruptedException{
		Select countries=getCountriesDropDown();
		countries.selectByVisibleText("Pakistan");
		Thread.sleep(2000);
		assertEquals("Pakistan",countries.getFirstSelectedOption().getText());
	}
	
	@Test
	public void selectByIndex(){
		Select countries=getCountriesDropDown();
		countries.selectByIndex(FIVE);
		assertEquals("Pakistan",countries.getFirstSelectedOption().getText());
	}
	
	//TODO: incomplete - nothing is getting asserted here
	@Test
	public void getAllItemsInDropDown(){
		List<String> lstCountries=new ArrayList<>();
		Select countries=getCountriesDropDown();
		for(WebElement country:countries.getOptions()){
			lstCountries.add(country.getText());
		}
		System.out.println("lstCountries="+lstCountries);
		
	}
	
	@Test
	public void getItemsCount(){
		Select countries=getCountriesDropDown();
		assertEquals(7,countries.getOptions().size());
	}
	
	@Test
	public void isEnabled(){
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		WebElement countries=seleniumUtil.findById(DROP_DOWN_COUNTRIES_ID);
		assertTrue(countries.isEnabled());
		
	}
	
	public void isDisplayed(){
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		WebElement countries=seleniumUtil.findById(DROP_DOWN_COUNTRIES_ID);
		assertTrue(countries.isDisplayed());
	}
	
	
	private Select getCountriesDropDown(){
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		WebElement countries=seleniumUtil.findById(DROP_DOWN_COUNTRIES_ID);
		return seleniumUtil.getSelectBox(countries);
	}
	

	
	


}
