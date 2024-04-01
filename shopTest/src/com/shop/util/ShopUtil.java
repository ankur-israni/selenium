package com.shop.util;

import static com.shop.util.Constants.LOGIN_BUTTON;
import static com.shop.util.Constants.PASSWORD_TEXTBOX_ID;
import static com.shop.util.Constants.SHOP_URL;
import static com.shop.util.Constants.USERNAME_TEXTBOX_ID;
import static com.shop.util.Constants.VALID_PASSWORD;
import static com.shop.util.Constants.VALID_USERNAME;

public class ShopUtil {

	public void login(SeleniumUtil seleniumUtil) {
		seleniumUtil.maximize();
		seleniumUtil.get(SHOP_URL);
		seleniumUtil.findById(USERNAME_TEXTBOX_ID).click();
		seleniumUtil.findById(USERNAME_TEXTBOX_ID).sendKeys(VALID_USERNAME);
		seleniumUtil.findById(PASSWORD_TEXTBOX_ID).click();
		seleniumUtil.findById(PASSWORD_TEXTBOX_ID).sendKeys(VALID_PASSWORD);
		seleniumUtil.findByName(LOGIN_BUTTON).click();
	}
	
	public void gotoLoginPage(SeleniumUtil seleniumUtil){
		seleniumUtil.get(SHOP_URL);
	}
	
	public void gotoSeleniumPage(SeleniumUtil seleniumUtil){
		login(seleniumUtil);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		seleniumUtil.findById("seleniumLinkId").click();
	}
	
	
	public void gotoHTMLControlsTab(SeleniumUtil seleniumUtil){
		gotoSeleniumPage(seleniumUtil);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		seleniumUtil.findById("htmlControlsId").click();
	}
	
	public void gotoHTMLTableTab(SeleniumUtil seleniumUtil){
		gotoSeleniumPage(seleniumUtil);
		try {
		
//		seleniumUtil.findById("htmlTableId").click();
		seleniumUtil.findByXpath(".//*[@id='ui-id-4']").click();
		Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}

}
