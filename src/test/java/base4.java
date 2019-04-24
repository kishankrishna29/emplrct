

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class base4
{
	public static WebDriver driver;
	
	@BeforeMethod
	public void start() throws InterruptedException
	{
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\testing04\\eclipse-workspace\\HCM\\chromedriver.exe");
	
	//System.setProperty("webdriver.gecko.driver","D:\\pro2\\Healthcare\\src\\main\\java\\com\\browsers\\geckodriver.exe");
	
	driver =  new ChromeDriver(); 
	driver.get("http://192.168.2.245:8181");
	Actions act = new Actions(driver);
	WebElement uname = driver.findElement(By.xpath("//*[@id='employeecode']"));
	act.sendKeys(uname,"27115").build().perform();
	
	WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
	act.sendKeys(pwd,"Leo@1234").build().perform();
	Thread.sleep(3000);
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//*[@id='loginid']")).click();
	}
	
	
	@AfterMethod
	public void end() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
}
