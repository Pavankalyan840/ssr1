package testscript;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genaric.Baseclass;

public class sendContactDetilsTest extends Baseclass{

	@Test
	public void sendContactDetilasTest() {
		SoftAssert soft=new SoftAssert();
		
		home.clickGearsTab();
		home.clickSkillraryDemoAppLink();
		web.switchtochildbrowser();
		
		soft.assertTrue(demoApp.getPageHeader().contains("Ecommers"));
		
		web.scrolltitleelement(demoApp.getPageHeader());
		demoApp.getContactUsLink();
		
		soft.assertTrue(contactus.getLogo().isDisplayed());
		
		Map<String,String > map=excel.getdatafromExcel("sheet1");
		contactus.sendDetails(map.get("fullname"),map.get("Email"),map.get("subject"),map.get("'message"));
		soft.assertAll();
	}
}
