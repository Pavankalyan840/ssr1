package genaric;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomclass.ContactUsPage;
import pomclass.SeleniumTrainingPage;
import pomclass.SkillraryDemoAppPage;
import pomclass.SkillraryHomePage;
import pomclass.TestingPage;


public class Baseclass{
	
	protected propertiesutility property;
	protected javautility jutil;
	protected excelutility excel;
	protected IConstantpath iconstant;
	protected WebDrivertuility web;
	
	protected ContactUsPage contactus;
	protected SkillraryHomePage home;
	protected SkillraryDemoAppPage demoApp;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	//@Beforesulit
	//@BeforeTest
	protected WebDriver driver;
	@BeforeClass
	public void classconfig() {
		property = new propertiesutility();
		excel =new excelutility ();
		jutil =new javautility() ;
	     web =new WebDrivertuility();	
	     property.readDataFromProperties(IConstantpath.PROPERTIES_PATH);
	     excel.excellimit(IConstantpath.EXECL_PATH);
	}
		
	@BeforeMethod
	public void methodconfig() {
		
		driver=web.lunachbrowser(property.readDataFromProperties("browser"));
		web.maximizewindow();;
		web.navigatemethod(property.readDataFromProperties("url"));
		web.waitutilElementsmethod(Long.parseLong(property.readDataFromProperties("time")));
		
		home =new SkillraryHomePage(driver);
		contactus=new ContactUsPage(driver);
		demoApp=new SkillraryDemoAppPage(driver);
		testing =new TestingPage(driver);
		selenium=new SeleniumTrainingPage(driver);
		}
	@AfterMethod
	public void methodTearDown() {
		web.quitallwindows();
	}
	@AfterClass
	public void clasaTearDown() {
	
	}
	//@AfterTest
	//@AfterSulit
	
}