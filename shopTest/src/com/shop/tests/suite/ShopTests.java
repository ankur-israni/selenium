package com.shop.tests.suite;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.shop.tests.base.BaseTests;

public class ShopTests extends BaseTests {

	@Test
	public void testPageSource() throws InterruptedException {
		shopUtil.login(seleniumUtil);
		Thread.sleep(5000);
		assertNotNull(seleniumUtil.getPageSource());
	}

}
