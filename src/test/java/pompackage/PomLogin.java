package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass{
	
	
	@FindBy(css="div.oxd-form-row:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")  //driver.findElement(By.
	WebElement Username;
	@FindBy(css="div.oxd-form-row:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)") WebElement Password;
	
	@FindBy(css=".oxd-button") WebElement Loginbtn;
	
	
	public PomLogin() {
		
PageFactory.initElements(driver, this);
		
		
	}
	
	public void typeusername(String name) {
		
	Username.sendKeys(name);
		
	}
	
	public void typepassword(String pass) {
		
		Password.sendKeys(pass);
		
		
	}
	
public void clickbtn() {
		
	Loginbtn.click();
		
}

public String verify() {
	
	return driver.getTitle();

}

}