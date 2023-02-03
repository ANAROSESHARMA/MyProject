package basePackage;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;
import java.io.File;

public class BaseHRMClass {
	
public static	Properties prop=new Properties();
public static	WebDriver driver;
	public BaseHRMClass() {  // Creating Constructor of this class
		try {
		
		FileInputStream file=new FileInputStream("C:\\Users\\anami\\Downloads\\HRmanagement\\src\\test\\java\\environmentvariables\\Config.properties");
		
		prop.load(file);
		
		
	}
	
	catch(FileNotFoundException e) {
	
	e.printStackTrace();
}
catch (IOException a) {
	a.printStackTrace();
}}
	@SuppressWarnings("deprecation")
	public static void initiate() {	// After Constructor will start with Method , keeping static as we want to use it in other classes
	String browsername= prop.getProperty("browser");
	
	if (browsername.equals("GoogleChrome")) {
	
	System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
	
	driver=new ChromeDriver();}
	else if (browsername.equals("Firefox")) {
		
		System.setProperty("Webdriver.gecko.driver","geckodriver.exe");
		
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(TimeUtils.implicitlyWait,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	}
	public static void screenshots(String Filename) {
		
	File file=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
	FileUtils.copyFile(file, new File("C:\\Users\\anami\\Downloads\\HRmanagement\\src\\test\\java\\screenshots\\Screenshots" +Filename+".jpg"));
	
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	}
	
	
	
	
	}
	