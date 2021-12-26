package Automation.Gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailAutologin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("syamforever.99@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("rajyaratnam89019");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.name("logout"));
		
		
		/*driver.get("http://demo.guru99.com/v4/");*/
		
		
			

		
	}

}
