package testscript;

import org.testng.asserts.SoftAssert;

import genaric.Baseclass;

public class addPythonToCartTest extends Baseclass{
	public void addPythonToCartTest() {
	SoftAssert soft=new SoftAssert();
	home.clickGearsTab();
	home.clickSkillraryDemoAppLink();
	web.switchtochildbrowser();
	
	soft.assertTrue(demoApp.getPageHeader().contains("Ecommerce"));

	demoApp.selectCategory(web, 1);
	
	soft.assertEquals(testing.getPageHeader(), "Testing");
	
	web.scrolltitleelement(testing.getPythonImage());
	
	web.dragAnddrop(testing.getPythonImage(), testing.getCartArea());
	
	web.scrolltitleelement(testing.getFacebookIcon());
	testing.clickFacebookIcon();
	
	soft.assertAll();
	
	
	}
}
