import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class hcm6 extends base4

{
	@Test(dataProvider = "login")
	public void reg(String appname) throws InterruptedException, IOException
	{
		Actions act = new Actions(driver);
		driver.get("http://192.168.2.245:8181/shortlistCandidates");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='checkout_filter']/label/input")).sendKeys(appname);
		
		
		System.out.println("Applicant Name is ::"+" "+appname);
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='scheduleid']")).click();
		
		Thread.sleep(3000);
		
		
		WebElement ap11=driver.findElement(By.xpath("//*[@id='txtassignto']"));
		act.sendKeys(ap11, "29519").build().perform();
		act.sendKeys(Keys.ENTER).click().build().perform();
		
		
		
		driver.findElement(By.xpath("//*[@id='datetxtid']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")).click();
		Thread.sleep(2000);
		
//		WebElement ap12=driver.findElement(By.xpath("//*[@id='txttimeid']"));
//		act.sendKeys(ap12, "11:00").build().perform();
		
		driver.findElement(By.xpath("//*[@id='ddltypeofInterview_chzn']/a")).click();
		
		act.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).click().build().perform();
		Thread.sleep(2000);
		

		WebElement ap13=driver.findElement(By.xpath("//*[@id='txtremarks']"));
		act.sendKeys(ap13, "scheduled").build().perform();
		
		driver.findElement(By.xpath("//*[@id='ddllocation_chzn']/a")).click();
		act.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).click().build().perform();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//*[@id='btnsave']")).click();
		Thread.sleep(2000);
	
		WebElement elmnt=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button[2]"));
		act.moveToElement(elmnt).click().build().perform();
	

		Thread.sleep(5000);
	}

	@DataProvider
	public Object[][] login() throws BiffException, IOException 
	{
		  Object [][]data= getExcelDat();
		  
		  return data;

	}
	private Object[][] getExcelDat() throws BiffException, IOException
	{
			FileInputStream fi= new FileInputStream("D:\\selenium\\rct files\\applicant_asn2.xls");
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
