package com.shop.tests.base;

import org.junit.After;
import org.junit.Before;

import com.shop.util.BrowserType;
import com.shop.util.OSType;
import com.shop.util.SeleniumUtil;
import com.shop.util.ShopUtil;

public class BaseTests {

	protected ShopUtil shopUtil;
	protected SeleniumUtil seleniumUtil;
	
	@Before
	public void setup() {
//		seleniumUtil = new SeleniumUtil(BrowserType.PHANTOMJS);
		seleniumUtil = new SeleniumUtil(OSType.MAC,BrowserType.CHROME);
		shopUtil=new ShopUtil();
	}
	
	
	@After
	public void cleanup() {
		seleniumUtil.closeAll();
	}
}
