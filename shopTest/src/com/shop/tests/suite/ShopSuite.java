package com.shop.tests.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.shop.tests.browser.BrowserTests;
import com.shop.tests.find.FinderTests;
import com.shop.tests.htmlelements.AlertBoxTestsIncomplete;
import com.shop.tests.htmlelements.HTMLElementsTests;
import com.shop.tests.navigation.NavigationTests;
import com.shop.tests.window.WindowTests;

@RunWith(Suite.class)

@Suite.SuiteClasses({ FinderTests.class, NavigationTests.class, ShopTests.class, AlertBoxTestsIncomplete.class,
		BrowserTests.class, HTMLElementsTests.class, WindowTests.class })
public class ShopSuite {

}
