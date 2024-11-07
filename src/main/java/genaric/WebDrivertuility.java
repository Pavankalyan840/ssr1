package genaric;


import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDrivertuility{
	
	private WebDriver driver;
	public WebDriver lunachbrowser(String browser) {
		switch(browser) {
		case"chrome":
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			break;
		case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
			break;
		case"edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			default:
				System.out.println("enter a browser right path");
				
		}
		return driver;
		
			
		}
	
	public void maximizewindow() {
		driver.manage().window().maximize();
	}
	public void navigatemethod(String url) {
		driver.get(url);
	}
	public void waitutilElementsmethod(long time) {
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
		
	}
	public WebElement WebDriverwait(long time, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	public WebElement WebDiverwait( WebElement element,long time) {
		WebDriverWait wait= new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public boolean excplicitwait(String element, long time) {
		WebDriverWait wait= new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.titleContains(element));
	}
	public void mousehover(WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	public void doubleclick(WebElement element) {
		Actions action =new Actions(driver);
		action.doubleClick(element).perform();
	}
	public void rightclick(WebElement element) {
		Actions action= new Actions(driver);
		action.contextClick(element).perform();
	}
	public void dragAnddrop(WebElement elemnet, WebElement traget) {
		Actions action=new Actions (driver);
	action.dragAndDrop(elemnet, traget).perform();
	
	}
	public void dropdown(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void dropdown(String value, WebElement element) {
		Select select= new Select(element);
		select.selectByValue(value);
	}
	public void dropdown(WebElement element, String text) {
	Select select =new Select(element);
		select.selectByVisibleText(text);
	}
	public void scrolltitleelement(Object element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arumenats[0].scollIntoview(ture)", element);
	}
	public void switchtofram(String index) {
		driver.switchTo().frame(index);
	}
	public void switchtofram(String index, String idorName) {
		driver.switchTo().frame(idorName); 
}
	public void switchtofram( WebElement frameElement) {
		driver.switchTo().frame(frameElement);
}
	public void switchtoback() {
		driver.switchTo().defaultContent();	
}
	public void takescreeenshot(javautility jutil) {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("./screenshot/sc-"+jutil.getcurrenttime()+".png");
		try {
			FileUtils.copyFile(src, dest);
		}catch(IOException e) {
			e.printStackTrace();
		}
}
	public void handlealert(String status) {
		Alert al=driver.switchTo().alert();
		if(status.equalsIgnoreCase("ok")) {
			al.accept();
	}
	else 
	{
	al.dismiss();	
	}
		}
	public void switchtochildbrowser() {
		Set<String> set =driver.getWindowHandles();
		for(String id: set) {
			driver.switchTo().window(id);
			
		}
	}
		public void closecurrentwindow() {
			driver.close();
		}
		public void quitallwindows() {
			driver.quit();
		}
	}

