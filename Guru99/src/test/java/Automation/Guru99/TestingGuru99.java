package Automation.Guru99;

/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingGuru99 {

	public static void main(String[] args) throws InterruptedException {
		/*System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.get("http://demo.guru99.com/v4/");
		driver.quit();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.findElement(By.name("uid")).sendKeys("1303");
		driver.findElement(By.name("password")).sendKeys("guru99");
		driver.findElement(By.name("btnLogin")).click();
		driver.findElement(By.xpath("//a[contains (text(), 'Fund Transfer')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains (text(), 'Log out')]")).click();
		
		//driver.close();

	}

}*/



import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingGuru99 {

private static WebDriver driver = null;

public static void main(String[] args) {
// TODO Auto-generated method stub

String homePage = "https://buildings.honeywell.com/in/en";
String url = "";
HttpURLConnection huc = null;
int respCode = 200;
System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\chromedriver.exe");
driver = new ChromeDriver();

driver.manage().window().maximize();

driver.get(homePage);

List<WebElement> links = driver.findElements(By.tagName("a"));

Iterator<WebElement> it = links.iterator();

while(it.hasNext()){

url = it.next().getAttribute("href");

/*System.out.println(url);

if(url == null || url.isEmpty()){
System.out.println("URL is either not configured for anchor tag or it is empty");
continue;
}

if(!url.startsWith(homePage)){
System.out.println("URL belongs to another domain, skipping it.");
continue;
}*/

try {
huc = (HttpURLConnection)(new URL(url).openConnection());

huc.setRequestMethod("HEAD");

huc.connect();

respCode = huc.getResponseCode();

if(respCode >= 400){
System.out.println(url+" is a broken link");
}
/*else{
System.out.println(url+" is a valid link");
}*/

} catch (MalformedURLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}

driver.quit();

}
}
