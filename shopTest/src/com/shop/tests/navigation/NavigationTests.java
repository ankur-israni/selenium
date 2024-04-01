package com.shop.tests.navigation;

import static com.shop.util.Constants.GOOGLE;
import static com.shop.util.Constants.ITEM_PAGE_TITLE;
import static com.shop.util.Constants.LOGIN_PAGE_TITLE;
import static com.shop.util.Constants.SHOP_URL;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.shop.tests.base.BaseTests;

public class NavigationTests extends BaseTests{

	@Test
	public void navigateTo() {
		seleniumUtil.get(SHOP_URL);
		assertEquals(LOGIN_PAGE_TITLE, seleniumUtil.getTitle());
		seleniumUtil.navigate(GOOGLE);
		assertEquals(seleniumUtil.getCurrentUrl(), GOOGLE);
	}
	
	@Test
	public void navigateBack(){
		seleniumUtil.get(SHOP_URL);
		assertEquals(LOGIN_PAGE_TITLE, seleniumUtil.getTitle());
		seleniumUtil.navigate(GOOGLE);
		seleniumUtil.back();
		assertEquals(LOGIN_PAGE_TITLE, seleniumUtil.getTitle());
	}
	
	@Test
	public void navigateForward()  throws InterruptedException{
		shopUtil.login(seleniumUtil);
		Thread.sleep(4000);
		assertEquals(ITEM_PAGE_TITLE, seleniumUtil.getTitle());
		seleniumUtil.back();
		Thread.sleep(4000);
		assertEquals(LOGIN_PAGE_TITLE, seleniumUtil.getTitle());
		seleniumUtil.forward();
		Thread.sleep(4000);
		assertEquals(ITEM_PAGE_TITLE, seleniumUtil.getTitle());
	}
	
	@Test
	public void navigateRefresh(){
		seleniumUtil.get(SHOP_URL);
		assertEquals(LOGIN_PAGE_TITLE, seleniumUtil.getTitle());
		seleniumUtil.refresh();
		assertEquals(LOGIN_PAGE_TITLE, seleniumUtil.getTitle());
	}
	
}
