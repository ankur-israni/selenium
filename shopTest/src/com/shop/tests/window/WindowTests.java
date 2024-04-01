package com.shop.tests.window;

import org.junit.Test;

import com.shop.tests.base.BaseTests;

public class WindowTests extends BaseTests{

	@Test
	public void maximize(){
		shopUtil.gotoLoginPage(seleniumUtil);
		seleniumUtil.maximize();
	}
	
}
