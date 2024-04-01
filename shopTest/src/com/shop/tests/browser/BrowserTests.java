package com.shop.tests.browser;

import static com.shop.util.Constants.SHOP_URL;
import static org.junit.Assert.*;

import org.junit.Test;

import com.shop.tests.base.BaseTests;

public class BrowserTests extends BaseTests{

	//TODO: incomplete
	@Test
	public void getWindowHandle(){
		
	}
	
	@Test
	public void get(){
		seleniumUtil.get(SHOP_URL);
		assertEquals("Login",seleniumUtil.getTitle());
	}
	
	@Test
	public void getTitle(){
		seleniumUtil.get(SHOP_URL);
		assertEquals("Login",seleniumUtil.getTitle());
	}
	
	@Test
	public void getPageSource(){
		seleniumUtil.get(SHOP_URL);
		assertTrue(seleniumUtil.getPageSource().contains("<form name=\"loginForm\" action=\"/Shop/cs\" method=\"post\">"));
	}
	
	@Test
	public void getCurrentUrl(){
		shopUtil.gotoLoginPage(seleniumUtil);
		assertEquals("http://localhost:3080/Shop/",seleniumUtil.getCurrentUrl());
	}
	
	@Test
	public void close(){
		seleniumUtil.get(SHOP_URL);
		seleniumUtil.close();
	}
	
	@Test
	public void quit(){
		seleniumUtil.get(SHOP_URL);
		seleniumUtil.quit();
	}
	
	
}
