package com.shop.tests.jqueryelements;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.shop.tests.base.BaseTests;

public class DropDownTests extends BaseTests{

	@Test
	public void test() throws InterruptedException{
		shopUtil.gotoHTMLControlsTab(seleniumUtil);
		WebElement ddl=seleniumUtil.findById("jqueryCountries");
		
		//Unhide the ddl which is the outer layer of the ddl hidden by jqueryui
		((JavascriptExecutor)seleniumUtil.getDriver()).executeScript("document.getElementById('jqueryCountries').style.display='block'");
		
		Select select=new Select(ddl);
		select.selectByVisibleText("Pakistan");
		
		Thread.sleep(2000);
		System.out.println("-------------getOptions-----------------------");
		List<WebElement> allOptions=select.getOptions();
		for(WebElement element:allOptions){
			System.out.println(element.getText());
			
		}
		
		
		System.out.println("isMultiple="+select.isMultiple());
		
		
		System.out.println("-------------selectedOptions-----------------------");
		List<WebElement> selectedOptions=select.getAllSelectedOptions();
		for(WebElement element:selectedOptions){
			System.out.println(element.getText());
		}
		
		assertEquals("Pakistan",select.getFirstSelectedOption().getText());
		
		//Hide back again
		((JavascriptExecutor)seleniumUtil.getDriver()).executeScript("document.getElementById('countries').style.display='none'");
		
	}
}
