import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class base
{
	public static WebDriver driver;
	@BeforeTest
	public void start() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","D:\\pro2\\Healthcare\\src\\main\\java\\com\\browsers\\chromedriver.exe");
	//System.setProperty("webdriver.gecko.driver","D:\\pro2\\Healthcare\\src\\main\\java\\com\\browsers\\geckodriver.exe");
	driver =  new ChromeDriver(); 
	driver.get("https://guestnest.io");
	Actions act = new Actions(driver);
	Thread.sleep(4000);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	WebElement email = driver.findElement(By.xpath("//*[@id='root']/div/form/div[1]/input"));
	act.sendKeys(email, "ticketing@gmail.com").sendKeys(Keys.ENTER).build().perform();
	
	WebElement pwd = driver.findElement(By.xpath("//*[@id='root']/div/form/div[2]/input"));
	act.sendKeys(pwd, "ticketing@123").sendKeys(Keys.ENTER).build().perform();
	
	driver.findElement(By.xpath("//*[@id='root']/div/form/button")).click();	
	
	}
}
