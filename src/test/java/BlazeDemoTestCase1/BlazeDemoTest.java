package BlazeDemoTestCase1;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BlazeDemoTest {

	WebDriver driver;
	
	@Test
	public void launchurltest()
	{
		driver = WebDriverManager.chromedriver().create();
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Page Title: "+driver.getTitle());
	
		driver.findElement(By.xpath("//a[text()='Travel The World']")).click();
		System.out.println("TravelTheWorld Page Title: "+driver.getTitle());
		
		driver.findElement(By.xpath("//a[text()='home']")).click();
		System.out.println("home Page Title: "+driver.getTitle());
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//a[text()='destination of the week! The Beach!']")).click();
		System.out.println("destination of the week! The Beach! Page Title: "+driver.getTitle());
		
		driver.navigate().back();
		
		WebElement boston=driver.findElement(By.name("fromPort"));
		Select departuredropdown = new Select(boston);
		departuredropdown.selectByVisibleText("Boston");
		
		WebElement london=driver.findElement(By.name("toPort"));
		Select destinationdropdown = new Select(london);
		destinationdropdown.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		driver.quit();
	}
	
	@Test(priority=1)
	public void logintest()
	{
		driver = WebDriverManager.chromedriver().create();
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[text()='home']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		driver.findElement(By.id("name")).sendKeys("Pratik Shingote");
		driver.findElement(By.id("company")).sendKeys("Edubridge");
		driver.findElement(By.id("email")).sendKeys("Pratik@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Pratik@123");
		driver.findElement(By.id("password-confirm")).sendKeys("Pratik@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		List <WebElement> registerdetails = driver.findElements(By.tagName("div"));
		for(WebElement registermessage:registerdetails)
		{
			System.out.println("Account Registration Details :"+registermessage.getText());
		}
		
		driver.quit();
		
	}
	
	@Test(priority=2)
	public void formtest()
	{
		driver = WebDriverManager.chromedriver().create();
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]")).click();
		WebElement confirmflight = driver.findElement(By.xpath("//h2[text()='Your flight from TLV to SFO has been reserved.']"));
		System.out.println("Flight confirmation message :"+confirmflight.getText());
		
		driver.findElement(By.id("inputName")).sendKeys("Pratik");
		driver.findElement(By.id("address")).sendKeys("Pune");
		driver.findElement(By.id("city")).sendKeys("Pune");
		driver.findElement(By.id("state")).sendKeys("Maharashtra");
		driver.findElement(By.id("zipCode")).sendKeys("411044");
		driver.findElement(By.id("creditCardNumber")).sendKeys("12345678");
		WebElement month = driver.findElement(By.id("creditCardMonth"));
		month.clear();
		month.sendKeys("05");
		WebElement year = driver.findElement(By.id("creditCardYear"));
		year.clear();
		year.sendKeys("2022");
		driver.findElement(By.id("nameOnCard")).sendKeys("Pratik");
		
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		WebElement ticketconfirm = driver.findElement(By.xpath("//h1[contains(text(),'Thank you')]"));
		System.out.println("Ticket Confirmation Message :"+ticketconfirm.getText());
		
		List <WebElement> ticketpurchasedetails = driver.findElements(By.xpath("//h1[contains(text(),'Thank you')]/following-sibling::table/tbody/tr"));
		for(WebElement printdetails:ticketpurchasedetails)
		{
			System.out.println("Flight Purchase Ticket Details: "+printdetails.getText());
		}
		
		driver.quit();
		
	}
}



















