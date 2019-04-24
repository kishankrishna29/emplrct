

import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class hcm extends base

{
	
@Test(dataProvider = "login")
public void reg(String num_packs_val, String name, String mobile, String email) throws InterruptedException, IOException
{
	Actions act = new Actions(driver);
	
	Thread.sleep(3000);
	WebElement num_packs = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[1]"));
	act.moveToElement(num_packs).click().build().perform();
	act.sendKeys(num_packs,num_packs_val).sendKeys(Keys.ENTER).build().perform();
	Thread.sleep(1000);
	
	WebElement paid = driver.findElement(By.xpath("//*[@id='btn_save']"));
	act.moveToElement(paid).click().build().perform();
	
	Thread.sleep(1000);
	WebElement name_w = driver.findElement(By.xpath("//*[@id='content']/div[2]/form/div[1]/div/div[2]/div[2]/div[1]/div[2]/div/input"));
	act.sendKeys(name_w, name).sendKeys(Keys.ENTER).build().perform();
	
	WebElement mobile_w = driver.findElement(By.xpath("//*[@id='content']/div[2]/form/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/input"));
	act.sendKeys(mobile_w, mobile).sendKeys(Keys.ENTER).build().perform();
	
	WebElement email_w = driver.findElement(By.xpath("//*[@id='content']/div[2]/form/div[1]/div/div[2]/div[2]/div[3]/div[2]/div/input"));
	act.sendKeys(email_w, email).sendKeys(Keys.ENTER).build().perform();
	
	WebElement click = driver.findElement(By.xpath("//*[@id='content']/div[2]/form/div[1]/div/div[2]/div[2]/div[4]/div[2]/div/input"));
	act.moveToElement(click).click().build().perform();
	
	Thread.sleep(4000);
}

@DataProvider
public Object[][] login() throws BiffException, IOException 
{
	  Object [][]data= getExcelDat();
	  
	  return data;

}
private Object[][] getExcelDat() throws BiffException, IOException
{
		FileInputStream fi= new FileInputStream("D:\\Dtp\\values.xls");
		Workbook wb= Workbook.getWorkbook(fi);
		Sheet sh= wb.getSheet("data");
		String[][] arexceldada = new String[sh.getRows()][sh.getColumns()];
		for (int i = 0; i < sh.getRows(); i++) 
		{
			for (int j = 0; j < sh.getColumns(); j++) 
			{
				arexceldada[i][j]=sh.getCell(j, i).getContents();
			}
		}
		return arexceldada;
	}

}